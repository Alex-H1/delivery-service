package model;

public class CompanyType {
    private Integer companyTypeId;
    private String companytypeName;

    public CompanyType() {

    }

    public Integer getCompanyTypeId() {
        return companyTypeId;
    }

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
