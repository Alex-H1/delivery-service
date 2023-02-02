package sql.mybatis;

import model.Staff;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sql.IStaffDAO;
import sql.mybatis.util.MyBatisSqlFactory;

import java.sql.SQLException;
import java.util.List;

public class StaffDAO implements IStaffDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void saveEntity(Staff model) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IStaffDAO staffDAO = session.getMapper(IStaffDAO.class);
            staffDAO.saveEntity(model);
            session.commit();
        }
    }

    @Override
    public Staff getEntityByID(int id) throws SQLException {
        Staff staff;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IStaffDAO staffDAO = session.getMapper(IStaffDAO.class);
            staff = staffDAO.getEntityByID(id);
        }
        return staff;
    }

    @Override
    public void updateEntity(Staff model) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IStaffDAO staffDAO = session.getMapper(IStaffDAO.class);
            staffDAO.updateEntity(model);
            session.commit();
        }
    }

    @Override
    public void removeEntity(int id) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IStaffDAO staffDAO = session.getMapper(IStaffDAO.class);
            staffDAO.removeEntity(id);
            session.commit();
        }
    }

    @Override
    public List<Staff> getAll() throws SQLException {
        List<Staff> staffList;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IStaffDAO staffDAO = session.getMapper(IStaffDAO.class);
            staffList = staffDAO.getAll();
        }
        return staffList;
    }

    @Override
    public List<Staff> getStaffByName(String name) throws SQLException {
        List<Staff> staffList;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IStaffDAO staffDAO = session.getMapper(IStaffDAO.class);
            staffList = staffDAO.getStaffByName(name);
        }
        return staffList;
    }
}
