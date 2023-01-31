package model;

public class Package {
    private Integer orderId;
    private Integer packageId;
    private String trackingNumber;
    private Integer packageTypeId;
    private Double weight;

    public Package() {

    }

    public Integer getPackageTypeId() {
        return packageTypeId;
    }

    public void setPackageTypeId(Integer packageTypeId) {
        this.packageTypeId = packageTypeId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Package{" +
                "orderId=" + orderId +
                ", packageId=" + packageId +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", packageTypeId=" + packageTypeId +
                ", weight=" + weight +
                '}';
    }
}
