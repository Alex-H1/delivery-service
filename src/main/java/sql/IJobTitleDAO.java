package sql;

import model.JobTitle;

import java.sql.SQLException;
import java.util.List;

public interface IJobTitleDAO extends IBaseDAO {
    void saveEntity(Object model) throws SQLException;

    void updateEntity(Object model) throws SQLException;

    List<JobTitle> getJobTitleByName(String name) throws SQLException;
}
