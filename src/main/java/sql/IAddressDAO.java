package sql;


import model.Address;

import java.sql.SQLException;

public interface IAddressDAO extends IBaseDAO<Address> {
    Address getAddressByAddress(String address) throws SQLException;

}
