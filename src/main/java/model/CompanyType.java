package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class CompanyType {
    @JsonProperty
    private Integer companyTypeId;
    @JsonProperty
    private String companytypeName;

    public CompanyType() {

    }

    public CompanyType(Integer companyTypeId, String companytypeName) {
        this.companyTypeId = companyTypeId;
        this.companytypeName = companytypeName;
    }

    public Integer getCompanyTypeId() {
        return companyTypeId;
    }
    @XmlTransient
    public void setCompanyTypeId(Integer companyTypeId) {
        this.companyTypeId = companyTypeId;
    }

    public String getCompanytypeName() {
        return companytypeName;
    }

    public void setCompanytypeName(String companytypeName) {
        this.companytypeName = companytypeName;
    }

    @Override
    public String toString() {
        return "CompanyType{" +
                "companyTypeId=" + companyTypeId +
                ", companytypeName='" + companytypeName + '\'' +
                '}';
    }
}
