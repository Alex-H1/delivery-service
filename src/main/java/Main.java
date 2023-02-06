import exception.UnsuportedTypeException;
import model.Company;
import model.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.IBaseDAO;
import sql.jdbc.CompanyDAO;
import sql.jdbc.CustomerDAO;
import sql.util.DBFactoryGenerator;
import sql.util.FacadeFactory;

import java.sql.SQLException;
import java.util.List;

import static sql.util.DBConnectionType.JDBC;
import static sql.util.DBConnectionType.MYBATIS;

public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException, UnsuportedTypeException {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customers = customerDAO.getAll();
        LOG.info(customers.toString());
        CompanyDAO companyDAO = new CompanyDAO();
        List<Company> companyList = companyDAO.getAll();
        LOG.info(companyList);


    }
}
