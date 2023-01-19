package main.java.sql.jdbc;

import main.java.model.Address;
import main.java.sql.ConnectionPool;
import main.java.sql.IAddressDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO implements IAddressDAO {

    private static final Logger LOG = LogManager.getLogger(AddressDAO.class);

    public Address getAddressByAddress(String address) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        List<Address> addressList = new ArrayList<>();
        String query = "SELECT * FROM addresses WHERE address=(?)";
        ResultSet rs = null;
        PreparedStatement ps = c.prepareStatement(query);
        try {
            ps.setString(1, address);
            ps.execute();
            rs = ps.getResultSet();
            while (rs.next()) {
                Address address1 = new Address();
                address1.setAddressId(rs.getInt("address_id"));
                address1.setPostalCode(rs.getDouble("postal_code"));
                address1.setCity(rs.getString("city"));
                address1.setAddressType(rs.getInt("address_type_id"));
                addressList.add(address1);
            }
        } catch (SQLException e) {
            LOG.error(e);
        } finally {
            ps.close();
            rs.close();
        }
        return (Address) addressList;
    }

    @Override
    public void saveEntity(Address model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "INSERT INTO addresses (address_id, address, postal_code, city_id, address_type_id)"
                + "VALUES((?), (?), (?), (?), (?))";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, model.getAddressId());
            ps.setString(2, model.getAddress());
            ps.setDouble(3, model.getPostalCode());
            ps.setInt(4, model.getCity());
            ps.setInt(5, model.getAddressType());
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

    public Address getEntityByID(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM addresses WHERE address_id=(?)";
        Address address = new Address();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.getResultSet();
            while (rs.next()) {
                address.setAddressId(rs.getInt("address_id"));
                address.setPostalCode(rs.getDouble("postal_code"));
                address.setCity(rs.getString("city"));
                address.setAddressType(rs.getInt("address_type_id"));
            }
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return address;
    }

    @Override
    public void updateEntity(Object model) throws SQLException {

    }

    public void updateEntity(Address model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "UPDATE addresses SET address=(?), postal_code=(?), city_id=(?), address_type_id WHERE address_id = (?)";

        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(5, model.getAddressId());
            ps.setString(1, model.getAddress());
            ps.setDouble(2, model.getPostalCode());
            ps.setInt(3, model.getCity());
            ps.setInt(4, model.getAddressType());
            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
        }

    }

    public void removeEntity(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "DELETE FROM addresses WHERE address_id=(?)";
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
        List<Address> addressList = new ArrayList<>();
        String query = "SELECT * FROM addresses";
        ResultSet rs = null;
        PreparedStatement ps = c.prepareStatement(query);
        try {
            ps.execute();
            rs = ps.getResultSet();
            while (rs.next()) {
                Address address1 = new Address();
                address1.setAddressId(rs.getInt("address_id"));
                address1.setPostalCode(rs.getDouble("postal_code"));
                address1.setCity(rs.getString("city"));
                address1.setAddressType(rs.getInt("address_type_id"));
                addressList.add(address1);
            }
        } catch (SQLException e) {
            LOG.error(e);
        } finally {
            ps.close();
            rs.close();
        }
        return addressList;
    }
}
