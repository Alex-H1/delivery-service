package sql;

import model.City;

import java.sql.SQLException;
import java.util.List;

public interface ICityDAO extends IBaseDAO<City> {
    List<City> getCityByName(String name) throws SQLException;
}
