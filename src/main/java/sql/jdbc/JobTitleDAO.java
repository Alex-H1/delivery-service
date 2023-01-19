package main.java.sql.jdbc;

import main.java.model.JobTitle;
import main.java.sql.ConnectionPool;
import main.java.sql.IJobTitleDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobTitleDAO implements IJobTitleDAO {
    private static final Logger LOG = LogManager.getLogger(JobTitleDAO.class);

    public void saveEntity(JobTitle model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "INSERT INTO job_titles (job_title)"
                + "VALUES((?))";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, model.getJobTitle());
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

    public JobTitle getEntityByID(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM job_titles WHERE job_title_id=(?)";
        JobTitle jobTitle = new JobTitle();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.getResultSet();
            jobTitle.setJobTitleId((rs.getInt("job_title_id")));
            jobTitle.setJobTitle(rs.getString("job_title"));
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return jobTitle;
    }

    @Override
    public void updateEntity(Object model) throws SQLException {

    }

    public void updateEntity(JobTitle model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "UPDATE job_titles SET job_title=(?) WHERE job_title_id=(?)";
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, model.getJobTitle());
            ps.setInt(2, model.getJobTitleId());

        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
        }
    }

    public void removeEntity(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "DELETE FROM job_titles WHERE job_title_id=(?)";
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
        String query = "SELECT * FROM job_titles";
        List<JobTitle> jobTitleList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            rs = ps.getResultSet();
            while(rs.next()) {
                JobTitle jobTitle = new JobTitle();
                jobTitle.setJobTitleId((rs.getInt("job_title_id")));
                jobTitle.setJobTitle(rs.getString("job_title"));
            }
            } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return jobTitleList;
    }

    public JobTitle getJobTitleByName(String name) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM job_titles WHERE job_title_name=(?)";
        JobTitle jobTitle = new JobTitle();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.getResultSet();
            jobTitle.setJobTitleId((rs.getInt("job_title_id")));
            jobTitle.setJobTitle(rs.getString("job_title"));
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return jobTitle;
    }
}
