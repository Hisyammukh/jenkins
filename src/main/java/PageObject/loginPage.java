package PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {
    
    @FindBy(name = "email")
    public WebElement emailField;

    @FindBy(name= "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button[@class= 'btn btn-primary btn-md']")
    public WebElement loginBtn;
    
}
