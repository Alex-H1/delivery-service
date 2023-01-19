package main.java.sql.jdbc;

import main.java.model.Customer;
import main.java.sql.ConnectionPool;
import main.java.sql.ICustomerDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {
    private static final Logger LOG = LogManager.getLogger(CustomerDAO.class);

    public void saveEntity(Customer model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "INSERT INTO customers(first_name, last_name, phone_number, " +
                "address_id, company_id, middle_initial)"
                + "VALUES((?), (?), (?), (?), (?), (?))";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, model.getFirstName());
            ps.setString(2, model.getLastName());
            ps.setString(3, model.getPhoneNumber());
            ps.setInt(4, model.getAddress());
            ps.setInt(5, model.getCompany());
            ps.setString(6, model.getMiddleInitial());
            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
        }
    }

    @Override
    public void saveEntity(Object model) throws SQLException {

    }

    public Customer getEntityByID(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM customers WHERE customer_id=(?)";
        Customer customer = new Customer();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.getResultSet();
            customer.setCustomerId((rs.getInt("customer_id")));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customer.setPhoneNumber(rs.getString("phone_number"));
            customer.setAddress(rs.getInt("address_id"));
            customer.setCompany(rs.getInt("company_id"));
            customer.setMiddleInitial(rs.getString("middle_initial"));

        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return customer;
    }

    @Override
    public void updateEntity(Object model) throws SQLException {

    }

    public void updateEntity(Customer model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "UPDATE customers SET first_name=(?), last_name, " +
                "phone_number, address_id, company_id, middle_initial=(?) " +
                "WHERE customer_id=(?)";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, model.getFirstName());
            ps.setString(2, model.getLastName());
            ps.setString(3, model.getPhoneNumber());
            ps.setInt(4, model.getAddress());
            ps.setInt(5, model.getCompany());
            ps.setString(6, model.getMiddleInitial());
            ps.setInt(7, model.getCustomerId());

            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
        }
    }

    public void removeEntity(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "DELETE FROM countries WHERE country_id=(?)";
        PreparedStatement ps = c.prepareStatement(query);
        try {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
        }
    }

    public List getAll() throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM customers ";
        List<Customer> customerList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            rs = ps.getResultSet();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerId((rs.getInt("customer_id")));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setPhoneNumber(rs.getString("phone_number"));
                customer.setAddress(rs.getInt("address_id"));
                customer.setCompany(rs.getInt("company_id"));
                customer.setMiddleInitial(rs.getString("middle_initial"));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return customerList;
    }

    public Customer getCustomerByPhoneNumber(String phoneNumber) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM customers WHERE phone_number=(?)";
        Customer customer = new Customer();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, Integer.parseInt(phoneNumber));
            rs = ps.getResultSet();
            customer.setCustomerId((rs.getInt("customer_id")));
            customer.setFirstName(rs.getString("first_name"));
            customer.setLastName(rs.getString("last_name"));
            customer.setPhoneNumber(rs.getString("phone_number"));
            customer.setAddress(rs.getInt("address_id"));
            customer.setCompany(rs.getInt("company_id"));
            customer.setMiddleInitial(rs.getString("middle_initial"));

        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return customer;
    }
}
