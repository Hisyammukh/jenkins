package TestSuite;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.codec.binary.Base64;
import org.testng.annotations.Test;
public class CreateVATest {
    @Test
    public void requestVAAuth(){
        String ooo = "xnd_development_4cM3qVcyEsdfTIiEpJlHPHfVBZ1AKxRUYkh0qsLpmAHp0PRXDuP3CkHJcayJ:  ";
        byte[] encodedSecret =Base64.encodeBase64(ooo.getBytes());
        String decodeSecret = new String(encodedSecret);
        String bodi = "{\n" +
        "  \"external_id\": \"demo_virtual_account_1475459775879\",\n" +
        "  \"bank_code\": \"BNI\",\n" +
        "  \"name\": \"Some name\"\n" +
        "}";
        
        Response response = RestAssured
        .given()
        .contentType(ContentType.JSON)
        .header("Authorization",  "Basic "+decodeSecret)
        
        .body(bodi)
        .post("https://api.xendit.co/callback_virtual_accounts");

        response.prettyPrint();
                
    }
    
}
