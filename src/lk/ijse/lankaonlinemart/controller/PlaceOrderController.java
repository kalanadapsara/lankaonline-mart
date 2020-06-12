/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.lankaonlinemart.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.lankaonlinemart.modal.Item;
import lk.ijse.lankaonlinemart.modal.Order;
import lk.ijse.lankaonlinemart.modal.Payment;
import lk.ijse.lankaonlinemart.modal.PlaceOrder;

import lk.ijse.lanlaonlinemart.db.DBConnection;

/**
 *
 * @author kalana dapsara
 */
public class PlaceOrderController {

    private CustomerController customerController = new CustomerController();
    private PaymentController paymentController = new PaymentController();
    private OrderController orderController = new OrderController();

    public int getNextOrderID() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT orderID FROM orders ORDER BY orderID DESC LIMIT 1");
        ResultSet rst = pstm.executeQuery();
        int orderid;
        if (rst.next()) {
            orderid = rst.getInt(1);
            orderid++;
            return orderid;
        }

        return 1;
    }

    public boolean addOrder(PlaceOrder placeOrder) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO order_detail VALUES(?,?,?,?)");
        try {
            connection.setAutoCommit(false);
            System.out.println("Place Order : " + placeOrder);
            boolean addedCustomer = customerController.isAddedCustomer(placeOrder.getCustomer().getCustomerId());
            if (addedCustomer == false) {
                boolean addCustomer = customerController.addCustomer(placeOrder.getCustomer());
            }

            System.out.println("customer added");
            Payment payment = new Payment(placeOrder.getPaymentId(), placeOrder.getTotalPrice());
            boolean addPayment = paymentController.addPayment(payment);
            if (addPayment) {
                System.out.println("payment added");
                Order order = new Order();
                        order.setOrderId(placeOrder.getOrderID());
                        order.setCustomerId(placeOrder.getCustomer().getCustomerId());
                        order.setOrderDate(placeOrder.getOrderDate());
                        order.setPaymentID(placeOrder.getPaymentId());
                boolean addOrder = orderController.addOrder(order);
                if (addOrder) {
                    System.out.println("order added");
                    boolean orderDetails = false;
                    for (Item item : placeOrder.getItemList()) {
                        pstm.setObject(1, 0);
                        pstm.setObject(2, item.getItemId());
                        pstm.setObject(3, placeOrder.getOrderID());
                        pstm.setObject(4, item.getItemQty());
                        System.out.println("Item id : " + item.getItemId());
                        orderDetails = pstm.executeUpdate() > 0;
                    }
                    if (orderDetails) {
                        System.out.println("order added");
                        connection.commit();
                        return true;
                    }

                }

            }

            connection.rollback();
            return false;
        } finally {

            connection.setAutoCommit(true);
        }

    }
    
    public void updateItemQty(ArrayList<Item> itemArray) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        System.out.println("Update Item Qty");
        //Item item = new Item();
        System.out.println("Item Array ; "+itemArray);
        for (Item item : itemArray) {
            PreparedStatement pstm = connection.prepareStatement("SELECT quantity FROM item WHERE itemID=?");
            System.out.println("Item Id : "+item.getItemId());
            pstm.setObject(1, item.getItemId());
            ResultSet rst = pstm.executeQuery();
            System.out.println("Result set ; "+rst);
            int qty = 0;
            if (rst.next()) {
                qty=rst.getInt(1);
            }
            
            qty=qty-item.getItemQty();
            System.out.println("QTY : "+qty);
            pstm = connection.prepareStatement("UPDATE item set quantity=? WHERE itemID=?");
            pstm.setObject(1, qty);
            pstm.setObject(2, item.getItemId());      
            pstm.executeUpdate();
        }
       
        
    }
}
