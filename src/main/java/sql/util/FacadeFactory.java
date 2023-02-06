package sql.util;

import exception.UnsuportedTypeException;
import sql.IBaseDAO;

public class FacadeFactory {
    private MyBatisDAOFactory MYBATIS;
    private JDBCDAOFactory JDBC;

    public FacadeFactory(){
        MYBATIS = new MyBatisDAOFactory();
        JDBC = new JDBCDAOFactory();
    }

    public IBaseDAO createDAO(String m) throws UnsuportedTypeException {
        return JDBC.getDAO(m);
    }

    public IBaseDAO createMyBatis(String m) throws UnsuportedTypeException {
        return MYBATIS.getDAO(m);
    }


}
