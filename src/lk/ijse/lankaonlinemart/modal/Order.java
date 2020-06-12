/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.lankaonlinemart.modal;

/**
 *
 * @author kalana dapsara
 */
public class Order {
    private int orderId;
    private int customerId;
    private String orderDate;
    private int paymentID;

    

    public Order() {
    }

    public Order(int orderId, int customerId, String orderDate, int paymentID) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = orderDate;
        this.paymentID = paymentID;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customerId=" + customerId + ", orderDate=" + orderDate + ", paymentID=" + paymentID + '}';
    }
    

  
    

  
    
    
    
}
