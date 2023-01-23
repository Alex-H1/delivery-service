package xml;

import model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
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
                        LOG.info("Customers");
                        break;
                    case "customerid":
                        nextEvent = reader.nextEvent();
                        customer.setCustomerId(Integer.valueOf(nextEvent.asCharacters().getData()));
                        break;
                    case "firstname":
                        nextEvent = reader.nextEvent();
                        customer.setFirstName(nextEvent.asCharacters().getData());
                        break;
                    case "middleinitial":
                        nextEvent = reader.nextEvent();
                        customer.setMiddleInitial(nextEvent.asCharacters().getData());
                        break;
                    case "lastname":
                        nextEvent = reader.nextEvent();
                        customer.setLastName(nextEvent.asCharacters().getData());
                        break;
                    case "phonenumber":
                        nextEvent = reader.nextEvent();
                        customer.setPhoneNumber(nextEvent.asCharacters().getData());
                        break;
                    case "companyid":
                        nextEvent = reader.nextEvent();
                        customer.setCompany(Integer.valueOf(nextEvent.asCharacters().getData()));
                        break;
                    case "addressid":
                        nextEvent = reader.nextEvent();
                        customer.setAddress(Integer.valueOf(nextEvent.asCharacters().getData()));
                        deliveryService.add(customer);
                        break;
                    case "companytype":
                        companyType = new CompanyType();

                        LOG.info("CompanyType");
                        break;
                    case "companytypeid":
                        nextEvent = reader.nextEvent();
                        companyType.setCompanyTypeId(Integer.valueOf(nextEvent.asCharacters().getData()));
                        break;
                    case "companytypename":
                        nextEvent = reader.nextEvent();
                        companyType.setCompanytypeName(nextEvent.asCharacters().getData());
                        deliveryService.add(companyType);
                        break;
                    case "company":
                        company = new Company();
                        LOG.info("Company");
                        break;
                    case "companyids":
                        nextEvent = reader.nextEvent();
                        company.setCompanyId(Integer.valueOf(nextEvent.asCharacters().getData()));
                        break;
                    case "companyname":
                        nextEvent = reader.nextEvent();
                        company.setCompanyName(nextEvent.asCharacters().getData());
                        deliveryService.add(company);
                        break;
                    case "companytypeids":
                        nextEvent = reader.nextEvent();
                        company.setCompanyId(Integer.valueOf(nextEvent.asCharacters().getData()));
                        break;
                    case "jobtitle":
                        jobTitle = new JobTitle();
                        LOG.info("Job title");
                        break;
                    case "jobtitleid":
                        nextEvent = reader.nextEvent();
                        jobTitle.setJobTitleId(Integer.valueOf(nextEvent.asCharacters().getData()));
                        break;
                    case "jobtitlename":
                        nextEvent = reader.nextEvent();
                        jobTitle.setJobTitle(nextEvent.asCharacters().getData());
//                        LOG.info(nextEvent.asCharacters().getData());
                        deliveryService.add(jobTitle);
                        break;
                    case "country":
                         country = new Country();
                        LOG.info("Country");
                        break;
                    case "countryName":
                        nextEvent = reader.nextEvent();
                        country.setCountryName(nextEvent.asCharacters().getData());
//                        LOG.info(nextEvent.asCharacters().getData());
                        deliveryService.add(country);
                        break;
                }
            }
        }
        LOG.info(deliveryService);
    }

}
