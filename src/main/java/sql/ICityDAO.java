package sql;

import model.City;

import java.sql.SQLException;
import java.util.List;

public interface ICityDAO extends IBaseDAO {
    void saveEntity(Object model) throws SQLException;

    void updateEntity(Object model) throws SQLException;

    List<City> getCityByName(String name) throws SQLException;
}
