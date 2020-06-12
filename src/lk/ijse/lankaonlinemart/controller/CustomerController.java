
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.lankaonlinemart.controller;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.lankaonlinemart.modal.Customer;
import lk.ijse.lanlaonlinemart.db.DBConnection;

/**
 *
 * @author kalana dapsara
 */
public class CustomerController {

    public boolean addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO customer VALUES(?,?,?,?)");
        pstm.setObject(1, customer.getCustomerId());
        pstm.setObject(2, customer.getCustomerName());
        pstm.setObject(3, customer.getCustomerAddress());
        pstm.setObject(4, customer.getCustomerContact());
        return pstm.executeUpdate() > 0;
    }
    
    public ArrayList<Customer> getAll() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("select * from customer");
        ResultSet rst = pstm.executeQuery();
        ArrayList<Customer> arrayList = new ArrayList<>();
        while(rst.next()){
            Customer customer = new Customer();
            customer.setCustomerId(rst.getInt(1));
            customer.setCustomerName(rst.getString(2));
            customer.setCustomerAddress(rst.getString(3));
            customer.setCustomerContact(rst.getString(4));
            
            arrayList.add(customer);
            
        }
        return arrayList;
       
        
    }
    
    public boolean deleteCustomer(int customerId) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM customer WHERE customerID=?");
        pstm.setObject(1,customerId);
        return pstm.executeUpdate()>0;
        
    }
    
    public boolean updateCustomer(Customer customer) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE customer set name=?,address=?,contact=? where customerId=?");
        pstm.setObject(1,customer.getCustomerName() );
        pstm.setObject(2, customer.getCustomerAddress());
        pstm.setObject(3, customer.getCustomerContact());
        pstm.setObject(4, customer.getCustomerId());
        
       return pstm.executeUpdate()>0;
        
    }
    
    public Customer searchCustomer(int customerId) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM customer WHERE customerId=?");
        pstm.setObject(1,customerId);
        
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
           return new Customer(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getString(4));
            
        }
        return null;
    }
    
    public int getNextCustomerId() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT customerID FROM customer ORDER BY customerID DESC LIMIT 1");
        ResultSet rst = pstm.executeQuery();
        
        if (rst.next()) {
            return rst.getInt(1)+1;
        }
        return 000;
    }public boolean isAddedCustomer(int id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT customerId FROM customer WHERE customerID =?");
        pstm.setObject(1, id);
        ResultSet rst = pstm.executeQuery();
        
            if (rst.next()) {
               return true;
                
            }else{
               return false;
            }
    }
    
    
    
}
