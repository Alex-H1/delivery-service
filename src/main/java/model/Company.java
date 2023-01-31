package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Company {

    @JsonProperty
    private Integer companyId;
    @JsonProperty
    private String companyName;
    @JsonProperty
    private Integer companyType;

    public Company() {

    }

    public Company(Integer companyId, String companyName, Integer companyType) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyType = companyType;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    @XmlTransient
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getCompanyType() {
        return companyType;
    }

    public void setCompanyType(Integer companyType) {
        this.companyType = companyType;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyType=" + companyType +
                '}';
    }
}
