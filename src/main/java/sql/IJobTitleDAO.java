package sql;

import model.JobTitle;

import java.sql.SQLException;
import java.util.List;

public interface IJobTitleDAO extends IBaseDAO<JobTitle> {

    List<JobTitle> getJobTitleByName(String name) throws SQLException;

}
