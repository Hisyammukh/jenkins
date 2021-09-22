package TestSteps;
import static Config.config.driver;
import Object.HeaderReq;
import PageObject.settingsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class settingsSteps extends settingsPage{
    Actions action = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, 30);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    HeaderReq headerReq;

    public settingsSteps(){
        PageFactory.initElements(driver, this);
    }

    public void clickCreateAPI(){
        createAPIbtn.click();
    }

    public void inputAPIName(){
        apiField.sendKeys("secret");
    }
    
    public void setReadPermission(){
        readFirstPermission.click();
        readSecondPermission.click();
        readThirdPermission.click();
    }

    public void setWritePermission(){
        writeFirstPermisssion.click();
        writeSecondPermisssion.click();
        writeThirdPermisssion.click();
    }

    public void clickGenerateKey(){
        wait.until(ExpectedConditions.elementToBeClickable(btnGenerateKey)).click();
        // btnGenerateKey.click();
    }

    public void inputPasswordKey(){
        passwordCreateKeyField.sendKeys("Glonggong1");
        confirmBtnCreateKey.click();
    }

    public void successCreateKey(){
        successInfo.isDisplayed();
    }

    public String setKey(){
        return apiKeyValue.getText();
    }

    public void getKey(){
        headerReq = new HeaderReq();
        headerReq.getSecretAPI();
    }

    public void closeModal(){
        closeBtn.click();
    }

    public void clickEditKey(){
        action.moveToElement(editIcon).perform();
        editIcon.click();
    }

    public void clickCloseErrBtn(){
        wait.until(ExpectedConditions.elementToBeClickable(closeBtnError)).click();
    }

    public void errorIsExist(){
        errorPermissionAlert.isDisplayed();
    }

    public void clickCancelBtn(){
        cancelBtn.click();
    }

    public void successEditPermissionInfo(){
        successEditInfo.isDisplayed();    
    }

    public void closeBtnOkay(){
        btnOK.click();
    }
    
}
