package json;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class JacksonMain {
    private static final Logger LOG = LogManager.getLogger(JacksonMain.class);

    public static void main(String[] args) throws ParseException {
        List<Customer> customerList = new ArrayList<>();
        List<Staff> staffList = new ArrayList<>();
        List<Company> companyList = new ArrayList<>();
        List<CompanyType> companyTypeList = new ArrayList<>();
        List<Country> countryList = new ArrayList<>();

        Customer customer1 = new Customer(1, "John", "O", "Doe", "(434)449-6545", 1, 2);
        Customer customer2 = new Customer(2, "Jimmy", "D", "Johns", "(475)482-3542", 3, 4);
        Staff staff1 = new Staff(1, "Jane", "June", 3, new SimpleDateFormat("dd-MM-yyyy").parse("23-05-2004"));
        Staff staff2 = new Staff(2, "Jane", "June", 3, new SimpleDateFormat("dd-MM-yyyy").parse("23-05-2004"));
        Company company1 = new Company(1, "John's Construction", 1);
        Company company2 = new Company(2, "Walmart", 2);
        CompanyType companyType1 = new CompanyType(1, "industrial");
        CompanyType companyType2 = new CompanyType(2, "retail");
        Country country1 = new Country(1, "Canada");
        Country country2 = new Country(2, "China");

        customerList.add(customer1);
        customerList.add(customer2);
        staffList.add(staff1);
        staffList.add(staff2);
        companyList.add(company1);
        companyList.add(company2);
        companyTypeList.add(companyType1);
        companyTypeList.add(companyType2);
        countryList.add(country1);
        countryList.add(country2);

        DeliveryService deliveryService = new DeliveryService(customerList, staffList, companyList, companyTypeList, countryList);
        ObjectMapper om = new ObjectMapper();
        try {
            om.writeValue(new File("src/main/resources/delivery_service_output.json"), deliveryService);
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }

    }
}
