package sql.jdbc;

import model.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.ConnectionPool;
import sql.ICountryDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO implements ICountryDAO {
    protected ICountryDAO countryDAO;
    private static final Logger LOG = LogManager.getLogger(CountryDAO.class);
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    public CountryDAO(ICountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    public CountryDAO() {
    }

    public void saveEntity(Country model) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "INSERT INTO countries (country_name)"
                + "VALUES((?))";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, model.getCountryName());
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

    public Country getEntityByID(int id) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM country WHERE country_id=(?)";
        Country country = new Country();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.getResultSet();
            country.setCountryId((rs.getInt("country_id")));
            country.setCountryName(rs.getString("country_name"));
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
        return country;
    }

    public void updateEntity(Country model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "UPDATE countries SET country_name WHERE country_id=(?)";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, model.getCountryName());
            ps.setInt(1, model.getCountryId());
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
        String query = "DELETE FROM country WHERE country_id=(?)";
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
        String query = "SELECT * FROM country ";
        List<Country> countryList = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                Country country = new Country();
                country.setCountryId((rs.getInt("country_id")));
                country.setCountryName(rs.getString("country_name"));
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
        return countryList;
    }

    public List<Country> getCountryByCountryName(String name) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM country WHERE country_name=(?)";
        List<Country> countryList = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            Country country = new Country();
            ps.setString(1, name);
            ResultSet rs = ps.getResultSet();
            country.setCountryId((rs.getInt("country_id")));
            country.setCountryName(rs.getString("country_name"));
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
        return countryList;
    }
}
