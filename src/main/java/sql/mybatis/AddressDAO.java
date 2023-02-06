package sql.mybatis;

import model.Address;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sql.IAddressDAO;
import sql.util.MyBatisSqlFactory;

import java.sql.SQLException;
import java.util.List;


public class AddressDAO implements IAddressDAO {

    protected IAddressDAO iAddressDAO;

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();
    public AddressDAO() {
    }

    public AddressDAO(IAddressDAO iAddressDAO) {
        this.iAddressDAO = iAddressDAO;
    }

    @Override
    public Address getAddressByAddress(String address) throws SQLException {
        Address address1;
        try(SqlSession session = sqlSessionFactory.openSession()){
            IAddressDAO addressDAO = session.getMapper(IAddressDAO.class);
            address1 = addressDAO.getAddressByAddress(address);
        }
        return address1;
    }

    @Override
    public void saveEntity(Address model) throws SQLException {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IAddressDAO addressDAO = session.getMapper(IAddressDAO.class);
            addressDAO.saveEntity(model);
            session.commit();
        }
    }

    @Override
    public Address getEntityByID(int id) throws SQLException {
        Address address;
        try(SqlSession session = sqlSessionFactory.openSession()){
            IAddressDAO addressDAO = session.getMapper(IAddressDAO.class);
            address = addressDAO.getEntityByID(id);
        }
        return address;
    }

    @Override
    public void updateEntity(Address model) throws SQLException {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IAddressDAO addressDAO = session.getMapper(IAddressDAO.class);
            addressDAO.updateEntity(model);
            session.commit();
        }
    }

    @Override
    public void removeEntity(int id) throws SQLException {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IAddressDAO addressDAO = session.getMapper(IAddressDAO.class);
            addressDAO.removeEntity(id);
            session.commit();
        }
    }

    @Override
    public List<Address> getAll() throws SQLException {
        List<Address> addressList;
        try(SqlSession session = sqlSessionFactory.openSession()){
            IAddressDAO addressDAO = session.getMapper(IAddressDAO.class);
            addressList = addressDAO.getAll();
        }
        return addressList;
    }
}
