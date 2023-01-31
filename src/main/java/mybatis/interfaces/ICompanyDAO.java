package mybatis.interfaces;

import model.Company;

import java.sql.SQLException;
import java.util.List;

public interface ICompanyDAO extends IParentDAO<Company> {

    List<Company> getCompanyByName(String name) throws SQLException;

}
