package model;

import com.google.gson.Gson;

public class IssueFields {
    private Fields fields;

    public IssueFields(Fields fields) {
        this.fields = fields;
    }

    public Fields getFields() {
        return fields;
    }



    public static class Fields{
        private Project project;
        private IssueType issuetype;
        private String summary;



        public Fields(Project project, IssueType issuetype, String summary) {
            this.project = project;
            this.issuetype = issuetype;
            this.summary = summary;
        }


        public void setProject(Project project) {
            this.project = project;
        }


        public void setIssuetype(IssueType issuetype) {
            this.issuetype = issuetype;
        }

        public Project getProject() {
            return project;
        }

        public IssueType getIssuetype() {
            return issuetype;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getSummary() {
            return summary;
        }
    }

    public static class Project{
        private String key;

        public Project(String key) {
            this.key = key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }
    }

    public static class IssueType{

        private String id;

        public IssueType(String id) {
            this.id = id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

    }

    public static void main(String[] args) {
        String summary = "This is my summary";
        IssueType issueType = new IssueType("10002");
        Project project = new Project("NHUT");
        Fields fields = new Fields(project, issueType, summary);
        IssueFields issueFields = new IssueFields(fields);

        System.out.println(new Gson().toJson(issueFields));
    }
}
