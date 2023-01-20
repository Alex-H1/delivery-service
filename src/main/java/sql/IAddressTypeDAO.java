package sql;

import model.AddressType;

import java.sql.SQLException;
import java.util.List;

public interface IAddressTypeDAO extends IBaseDAO {
    List<AddressType> getAddressTypeByName(String name) throws SQLException;

    void saveEntity(Object model) throws SQLException;

    void updateEntity(Object model) throws SQLException;
}
