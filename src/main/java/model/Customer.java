package model;

public class Customer {
    private Integer customerId;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String phoneNumber;
    private Integer address;
    private Integer company;

    public Customer(Integer customerId, String firstName,
                    String middleInitial, String lastName,
                    String phoneNumber, Integer address,
                    Integer company) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.company = company;
    }

    public Customer() {

    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public int getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "\n" + "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                ", company=" + company +
                '}' +
                "\n"
                ;
    }
}
