package exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UnsuportedTypeException extends Exception{
    private static final Logger LOG = LogManager.getLogger(UnsuportedTypeException.class);

    public UnsuportedTypeException(String m) {
        LOG.error(m);
    }
}
