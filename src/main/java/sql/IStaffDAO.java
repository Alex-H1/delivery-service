package sql;

import model.Staff;

import java.sql.SQLException;
import java.util.List;

public interface IStaffDAO extends IBaseDAO<Staff> {

    List<Staff> getStaffByName(String name) throws SQLException;

}
