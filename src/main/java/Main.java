package main.java;

import main.java.model.Customer;
import main.java.sql.ConnectionPool;
import main.java.sql.jdbc.CustomerDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void  main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionPool.getInstance();
        CustomerDAO customerDAO = new CustomerDAO();
        List<Customer> customers = customerDAO.getAll();
        LOG.info(customers);
    }
}
