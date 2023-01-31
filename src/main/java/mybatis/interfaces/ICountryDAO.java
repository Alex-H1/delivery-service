package mybatis.interfaces;

import model.Country;

import java.sql.SQLException;
import java.util.List;

public interface ICountryDAO extends IParentDAO<Country> {

    List<Country> getCountryByCountryName(String name) throws SQLException;

}
