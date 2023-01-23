package xml;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;


public class Runner {
    private static final Logger LOG = LogManager.getLogger(Runner.class);

    public static void main(String[] args) throws XMLStreamException, FileNotFoundException {
        StaxParser.read();
        LOG.info("xml is valid: " + XMLValidator.ValidateXML("src/main/resources/deliveryService.xsd", "src/main/resources/deliveryService.xml"));

    }
}
