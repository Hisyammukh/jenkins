package TestSteps;

import static Config.config.driver;
import PageObject.homePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class homeSteps extends homePage{

    Actions action = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    JavascriptExecutor js = (JavascriptExecutor) driver;
        
    public homeSteps(){
        PageFactory.initElements(driver, this);
    }
    
    public void homeDashboard(){
        wait.until(ExpectedConditions.titleIs("Xendit Dashboard"));

    }

    public void SettingsSideMenu(){
        settingsMenu.isDisplayed();
        settingsMenu.click();
    }

    public void scrollToDev()throws InterruptedException {
        js.executeScript("arguments[0].scrollIntoView();",apiKeysLink);
        Thread.sleep(3000);
        
    }

    public void linkAPIKey(){
        wait.until(ExpectedConditions.elementToBeClickable(apiKeysLink)).click();
    }

}