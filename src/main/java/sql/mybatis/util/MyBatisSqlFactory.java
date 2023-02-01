package sql.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.apache.logging.log4j.*;

import java.io.IOException;
import java.io.Reader;

public class MyBatisSqlFactory {
    private static SqlSessionFactory sqlSessionFactory;
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");

    static {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}