package model;

public class Address {
    private Integer addressId;
    private String address;
    private Double postalCode;
    private Integer city;


    private int addressType;


    public Address() {

    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Double postalCode) {
        this.postalCode = postalCode;
    }

    public int getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = Integer.valueOf(city);
    }

    public int getAddressType() {
        return addressType;
    }

    public void setAddressType(int addressType) {
        this.addressType = addressType;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", address='" + address + '\'' +
                ", postalCode=" + postalCode +
                ", city=" + city +
                ", addressType=" + addressType +
                '}';
    }
}
