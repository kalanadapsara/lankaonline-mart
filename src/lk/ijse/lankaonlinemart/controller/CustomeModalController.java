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
import java.util.ArrayList;
import lk.ijse.lankaonlinemart.modal.CustomeModal;
import lk.ijse.lanlaonlinemart.db.DBConnection;

/**
 *
 * @author kalana dapsara
 */
public class CustomeModalController {
    public ArrayList<CustomeModal> loadTable1() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT orderID,customer.name,payment.totalPrice,order_date\n" +
        "FROM ((orders\n" +
        "INNER JOIN customer ON orders.customerID=customer.customerID)\n" +
        "INNER JOIN payment ON orders.paymentID=payment.paymentID);");
        ResultSet rst = pstm.executeQuery();
        
        ArrayList<CustomeModal> arrayList = new ArrayList<CustomeModal>();
        while (rst.next()) {            
            CustomeModal customeModal = new CustomeModal();
            customeModal.setOrderId(rst.getInt(1));
            customeModal.setCustomerName(rst.getString(2));
            customeModal.setTotalPrice(rst.getDouble(3));
            customeModal.setDate(rst.getString(4));
            arrayList.add(customeModal);
        }
        return arrayList;
    }
    public ArrayList<CustomeModal> loadTable2(int orderID) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT item.name,qty,(item.unitPrice*qty) as price\n" +
        "FROM order_detail\n" +
        "INNER JOIN item ON order_detail.itemID=item.itemID\n" +
        "WHERE orderID=?");
        pstm.setObject(1,orderID);
        ResultSet rst = pstm.executeQuery();
        ArrayList<CustomeModal> arrayList = new ArrayList<CustomeModal>();
        while (rst.next()) {            
            CustomeModal customeModal = new CustomeModal();
            customeModal.setItemName(rst.getString(1));
            customeModal.setQty(rst.getInt(2));
            customeModal.setPrice(rst.getDouble(3));
            arrayList.add(customeModal);
        }
        return arrayList;
    }
}
