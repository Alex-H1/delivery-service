package mybatis.interfaces;

import model.AddressType;

import java.sql.SQLException;
import java.util.List;

public interface IAddressTypeDAO extends IParentDAO<AddressType> {

    List<AddressType> getAddressTypeByName(String name) throws SQLException;

}
