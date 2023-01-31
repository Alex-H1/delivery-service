package mybatis;

import mybatis.interfaces.IParentDAO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class MyBatisDAO<T, PK> implements IParentDAO<T> {

    private static final Logger LOG = LogManager.getLogger(MyBatisDAO.class);
    private static final String NAMESPACE = "mappers";
    private SqlSessionFactory sf;
    private Class<T> type;
    public static final String PREFIX_SELECT_QUERY = "get";
    public static final String PREFIX_INSERT_QUERY = "create";
    public static final String PREFIX_UPDATE_QUERY = "update";
    public static final String PREFIX_DELETE_QUERY = "delete";

    public MyBatisDAO(Class<T> type, SqlSessionFactory sf) {
        this.type = type;
        this.sf = sf;
        if (sf == null) {
            LOG.error("Error: Could not instantiate MyBatisDAO. Loading myBatis sessionFactory failed.");
        }
    }

    protected SqlSessionFactory getSessionFactory() {
        return sf;
    }

    public T get(int id) {
        SqlSession session = sf.openSession();
        T obj = null;
        try {
            String query = NAMESPACE + "." + PREFIX_SELECT_QUERY + this.type.getSimpleName();
            obj = (T) session.selectOne(query, id);
        } finally {
            session.close();
        }
        return obj;
    }

    public ArrayList<T> getAll() {
        SqlSession session = sf.openSession();
        ArrayList<T> list = null;
        try {
            String query = NAMESPACE + "." + PREFIX_SELECT_QUERY + "All";
            list = (ArrayList<T>) session.selectList(query);
        } finally {
            session.close();
        }
        return list;
    }

    public int create(T o) {
        SqlSession session = sf.openSession();
        Integer status = null;
        try {
            String query = NAMESPACE + "." + PREFIX_INSERT_QUERY + o.getClass().getSimpleName();
            status = (Integer) session.insert(query, o);
            session.commit();
        } finally {
            session.close();
        }
        return status;
    }

    public int update(T o){
        SqlSession session = sf.openSession();
        Integer status = null;
        try{
            String query = NAMESPACE + "." + PREFIX_UPDATE_QUERY + o.getClass().getSimpleName();
            status = session.update(query, o);
            session.commit();
        }finally {
            session.close();
        }
        return status;
    }

    public int delete(int id){
        SqlSession session = sf.openSession();
        Integer status = null;
        try{
            String query = NAMESPACE + "." + PREFIX_DELETE_QUERY + this.type.getSimpleName();
            status = session.delete(query, id);
            session.commit();
        }finally {
            session.close();
        }
        return status;
    }
}
