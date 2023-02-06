package sql.mybatis;

import model.Status;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sql.IStatusDAO;
import sql.util.MyBatisSqlFactory;

import java.sql.SQLException;
import java.util.List;

public class StatusDAO implements IStatusDAO {

    protected IStatusDAO iStatusDAO;
    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    public StatusDAO(IStatusDAO iStatusDAO) {
        this.iStatusDAO = iStatusDAO;
    }

    public StatusDAO() {
    }

    @Override
    public void saveEntity(Status model) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IStatusDAO statusDAO = session.getMapper(IStatusDAO.class);
            statusDAO.saveEntity(model);
        }
    }

    @Override
    public Status getEntityByID(int id) throws SQLException {
        Status status;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IStatusDAO statusDAO = session.getMapper(IStatusDAO.class);
            status = statusDAO.getEntityByID(id);
        }
        return status;
    }

    @Override
    public void updateEntity(Status model) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IStatusDAO statusDAO = session.getMapper(IStatusDAO.class);
            statusDAO.updateEntity(model);
            session.commit();
        }
    }

    @Override
    public void removeEntity(int id) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IStatusDAO statusDAO = session.getMapper(IStatusDAO.class);
            statusDAO.removeEntity(id);
            session.commit();
        }
    }

    @Override
    public List<Status> getAll() throws SQLException {
        List<Status> statusList;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IStatusDAO statusDAO = session.getMapper(IStatusDAO.class);
            statusList = statusDAO.getAll();
        }
        return statusList;
    }

    @Override
    public List<Status> getStatusByName(String name) throws SQLException {
        List<Status> statusList;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IStatusDAO statusDAO = session.getMapper(IStatusDAO.class);
            statusList = statusDAO.getStatusByName(name);
        }
        return statusList;
    }
}
