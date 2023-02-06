package sql.jdbc;

import model.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.ConnectionPool;
import sql.IStatusDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDAO implements IStatusDAO {

    protected IStatusDAO iStatusDAO;
    private static final Logger LOG = LogManager.getLogger(AddressTypeDAO.class);
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    public StatusDAO(IStatusDAO iStatusDAO) {
        this.iStatusDAO = iStatusDAO;
    }

    public StatusDAO() {
    }

    public void saveEntity(Status model) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "INSERT INTO statuses (status_name)"
                + "VALUES((?))";

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, model.getStatusName());
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

    public Status getEntityByID(int id) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM statuses where status_id=(?)";
        Status status = new Status();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.getResultSet();
            status.getStatusId();
            status.getStatusName();
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
        return status;
    }

    public void updateEntity(Status model) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "UPDATE Status SET status_name=(?) WHERE status_id=(?)";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(2, model.getStatusId());
            ps.setString(1, model.getStatusName());

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
        String query = "DELETE FROM statuses WHERE status_id=(?)";
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
        String query = "SELECT * FROM statuses";
        List<Status> statusList = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.getResultSet();
            ps.execute();
            while (rs.next()) {
                Status status = new Status();
                status.getStatusId();
                status.getStatusName();
            }
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
        return statusList;
    }

    public List<Status> getStatusByName(String name) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM statuses WHERE status_name=(?)";
        List<Status> statusList = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                ps.setString(1, name);
                Status status = new Status();
                status.getStatusId();
                status.getStatusName();
                statusList.add(status);
            }
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
        return statusList;
    }
}
