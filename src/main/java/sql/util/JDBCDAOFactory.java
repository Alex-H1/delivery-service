package sql.util;

import exception.UnsuportedTypeException;
import sql.IBaseDAO;
import sql.jdbc.*;

public class JDBCDAOFactory extends AbstractDAOFactory{

    @Override
    public IBaseDAO getDAO(String model) throws UnsuportedTypeException {
        switch (model) {
            case "address":
                return new AddressDAO();
            case "addressType":
                return new AddressTypeDAO();
            case "city":
                return new CityDAO();
            case "company":
                return new CompanyDAO();
            case "companyType":
                return new CompanyTypeDAO();
            case "country":
                return new CountryDAO();
            case "customer":
                return new CustomerDAO();
            case "jobTitle":
                return new JobTitleDAO();
            case "order":
                return new OrderDAO();
            case "package":
                return new PackageDAO();
            case "packageType":
                return new PackageTypeDAO();
            case "staff":
                return new StaffDAO();
            case "status":
                return new StatusDAO();
            default:
                throw new UnsuportedTypeException("Invalid Object");
        }
    }
}
