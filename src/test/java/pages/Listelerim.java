package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Listelerim {

    public Listelerim (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h2[@class='a-size-base']/a")
    public List<WebElement> listedekiUrunBasliklari;

    @FindBy(xpath = "(//span[@data-action='add-to-cart'])[1]")
    public WebElement listedekiUrunuSepeteEkleButonu;

    @FindBy(xpath = "//div[@class='a-fixed-right-grid-inner']/div[2]/div/div/div/div")
    public WebElement listedekiUrunSepeteEklendiAssert;


}
