package main.java.sql;

import java.sql.SQLException;

public interface IStatusDAO extends IBaseDAO {
    main.java.model.Status getStatusByName(String name) throws SQLException;
}
