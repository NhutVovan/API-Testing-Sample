package test;

import Builder.BodyJsonBuilder;
import Builder.IssueContentBuilder;
import com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.IssueFields;
import model.Requestcapability;
import utils.AuthenticationHandler;
import utils.ProjectInfo;

import static io.restassured.RestAssured.given;

public class JiraNewIssue implements Requestcapability {
    public static void main(String[] args) {
        //API info
        String baseUri = "https://nhutvo.atlassian.net";
        String path = "/rest/api/3/issue";
        String projectKey = "NHUT";

        String email = "nhutvovan@gmail.com";
        String apiToken = "vaGdIPOUJ5Rpa3qLZGrCCEF4";
        String encodeCreditStr = AuthenticationHandler.encodedCredStr(email, apiToken);

        //Request object
        RequestSpecification request = given();
        request.baseUri(baseUri);
        request.header(defaultHeader);
        request.header(acceptJSONHeader);
        request.header(Requestcapability.getAuthenticatedHeader(encodeCreditStr));

        //Define body data
        ProjectInfo projectInfo = new ProjectInfo(baseUri, projectKey);
        String taskTypeId = projectInfo.getIssueTypeId("task");
        String summary = "This is my summary | IssueContentBuilder";

        String issueFieldsContent = IssueContentBuilder.Build(projectKey, taskTypeId, summary);

        //Send request
        Response response = request.body(issueFieldsContent).post(path);
        response.prettyPrint();

    }
}
