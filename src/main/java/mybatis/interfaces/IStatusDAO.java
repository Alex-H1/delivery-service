package mybatis.interfaces;

import model.Status;

import java.sql.SQLException;
import java.util.List;

public interface IStatusDAO extends IParentDAO<Status> {

    List<Status> getStatusByName(String name) throws SQLException;


}
