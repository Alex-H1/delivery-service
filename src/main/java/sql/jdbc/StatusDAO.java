package main.java.sql.jdbc;

import main.java.model.Status;
import main.java.sql.ConnectionPool;
import main.java.sql.IStatusDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDAO implements IStatusDAO {
    private static final Logger LOG = LogManager.getLogger(AddressTypeDAO.class);

    public void saveEntity(Status model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "INSERT INTO statuses (status_name)"
                + "VALUES((?))";
        PreparedStatement ps = null;
        ResultSet rs = ps.getResultSet();
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, model.getStatusName());
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

    public Status getEntityByID(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM statuses where status_id=(?)";
        Status status = new Status();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.getResultSet();
            status.getStatusId();
            status.getStatusName();
            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
        }
        return status;
    }

    @Override
    public void updateEntity(Object model) throws SQLException {

    }

    public void updateEntity(Status model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "UPDATE Status SET status_name=(?) WHERE status_id=(?)";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(2, model.getStatusId());
            ps.setString(1, model.getStatusName());

            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
        }
    }

    public void removeEntity(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "DELETE FROM statuses WHERE status_id=(?)";
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
        String query = "SELECT * FROM statuses";
        List<Status> statusList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            rs = ps.getResultSet();
            while(rs.next()) {
                Status status = new Status();
                status.getStatusId();
                status.getStatusName();
            }
            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
        }
        return statusList;
    }

    public Status getStatusByName(String name) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM statuses WHERE status_name=(?)";
        List<Status> statusList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            rs = ps.getResultSet();
            while(rs.next()) {
                ps.setString(1, name);
                Status status = new Status();
                status.getStatusId();
                status.getStatusName();
            }
            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
        }
        return (Status) statusList;
    }
}
