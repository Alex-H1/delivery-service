package sql.jdbc;

import model.Customer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.ConnectionPool;
import sql.ICustomerDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {
    private static final Logger LOG = LogManager.getLogger(CustomerDAO.class);
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void saveEntity(Customer model) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "INSERT INTO customers(first_name, last_name, phone_number, " +
                "address_id, company_id, middle_initial)"
                + "VALUES((?), (?), (?), (?), (?), (?))";
        try (PreparedStatement ps = c.prepareStatement(query)) {

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
            if (c != null) {
                try {
                    connectionPool.releaseConnection(c);
                } catch (SQLException e) {
                    LOG.error(e.getMessage());
                }
            }
        }
    }

    @Override
    public void saveEntity(Object model) throws SQLException {

    }

    public Customer getEntityByID(int id) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM customers WHERE customer_id=(?)";
        Customer customer = new Customer();

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.getResultSet();
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
            if (c != null) {
                try {
                    connectionPool.releaseConnection(c);
                } catch (SQLException e) {
                    LOG.error(e.getMessage());
                }
            }
        }
        return customer;
    }

    @Override
    public void updateEntity(Object model) throws SQLException {

    }


    @Override
    public Customer getCustomerByPhoneNumber(String phoneNumber) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM customers WHERE phone_number=(?)";
        Customer customer = new Customer();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, Integer.parseInt(phoneNumber));
            ResultSet rs = ps.getResultSet();
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
            if (c != null) {
                try {
                    connectionPool.releaseConnection(c);
                } catch (SQLException e) {
                    LOG.error(e.getMessage());
                }
            }
        }
        return customer;
    }

    public void updateEntity(Customer model) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "UPDATE customers SET first_name=(?), last_name, " +
                "phone_number, address_id, company_id, middle_initial=(?) " +
                "WHERE customer_id=(?)";
        try (PreparedStatement ps = c.prepareStatement(query)) {
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
            if (c != null) {
                try {
                    connectionPool.releaseConnection(c);
                } catch (SQLException e) {
                    LOG.error(e.getMessage());
                }
            }
        }
    }

    public void removeEntity(int id) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "DELETE FROM countries WHERE country_id=(?)";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            if (c != null) {
                try {
                    connectionPool.releaseConnection(c);
                } catch (SQLException e) {
                    LOG.error(e.getMessage());
                }
            }
        }
    }

    public List getAll() throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM customers";
        List<Customer> customerList = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Customer customer = new Customer();
                    customer.setCustomerId((rs.getInt("customer_id")));
                    customer.setFirstName(rs.getString("first_name"));
                    customer.setLastName(rs.getString("last_name"));
                    customer.setCompany(rs.getInt("company_id"));
                    customer.setMiddleInitial(rs.getString("middle_initial"));
                    customer.setPhoneNumber(rs.getString("phone_number"));
                    customer.setAddress(rs.getInt("address_id"));
                    customerList.add(customer);
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            if (c != null) {
                try {
                    connectionPool.releaseConnection(c);
                } catch (SQLException e) {
                    LOG.error(e.getMessage());
                }
            }
        }
        return customerList;
    }

}
