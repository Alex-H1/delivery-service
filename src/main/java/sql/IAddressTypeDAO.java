package main.java.sql;

import java.sql.SQLException;

public interface IAddressTypeDAO extends IBaseDAO {
    main.java.model.AddressType getAddressTypeByName(String name) throws SQLException;
}
