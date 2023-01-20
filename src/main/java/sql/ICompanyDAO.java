package sql;

import model.Company;

import java.sql.SQLException;
import java.util.List;

public interface ICompanyDAO extends IBaseDAO {
    List<Company> getCompanyByName(String name) throws SQLException;
}
