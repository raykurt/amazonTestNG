package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Urunler {

    public Urunler (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"n/13709907031\"]/span/a/span")
    public WebElement cepTelefonlariKategorisi;

    @FindBy(xpath = "//div[@data-component-type='s-search-result']/div/div/div/div/div/div[2]/h2/a/span")
    public List<WebElement> urunSonuclariBasliklari;

    @FindBy(xpath = "//span[@class='s-pagination-strip']/a[1]")
    public WebElement ikinciSayfaButonu;

    @FindBy(xpath = "//div[@data-component-type='s-search-result'][5]")
    public WebElement usttenBesinciUrun;

    @FindBy(id = "productTitle")
    public WebElement secilenUrunBasligi;

    @FindBy(id = "add-to-wishlist-button-submit")
    public WebElement urunuListeyeEkleButonu;

    @FindBy(xpath = "//div[@id='huc-atwl-header-section']/div/span[1]")
    public WebElement urunListeyeEklendiAssert;

    @FindBy(id = "huc-view-your-list-button")
    public WebElement listeniziGoruntuleButonu;


}