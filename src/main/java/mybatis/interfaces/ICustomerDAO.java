package mybatis.interfaces;

import model.Customer;

import java.sql.SQLException;

public interface ICustomerDAO extends IParentDAO<Customer> {

    Customer getCustomerByPhoneNumber(String phoneNumber) throws SQLException;

}
