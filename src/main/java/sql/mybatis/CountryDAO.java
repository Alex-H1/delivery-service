package sql.mybatis;

import model.Country;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sql.ICountryDAO;
import sql.util.MyBatisSqlFactory;

import java.sql.SQLException;
import java.util.List;

public class CountryDAO implements ICountryDAO {

    protected ICountryDAO countryDAO;
    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    public CountryDAO(ICountryDAO countryDAO) {
        this.countryDAO = countryDAO;
    }

    public CountryDAO() {
    }

    @Override
    public void saveEntity(Country model) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICountryDAO countryDAO = session.getMapper(ICountryDAO.class);
            countryDAO.saveEntity(model);
            session.commit();
        }
    }

    @Override
    public Country getEntityByID(int id) throws SQLException {
        Country country;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICountryDAO countryDAO = session.getMapper(ICountryDAO.class);
            country = countryDAO.getEntityByID(id);
        }
        return country;
    }

    @Override
    public void updateEntity(Country model) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICountryDAO countryDAO = session.getMapper(ICountryDAO.class);
            countryDAO.saveEntity(model);
            session.commit();
        }
    }

    @Override
    public void removeEntity(int id) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICountryDAO countryDAO = session.getMapper(ICountryDAO.class);
            countryDAO.removeEntity(id);
            session.commit();
        }
    }

    @Override
    public List<Country> getAll() throws SQLException {
        List<Country> countryList;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICountryDAO countryDAO = session.getMapper(ICountryDAO.class);
            countryList = countryDAO.getAll();
        }
        return countryList;
    }

    @Override
    public List<Country> getCountryByCountryName(String name) throws SQLException {
        List<Country> countryList;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICountryDAO countryDAO = session.getMapper(ICountryDAO.class);
            countryList = countryDAO.getCountryByCountryName(name);
        }
        return countryList;
    }
}
