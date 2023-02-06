package sql.jdbc;

import model.Package;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.ConnectionPool;
import sql.IPackageDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PackageDAO implements IPackageDAO {
    private static final Logger LOG = LogManager.getLogger(PackageDAO.class);
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void saveEntity(Package model) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "INSERT INTO packages(tracking_number, weight, " +
                "package_type_id)"
                + "VALUES((?), (?), (?))";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, model.getTrackingNumber());
            ps.setDouble(2, model.getWeight());
            ps.setInt(3, model.getPackageTypeId());
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


    public Package getEntityByID(int id) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM packages WHERE package_id=(?)";
        Package aPackage = new Package();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.getResultSet();
            aPackage.setTrackingNumber(rs.getString("tracking_number"));
            aPackage.setWeight(rs.getDouble("weight"));
            aPackage.setPackageTypeId(rs.getInt("package_type_id"));
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
        return aPackage;
    }

    public void updateEntity(Package model) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "UPDATE packages SET tracking_number=(?), weight=(?), " +
                "package_type_id=(?)"
                + "WHERE package_id=(?)";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, model.getTrackingNumber());
            ps.setDouble(2, model.getWeight());
            ps.setInt(3, model.getPackageTypeId());
            ps.setInt(4, model.getPackageId());
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
        String query = "DELETE FROM packages WHERE package_id=(?)";
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
        String query = "SELECT * FROM packages";
        List<Package> packageList = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.getResultSet();
            ps.execute();
            while (rs.next()) {
                Package aPackage = new Package();
                aPackage.setPackageId((rs.getInt("package_id")));
                aPackage.setTrackingNumber(rs.getString("tracking_number"));
                aPackage.setWeight(rs.getDouble("weight"));
                aPackage.setPackageTypeId(rs.getInt("package_type_id"));
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
        return packageList;
    }

    @Override
    public Package getPackageByTrackingNumber(String num) {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM packages WHERE tracking_number=(?)";
        Package aPackage = new Package();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, num);
            ResultSet rs = ps.getResultSet();
            aPackage.setTrackingNumber(rs.getString("tracking_number"));
            aPackage.setWeight(rs.getDouble("weight"));
            aPackage.setPackageTypeId(rs.getInt("package_type_id"));
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
        return aPackage;
    }
}
