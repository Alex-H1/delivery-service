package sql.mybatis;

import model.AddressType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sql.IAddressTypeDAO;
import sql.mybatis.util.MyBatisSqlFactory;

import java.sql.SQLException;
import java.util.List;

public class AddressTypeDAO implements IAddressTypeDAO {

    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public List<AddressType> getAddressTypeByName(String name) throws SQLException {
        List<AddressType> addressTypeList;
        try(SqlSession session = sqlSessionFactory.openSession()){
            IAddressTypeDAO addressTypeDAO = session.getMapper(IAddressTypeDAO.class);
            addressTypeList = addressTypeDAO.getAddressTypeByName(name);
        }
        return addressTypeList;
    }

    @Override
    public void saveEntity(AddressType model) throws SQLException {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IAddressTypeDAO addressTypeDAO = session.getMapper(IAddressTypeDAO.class);
            session.commit();
        }
    }

    @Override
    public AddressType getEntityByID(int id) throws SQLException {
        AddressType addressType;
        try(SqlSession session = sqlSessionFactory.openSession()){
            IAddressTypeDAO addressTypeDAO = session.getMapper(IAddressTypeDAO.class);
            addressType = addressTypeDAO.getEntityByID(id);
        }
        return addressType;
    }

    @Override
    public void updateEntity(AddressType model) throws SQLException {

    }

    @Override
    public void removeEntity(int id) throws SQLException {

    }

    @Override
    public List<AddressType> getAll() throws SQLException {
        return null;
    }
}
