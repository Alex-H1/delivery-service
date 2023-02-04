package sql.util;

import exception.UnsuportedTypeException;

public class DBFactoryGenerator {
    public static AbstractDAOFactory getFactory(DBConnectionType connectionType) throws UnsuportedTypeException {
        switch (connectionType) {
            case JDBC:
                return new JDBCDAOFactory();
            case MYBATIS:
                return new MyBatisDAOFactory();
            default:
                throw new UnsuportedTypeException("Invalid DB");
        }
    }
}
