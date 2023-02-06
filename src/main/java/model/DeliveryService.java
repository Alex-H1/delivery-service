package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement(name = "delivery_service")
@XmlType(propOrder = {"customers", "staff", "companies", "companyTypes", "countries"})
public class DeliveryService {

    @JsonProperty
    private List<Customer> customers;
    @JsonProperty
    private List<Staff> staff;
    @JsonProperty
    private List<Company> companies;
    @JsonProperty
    private List<CompanyType> companyTypes;
    @JsonProperty
    private List<Country> countries;

    public DeliveryService(List<Customer> customers, List<Staff> staff, List<Company> companies, List<CompanyType> companyTypes, List<Country> countries) {
        this.customers = customers;
        this.staff = staff;
        this.companies = companies;
        this.companyTypes = companyTypes;
        this.countries = countries;
    }

    public DeliveryService() {
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    @XmlElementWrapper(name = "customers")
    @XmlElement(name = "customer", type = Customer.class)
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<model.Staff> getStaff() {
        return staff;
    }

    @XmlElementWrapper(name = "staff")
    @XmlElement(name = "staff")
    public void setStaff(List<model.Staff> staff) {
        staff = staff;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    @XmlElementWrapper(name = "companies")
    @XmlElement(name = "comapany", type = Company.class)
    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<CompanyType> getCompanyTypes() {
        return companyTypes;
    }

    @XmlElementWrapper(name = "companyTypes")
    @XmlElement(name = "companyTypes")
    public void setCompanyTypes(List<CompanyType> companyTypes) {
        this.companyTypes = companyTypes;
    }

    public List<Country> getCountries() {
        return countries;
    }

    @XmlElementWrapper(name = "countries")
    @XmlElement(name = "country", type = Country.class)
    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    @Override
    public String toString() {
        return "DeliveryService{" +
                "customers=" + customers +
                ", Staff=" + staff +
                ", companies=" + companies +
                ", companyTypes=" + companyTypes +
                ", countries=" + countries +
                '}';
    }
}
