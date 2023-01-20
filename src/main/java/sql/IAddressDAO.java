package sql;


import model.Address;

import java.sql.SQLException;

public interface IAddressDAO extends IBaseDAO {
    Address getAddressByAddress(String address) throws SQLException;

    void saveEntity(Address model) throws SQLException;

    void saveEntity(Object model) throws SQLException;

    void updateEntity(Object model) throws SQLException;
}
