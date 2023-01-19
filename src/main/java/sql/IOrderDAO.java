package main.java.sql;

import main.java.model.Order;

import java.sql.SQLException;

public interface IOrderDAO extends IBaseDAO {

    void saveEntity(Order model) throws SQLException;
}
