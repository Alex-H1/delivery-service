import exception.UnsuportedTypeException;
import model.Company;
import model.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.IBaseDAO;
import sql.util.DBFactoryGenerator;
import sql.util.FacadeFactory;

import java.sql.SQLException;
import java.util.List;

import static sql.util.DBConnectionType.JDBC;
import static sql.util.DBConnectionType.MYBATIS;

public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException, UnsuportedTypeException {
//        CustomerDAO customerDAO = new CustomerDAO();
//        List<Customer> customers = customerDAO.getAll();
//        LOG.info(customers.toString());
//        CompanyDAO companyDAO = new CompanyDAO();
//        List<Company> companyList = companyDAO.getAll();
//        LOG.info(companyList);

//        IBaseDAO customerDAO = DBFactoryGenerator.getFactory(JDBC).getDAO("customer");
//        List<Company> customerList = customerDAO.getAll();
//        LOG.info(customerList);
//
//        IBaseDAO companyDAO = DBFactoryGenerator.getFactory(MYBATIS).getDAO("company");
//        List<Company> companyList = companyDAO.getAll();
//        LOG.info(companyList);

        IBaseDAO<Customer> customerDAO1 = DBFactoryGenerator.getFactory(JDBC).getDAO("customer");
        customerDAO1.saveEntity(new Customer("Johnny", "A", "Appleseed", "(617)414-4270", 3, 23));

        FacadeFactory factory = new FacadeFactory();
        IBaseDAO customer = factory.createDAO("customer");
        List<Customer> customerList1 = customer.getAll();
        LOG.info(customerList1);

//        IBaseDAO companyDAO1 = factory.createMyBatis("company");
//        List<Company> companyList1 = companyDAO1.getAll();
//        LOG.info(companyList1);
    }
}
