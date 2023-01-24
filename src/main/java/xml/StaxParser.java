package xml;

import model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class StaxParser {
    private static final Logger LOG = LogManager.getLogger(StaxParser.class);
    private static Customer customer;
    private static CompanyType companyType;
    private static Company company;
    private static JobTitle jobTitle;
    private static Country country;

    public static void read() throws FileNotFoundException, XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileReader("src/main/resources/deliveryService.xml"));
        ArrayList deliveryService = new ArrayList<>();
        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();
            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();

                switch (startElement.getName().getLocalPart()) {
                    case "customer":
                        customer = new Customer();
                        Attribute id = startElement.getAttributeByName(new QName("id"));
                        if(id != null){
                            customer.setCustomerId(Integer.valueOf(id.getValue()));
                        }
                        break;
                    case "firstName":
                        nextEvent = reader.nextEvent();
                        customer.setFirstName(nextEvent.asCharacters().getData());
                        break;
                    case "middleInitial":
                        nextEvent = reader.nextEvent();
                        customer.setMiddleInitial(nextEvent.asCharacters().getData());
                        break;
                    case "lastName":
                        nextEvent = reader.nextEvent();
                        customer.setLastName(nextEvent.asCharacters().getData());
                        break;
                    case "phoneNumber":
                        nextEvent = reader.nextEvent();
                        customer.setPhoneNumber(nextEvent.asCharacters().getData());
                        break;
                    case "companyType":
                        companyType = new CompanyType();
                        Attribute companyTypeId = startElement.getAttributeByName(new QName("id"));
                        if(companyTypeId != null) {
                            customer.setCustomerId(Integer.valueOf(companyTypeId.getValue()));
                            break;
                        }
                    case "companyTypeName":
                        nextEvent = reader.nextEvent();
                        companyType.setCompanytypeName(nextEvent.asCharacters().getData());
                        deliveryService.add(companyType);
                        break;
                    case "company":
                        company = new Company();
                        Attribute companyId = startElement.getAttributeByName(new QName("id"));
                        if(companyId != null) {
                            customer.setCustomerId(Integer.valueOf(companyId.getValue()));
                            break;
                        }
                        break;
                    case "companyName":
                        nextEvent = reader.nextEvent();
                        company.setCompanyName(nextEvent.asCharacters().getData());
                        deliveryService.add(company);
                        break;
                    case "companyTypeId":
                        nextEvent = reader.nextEvent();
                        company.setCompanyId(Integer.valueOf(nextEvent.asCharacters().getData()));
                        break;
                    case "jobTitle":
                        jobTitle = new JobTitle();
                        Attribute jobTitleId = startElement.getAttributeByName(new QName("id"));
                        if(jobTitleId != null) {
                            customer.setCustomerId(Integer.valueOf(jobTitleId.getValue()));
                            break;
                        }
                        break;
                    case "jobTitleName":
                        nextEvent = reader.nextEvent();
                        jobTitle.setJobTitle(nextEvent.asCharacters().getData());
                        deliveryService.add(jobTitle);
                        break;
                    case "country":
                        country = new Country();
                        Attribute countryId = startElement.getAttributeByName(new QName("id"));
                        if(countryId != null) {
                            customer.setCustomerId(Integer.valueOf(countryId.getValue()));
                            break;
                        }
                        break;
                    case "countryName":
                        nextEvent = reader.nextEvent();
                        country.setCountryName(nextEvent.asCharacters().getData());
                        deliveryService.add(country);
                        break;
                }
            }
        }
        LOG.info(deliveryService);
    }

}
