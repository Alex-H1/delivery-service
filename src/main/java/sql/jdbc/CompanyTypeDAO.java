package main.java.sql.jdbc;

import main.java.model.Company;
import main.java.model.CompanyType;
import main.java.sql.ConnectionPool;
import main.java.sql.ICompanyTypeDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyTypeDAO implements ICompanyTypeDAO {
    private static final Logger LOG = LogManager.getLogger(CompanyTypeDAO.class);



    @Override
    public void saveEntity(CompanyType model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "INSERT INTO company_types (company_type_name) VALUES((?))";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, model.getCompanytypeName());
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

    public CompanyType getEntityByID(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM company_types WHERE company_type_id=(?)";
        CompanyType companyType = new CompanyType();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.getResultSet();
            companyType.setCompanyTypeId(rs.getInt("company_type_id"));
            companyType.setCompanytypeName(rs.getString("company_type_name"));

        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return companyType;
    }

    @Override
    public void updateEntity(Object model) throws SQLException {

    }

    @Override
    public void updateEntity(CompanyType model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "UPDATE company_types SET company_type_name=(?) WHERE company_type_id=(?)";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(2, model.getCompanyTypeId());
            ps.setString(1, model.getCompanytypeName());
            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
        }
    }


    public void removeEntity(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "DELETE FROM company_types WHERE company_type_id=(?)";
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
        String query = "SELECT * FROM company_types";
        List<CompanyType> companyTypeList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            rs = ps.getResultSet();
            while (rs.next()) {
                CompanyType companyType = new CompanyType();
                companyType.setCompanyTypeId(rs.getInt("company_type_id"));
                companyType.setCompanytypeName(rs.getString("company_type_name"));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return companyTypeList;
    }


    @Override
    public CompanyType getCompanyTypeByCompanyTypeName(String name) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM company_types WHERE company_type_id=(?)";
        List<Company> companyList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ps = c.prepareStatement(query);
        ps.setString(1, name);
        try {
            rs = ps.getResultSet();
            while (rs.next()) {
                CompanyType companyType = new CompanyType();
                companyType.setCompanyTypeId(rs.getInt("company_type_id"));
                companyType.setCompanytypeName(rs.getString("company_type_name"));
            }

        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return (CompanyType) companyList;
    }
}
