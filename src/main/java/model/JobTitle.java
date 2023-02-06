package model;

public class JobTitle {
    private Integer jobTitleId;
    private String jobTitle;

    public JobTitle() {
    }

    public Integer getJobTitleId() {
        return jobTitleId;
    }

    public void setJobTitleId(Integer jobTitleId) {
        this.jobTitleId = jobTitleId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return "JobTitle{" +
                "jobTitleId=" + jobTitleId +
                ", jobTitle='" + jobTitle + '\'' +
                '}';
    }
}
