package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utilities.Driver;

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
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
    Random randomObj=new Random();
    String secilenUrunBasligi;
    List<String> listOfString = new ArrayList<>();



    @BeforeMethod
    public void setUp () {
        Driver.getDriver().navigate().to("https://www.amazon.com.tr/");
    }

    @Test
    public void Test1 () {

        wait.until(ExpectedConditions.elementToBeClickable(anasayfaObj.hesapVeListelerButonu));
        anasayfaObj.hesapVeListelerButonu.click();

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        girisYapObj.epostaTextKutusu.sendKeys("raykurt@hotmail.com" + Keys.ENTER);

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        girisYapObj.sifreTextKutusu.sendKeys("123Recep");
        girisYapObj.girisYapButonu.click();

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

        Driver.waitAndClick(urunlerObj.usttenBesinciUrun);

        secilenUrunBasligi = urunlerObj.secilenUrunBasligi.getText();

        Driver.waitAndClick(urunlerObj.urunuListeyeEkleButonu);

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(urunlerObj.urunListeyeEklendiAssert.getText().contains("ürün şuraya eklendi:"));

        Driver.waitAndClick(urunlerObj.listeniziGoruntuleButonu);

        for (int i = 0; i < listelerimObj.listedekiUrunBasliklari.size(); i++) {
            listOfString.add(listelerimObj.listedekiUrunBasliklari.get(i).getText());
        }
        Assert.assertTrue(listOfString.contains(secilenUrunBasligi));

        Driver.waitAndClick(listelerimObj.listedekiUrunuSepeteEkleButonu);

        Driver.wait(2);
        Assert.assertEquals(listelerimObj.listedekiUrunSepeteEklendiAssert.getText(), "Sepete Eklendi");

        anasayfaObj.sepetimButonu.click();

        Assert.assertEquals(sepetimobj.sepettekiUrunBasligi.getText(), secilenUrunBasligi);

        Driver.waitAndClick(sepetimobj.sepettekiUrunuSilButonu);

        Assert.assertTrue(sepetimobj.sepettekiUrunuSilAssert.getText().contains("Alışveriş Sepetiniz konumundan kaldırıldı."));

    }

    @AfterMethod
    public void tearDown () {
        System.out.println("This is after method");
    }

}
