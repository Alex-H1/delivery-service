package sql;

import model.AddressType;

import java.sql.SQLException;
import java.util.List;

public interface IAddressTypeDAO extends IBaseDAO<AddressType> {

    List<AddressType> getAddressTypeByName(String name) throws SQLException;
}
