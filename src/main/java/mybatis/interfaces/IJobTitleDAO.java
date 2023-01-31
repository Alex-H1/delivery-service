package mybatis.interfaces;

import model.JobTitle;

import java.sql.SQLException;
import java.util.List;

public interface IJobTitleDAO extends IParentDAO<JobTitle> {

    List<JobTitle> getJobTitleByName(String name) throws SQLException;

}
