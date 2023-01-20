package sql.jdbc;

import model.PackageType;
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

public class PackageTypeDAO implements IPackageDAO {
    private static final Logger LOG = LogManager.getLogger(AddressTypeDAO.class);
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    public void saveEntity(PackageType model) {
        Connection c = connectionPool.getConnection();
        String query = "INSERT INTO package_types (package_type_name)"
                + "VALUES((?))";

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, model.getPackageTypeName());
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

    public PackageType getEntityByID(int id) {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM package_types where package_type_id=(?)";
        PackageType packageType = new PackageType();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.getResultSet();
            packageType.setPackageTypeId(rs.getInt("package_type_id"));
            packageType.setPackageTypeName(rs.getString("package_type_name"));
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
        return packageType;
    }

    public void updateEntity(PackageType model) {
        Connection c = connectionPool.getConnection();
        String query = "UPDATE package_types SET package_type_name=(?) WHERE package_type_id=(?)";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, model.getPackageTypeName());
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

    public void removeEntity(int id) {
        Connection c = connectionPool.getConnection();
        String query = "DELETE FROM package_types WHERE package_type_id=(?)";
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
        String query = "SELECT * FROM package_types";
        List<PackageType> packageTypeList = new ArrayList<>();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ResultSet rs = ps.getResultSet();
            ps.execute();
            while (rs.next()) {
                PackageType packageType = new PackageType();
                packageType.setPackageTypeId(rs.getInt("package_types_id"));
                packageType.setPackageTypeName(rs.getString("package_types_name"));
            }
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
        return packageTypeList;
    }


    @Override
    public void saveEntity(Object model) throws SQLException {

    }

    @Override
    public void updateEntity(Object model) throws SQLException {

    }

    @Override
    public PackageType getPackageByTrackingNumber(String number) throws SQLException {
        Connection c = connectionPool.getConnection();
        String query = "SELECT * FROM package_types where package_type_id=(?)";
        PackageType packageType = new PackageType();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, number);
            ResultSet rs = ps.getResultSet();
            packageType.setPackageTypeId(rs.getInt("package_type_id"));
            packageType.setPackageTypeName(rs.getString("package_type_name"));
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
        return packageType;
    }


}
