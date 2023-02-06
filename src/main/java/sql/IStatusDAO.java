package sql;

import model.Status;

import java.sql.SQLException;
import java.util.List;

public interface IStatusDAO extends IBaseDAO<Status> {

    List<Status> getStatusByName(String name) throws SQLException;

}
