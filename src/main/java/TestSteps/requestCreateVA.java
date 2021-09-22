package TestSteps;
import Object.HeaderReq;
import Object.VAObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.codec.binary.Base64;

public class requestCreateVA {
    RequestSpecification request;
    HeaderReq head;
    VAObject createVAObj;
    
    public requestCreateVA(){
        
    }
    // public RequestSpecification requestCreateVA(){
    //     head = new HeaderReq();
    //     createVAObj = new VAObject();
    //     RestAssured.baseURI = "https://api.xendit.co";

    //     // request = RestAssured.given().auth().basic(head.getSecretAPI());

    //     // // request =   given().auth().basic(head.getSecretAPI())
    //     // //             .formParam("external_id", createVAObj.getExternalID())
    //     // //             .formParam("bank_code", createVAObj.getBankCode())
    //     // //             .formParam("name", createVAObj.getName());

    //     return request;
    // }

    public void requestVAAuth(){
        byte[] encodedSecret =Base64.encodeBase64(head.getSecretAPI().getBytes());
        String decodeSecret = new String(encodedSecret);
        RequestSpecification httpRequest = RestAssured.given().header("Authorization", "Basic "+decodeSecret)
                                           .formParam("external_id", "demo_virtual_account_1475459775879")
                                           .formParam("bank_code", "BNI")
                                           .formParam("name", "Hisyam Mukharor");

        Response resp = httpRequest.post("https://api.xendit.co/callback_virtual_accounts");
        resp.prettyPrint();
    }

}