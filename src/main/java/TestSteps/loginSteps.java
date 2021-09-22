package TestAction;

import static Config.config.driver;
import PageObject.loginPage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginSteps extends loginPage{

    Actions action = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    
    public loginSteps(){
        PageFactory.initElements(driver,this);
    }
    
    public void inputEmail(){
        emailField.sendKeys("hisyammukhh@gmail.com");
    }

    public void inputPass(){
        passwordField.sendKeys("Glonggong1");
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }
}