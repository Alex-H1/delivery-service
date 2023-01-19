package main.java.sql.jdbc;


import main.java.model.AddressType;
import main.java.sql.ConnectionPool;
import main.java.sql.IAddressTypeDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressTypeDAO implements IAddressTypeDAO {
    private static final Logger LOG = LogManager.getLogger(AddressTypeDAO.class);

    public AddressType getAddressTypeByName(String name) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        List<AddressType> addressTypeList = new ArrayList<>();
        String query = "SELECT * FROM address_types where address_type_name=(?)";
        ResultSet rs = null;
        PreparedStatement ps = c.prepareStatement(query);
        try {
            ps.setString(1, name);
            ps.execute();
            while (rs.next()) {
                AddressType addressType = new AddressType();
                addressType.setAddressTypeId(rs.getInt("address_type_id"));
                addressType.setAddressType(rs.getString("address_type_name"));
            }
        } catch (SQLException e) {
            LOG.error(e);
        } finally {
            ps.close();
            rs.close();
        }
        return (AddressType) addressTypeList;
    }

    public void saveEntity(AddressType model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "INSERT INTO addresse_types ( address_type_name)"
                + "VALUES((?))";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setString(1, model.getAddressType());
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

    public AddressType getEntityByID(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM addresss_types WHERE address_type_id=(?)";
        AddressType addressType = new AddressType();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.getResultSet();
            addressType.setAddressTypeId((rs.getInt("address_type_id")));
            addressType.setAddressType(rs.getString("address_type_name"));
            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
            rs.close();
        }
        return addressType;
    }

    @Override
    public void updateEntity(Object model) throws SQLException {

    }

    public void updateEntity(AddressType model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "UPDATE address_types SET address_type_name=(?) WHERE address_type_id=(?)";
        PreparedStatement ps = null;
        try {
            ps = c.prepareStatement(query);
            ps.setInt(2, model.getAddressTypeId());
            ps.setString(1, model.getAddressType());

            ps.execute();
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            ps.close();
        }
    }

    public void removeEntity(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "DELETE FROM address_types WHERE address_type_id=(?)";
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
        List<AddressType> addressTypeList = new ArrayList<>();
        String query = "SELECT * FROM address_type_list";
        ResultSet rs = null;
        PreparedStatement ps = c.prepareStatement(query);
        try {
            ps.execute();
            rs = ps.getResultSet();
            while (rs.next()) {
                AddressType addressType = new AddressType();
                addressType.setAddressTypeId(rs.getInt("address_type_id"));
                addressType.setAddressType(rs.getString("address_type_name"));
                addressTypeList.add(addressType);
            }
        } catch (SQLException e) {
            LOG.error(e);
        } finally {
            ps.close();
            rs.close();
        }
        return addressTypeList;
    }
}
