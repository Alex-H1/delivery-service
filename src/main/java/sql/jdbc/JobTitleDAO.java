package sql.jdbc;

import model.JobTitle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.ConnectionPool;
import sql.IJobTitleDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JobTitleDAO implements IJobTitleDAO {

    private static final Logger LOG = LogManager.getLogger(JobTitleDAO.class);
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void saveEntity(JobTitle model) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "INSERT INTO job_titles (job_title)"
                + "VALUES((?))";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, model.getJobTitle());
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

    public JobTitle getEntityByID(int id) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM job_titles WHERE job_title_id=(?)";
        JobTitle jobTitle = new JobTitle();

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.getResultSet();
            jobTitle.setJobTitleId((rs.getInt("job_title_id")));
            jobTitle.setJobTitle(rs.getString("job_title"));
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
        return jobTitle;
    }

    public void updateEntity(JobTitle model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "UPDATE job_titles SET job_title=(?) WHERE job_title_id=(?)";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, model.getJobTitle());
            ps.setInt(2, model.getJobTitleId());

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
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "DELETE FROM job_titles WHERE job_title_id=(?)";
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
        String query = "SELECT * FROM job_titles";
        List<JobTitle> jobTitleList = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                JobTitle jobTitle = new JobTitle();
                jobTitle.setJobTitleId((rs.getInt("job_title_id")));
                jobTitle.setJobTitle(rs.getString("job_title"));
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
        return jobTitleList;
    }

    public List<JobTitle> getJobTitleByName(String name) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM job_titles WHERE job_title_name=(?)";
        List<JobTitle> jobTitleList = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, name);
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                JobTitle jobTitle = new JobTitle();
                jobTitle.setJobTitleId((rs.getInt("job_title_id")));
                jobTitle.setJobTitle(rs.getString("job_title"));
                jobTitleList.add(jobTitle);
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
        return jobTitleList;
    }
}
