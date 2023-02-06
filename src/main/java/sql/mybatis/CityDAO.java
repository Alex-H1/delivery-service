package sql.mybatis;

import model.City;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sql.ICityDAO;
import sql.util.MyBatisSqlFactory;

import java.sql.SQLException;
import java.util.List;

public class CityDAO implements ICityDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void saveEntity(City model) throws SQLException {
        try(SqlSession session = sqlSessionFactory.openSession()){
            ICityDAO cityDAO = session.getMapper(ICityDAO.class);
            cityDAO.saveEntity(model);
            session.commit();
        }
    }

    @Override
    public City getEntityByID(int id) throws SQLException {
        City city;
        try(SqlSession session = sqlSessionFactory.openSession()){
            ICityDAO cityDAO = session.getMapper(ICityDAO.class);
            city = cityDAO.getEntityByID(id);
        }
        return city;
    }

    @Override
    public void updateEntity(City model) throws SQLException {
        try(SqlSession session = sqlSessionFactory.openSession()){
            ICityDAO cityDAO = session.getMapper(ICityDAO.class);
            cityDAO.updateEntity(model);
            session.commit();
        }
    }

    @Override
    public void removeEntity(int id) throws SQLException {
        try(SqlSession session = sqlSessionFactory.openSession()){
            ICityDAO cityDAO = session.getMapper(ICityDAO.class);
            cityDAO.removeEntity(id);
            session.commit();
        }
    }

    @Override
    public List<City> getAll() throws SQLException {
        List<City> cityList;
        try(SqlSession session = sqlSessionFactory.openSession()){
            ICityDAO cityDAO = session.getMapper(ICityDAO.class);
            cityList = cityDAO.getAll();
        }
        return cityList;
    }

    @Override
    public List<City> getCityByName(String name) throws SQLException {
        List<City> cityList;
        try(SqlSession session = sqlSessionFactory.openSession()){
            ICityDAO cityDAO = session.getMapper(ICityDAO.class);
            cityList = cityDAO.getCityByName(name);
        }
        return cityList;
    }
}
