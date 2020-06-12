/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.lankaonlinemart.modal;

import java.util.ArrayList;

/**
 *
 * @author kalana dapsara
 */
public class PlaceOrder {
    private int orderID;
    private String orderDate;
    private Customer customer;
    private ArrayList<Item> itemList;
    private int paymentId;
    private double totalPrice;
    
    
    

    public PlaceOrder() {
    }

    public PlaceOrder(int orderID, String orderDate, Customer customer, ArrayList<Item> itemList, int paymentId, double totalPrice) {
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.customer = customer;
        this.itemList = itemList;
        this.paymentId = paymentId;
        this.totalPrice = totalPrice;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

  

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "PlaceOrder{" + "orderID=" + orderID + ", orderDate=" + orderDate + ", customer=" + customer + ", itemList=" + itemList + ", paymentId=" + paymentId + ", totalPrice=" + totalPrice + '}';
    }

   

   
    
            
    
}
