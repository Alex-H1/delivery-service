package main.java.sql;

import java.sql.SQLException;

public interface IJobTitleDAO extends IBaseDAO {
    main.java.model.JobTitle getJobTitleByName(String name) throws SQLException;
}
