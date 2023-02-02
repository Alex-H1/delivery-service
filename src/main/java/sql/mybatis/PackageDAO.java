package sql.mybatis;

import model.Package;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sql.IPackageDAO;
import sql.mybatis.util.MyBatisSqlFactory;

import java.sql.SQLException;
import java.util.List;

public class PackageDAO implements IPackageDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void saveEntity(Package model) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPackageDAO packageDAO = session.getMapper(IPackageDAO.class);
            packageDAO.saveEntity(model);
            session.commit();
        }
    }

    @Override
    public Package getEntityByID(int id) throws SQLException {
        Package box;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPackageDAO packageDAO = session.getMapper(IPackageDAO.class);
            box = packageDAO.getEntityByID(id);
        }
        return box;
    }

    @Override
    public void updateEntity(Package model) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPackageDAO packageDAO = session.getMapper(IPackageDAO.class);
            packageDAO.updateEntity(model);
            session.commit();
        }
    }

    @Override
    public void removeEntity(int id) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPackageDAO packageDAO = session.getMapper(IPackageDAO.class);
            packageDAO.removeEntity(id);
            session.commit();
        }
    }

    @Override
    public List<Package> getAll() throws SQLException {
        List<Package> packageList;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPackageDAO packageDAO = session.getMapper(IPackageDAO.class);
            packageList = packageDAO.getAll();
        }
        return packageList;
    }

    @Override
    public Package getPackageByTrackingNumber(String num) {
        Package box;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPackageDAO packageDAO = session.getMapper(IPackageDAO.class);
            box = packageDAO.getPackageByTrackingNumber(num);
        }
        return box;
    }
}
