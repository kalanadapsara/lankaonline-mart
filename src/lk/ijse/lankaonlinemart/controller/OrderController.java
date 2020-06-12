/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.lankaonlinemart.controller;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.lankaonlinemart.modal.Order;
import lk.ijse.lanlaonlinemart.db.DBConnection;

/**
 *
 * @author kalana dapsara
 */
public class OrderController {
    public boolean addOrder(Order order) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO orders VALUES(?,?,?,?)");
        pstm.setObject(1,0);
        pstm.setObject(2, order.getCustomerId());
        pstm.setObject(3,order.getOrderDate());
        pstm.setObject(4, order.getPaymentID());
        return pstm.executeLargeUpdate()>0;
    }
    public ArrayList<Order> loadTable1() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT orderID,customer.name,payment.totalPrice,order_date\n" +
        "FROM ((orders\n" +
        "INNER JOIN customer ON orders.customerID=customer.customerID)\n" +
        "INNER JOIN payment ON orders.paymentID=payment.paymentID);");
        
        ResultSet rst = pstm.executeQuery();
        ArrayList<Order> arrayList = new ArrayList<Order>();
        while (rst.next()) {            
            Order order = new Order();
            
        }
        return arrayList;
    
    }
    
}
