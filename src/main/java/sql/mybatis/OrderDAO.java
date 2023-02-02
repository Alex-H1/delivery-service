package sql.mybatis;

import model.Order;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sql.IOrderDAO;
import sql.mybatis.util.MyBatisSqlFactory;

import java.sql.SQLException;
import java.util.List;

public class OrderDAO implements IOrderDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void saveEntity(Order model) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IOrderDAO orderDAO = session.getMapper(IOrderDAO.class);
            orderDAO.saveEntity(model);
            session.commit();
        }
    }

    @Override
    public Order getEntityByID(int id) throws SQLException {
        Order order;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IOrderDAO orderDAO = session.getMapper(IOrderDAO.class);
            order = orderDAO.getEntityByID(id);
        }
        return order;
    }

    @Override
    public void updateEntity(Order model) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IOrderDAO orderDAO = session.getMapper(IOrderDAO.class);
            orderDAO.updateEntity(model);
            session.commit();
        }
    }

    @Override
    public void removeEntity(int id) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IOrderDAO orderDAO = session.getMapper(IOrderDAO.class);
            orderDAO.removeEntity(id);
            session.commit();
        }
    }

    @Override
    public List<Order> getAll() throws SQLException {
        List<Order> orderList;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IOrderDAO orderDAO = session.getMapper(IOrderDAO.class);
            orderList = orderDAO.getAll();
        }
        return orderList;
    }

    @Override
    public List<Order> getOrderByDeliveryEmployee(int id) {
        List<Order> orderList;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            IOrderDAO orderDAO = session.getMapper(IOrderDAO.class);
            orderList = orderDAO.getOrderByDeliveryEmployee(id);
        }
        return orderList;
    }
}
