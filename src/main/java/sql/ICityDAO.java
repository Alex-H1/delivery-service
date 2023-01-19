package main.java.sql;

import main.java.model.City;

import java.sql.SQLException;

public interface ICityDAO extends IBaseDAO {
    City getCityByName(String name) throws SQLException;
}
