package main.java.sql;

import main.java.model.CompanyType;

import java.sql.SQLException;

public interface ICompanyTypeDAO extends IBaseDAO {
    void saveEntity(CompanyType model) throws SQLException;

    void updateEntity(CompanyType model) throws SQLException;

    main.java.model.CompanyType getCompanyTypeByCompanyTypeName(String name) throws SQLException;
}
