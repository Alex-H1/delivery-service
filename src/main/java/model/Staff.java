package main.java.model;

public class Staff {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private Integer jobTitle;

    public Staff() {

    }


    public Integer getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getJobTitle() {
        return jobTitle;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setJobTitle(Integer jobTitle) {
        this.jobTitle = jobTitle;
    }
}
