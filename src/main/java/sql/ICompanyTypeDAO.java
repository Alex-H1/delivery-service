package sql;


import model.CompanyType;

import java.sql.SQLException;
import java.util.List;

public interface ICompanyTypeDAO extends IBaseDAO<CompanyType> {

    List<CompanyType> getCompanyTypeByCompanyTypeName(String name) throws SQLException;

}
