package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;

@XmlRootElement
public class Staff {
    @JsonProperty
    private Integer employeeId;
    @JsonProperty
    private String firstName;
    @JsonProperty
    private String lastName;
    @JsonProperty
    private Integer jobTitleId;
    @JsonProperty
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern =" yyyyy-MM-dd")
    private Date dateHired;

    public Staff() {

    }

    public Staff(Integer employeeId, String firstName, String lastName, Integer jobTitleId, Date dateHired) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.jobTitleId = jobTitleId;
        this.dateHired = dateHired;
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

    public Date getDateHired() {
        return dateHired;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getJobTitleId() {
        return jobTitleId;
    }
    @XmlTransient

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setJobTitleId(Integer jobTitleId) {
        this.jobTitleId = jobTitleId;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", jobTitleId=" + jobTitleId +
                ", dateHired=" + dateHired +
                '}';
    }
}
