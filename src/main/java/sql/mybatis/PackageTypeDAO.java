package sql.mybatis;

import model.PackageType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sql.IPackageTypeDAO;
import sql.util.MyBatisSqlFactory;

import java.sql.SQLException;
import java.util.List;

public class PackageTypeDAO implements IPackageTypeDAO {

    protected IPackageTypeDAO iPackageTypeDAO;
    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    public PackageTypeDAO(IPackageTypeDAO iPackageTypeDAO) {
        this.iPackageTypeDAO = iPackageTypeDAO;
    }

    public PackageTypeDAO() {
    }

    @Override
    public void saveEntity(PackageType model) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPackageTypeDAO packageTypeDAO = session.getMapper(IPackageTypeDAO.class);
            packageTypeDAO.saveEntity(model);
            session.commit();
        }
    }

    @Override
    public PackageType getEntityByID(int id) throws SQLException {
        PackageType packageType;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPackageTypeDAO packageTypeDAO = session.getMapper(IPackageTypeDAO.class);
            packageType = packageTypeDAO.getEntityByID(id);
        }
        return packageType;
    }

    @Override
    public void updateEntity(PackageType model) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPackageTypeDAO packageTypeDAO = session.getMapper(IPackageTypeDAO.class);
            packageTypeDAO.updateEntity(model);

        }
    }

    @Override
    public void removeEntity(int id) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPackageTypeDAO packageTypeDAO = session.getMapper(IPackageTypeDAO.class);
            packageTypeDAO.removeEntity(id);

        }
    }

    @Override
    public List<PackageType> getAll() throws SQLException {
        List<PackageType> packageTypeList;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPackageTypeDAO packageTypeDAO = session.getMapper(IPackageTypeDAO.class);
            packageTypeList = packageTypeDAO.getAll();

        }
        return packageTypeList;
    }

    @Override
    public List<PackageType> getPackageTypeByName(String name) {
        List<PackageType> packageTypeList;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IPackageTypeDAO packageTypeDAO = session.getMapper(IPackageTypeDAO.class);
            packageTypeList = packageTypeDAO.getPackageTypeByName(name);

        }
        return packageTypeList;
    }
}
