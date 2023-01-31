package mybatis.interfaces;

import model.CompanyType;

import java.sql.SQLException;
import java.util.List;

public interface ICompanyTypeDAO extends IParentDAO<CompanyType>{

    List<CompanyType> getCompanyTypeByCompanyTypeName(String name) throws SQLException;

}
