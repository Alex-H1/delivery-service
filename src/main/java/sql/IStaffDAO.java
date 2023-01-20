package sql;

import model.Staff;

import java.sql.SQLException;
import java.util.List;

public interface IStaffDAO extends IBaseDAO {
    void saveEntity(Object model) throws SQLException;

    void updateEntity(Object model) throws SQLException;

    List<Staff> getStaffByName(String name) throws SQLException;
}
