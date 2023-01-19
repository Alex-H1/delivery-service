package main.java.sql;

import java.sql.SQLException;

public interface ICustomerDAO extends IBaseDAO {
    main.java.model.Customer getCustomerByPhoneNumber(String phoneNumber) throws SQLException;
}
