package main.java.sql;

import java.sql.SQLException;

public interface IStaffDAO extends IBaseDAO {
    main.java.model.Staff getStaffByName(String name) throws SQLException;
}
