package main.java.sql.jdbc;

import main.java.model.Company;
import main.java.sql.ConnectionPool;
import main.java.sql.ICompanyDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CompanyDAO implements ICompanyDAO {
    private static final Logger LOG = LogManager.getLogger(CompanyDAO.class);

    public void saveEntity(Company model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "INSERT INTO companies (company_name, company_type_id)"
                + "VALUES((?), (?))";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, model.getCompanyName());
            ps.setInt(1, model.getCompanyType());
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

    public Company getEntityByID(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM companies WHERE company_id=(?)";
        Company company = new Company();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.getResultSet();
            company.setCompanyId((rs.getInt("company_id")));
            company.setCompanyName(rs.getString("company_name"));
            company.setCompanyType(rs.getInt("company_type"));
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return company;
    }

    @Override
    public void updateEntity(Object model) throws SQLException {

    }

    public void updateEntity(Company model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "UPDATE companies SET company_name=(?), company_type=(?) WHERE company_id=(?)";
        Company company = new Company();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(3, model.getCompanyId());
            ps.setString(1, model.getCompanyName());
            ps.setInt(2, model.getCompanyType());

        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
    }




    public void removeEntity(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "DELETE FROM companies WHERE company_address=(?)";
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

    public List getAll() {
        return null;
    }

    public Company getCompanyByName(String Name) {
        return null;
    }
}
