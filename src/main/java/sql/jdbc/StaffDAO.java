package sql.jdbc;

import model.Staff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.ConnectionPool;
import sql.IStaffDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO implements IStaffDAO {

    protected IStaffDAO iStaffDAO;
    private static final Logger LOG = LogManager.getLogger(StaffDAO.class);
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    public StaffDAO(IStaffDAO iStaffDAO) {
        this.iStaffDAO = iStaffDAO;
    }

    public StaffDAO() {
    }

    public void saveEntity(Staff model) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "INSERT INTO staff(first_name, last_name, job_title_id)"
                + "VALUES((?), (?), (?))";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, model.getFirstName());
            ps.setString(2, model.getLastName());
            ps.setInt(3, model.getJobTitleId());

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

    public Staff getEntityByID(int id) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM Staff WHERE employee_id=(?)";
        Staff staff = new Staff();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.getResultSet();
            staff.setEmployeeId((rs.getInt("employee_id")));
            staff.setFirstName(rs.getString("first_name"));
            staff.setLastName(rs.getString("last_name"));
            staff.setJobTitleId(rs.getInt("job_title_id"));


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
        return staff;
    }


    public void updateEntity(Staff model) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "UPDATE staff SET first_name=(?), last_name=(?), job_title_id=(?)"
                + "WHERE employee_id=(?)";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, model.getFirstName());
            ps.setString(2, model.getLastName());
            ps.setInt(3, model.getJobTitleId());
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
        String query = "DELETE FROM Staff WHERE Staff_id=(?)";
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
        Connection connection = connectionPool.getConnection();
        String query = "SELECT * FROM Staff";
        List<Staff> staffList = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Staff staff = new Staff();
                    staff.setEmployeeId((rs.getInt("employee_id")));
                    staff.setFirstName(rs.getString("first_name"));
                    staff.setLastName(rs.getString("last_name"));
                    staff.setJobTitleId(rs.getInt("job_title_id"));
                    staffList.add(staff);
                }
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOG.error(e.getMessage());
                }
            }
        }
        return staffList;
    }


    public List<Staff> getStaffByName(String name) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM Staff WHERE first_name=(?)";
        List<Staff> staffList = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, name);
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setEmployeeId((rs.getInt("employee_id")));
                staff.setFirstName(rs.getString("first_name"));
                staff.setLastName(rs.getString("last_name"));
                staff.setJobTitleId(rs.getInt("job_title_id"));
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
        return staffList;
    }
}
