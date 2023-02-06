package sql.mybatis;

import model.JobTitle;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sql.IJobTitleDAO;
import sql.util.MyBatisSqlFactory;

import java.sql.SQLException;
import java.util.List;

public class JobTitleDAO implements IJobTitleDAO {

    protected IJobTitleDAO iJobTitleDAO;
    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    public JobTitleDAO(IJobTitleDAO iJobTitleDAO) {
        this.iJobTitleDAO = iJobTitleDAO;
    }

    public JobTitleDAO() {
    }

    @Override
    public void saveEntity(JobTitle model) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IJobTitleDAO jobTitleDAO = session.getMapper(IJobTitleDAO.class);
            jobTitleDAO.saveEntity(model);
            session.commit();
        }
    }

    @Override
    public JobTitle getEntityByID(int id) throws SQLException {
        JobTitle jobTitle;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IJobTitleDAO jobTitleDAO = session.getMapper(IJobTitleDAO.class);
            jobTitle = jobTitleDAO.getEntityByID(id);
        }
        return jobTitle;
    }

    @Override
    public void updateEntity(JobTitle model) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IJobTitleDAO jobTitleDAO = session.getMapper(IJobTitleDAO.class);
            jobTitleDAO.updateEntity(model);
            session.commit();
        }
    }

    @Override
    public void removeEntity(int id) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IJobTitleDAO jobTitleDAO = session.getMapper(IJobTitleDAO.class);
            jobTitleDAO.removeEntity(id);
            session.commit();
        }
    }

    @Override
    public List<JobTitle> getAll() throws SQLException {
        List<JobTitle> jobTitleList;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IJobTitleDAO jobTitleDAO = session.getMapper(IJobTitleDAO.class);
            jobTitleList = jobTitleDAO.getAll();
        }
        return jobTitleList;
    }

    @Override
    public List<JobTitle> getJobTitleByName(String name) throws SQLException {
        List<JobTitle> jobTitleList;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IJobTitleDAO jobTitleDAO = session.getMapper(IJobTitleDAO.class);
            jobTitleList = jobTitleDAO.getJobTitleByName(name);
        }
        return jobTitleList;
    }
}
