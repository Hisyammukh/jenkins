package PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class settingsPage {
    
    @FindBy(xpath="//button[@class='btn btn-primary btn-md btn-with-icon']")
    public WebElement createAPIbtn;

    @FindBy(name= "apiKeyName")
    public WebElement apiField;

    @FindBy(xpath="/html/body/div[4]/div/div/div[2]/div[2]/div[1]/div/button[3]")
    public WebElement writeFirstPermisssion;
    
    @FindBy(xpath="/html/body/div[4]/div/div/div[2]/div[2]/div[1]/div/button[2]")
    public WebElement readFirstPermission;

    @FindBy(xpath="/html/body/div[4]/div/div/div[2]/div[3]/div[1]/div/button[3]")
    public WebElement writeSecondPermisssion;
    
    @FindBy(xpath="/html/body/div[4]/div/div/div[2]/div[3]/div[1]/div/button[2]")
    public WebElement readSecondPermission;

    @FindBy(xpath="/html/body/div[4]/div/div/div[2]/div[4]/div[1]/div/button[3]")
    public WebElement writeThirdPermisssion;
    
    @FindBy(xpath="/html/body/div[4]/div/div/div[2]/div[4]/div[1]/div/button[2]")
    public WebElement readThirdPermission;

    @FindBy(xpath="/html/body/div[4]/div/div/div[3]/button[1]")
    public WebElement btnCancel;

    @FindBy(xpath="/html/body/div[4]/div/div/div[3]/button[2]")
    public WebElement btnGenerateKey;

    @FindBy(xpath="/html/body/div[6]/div/div/div[1]/div/div[3]/div/input")
    public WebElement passwordCreateKeyField;

    @FindBy(xpath="/html/body/div[6]/div/div/div[2]/div/button[2]")
    public WebElement confirmBtnCreateKey;

    @FindBy(xpath="//p[contains(text(),'Secret API key successfully created.')]")
    public WebElement successInfo;

    @FindBy(xpath="//span[@class='secret-api-key-success']")
    public WebElement apiKeyValue;

    @FindBy(xpath="/html/body/div[4]/div/div/div[2]/button")
    public WebElement closeBtn;

    @FindBy(xpath="//table/tbody/tr[1]/td[4]/div/img[1]")
    public WebElement editIcon;

    @FindBy(xpath="/html/body/div[6]/div/div/div/div[2]/button")
    public WebElement closeBtnError;

    @FindBy(xpath="//*[contains(text(),'You must select a permission')]")
    public WebElement errorPermissionAlert;

    @FindBy(xpath="/html/body/div[4]/div/div/div[3]/button[1]")
    public WebElement cancelBtn;

    @FindBy(xpath="//p[contains(text(),'We’ve saved the changes you made to your API key.')]")
    public WebElement successEditInfo;

    @FindBy(xpath="//button[contains(text(),'Okay')]")
    public WebElement btnOK;

}