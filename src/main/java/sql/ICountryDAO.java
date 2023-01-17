package main.java.sql;

import java.sql.SQLException;

public interface ICountryDAO extends IBaseDAO {
    main.java.model.Country getCountryByCountryName(String name) throws SQLException;
}
