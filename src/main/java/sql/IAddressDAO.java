package main.java.sql;

import main.java.model.Address;

import java.sql.SQLException;

public interface IAddressDAO extends IBaseDAO {
    main.java.model.Address getAddressByAddress(String address) throws SQLException;

    void saveEntity(Address model) throws SQLException;
}
