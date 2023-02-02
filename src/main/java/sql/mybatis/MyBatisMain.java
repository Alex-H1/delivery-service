package sql.mybatis;

import model.Company;
import model.Customer;
import model.Staff;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.SQLException;
import java.util.List;

public class MyBatisMain {

    private static final Logger LOG = LogManager.getLogger("TEST_LOGGER");

    public static void main(String[] args) throws SQLException {
        AddressDAO addressDAO = new AddressDAO();
        AddressTypeDAO addressTypeDAO = new AddressTypeDAO();
        CityDAO cityDAO = new CityDAO();
        CompanyDAO companyDAO = new CompanyDAO();
        CompanyTypeDAO companyTypeDAO = new CompanyTypeDAO();
        CountryDAO countryDAO = new CountryDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        JobTitleDAO jobTitleDAO = new JobTitleDAO();
        OrderDAO orderDAO = new OrderDAO();
        PackageDAO packageDAO = new PackageDAO();
        PackageTypeDAO packageTypeDAO = new PackageTypeDAO();
        StaffDAO staffDAO = new StaffDAO();
        StatusDAO statusDAO = new StatusDAO();

        Customer customer1 = new Customer(1, "Jesus", "O", "F", "(345)423-2344", 3, 23);
        Customer customer2 = new Customer(2, "Manuel", "P", "H", "(502)345-4323", 4, 24);
        Staff staff1 = new Staff(1,"Alex", "H", 4);
        Staff staff2 = new Staff(2,"Janet", "b", 6);
        Company company1 = new Company(1, "kohls", 33);
        Company company2 = new Company(2, "harborFreight", 22);
        customerDAO.saveEntity(customer1);
        customerDAO.saveEntity(customer2);
        List<Customer> customerList = customerDAO.getAll();
        List<Staff> staffList = staffDAO.getAll();
        List<Company> companyList = companyDAO.getAll();
        LOG.info(customerList);
        LOG.info(staffList);
        LOG.info(companyList);


    }
}
