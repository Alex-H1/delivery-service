package sql.util;

import exception.UnsuportedTypeException;
import sql.IBaseDAO;

public abstract class AbstractDAOFactory {
    public abstract IBaseDAO getDAO(String model) throws UnsuportedTypeException;
}
