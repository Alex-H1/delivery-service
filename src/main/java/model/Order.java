package model;

public class Order {
    private Integer orderId;
    private Integer customer;
    private Integer boxId;
    private Integer status;
    private Integer deliveryEmployeeId;
    private Double amount;


    public Order() {
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(Integer customer) {
        this.customer = customer;
    }

    public Integer getBoxId() {
        return boxId;
    }

    public void setBoxId(Integer boxId) {
        this.boxId = boxId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeliveryEmployeeId() {
        return deliveryEmployeeId;
    }

    public void setDeliveryEmployeeId(Integer deliveryEmployee) {
        this.deliveryEmployeeId = deliveryEmployee;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", boxId=" + boxId +
                ", status=" + status +
                ", deliveryEmployeeId=" + deliveryEmployeeId +
                ", amount=" + amount +
                '}';
    }
}
