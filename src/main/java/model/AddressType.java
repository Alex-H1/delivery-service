package model;

public class AddressType {
    private int addressTypeId;
    private String addressType;

    public AddressType() {

    }

    public int getAddressTypeId() {
        return addressTypeId;
    }

    public void setAddressTypeId(int addressTypeId) {
        this.addressTypeId = addressTypeId;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    @Override
    public String toString() {
        return "AddressType{" +
                "addressTypeId=" + addressTypeId +
                ", addressType='" + addressType + '\'' +
                '}';
    }
}
