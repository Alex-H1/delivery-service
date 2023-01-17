package main.java.sql.jdbc;


import main.java.model.Order;
import main.java.sql.ConnectionPool;
import main.java.sql.IOrderDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IOrderDAO {
    private static final Logger LOG = LogManager.getLogger(OrderDAO.class);

    @Override
    public void saveEntity(Order model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "INSERT INTO orders(customer_id, package_id, status_id, " +
                "delivery_employee_id, amount)"
                + "VALUES((?), (?), (?), (?), (?))";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, model.getCustomer());
            ps.setInt(2, model.getOrderId());
            ps.setInt(3, model.getStatus());
            ps.setInt(4, model.getDeliveryEmployee());
            ps.setDouble(5, model.getAmount());
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

    public Order getEntityByID(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM orders WHERE order_id=(?)";
        Order order = new Order();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.getResultSet();
            order.setOrderId((rs.getInt("order_id")));
            order.setBox(rs.getInt("package_id"));
            order.setStatus(rs.getInt("status_id"));
            order.setDeliveryEmployee(rs.getInt("delivery_employee_id"));
            order.setAmount(rs.getDouble("amount"));


        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return order;
    }

    @Override
    public void updateEntity(Object model) throws SQLException {

    }

    public void updateEntity(Order model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "UPDATE orders SET customer_id, package_id, status_id, " +
                "delivery_employee_id, amount)"
                + "WHERE order_id=(?)";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, model.getCustomer());
            ps.setInt(2, model.getOrderId());
            ps.setInt(3, model.getStatus());
            ps.setInt(4, model.getDeliveryEmployee());
            ps.setDouble(5, model.getAmount());
            ps.setInt(5, model.getOrderId());
            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
        }
    }

    public void removeEntity(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "DELETE FROM orders WHERE order_id=(?)";
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
        String query = "SELECT * FROM orders WHERE order_id=(?)";
        List<Order> orderList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            rs = ps.getResultSet();
            while(rs.next()) {
                Order order = new Order();
                order.setOrderId((rs.getInt("order_id")));
                order.setBox(rs.getInt("package_id"));
                order.setStatus(rs.getInt("status_id"));
                order.setDeliveryEmployee(rs.getInt("delivery_employee_id"));
                order.setAmount(rs.getDouble("amount"));
            }

        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return orderList;
    }
}
