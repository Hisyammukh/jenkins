package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage {
    
    @FindBy(id="lhs-settings")
    public WebElement settingsMenu;

    @FindBy(xpath="//div[@class='info-banner-content']")
    public By banner;

    @FindBy(xpath="(//div[@class='col-lg-4'])[1]")
    public By moneySection;

    @FindBy(xpath="(//div[@class='col-lg-4'])[7]")
    public By developersSection;

    @FindBy(xpath="//a[@href='/settings/developers#api-keys']")
    // @FindBy(linkText="API keys")
    public WebElement apiKeysLink;
}
