package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;
@XmlRootElement(name = "deliveryService")
@XmlType(propOrder = {"customerList", "staffList"})
public class DeliveryService {
    private List<Customer> customerList;
    private List<Staff> staffList;

    public DeliveryService(List<Customer> customerList, List<Staff> staffList) {
        this.customerList = customerList;
        this.staffList = staffList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    @XmlElementWrapper(name = "customers")
    @XmlElement(name = "customer", type = Customer.class)
    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    @XmlElementWrapper(name = "staff")
    @XmlElement(name = "staff", type = Staff.class)
    public void setStaffList(List<Staff> staffList) {
        this.staffList = staffList;
    }

    @Override
    public String toString() {
        return "DeliveryService{" +
                "customerList=" + customerList +
                ", staffList=" + staffList +
                '}';
    }
}
