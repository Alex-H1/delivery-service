package sql.mybatis;

import model.CompanyType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sql.ICompanyTypeDAO;
import sql.util.MyBatisSqlFactory;

import java.sql.SQLException;
import java.util.List;

public class CompanyTypeDAO implements ICompanyTypeDAO {

    protected ICompanyTypeDAO iCompanyTypeDAO;
    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    public CompanyTypeDAO(ICompanyTypeDAO iCompanyTypeDAO) {
        this.iCompanyTypeDAO = iCompanyTypeDAO;
    }

    public CompanyTypeDAO() {
    }

    @Override
    public void saveEntity(CompanyType model) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICompanyTypeDAO companyTypeDAO = session.getMapper(ICompanyTypeDAO.class);
            companyTypeDAO.saveEntity(model);
            session.commit();
        }
    }

    @Override
    public CompanyType getEntityByID(int id) throws SQLException {
        CompanyType companyType;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICompanyTypeDAO companyTypeDAO = session.getMapper(ICompanyTypeDAO.class);
            companyType = companyTypeDAO.getEntityByID(id);
        }
        return companyType;
    }

    @Override
    public void updateEntity(CompanyType model) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICompanyTypeDAO companyTypeDAO = session.getMapper(ICompanyTypeDAO.class);
            companyTypeDAO.updateEntity(model);
        }
    }

    @Override
    public void removeEntity(int id) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICompanyTypeDAO companyTypeDAO = session.getMapper(ICompanyTypeDAO.class);
            companyTypeDAO.removeEntity(id);
            session.commit();
        }
    }

    @Override
    public List<CompanyType> getAll() throws SQLException {
        List<CompanyType> companyTypeList;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICompanyTypeDAO companyTypeDAO = session.getMapper(ICompanyTypeDAO.class);
            companyTypeList = companyTypeDAO.getAll();
        }
        return companyTypeList;
    }

    @Override
    public List<CompanyType> getCompanyTypeByCompanyTypeName(String name) throws SQLException {
        List<CompanyType> companyTypeList;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICompanyTypeDAO companyTypeDAO = session.getMapper(ICompanyTypeDAO.class);
            companyTypeList = companyTypeDAO.getCompanyTypeByCompanyTypeName(name);
        }
        return companyTypeList;
    }
}
