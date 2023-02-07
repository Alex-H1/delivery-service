package sql.jdbc;

import model.City;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.ConnectionPool;
import sql.ICityDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CityDAO implements ICityDAO {

    private static final Logger LOG = LogManager.getLogger(AddressTypeDAO.class);
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();



    public void saveEntity(City model) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "INSERT INTO cities (city_name, country_id)"
                + "VALUES((?), (?))";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, model.getCityName());
            ps.setInt(2, model.getCountry());
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

    public City getEntityByID(int id) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM cities WHERE city_id=(?)";
        City city = new City();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                city.setCityId((rs.getInt("city_id")));
                city.setCityName(rs.getString("city_name"));
                city.setCountry(rs.getInt("country_id"));
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
        return city;
    }

    public void updateEntity(City model) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "UPDATE cities SET city_name=(?), city_id=(?), country_id=(?) WHERE city_id=(?)";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(4, model.getCityId());
            ps.setString(1, model.getCityName());
            ps.setInt(2, model.getCityId());
            ps.setInt(3, model.getCountry());
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
        String query = "DELETE FROM cities WHERE city_id=(?)";
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
        String query = "SELECT * FROM cities";
        List<City> cityList = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.getResultSet();
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
            if (c != null) {
                try {
                    connectionPool.releaseConnection(c);
                } catch (SQLException e) {
                    LOG.error(e.getMessage());
                }
            }
        }
        return cityList;
    }

    public List<City> getCityByName(String name) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM cities WHERE city_name=(?)";
        List<City> cityList = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, name);
            ResultSet rs = ps.getResultSet();
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
            if (c != null) {
                try {
                    connectionPool.releaseConnection(c);
                } catch (SQLException e) {
                    LOG.error(e.getMessage());
                }
            }
        }
        return cityList;
    }
}
