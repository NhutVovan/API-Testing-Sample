package test;

import com.google.gson.Gson;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.PostBody;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;

public class POSTMethod {
    public static void main(String[] args) {
        //Request specification object
        String baseUri = "https://jsonplaceholder.typicode.com";
        RequestSpecification request = given();
        request.baseUri(baseUri);

        //Content-type
        request.header(new Header("Content-type", "application/json; charset=UTF-8"));

        //Form up request body
//        String postBody = "{\n" +
//                "  \"userId\": 1,\n" +
//                "  \"id\": 1,\n" +
//                "  \"title\": \"The request title\",\n" +
//                "  \"body\": \"The request body\"\n" +
//                "}";

        //Gson
        Gson gson = new Gson();
        PostBody postBody = new PostBody();
        postBody.setUserId(1);
        postBody.setId(1);
        postBody.setTitle("The request title");
        postBody.setBody("The request body");

        //Send POST request
        Response response = request.body(gson.toJson(postBody)).post("/posts");
        response.prettyPrint();

        //Verification
        response.then().statusCode(equalTo(201));
        response.then().statusLine(containsStringIgnoringCase("201 Created"));
        response.then().body("userId", equalTo(1));
        response.then().body("title", equalTo("The request title"));
        response.then().body("body", equalTo("The request body"));
    }
}
