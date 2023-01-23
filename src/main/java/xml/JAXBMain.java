package xml;

import model.Staff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JAXBMain {
    private static final Logger LOG = LogManager.getLogger(JAXBMain.class);

    public static void main(String[] args) throws ParseException, JAXBException {
        try {
            Staff staff = new Staff(1, "Jane", "June", 3, new SimpleDateFormat("dd-MM-yyyy").parse("23-05-2004"));
            JAXBContext jaxbContext = JAXBContext.newInstance(Staff.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(staff, new File("src/main/resources/delivery_service_output.xml"));
            LOG.info(JAXBMain.unMarshall());
        } catch (ParseException | JAXBException e) {
            LOG.error(e.getMessage());
        }
    }

    public static Staff unMarshall() throws JAXBException {
        Staff staff = new Staff();
        try{
        JAXBContext context = JAXBContext.newInstance(Staff.class);
        staff = (Staff) context.createUnmarshaller().unmarshal(new FileReader("src/main/resources/delivery_service_output.xml"));
    } catch (FileNotFoundException e) {
            LOG.error(e.getMessage());
        }
        return staff;
    }
}
