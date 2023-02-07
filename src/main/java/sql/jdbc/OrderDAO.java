package sql.jdbc;


import model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.ConnectionPool;
import sql.IOrderDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements IOrderDAO {

    private static final Logger LOG = LogManager.getLogger(OrderDAO.class);
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();


    public void saveEntity(Order model) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "INSERT INTO orders(customer_id, package_id, status_id, " +
                "delivery_employee_id, amount)"
                + "VALUES((?), (?), (?), (?), (?))";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, model.getCustomerId());
            ps.setInt(2, model.getOrderId());
            ps.setInt(3, model.getStatus());
            ps.setInt(4, model.getDeliveryEmployeeId());
            ps.setDouble(5, model.getAmount());
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

    public Order getEntityByID(int id) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM orders WHERE order_id=(?)";
        Order order = new Order();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.getResultSet();
            order.setOrderId((rs.getInt("order_id")));
            order.setBoxId(rs.getInt("package_id"));
            order.setStatus(rs.getInt("status_id"));
            order.setDeliveryEmployeeId(rs.getInt("delivery_employee_id"));
            order.setAmount(rs.getDouble("amount"));


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
        return order;
    }

    @Override
    public void updateEntity(Order model) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "UPDATE orders SET customer_id, package_id, status_id, " +
                "delivery_employee_id, amount)"
                + "WHERE order_id=(?)";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, model.getCustomerId());
            ps.setInt(2, model.getOrderId());
            ps.setInt(3, model.getStatus());
            ps.setInt(4, model.getDeliveryEmployeeId());
            ps.setDouble(5, model.getAmount());
            ps.setInt(5, model.getOrderId());
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
        String query = "DELETE FROM orders WHERE order_id=(?)";
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
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM orders WHERE order_id=(?)";
        List<Order> orderList = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderId((rs.getInt("order_id")));
                order.setBoxId(rs.getInt("package_id"));
                order.setStatus(rs.getInt("status_id"));
                order.setDeliveryEmployeeId(rs.getInt("delivery_employee_id"));
                order.setAmount(rs.getDouble("amount"));
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
        return orderList;
    }

    @Override
    public List<Order> getOrderByDeliveryEmployee(int id) {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM orders WHERE delivery_employee_id=(?)";
        List<Order> orderList = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderId((rs.getInt("order_id")));
                order.setBoxId(rs.getInt("package_id"));
                order.setStatus(rs.getInt("status_id"));
                order.setDeliveryEmployeeId(rs.getInt("delivery_employee_id"));
                order.setAmount(rs.getDouble("amount"));
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
        return orderList;
    }
}
