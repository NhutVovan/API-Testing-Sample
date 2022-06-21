package test;
import com.google.gson.Gson;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.PostBody;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;


public class PUTMethod {
    public static void main(String[] args) {
        String baseUri = "https://jsonplaceholder.typicode.com";
        RequestSpecification request = given();
        request.baseUri(baseUri);

        //Content-type
        request.header(new Header("Content-type", "application/json; charset=UTF-8"));

        //Construct body
        PostBody postBody = new PostBody();
        postBody.setUserId(1);
        postBody.setId(1);
        postBody.setTitle("New title");
        postBody.setBody("New body");

        Gson gson = new Gson();
        String postBodyStr = gson.toJson(postBody);

        //Send request
        final int TAR_PUT_NUM = 1;
        Response response =request.body(postBodyStr).put("/posts/".concat(String.valueOf(TAR_PUT_NUM)));
        response.prettyPrint();

        //Verification
        response.then().body("userId", equalTo(postBody.getUserId()));
        response.then().body("id", equalTo(postBody.getId()));
        response.then().body("title", equalTo(postBody.getTitle()));
        response.then().body("body", equalTo(postBody.getBody()));

    }
}
