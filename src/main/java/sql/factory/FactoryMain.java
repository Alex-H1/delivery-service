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
import sql.util.JDBCFacadeFactory;
import sql.util.MyBatisFacadeFactory;

import java.sql.SQLException;
import java.util.List;

import static sql.util.DBConnectionType.JDBC;
import static sql.util.DBConnectionType.MYBATIS;

public class FactoryMain {

    private static final Logger LOG = LogManager.getLogger(FactoryMain.class);

    public static void main(String[] args) throws UnsuportedTypeException, SQLException {
        IBaseDAO customerDAO = DBFactoryGenerator.getFactory(JDBC).getDAO("customer");
        List<Company> customerList = customerDAO.getAll();
        LOG.info(customerList);

        IBaseDAO companyDAO = DBFactoryGenerator.getFactory(MYBATIS).getDAO("company");
        List<Company> companyList = companyDAO.getAll();
        LOG.info(companyList);

        IBaseDAO<Customer> customerDAO1 = DBFactoryGenerator.getFactory(JDBC).getDAO("customer");
        customerDAO1.saveEntity(new Customer("Johnny", "A", "Appleseed", "(617)414-4270", 3, 23));

        JDBCFacadeFactory jdbcFacadeFactory = new JDBCFacadeFactory();
        jdbcFacadeFactory.useCustomer().saveEntity(new Customer(2,"Sponge", "S", "Bob", "(435)683-5574", 4, 23));
        jdbcFacadeFactory.useStaff().saveEntity(new Staff(2, "Bert", "K", 5));

        MyBatisFacadeFactory myBatisFacadeFactory = new MyBatisFacadeFactory();
        myBatisFacadeFactory.useCustomer().saveEntity(new Customer(3,"Patrick", "*", "Star", "(354)356-3453", 3, 23));
    }
}
