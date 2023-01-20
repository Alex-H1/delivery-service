package xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Parser {
    private static final Logger LOG = LogManager.getLogger(Parser.class);

    public static void reader() throws FileNotFoundException, XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(new FileInputStream("src/main/resources/deliveryService.xml"));
        while(xmlStreamReader.hasNext()){
            int eventType = xmlStreamReader.getEventType();
            switch(eventType){
                case XMLStreamReader.START_DOCUMENT:
                    LOG.info("delivery_service");
                    break;
                case XMLStreamReader.START_ELEMENT:
                    LOG.info("Start Element - name " + xmlStreamReader.getLocalName());
                    break;
                case XMLStreamReader.END_ELEMENT:
                    LOG.info("End Element - name " + xmlStreamReader.getLocalName());

                    break;
                case XMLStreamReader.CHARACTERS:
                    LOG.info("Element Data - name " + xmlStreamReader.getText() );

                    break;
            }
            xmlStreamReader.next();
        }
        xmlStreamReader.close();
    }

}
