package test;
import com.google.gson.Gson;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.PostBody;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class PUTMethod_Multi {
    public static void main(String[] args) {
        String baseUri = "https://jsonplaceholder.typicode.com";
        RequestSpecification request = given();
        request.baseUri(baseUri);

        //Content-type
        request.header(new Header("Content-type", "application/json; charset=UTF-8"));

        //Construct body
        PostBody postBody1 = new PostBody(1, 1, "New title 1", "New body 1");
        PostBody postBody2 = new PostBody(1, 1, "New title 2", "New body 2");
        PostBody postBody3 = new PostBody(1, 1, "New title 3", "New body 3");
        PostBody postBody4 = new PostBody(1, 1, "New title 4", "New body 4");
        PostBody postBody5 = new PostBody(1, 1, "New title 5", "New body 5");

        List<PostBody> postBodyList = Arrays.asList(postBody1, postBody2, postBody3, postBody4, postBody5);

        for (PostBody postBody : postBodyList) {
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
}
