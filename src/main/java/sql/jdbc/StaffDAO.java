package main.java.sql.jdbc;

import main.java.model.Staff;
import main.java.sql.ConnectionPool;
import main.java.sql.IStaffDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO implements IStaffDAO {
    private static final Logger LOG = LogManager.getLogger(CustomerDAO.class);

    public void saveEntity(Staff model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "INSERT INTO staff(first_name, last_name, job_title_id)"
                + "VALUES((?), (?), (?))";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, model.getFirstName());
            ps.setString(2, model.getLastName());
            ps.setInt(3, model.getJobTitle());

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

    public Staff getEntityByID(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM Staff WHERE employee_id=(?)";
        Staff staff = new Staff();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.getResultSet();
            staff.setEmployeeId((rs.getInt("employee_id")));
            staff.setFirstName(rs.getString("first_name"));
            staff.setLastName(rs.getString("last_name"));
            staff.setJobTitle(rs.getInt("job_title_id"));


        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return staff;
    }

    @Override
    public void updateEntity(Object model) throws SQLException {

    }

    public void updateEntity(Staff model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "UPDATE staff SET first_name=(?), last_name=(?), job_title_id=(?)"
                + "WHERE employee_id=(?)";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, model.getFirstName());
            ps.setString(2, model.getLastName());
            ps.setInt(3, model.getJobTitle());

            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
        }
    }

    public void removeEntity(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "DELETE FROM Staff WHERE Staff_id=(?)";
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
        String query = "SELECT * FROM Staff";
        List<Staff> staffList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            rs = ps.getResultSet();
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setEmployeeId((rs.getInt("employee_id")));
                staff.setFirstName(rs.getString("first_name"));
                staff.setLastName(rs.getString("last_name"));
                staff.setJobTitle(rs.getInt("job_title_id"));
            }

        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return staffList;
    }

    public Staff getStaffByName(String name) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM Staff WHERE first_name=(?)";
        List<Staff> staffList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.getResultSet();
            while (rs.next()) {
                Staff staff = new Staff();
                staff.setEmployeeId((rs.getInt("employee_id")));
                staff.setFirstName(rs.getString("first_name"));
                staff.setLastName(rs.getString("last_name"));
                staff.setJobTitle(rs.getInt("job_title_id"));
            }

        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return (Staff) staffList;
    }
}
