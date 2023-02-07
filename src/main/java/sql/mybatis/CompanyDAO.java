package sql.mybatis;

import model.Company;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sql.ICompanyDAO;
import sql.util.MyBatisSqlFactory;

import java.sql.SQLException;
import java.util.List;

public class CompanyDAO implements ICompanyDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();


    @Override
    public void saveEntity(Company model) throws SQLException {
        try(SqlSession session = sqlSessionFactory.openSession()){
            ICompanyDAO companyDAO = session.getMapper(ICompanyDAO.class);
            companyDAO.saveEntity(model);
            session.commit();
        }
    }

    @Override
    public Company getEntityByID(int id) throws SQLException {
        Company company;
        try(SqlSession session = sqlSessionFactory.openSession()){
            ICompanyDAO companyDAO = session.getMapper(ICompanyDAO.class);
            company = companyDAO.getEntityByID(id);
        }
        return company;
    }

    @Override
    public void updateEntity(Company model) throws SQLException {
        try(SqlSession session = sqlSessionFactory.openSession()){
            ICompanyDAO companyDAO = session.getMapper(ICompanyDAO.class);
            companyDAO.updateEntity(model);
            session.commit();
        }
    }

    @Override
    public void removeEntity(int id) throws SQLException {
        try(SqlSession session = sqlSessionFactory.openSession()){
            ICompanyDAO companyDAO = session.getMapper(ICompanyDAO.class);
            companyDAO.removeEntity(id);
            session.commit();
        }
    }

    @Override
    public List<Company> getAll() throws SQLException {
        List<Company> companyList;
        try(SqlSession session = sqlSessionFactory.openSession()){
            ICompanyDAO companyDAO = session.getMapper(ICompanyDAO.class);
            companyList = companyDAO.getAll();
        }
        return companyList;
    }

    @Override
    public List<Company> getCompanyByName(String name) throws SQLException {
        List<Company> companyList;
        try(SqlSession session = sqlSessionFactory.openSession()){
            ICompanyDAO companyDAO = session.getMapper(ICompanyDAO.class);
            companyList = companyDAO.getCompanyByName(name);
        }
        return companyList;
    }
}
