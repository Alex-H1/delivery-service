package main.java.sql;

import main.java.model.Company;

import java.sql.SQLException;

public interface ICompanyDAO extends IBaseDAO {
    void saveEntity(Company model) throws SQLException;

    void updateEntity(Company model) throws SQLException;

    main.java.model.Company getCompanyByName(String name) throws SQLException;
}
