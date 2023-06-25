import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

public class ReqResPOST_Example {

    public static void main(String[] args) {
        // Initiating the Base URI with only domain part
        RestAssured.baseURI = "https://reqres.in/";
        // Calling given method will create an object of implementing class of RequestSpecification
        // & return it
        RequestSpecification postRequest = RestAssured.given();
        // Creeate a Header for Content-Type and add to request
        postRequest.header(new Header("Content-Type", "application/json"));
        // We are constructing the request body using org.json "JSONObject" class
//        JSONObject reqBody = new JSONObject();
//        reqBody.put("nam", "Kaarthik");
//        reqBody.put("job", "API Trainer");

        // Example of using JAVA POJO object to generate req body ..

        ReqResPostBody reqResPostBody = new ReqResPostBody();
        reqResPostBody.setName("Kaarthik");
        reqResPostBody.setJob("API Trainer");

        // Set the body in POST request
        postRequest.body(reqResPostBody);
        // Trigger the POST request
        Response postResponse = postRequest.post("/api/users");
        // Get status code & response
        System.out.println(postResponse.statusCode());
        postResponse.prettyPrint();




    }
}
