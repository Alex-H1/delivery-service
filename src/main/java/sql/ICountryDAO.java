package sql;

import model.Country;

import java.sql.SQLException;
import java.util.List;

public interface ICountryDAO extends IBaseDAO<Country> {

    List<Country> getCountryByCountryName(String name) throws SQLException;

}
