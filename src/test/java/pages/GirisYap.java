package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class GirisYap {

    public GirisYap (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "ap_email")
    public WebElement epostaTextKutusu;

    @FindBy(id = "ap_password")
    public WebElement sifreTextKutusu;

    @FindBy(id = "signInSubmit")
    public WebElement girisYapButonu;


}