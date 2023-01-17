package main.java.sql.jdbc;

import main.java.model.Package;
import main.java.model.PackageType;
import main.java.sql.ConnectionPool;
import main.java.sql.IPackageDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PackageDAO implements IPackageDAO {
    private static final Logger LOG = LogManager.getLogger(PackageDAO.class);

    public void saveEntity(Package model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "INSERT INTO packages(tracking_number, weight, " +
                "package_type_id)"
                + "VALUES((?), (?), (?))";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, model.getTrackingNumber());
            ps.setDouble(2, model.getWeight());
            ps.setInt(3, model.getPackageTypeId());
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

    public Package getEntityByID(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM packages WHERE package_id=(?)";
        Package aPackage = new Package();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.getResultSet();
            aPackage.setPackageId((rs.getInt("package_id")));
            aPackage.setTrackingNumber(rs.getString("tracking_number"));
            aPackage.setWeight(rs.getDouble("weight"));
            aPackage.setPackageTypeId(rs.getInt("package_type_id"));
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return aPackage;
    }

    @Override
    public void updateEntity(Object model) throws SQLException {

    }

    public void updateEntity(Package model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "UPDATE packages SET tracking_number=(?), weight=(?), " +
                "package_type_id=(?)"
                + "WHERE package_id=(?)";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, model.getTrackingNumber());
            ps.setDouble(2, model.getWeight());
            ps.setInt(3, model.getPackageTypeId());
            ps.setInt(4, model.getPackageId());
            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
        }
    }

    public void removeEntity(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "DELETE FROM packages WHERE package_id=(?)";
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
        String query = "SELECT * FROM packages";
        List<Package> packageList = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            rs = ps.getResultSet();
            while(rs.next()) {
                Package aPackage = new Package();
                aPackage.setPackageId((rs.getInt("package_id")));
                aPackage.setTrackingNumber(rs.getString("tracking_number"));
                aPackage.setWeight(rs.getDouble("weight"));
                aPackage.setPackageTypeId(rs.getInt("package_type_id"));
            }
            } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return packageList;
    }

    public Package getPackageByTrackingNumber(String number) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM packages WHERE tracking_number=(?)";
        Package aPackage = new Package();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, number);
            rs = ps.getResultSet();
            aPackage.setPackageId((rs.getInt("package_id")));
            aPackage.setTrackingNumber(rs.getString("tracking_number"));
            aPackage.setWeight(rs.getDouble("weight"));
            aPackage.setPackageTypeId(rs.getInt("package_type_id"));
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return aPackage;
    }
}
