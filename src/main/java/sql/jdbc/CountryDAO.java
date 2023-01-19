package main.java.sql.jdbc;

import main.java.model.Country;
import main.java.sql.ConnectionPool;
import main.java.sql.ICountryDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO implements ICountryDAO {
    private static final Logger LOG = LogManager.getLogger(CountryDAO.class);

    public void saveEntity(Country model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "INSERT INTO countries (country_name)"
                + "VALUES((?))";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, model.getCountryName());
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

    public Country getEntityByID(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM country WHERE country_id=(?)";
        Country country = new Country();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.getResultSet();
            country.setCountryId((rs.getInt("country_id")));
            country.setCountryName(rs.getString("country_name"));
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return country;
    }

    @Override
    public void updateEntity(Object model) throws SQLException {

    }

    public void updateEntity(Country model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "UPDATE countries SET country_name WHERE country_id=(?)";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, model.getCountryName());
            ps.setInt(1, model.getCountryId());
            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
        }
    }

    public void removeEntity(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "DELETE FROM country WHERE country_id=(?)";
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
        String query = "SELECT * FROM country ";
        List<Country> countryList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            rs = ps.getResultSet();
            while (rs.next()) {
                Country country = new Country();
                country.setCountryId((rs.getInt("country_id")));
                country.setCountryName(rs.getString("country_name"));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return countryList;
    }

    public Country getCountryByCountryName(String name) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM country WHERE country_name=(?)";
        Country country = new Country();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.getResultSet();
            country.setCountryId((rs.getInt("country_id")));
            country.setCountryName(rs.getString("country_name"));
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return country;
    }
}
