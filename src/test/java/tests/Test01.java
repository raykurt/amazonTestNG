package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utilities.Driver;
import utilities.ExcelUtil;
import utilities.Log;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test01 {

    Anasayfa anasayfaObj = new Anasayfa();
    GirisYap girisYapObj = new GirisYap();
    Urunler urunlerObj = new Urunler();
    Listelerim listelerimObj = new Listelerim();
    Sepetim sepetimobj = new Sepetim();
    ExcelUtil excelUtil;
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
    Random randomObj=new Random();
    String secilenUrunBasligi;
    List<String> listOfString = new ArrayList<>();



    @BeforeSuite
    public void setUp () {
        Driver.getDriver().navigate().to("https://www.amazon.com.tr/");
    }


    @Test
    public void Test01 () {

        Log.warn("Test Basliyor...");
        wait.until(ExpectedConditions.elementToBeClickable(anasayfaObj.hesapVeListelerButonu));
        anasayfaObj.hesapVeListelerButonu.click();

    }

    @Test(dataProvider = "loginInfo")
    public void Test02_UserLogin(String username, String password) {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Log.info("Uyelik e-posta bilgisi giriliyor...");
        girisYapObj.epostaTextKutusu.sendKeys(username + Keys.ENTER);

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Log.info("Uyelik sifre bilgisi giriliyor...");
        girisYapObj.sifreTextKutusu.sendKeys(password);
        girisYapObj.girisYapButonu.click();
    }

    @Test
    public void Test03 () {

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        anasayfaObj.searchTextKutusu.sendKeys("samsung");
        anasayfaObj.searchButonu.click();

        wait.until(ExpectedConditions.elementToBeClickable(urunlerObj.cepTelefonlariKategorisi));
        urunlerObj.cepTelefonlariKategorisi.click();

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        int randomNumber = randomObj.nextInt(urunlerObj.urunSonuclariBasliklari.size());
        Assert.assertTrue(urunlerObj.urunSonuclariBasliklari.get(randomNumber).getText().contains("Samsung"));

        urunlerObj.ikinciSayfaButonu.click();

        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("sr_pg_2"));

        Log.info("Ustten 5. Urun Inceleniyor...");
        Driver.waitAndClick(urunlerObj.usttenBesinciUrun);

        secilenUrunBasligi = urunlerObj.secilenUrunBasligi.getText();

        Log.info("Urun Listeye Ekleniyor...");
        Driver.waitAndClick(urunlerObj.urunuListeyeEkleButonu);

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(urunlerObj.urunListeyeEklendiAssert.getText().contains("ürün şuraya eklendi:"));

        Driver.waitAndClick(urunlerObj.listeniziGoruntuleButonu);

        for (int i = 0; i < listelerimObj.listedekiUrunBasliklari.size(); i++) {
            listOfString.add(listelerimObj.listedekiUrunBasliklari.get(i).getText());
        }
        Assert.assertTrue(listOfString.contains(secilenUrunBasligi));

        Log.info("Listedeki Urun Sepete Ekleniyor...");
        Driver.waitAndClick(listelerimObj.listedekiUrunuSepeteEkleButonu);

        Driver.wait(2);
        Assert.assertEquals(listelerimObj.listedekiUrunSepeteEklendiAssert.getText(), "Sepete Eklendi");

        anasayfaObj.sepetimButonu.click();

        Assert.assertEquals(sepetimobj.sepettekiUrunBasligi.getText(), secilenUrunBasligi);

        Log.info("Sepetteki Urun Siliniyor...");
        Driver.waitAndClick(sepetimobj.sepettekiUrunuSilButonu);

        Assert.assertTrue(sepetimobj.sepettekiUrunuSilAssert.getText().contains("Alışveriş Sepetiniz konumundan kaldırıldı."));

    }

    @DataProvider(name = "loginInfo")
    public Object [][] getData(){
        String path = "./src/test/java/resources/optiim.xlsx";
        String sheetName="login_info";
        excelUtil = new ExcelUtil(path,sheetName);
        Object [][]  loginCredentials = excelUtil.getDataArrayWithoutFirstRow();
        return loginCredentials;
    }

    @AfterSuite
    public void tearDown () {
        Log.warn("Test Bitti... Driver Kapatiliyor...");
        Driver.closeDriver();
    }

}