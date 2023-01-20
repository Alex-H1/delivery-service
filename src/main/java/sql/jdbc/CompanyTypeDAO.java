package sql.jdbc;


import model.CompanyType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.ConnectionPool;
import sql.ICompanyTypeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyTypeDAO implements ICompanyTypeDAO {
    private static final Logger LOG = LogManager.getLogger(CompanyTypeDAO.class);
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();


    public void saveEntity(CompanyType model) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "INSERT INTO company_types (company_type_name) VALUES((?))";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, model.getCompanytypeName());
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

    public CompanyType getEntityByID(int id) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM company_types WHERE company_type_id=(?)";
        CompanyType companyType = new CompanyType();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.getResultSet();
            companyType.setCompanyTypeId(rs.getInt("company_type_id"));
            companyType.setCompanytypeName(rs.getString("company_type_name"));

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
        return companyType;
    }

    @Override
    public void updateEntity(Object model) throws SQLException {

    }

    public void updateEntity(CompanyType model) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "UPDATE company_types SET company_type_name=(?) WHERE company_type_id=(?)";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(2, model.getCompanyTypeId());
            ps.setString(1, model.getCompanytypeName());
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
        String query = "DELETE FROM company_types WHERE company_type_id=(?)";
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
        String query = "SELECT * FROM company_types";
        List<CompanyType> companyTypeList = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.getResultSet();
            ps.execute();
            while (rs.next()) {
                CompanyType companyType = new CompanyType();
                companyType.setCompanyTypeId(rs.getInt("company_type_id"));
                companyType.setCompanytypeName(rs.getString("company_type_name"));
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
        return companyTypeList;
    }


    @Override
    public List<CompanyType> getCompanyTypeByCompanyTypeName(String name) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM company_types WHERE company_type_id=(?)";
        List<CompanyType> companyList = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, name);
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                CompanyType companyType = new CompanyType();
                companyType.setCompanyTypeId(rs.getInt("company_type_id"));
                companyType.setCompanytypeName(rs.getString("company_type_name"));
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
        return companyList;
    }
}
