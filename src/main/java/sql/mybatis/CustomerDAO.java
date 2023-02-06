package sql.mybatis;

import model.Customer;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sql.ICustomerDAO;
import sql.util.MyBatisSqlFactory;

import java.sql.SQLException;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {

    protected ICustomerDAO iCustomerDAO;
    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    public CustomerDAO(ICustomerDAO iCustomerDAO) {
        this.iCustomerDAO = iCustomerDAO;
    }

    public CustomerDAO() {
    }

    @Override
    public void saveEntity(Customer model) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = session.getMapper(ICustomerDAO.class);
            customerDAO.saveEntity(model);
            session.commit();
        }
    }

    @Override
    public Customer getEntityByID(int id) throws SQLException {
        Customer customer;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = session.getMapper(ICustomerDAO.class);
            customer = customerDAO.getEntityByID(id);
        }
        return customer;
    }

    @Override
    public void updateEntity(Customer model) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = session.getMapper(ICustomerDAO.class);
            customerDAO.updateEntity(model);
            session.commit();
        }
    }

    @Override
    public void removeEntity(int id) throws SQLException {
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = session.getMapper(ICustomerDAO.class);
            customerDAO.removeEntity(id);
            session.commit();
        }
    }

    @Override
    public List<Customer> getAll() throws SQLException {
        List<Customer> customerList;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = session.getMapper(ICustomerDAO.class);
            customerList = customerDAO.getAll();
        }
        return customerList;
    }

    @Override
    public Customer getCustomerByPhoneNumber(String phoneNumber) throws SQLException {
        Customer customer;
        try (SqlSession session = sqlSessionFactory.openSession()) {
            ICustomerDAO customerDAO = session.getMapper(ICustomerDAO.class);
            customer = customerDAO.getCustomerByPhoneNumber(phoneNumber);
        }
        return customer;
    }
}
