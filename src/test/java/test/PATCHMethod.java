package test;

import com.google.gson.Gson;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.PostBody;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PATCHMethod {
    public static void main(String[] args) {
        String baseUri = "https://jsonplaceholder.typicode.com";
        RequestSpecification request = given();
        request.baseUri(baseUri);

        //Content-type
        request.header(new Header("Content-type", "application/json; charset=UTF-8"));

        //Construct body
        PostBody postBody = new PostBody();
        postBody.setTitle("New path title");

        // Parse to string
        Gson gson = new Gson();
        String postBodyStr = gson.toJson(postBody);

        //Send request
        final int TAR_PUT_NUM = 1;
        Response response =request.body(postBodyStr).patch("/posts/".concat(String.valueOf(TAR_PUT_NUM)));
        response.prettyPrint();

        //Verification
        response.then().body("title", equalTo(postBody.getTitle()));

    }
}
