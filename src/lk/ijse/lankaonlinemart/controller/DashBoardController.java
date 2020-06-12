/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.lankaonlinemart.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lk.ijse.lanlaonlinemart.db.DBConnection;

/**
 *
 * @author kalana dapsara
 */
public class DashBoardController {
    public int getTotalCustomers() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT COUNT(customerID) FROM customer");
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return rst.getInt(1);
        }
        return 0;
    }
    public  int getTotalItems() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT COUNT(itemID) FROM item");
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return rst.getInt(1);
        }
        return 0;        
    }
    
        public  int getTotalOrders() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT COUNT(orderID) FROM orders");
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return rst.getInt(1);
        }
        return 0;        
    }
    public  String getBestCustomr() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT customerID, COUNT(customerID) AS popularity\n" +
        "     FROM orders\n" +
        "     GROUP BY customerID\n" +
        "     ORDER BY popularity DESC limit 1");
        ResultSet rst = pstm.executeQuery();
        int id=0;
        if (rst.next()) {
            id=rst.getInt(1);
        }
        pstm = connection.prepareStatement("SELECT name FROM customer WHERE customerID=? ");
        pstm.setObject(1,id);
        rst = pstm.executeQuery();
        if (rst.next()) {
            return rst.getString(1);
        }
        return "";    
    }  

    public String mostSellingItem() throws SQLException, ClassNotFoundException{
         
        
        
        
        
        
        /*
        
        
        
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT ");
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return rst.getString(1);
        }else{
            return "";
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        */
        
        
        
        
    }
    
    public Double totalIncome() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT SUM(totalPrice) FROM payment");
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return rst.getDouble(1);
        }
        return 0.0;
    }
}
