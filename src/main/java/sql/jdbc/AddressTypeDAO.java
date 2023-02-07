package sql.jdbc;


import model.AddressType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sql.ConnectionPool;
import sql.IAddressTypeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressTypeDAO implements IAddressTypeDAO {

    private static final Logger LOG = LogManager.getLogger(AddressTypeDAO.class);
    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

  

    public List<AddressType> getAddressTypeByName(String name) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        List<AddressType> addressTypeList = new ArrayList<>();
        String query = "SELECT * FROM address_types where address_type_name=(?)";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, name);
            ResultSet rs = ps.getResultSet();
            ps.execute();
            while (rs.next()) {
                AddressType addressType = new AddressType();
                addressType.setAddressTypeId(rs.getInt("address_type_id"));
                addressType.setAddressType(rs.getString("address_type_name"));
            }
        } catch (SQLException e) {
            LOG.error(e);
        } finally {
            if (c != null) {
                try {
                    connectionPool.releaseConnection(c);
                } catch (SQLException e) {
                    LOG.error(e.getMessage());
                }
            }
        }
        return addressTypeList;
    }

    public void saveEntity(AddressType model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "INSERT INTO addresse_types ( address_type_name)"
                + "VALUES((?))";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, model.getAddressType());
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

    public AddressType getEntityByID(int id) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "SELECT * FROM addresss_types WHERE address_type_id=(?)";
        AddressType addressType = new AddressType();
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(1, id);
            ResultSet rs = ps.getResultSet();
            addressType.setAddressTypeId((rs.getInt("address_type_id")));
            addressType.setAddressType(rs.getString("address_type_name"));
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
        return addressType;
    }

    public void updateEntity(AddressType model) throws SQLException {
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "UPDATE address_types SET address_type_name=(?) WHERE address_type_id=(?)";
        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.setInt(2, model.getAddressTypeId());
            ps.setString(1, model.getAddressType());

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
        Connection c = ConnectionPool.getInstance().getConnection();
        String query = "DELETE FROM address_types WHERE address_type_id=(?)";
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
        Connection c = ConnectionPool.getInstance().getConnection();
        List<AddressType> addressTypeList = new ArrayList<>();
        String query = "SELECT * FROM address_type_list";

        try (PreparedStatement ps = c.prepareStatement(query)) {
            ps.execute();
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                AddressType addressType = new AddressType();
                addressType.setAddressTypeId(rs.getInt("address_type_id"));
                addressType.setAddressType(rs.getString("address_type_name"));
                addressTypeList.add(addressType);
            }
        } catch (SQLException e) {
            LOG.error(e);
        } finally {
            if (c != null) {
                try {
                    connectionPool.releaseConnection(c);
                } catch (SQLException e) {
                    LOG.error(e.getMessage());
                }
            }
        }
        return addressTypeList;
    }
}
