package mybatis.interfaces;

import model.City;

import java.sql.SQLException;
import java.util.List;

public interface ICityDAO extends IParentDAO<City> {
    List<City> getCityByName(String name) throws SQLException;

}
