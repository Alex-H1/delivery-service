package sql;

import model.Country;

import java.sql.SQLException;
import java.util.List;

public interface ICountryDAO extends IBaseDAO {
    void saveEntity(Object model) throws SQLException;

    void updateEntity(Object model) throws SQLException;

    List<Country> getCountryByCountryName(String name) throws SQLException;
}
