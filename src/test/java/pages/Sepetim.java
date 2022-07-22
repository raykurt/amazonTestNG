package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Sepetim {

    public Sepetim (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='a-fixed-left-grid-inner']/div[2]/ul/li/span/a/span/span/span[2]")
    public WebElement sepettekiUrunBasligi;

    @FindBy(xpath = "//div[@class='a-fixed-left-grid-inner']/div[2]/div/span[2]/span")
    public WebElement sepettekiUrunuSilButonu;

    @FindBy(xpath = "//form[@id='activeCartViewForm']/div[2]/div/div/div/span[1]")
    public WebElement sepettekiUrunuSilAssert;


}