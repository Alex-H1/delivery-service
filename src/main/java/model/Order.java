package model;

public class Order {
    private Integer orderId;
    private Integer customer;
    private Integer box;
    private Integer status;
    private Integer deliveryEmployee;
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

    public Integer getBox() {
        return box;
    }

    public void setBox(Integer box) {
        this.box = box;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeliveryEmployee() {
        return deliveryEmployee;
    }

    public void setDeliveryEmployee(Integer deliveryEmployee) {
        this.deliveryEmployee = deliveryEmployee;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
