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
import lk.ijse.lankaonlinemart.modal.Payment;
import lk.ijse.lanlaonlinemart.db.DBConnection;

/**
 *
 * @author kalana dapsara
 */
public class PaymentController {
    public int getNextPaymentID() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT paymentID FROM payment ORDER BY paymentID DESC LIMIT 1");
        ResultSet rst = pstm.executeQuery();
        int nextPaymentID;
        if (rst.next()) {
            nextPaymentID=rst.getInt(1);
            nextPaymentID++;
            return nextPaymentID;
        }
        return 1;
    }
    
    public boolean addPayment(Payment payment) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO payment VALUES(?,?)");
        pstm.setObject(1,payment.getPaymentID());
        
        pstm.setObject(2,payment.getTotalPrie());
        
        return pstm.executeLargeUpdate()>0;
        
    }
}
