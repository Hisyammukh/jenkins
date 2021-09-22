package TestSuite;

import Config.config;
import Object.HeaderReq;
import TestAction.loginSteps;
import TestSteps.callbackSteps;
import TestSteps.homeSteps;
import TestSteps.settingsSteps;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends config {
    loginSteps ls;
    homeSteps hs;
    settingsSteps ss;
    HeaderReq hr ;
    callbackSteps cb;
    
    ExtentTest test;
    ExtentReports report;

    @BeforeSuite
    public void initTest(){
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("report.html");
        report = new ExtentReports();
        report.attachReporter(htmlReporter);
            
    }

    @BeforeTest
    public void start(){
        initialize();
        ls = new loginSteps();
        hs = new homeSteps();
        ss = new settingsSteps();
        cb = new callbackSteps();
        hr = new HeaderReq();
    }

    @Test (priority = -1)
    public void login()throws InterruptedException {
        Thread.sleep(5000);
        ls.inputEmail();
        ls.inputPass();
        ls.clickLoginBtn();
        Thread.sleep(10000);
        hs.homeDashboard();
        Thread.sleep(5000);
    }

    @Test (priority = 0)
    public void createSecretWithoutPermission()throws InterruptedException {
        test = report.createTest("Failed creat secret API because of empty permission");
        hs.SettingsSideMenu();
        Thread.sleep(5000);
        hs.scrollToDev();
        Thread.sleep(3000);
        hs.linkAPIKey();
        test.log(Status.INFO, "Go to API page");
        Thread.sleep(10000);
        ss.clickCreateAPI();
        ss.inputAPIName();
        Thread.sleep(3000);
        ss.clickGenerateKey();
        Thread.sleep(3000);
        ss.errorIsExist();
        test.pass("Could not create secret key without permission");
        ss.clickCancelBtn();
        Thread.sleep(5000);
        
    }
    @Test (priority = 0)
    public void createSecret() throws InterruptedException {
        test = report.createTest("Created new secret API key successfully");
        try{
            hs.SettingsSideMenu();
            Thread.sleep(5000);
            hs.scrollToDev();
            Thread.sleep(3000);
            hs.linkAPIKey();
            test.log(Status.INFO, "Go to API page");
            Thread.sleep(10000);
            ss.clickCreateAPI();
            ss.inputAPIName();
            ss.setReadPermission();
            Thread.sleep(3000);
            ss.clickGenerateKey();
            test.log(Status.INFO, "Generating new secret");
            Thread.sleep(3000);
            ss.inputPasswordKey();
            test.log(Status.INFO, "Confirm creating new secret");
            Thread.sleep(3000);
            ss.successCreateKey();
            ss.setKey();
            hr.setSecretAPI(ss.setKey());
            test.log(Status.INFO, "New secret generated");
            Thread.sleep(5000);
            ss.closeModal();
        }catch(AssertionError e){
            test.fail("Fail to create new secret");
            ss.clickCloseErrBtn();
            ss.clickCancelBtn();
        }
    }

    @Test(priority = 1)
    public void updateSecretPermission() throws InterruptedException {
        test = report.createTest("Update secret permission successfully");
        try{
            Thread.sleep(3000);
            ss.clickEditKey();
            Thread.sleep(5000);
            ss.setWritePermission();
            ss.clickGenerateKey();
            Thread.sleep(3000);
            test.log(Status.INFO, "Editing permission's secret");
            ss.inputPasswordKey();
            test.log(Status.INFO, "Confirm editing permission's secret");
            Thread.sleep(10000);
            ss.successEditPermissionInfo();
            test.pass("Edit permission successfully");
            Thread.sleep(3000);
            ss.closeBtnOkay();

        }catch(AssertionError e){
            test.fail("Fail to edit permission");
            ss.clickCloseErrBtn();
            ss.clickCancelBtn();
        }   
    }

    @Test(priority = 2)
    public void requestVANoAuth()throws InterruptedException {
        test = report.createTest("Create Fixed Virtual Account without Secret Key");
        String bodyRequest = "{\n" +
        "  \"external_id\": \"demo_virtual_account_1475459775879\",\n" +
        "  \"bank_code\": \"BNI\",\n" +
        "  \"name\": \"Some name\"\n" +
        "}";
        Response response = RestAssured
        .given()
        .contentType(ContentType.JSON)
        .body(bodyRequest)
        .post("https://api.xendit.co/callback_virtual_accounts");
        response.prettyPrint();
        Thread.sleep(3000);
        respCode(response, 401);
        test.info(MarkupHelper.createCodeBlock(response.asString(), CodeLanguage.JSON));
                
    }

    @Test(priority = 3)
    public void requestVAAuth()throws InterruptedException {
        test = report.createTest("Create Fixed Virtual Account");
        String credential = hr.getSecretAPI()+": ";
        byte[] encodedSecret =Base64.encodeBase64(credential.getBytes());
        String decodeSecret = new String(encodedSecret);
        String bodyRequest = "{\n" +
        "  \"external_id\": \"demo_virtual_account_1475459775879\",\n" +
        "  \"bank_code\": \"BNI\",\n" +
        "  \"name\": \"Some name\"\n" +
        "}";
        Response response = RestAssured
        .given()
        .contentType(ContentType.JSON)
        .header("Authorization",  "Basic "+decodeSecret)
        .body(bodyRequest)
        .post("https://api.xendit.co/callback_virtual_accounts");

        response.prettyPrint();
        Thread.sleep(3000);
        respCode(response, 200);
        test.info(MarkupHelper.createCodeBlock(response.asString(), CodeLanguage.JSON));
                
    }

    @Test (priority = 4)
    public void validateVAList()throws InterruptedException {
        test = report.createTest("Verify Created VA is show correctly");
        try{
            cb.clickCallbackMenu();
            Thread.sleep(3000);
            cb.getStatus();
            cb.getProductType();
            test.log(Status.INFO, "Selected status is: "+cb.getTextStatus());
            test.log(Status.INFO, "Product type value is: "+cb.getTextType());
            test.pass("All List Value is correct");
        }
        catch(AssertionError e){
            test.fail("Expected status is [Completed]', Get ["+cb.getTextStatus()+"]");
            test.fail("Expected Product type [Virtual Account Status]', Get ["+cb.getTextType()+"]");
            
        }
    }

    public void respCode(Response response, int expectedResp) {	
    	if(response.getStatusCode() == expectedResp) {
        	test.log(Status.PASS, "Status Code is matched : "+response.getStatusCode());
    	}else {
        	test.log(Status.FAIL, "Status Code is not matched : "+response.getStatusCode());
    	}
    	
    }

    @AfterTest
    public void close(){
        quit();
        report.flush();
    }
    
}
