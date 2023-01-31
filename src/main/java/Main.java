import model.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.jdbc.CustomerDAO;

import java.sql.SQLException;
import java.util.List;

public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws SQLException {
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customers = customerDAO.getAll();
        LOG.info(customers.toString());

    }
}
