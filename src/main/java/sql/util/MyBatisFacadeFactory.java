package sql.util;

import sql.mybatis.*;

public class MyBatisFacadeFactory {

    private AddressDAO addressDAO;
    private AddressTypeDAO addressTypeDAO;
    private CityDAO cityDAO;
    private CompanyDAO companyDAO;
    private CompanyTypeDAO companyTypeDAO;
    private CountryDAO countryDAO;
    private CustomerDAO customerDAO;
    private JobTitleDAO jobTitleDAO;
    private OrderDAO orderDAO;
    private PackageDAO packageDAO;
    private PackageTypeDAO packageTypeDAO;
    private StaffDAO staffDAO;
    private StatusDAO statusDAO;

    public MyBatisFacadeFactory() {
        addressDAO = new AddressDAO();
        addressTypeDAO = new AddressTypeDAO();
        cityDAO = new CityDAO();
        companyDAO = new CompanyDAO();
        companyTypeDAO = new CompanyTypeDAO();
        countryDAO = new CountryDAO();
        customerDAO = new CustomerDAO();
        jobTitleDAO = new JobTitleDAO();
        orderDAO = new OrderDAO();
        packageDAO = new PackageDAO();
        packageTypeDAO = new PackageTypeDAO();
        staffDAO = new StaffDAO();
        statusDAO = new StatusDAO();
    }

    public AddressDAO useAddress() {
        return addressDAO;
    }

    public AddressTypeDAO useAddressType() {
        return addressTypeDAO;
    }

    public CityDAO useCity() {
        return cityDAO;
    }

    public CompanyDAO useCompany() {
        return companyDAO;
    }

    public CompanyTypeDAO useCompanyType() {
        return companyTypeDAO;
    }

    public CountryDAO useCountry() {
        return countryDAO;
    }

    public CustomerDAO useCustomer() {
        return customerDAO;
    }

    public JobTitleDAO useJobTitle() {
        return jobTitleDAO;
    }

    public OrderDAO useOrder() {
        return orderDAO;
    }

    public PackageDAO usePackage() {
        return packageDAO;
    }

    public PackageTypeDAO usePackageType() {
        return packageTypeDAO;
    }

    public StaffDAO useStaff() {
        return staffDAO;
    }

    public StatusDAO useStatus() {
        return statusDAO;
    }
}
