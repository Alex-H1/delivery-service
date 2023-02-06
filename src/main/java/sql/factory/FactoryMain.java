package sql.factory;

import exception.UnsuportedTypeException;
import model.Company;
import model.Customer;
import model.Staff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.IBaseDAO;
import sql.ICustomerDAO;
import sql.IStaffDAO;
import sql.jdbc.CustomerDAO;
import sql.jdbc.StaffDAO;
import sql.util.DBFactoryGenerator;
import sql.util.FacadeFactory;

import java.sql.SQLException;
import java.util.List;

import static sql.util.DBConnectionType.JDBC;
import static sql.util.DBConnectionType.MYBATIS;

public class FactoryMain {

    private static final Logger LOG = LogManager.getLogger(FactoryMain.class);

    public static void main(String[] args) throws UnsuportedTypeException, SQLException {
//        IBaseDAO customerDAO = DBFactoryGenerator.getFactory(JDBC).getDAO("customer");
//        List<Company> customerList = customerDAO.getAll();
//        LOG.info(customerList);
//
//        IBaseDAO companyDAO = DBFactoryGenerator.getFactory(MYBATIS).getDAO("company");
//        List<Company> companyList = companyDAO.getAll();
//        LOG.info(companyList);
//
//        IBaseDAO<Customer> customerDAO1 = DBFactoryGenerator.getFactory(JDBC).getDAO("customer");
//        customerDAO1.saveEntity(new Customer("Johnny", "A", "Appleseed", "(617)414-4270", 3, 23));

//        FacadeFactory factory = new FacadeFactory();
//        IBaseDAO customer = factory.createDAO("customer");
//        List<Customer> customerList1 = customer.getAll();
//        LOG.info(customerList1);
//
//        IBaseDAO companyDAO1 = factory.createMyBatis("company");
//        List<Company> companyList1 = companyDAO1.getAll();
//        LOG.info(companyList1);

        Staff staff = new Staff(1, "Jimmy", "yang", 5);
        IStaffDAO staffDAO = new StaffDAO();
        staffDAO.saveEntity(staff);
        List<Staff> staffList = staffDAO.getAll();
        LOG.info(staffList);

        Customer customer1 = new Customer(2, "Patrick", "*","Star","(345)235-1582", 3, 23);
        ICustomerDAO iCustomerDAO = new CustomerDAO();
        iCustomerDAO.saveEntity(customer1);
        List<Customer> customerList = iCustomerDAO.getAll();
        LOG.info(customerList);

        ICustomerDAO iCustomerDAO1 = new sql.mybatis.CustomerDAO();
        iCustomerDAO1.removeEntity(44);
        LOG.info(customerList);

    }


}
