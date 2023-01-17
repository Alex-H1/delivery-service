package main.java.sql.jdbc;

import main.java.model.City;
import main.java.sql.ConnectionPool;
import main.java.sql.ICityDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO implements ICityDAO {

    private static final Logger LOG = LogManager.getLogger(AddressTypeDAO.class);

    public void saveEntity(City model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "INSERT INTO cities (city_name, country_id)"
                + "VALUES((?), (?))";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, model.getCityName());
            ps.setInt(2, model.getCountry());
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

    public City getEntityByID(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM cities WHERE city_id=(?)";
        City city = new City();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.getResultSet();
            while (rs.next()) {
                city.setCityId((rs.getInt("city_id")));
                city.setCityName(rs.getString("city_name"));
                city.setCountry(rs.getInt("country_id"));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return city;
    }

    @Override
    public void updateEntity(Object model) throws SQLException {

    }

    public void updateEntity(City model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "UPDATE cities SET city_name=(?), city_id=(?), country_id=(?) WHERE city_id=(?)";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(4, model.getCityId());
            ps.setString(1, model.getCityName());
            ps.setInt(2, model.getCityId());
            ps.setInt(3, model.getCountry());
            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
        }
    }

    public void removeEntity(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "DELETE FROM cities WHERE city_id=(?)";
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
        String query = "SELECT * FROM cities";
        List<City> cityList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            rs = ps.getResultSet();
            while (rs.next()) {
                City city = new City();
                city.setCityId((rs.getInt("city_id")));
                city.setCityName(rs.getString("city_name"));
                city.setCountry(rs.getInt("country_id"));
                cityList.add(city);
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return cityList;
    }

    public City getCityByName(String name) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM cities WHERE city_name=(?)";
        City city = new City();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.getResultSet();
            while (rs.next()) {
                city.setCityId((rs.getInt("city_id")));
                city.setCityName(rs.getString("city_name"));
                city.setCountry(rs.getInt("country_id"));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return city;
    }
}
