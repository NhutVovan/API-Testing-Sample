package test;

import model.Requestcapability;
import utils.ProjectInfo;


public class JiraIssueTypes implements Requestcapability {
    public static void main(String[] args) {
        String baseUri = "https://nhutvo.atlassian.net";
        String projectKey = "NHUT";

        ProjectInfo projectInfo = new ProjectInfo(baseUri, projectKey);
        System.out.println("Task id: " + projectInfo.getIssueTypeId("Task"));

    }
}
