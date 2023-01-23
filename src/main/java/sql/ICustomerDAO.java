package sql;

import model.Customer;

import java.sql.SQLException;

public interface ICustomerDAO extends IBaseDAO<Customer> {

    Customer getCustomerByPhoneNumber(String phoneNumber) throws SQLException;

}
