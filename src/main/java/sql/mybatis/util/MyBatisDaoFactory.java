package sql.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class MyBatisDaoFactory {

    private final static Logger LOG = LogManager.getLogger(MyBatisDaoFactory.class);
    private final static MyBatisDaoFactory myBatisDaoFactory = new MyBatisDaoFactory();
    private static SqlSessionFactory sqlSessionFactory;

    private MyBatisDaoFactory() {
        try {
            Reader reader = Resources.getResourceAsReader("sql.mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            LOG.error("Exception while reading configuration", e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
