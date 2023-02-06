package sql.jdbc;

import model.Company;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.ConnectionPool;
import sql.ICompanyDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO implements ICompanyDAO {
    private static final Logger LOG = LogManager.getLogger(CompanyDAO.class);
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void saveEntity(Company model) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "INSERT INTO companies (company_name, company_type_id)"
                + "VALUES((?), (?))";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, model.getCompanyName());
            ps.setInt(1, model.getCompanyType());
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

    public Company getEntityByID(int id) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM companies WHERE company_id=(?)";
        Company company = new Company();

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.getResultSet();
            company.setCompanyId((rs.getInt("company_id")));
            company.setCompanyName(rs.getString("company_name"));
            company.setCompanyType(rs.getInt("company_type"));
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
        return company;
    }

    public void updateEntity(Company model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "UPDATE companies SET company_name=(?), company_type=(?) WHERE company_id=(?)";
        Company company = new Company();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(3, model.getCompanyId());
            ps.setString(1, model.getCompanyName());
            ps.setInt(2, model.getCompanyType());

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
        String query = "DELETE FROM companies WHERE company_address=(?)";
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

    public List getAll() {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM companies";
        List<Company> companyList = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Company company = new Company();
                    company.setCompanyId((rs.getInt("company_id")));
                    company.setCompanyName((rs.getString("company_name")));
                    company.setCompanyType((rs.getInt("company_type_id")));
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
        return companyList;
    }

    public List<Company> getCompanyByName(String name) {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM companies WHERE company_name=(?)";
        List<Company> companyList = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, name);
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Company company = new Company();
                company.setCompanyId((rs.getInt("company_id")));
                company.setCompanyName(rs.getString("company_name"));
                company.setCompanyType(rs.getInt("company_type_id"));
                companyList.add(company);
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

