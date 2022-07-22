package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Anasayfa {

    public Anasayfa (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "nav-link-accountList")
    public WebElement hesapVeListelerButonu;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchTextKutusu;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchButonu;

    @FindBy(id = "nav-cart")
    public WebElement sepetimButonu;

}