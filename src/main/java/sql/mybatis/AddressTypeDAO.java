package sql.mybatis;

import model.AddressType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import sql.IAddressTypeDAO;
import sql.util.MyBatisSqlFactory;

import java.sql.SQLException;
import java.util.List;

public class AddressTypeDAO implements IAddressTypeDAO {

    protected IAddressTypeDAO  IAddressTypeDAO;


    private SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    public AddressTypeDAO(sql.IAddressTypeDAO IAddressTypeDAO) {
        this.IAddressTypeDAO = IAddressTypeDAO;
    }

    public AddressTypeDAO() {
    }

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
            addressTypeDAO.saveEntity(model);
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
        try(SqlSession session = sqlSessionFactory.openSession()){
            IAddressTypeDAO addressTypeDAO = session.getMapper(IAddressTypeDAO.class);
            addressTypeDAO.updateEntity(model);
            session.commit();
        }
    }

    @Override
    public void removeEntity(int id) throws SQLException {
        try(SqlSession session = sqlSessionFactory.openSession()){
            IAddressTypeDAO addressTypeDAO = session.getMapper(IAddressTypeDAO.class);
            addressTypeDAO.removeEntity(id);
            session.commit();
        }
    }

    @Override
    public List<AddressType> getAll() throws SQLException {
       List<AddressType> addressTypeList;
       try(SqlSession session = sqlSessionFactory.openSession()){
           IAddressTypeDAO addressTypeDAO = session.getMapper(IAddressTypeDAO.class);
           addressTypeList = addressTypeDAO.getAll();
       }
        return addressTypeList;
    }
}
