package main.java.sql;

import java.sql.SQLException;
import java.util.List;

public interface IBaseDAO<Entity> {
    void saveEntity(Entity model) throws SQLException;

    Entity getEntityByID(int id) throws SQLException;

    void updateEntity(Entity model) throws SQLException;

    void removeEntity(int id) throws SQLException;

    List<Entity> getAll() throws SQLException;
}
