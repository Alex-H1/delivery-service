package model;

import java.util.Date;
public class Order {
    private Integer orderId;
    private Integer customerId;
    private Integer boxId;
    private Integer status;
    private Integer deliveryEmployeeId;
    private Double amount;
    private Date date;

    public Order(Integer orderId, Integer customer, Integer boxId, Integer status, Integer deliveryEmployeeId, Double amount, Date date) {
        this.orderId = orderId;
        this.customerId = customer;
        this.boxId = boxId;
        this.status = status;
        this.deliveryEmployeeId = deliveryEmployeeId;
        this.amount = amount;
        this.date = date;
    }

    public Order() {
    }
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
                ", customer=" + customerId +
                ", boxId=" + boxId +
                ", status=" + status +
                ", deliveryEmployeeId=" + deliveryEmployeeId +
                ", amount=" + amount +
                '}';
    }
}
