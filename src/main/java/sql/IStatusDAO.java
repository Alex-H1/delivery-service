package sql;

import model.Status;

import java.sql.SQLException;
import java.util.List;

public interface IStatusDAO extends IBaseDAO {
    void saveEntity(Object model) throws SQLException;

    void updateEntity(Object model) throws SQLException;

    List<Status> getStatusByName(String name) throws SQLException;
}
