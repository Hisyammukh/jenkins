package TestSteps;

import static Config.config.driver;
import PageObject.callbackPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class callbackSteps extends callbackPage{
    Actions action = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public callbackSteps(){
        PageFactory.initElements(driver, this);
    }

    public void clickCallbackMenu(){
        wait.until(ExpectedConditions.elementToBeClickable(callbacksMenu)).click();
        // callbacksMenu.click();
    }
    
    public String getTextStatus(){
        return firstRowStatus.getText();
    }

    public String getTextType(){
        return firstRowType.getText();
    }

    public void getStatus(){
        String actual = firstRowStatus.getText();
        String expectedStatus = "Completed";
        Assert.assertEquals(expectedStatus, actual);
    }

    public void getProductType(){
        String actualType = firstRowType.getText();
        String expectedType = "Virtual Account Status";
        Assert.assertEquals(actualType, expectedType);
    }
}