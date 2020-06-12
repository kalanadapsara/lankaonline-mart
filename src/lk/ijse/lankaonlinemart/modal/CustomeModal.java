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
public class CustomeModal {
    private int orderId;
    private String customerName;
    private Double totalPrice;
    private String date;
    private String itemName;
    private  int qty;
    private Double price;

    public CustomeModal() {
    }

    public CustomeModal(int orderId, String customerName, Double totalPrice, String date, String itemName, int qty, Double price) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
        this.date = date;
        this.itemName = itemName;
        this.qty = qty;
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "CustomeModal{" + "orderId=" + orderId + ", customerName=" + customerName + ", totalPrice=" + totalPrice + ", date=" + date + ", itemName=" + itemName + ", qty=" + qty + ", price=" + price + '}';
    }
    
}
