package PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class callbackPage {
    
    @FindBy(id="lhs-callbacks")
    public WebElement callbacksMenu;

    @FindBy(xpath="//table/tbody/tr[1]/td[2]/span")
    public WebElement firstRowStatus;

    @FindBy(xpath="//table/tbody/tr[1]/td[5]")
    public WebElement firstRowType;
}