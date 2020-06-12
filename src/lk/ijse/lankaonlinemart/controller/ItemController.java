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
import lk.ijse.lankaonlinemart.modal.Item;
import lk.ijse.lanlaonlinemart.db.DBConnection;

/**
 *
 * @author kalana dapsara
 */
public class ItemController {
    public boolean addItem(Item item) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("INSERT INTO item VALUES(?,?,?,?)");
        pstm.setObject(1,item.getItemId());
        pstm.setObject(2, item.getItemName());
        pstm.setObject(3,item.getItemUnitPrice());
        pstm.setObject(4,item.getItemQty());
        return pstm.executeLargeUpdate()>0;
        
    }
    
    public ArrayList<Item> getAll() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM item");
        ResultSet rst = pstm.executeQuery();
        ArrayList<Item> arrayList = new ArrayList<>();
        
        while (rst.next()) {
            Item item = new Item();
            item.setItemId(rst.getInt(1));
            item.setItemName(rst.getString(2));
            item.setItemUnitPrice(rst.getInt(3));
            item.setItemQty(rst.getInt(4));
            arrayList.add(item);
        }
        
        return arrayList;
        
        
    }
    public boolean deleteItem(Item item) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM item WHERE itemID=?");
        pstm.setObject(1, item.getItemId());
        return pstm.executeLargeUpdate()>0;
    
    }
    
    public boolean updateItem(Item item) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE item SET name=?,unitPrice=?,quantity=? WHERE itemId=?");
        pstm.setObject(1, item.getItemName());
        pstm.setObject(2, item.getItemUnitPrice());
        pstm.setObject(3, item.getItemQty());
        pstm.setObject(4, item.getItemId());
        
        return pstm.executeUpdate()>0;
        
    }
    
    public Item  searchItem(int id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM item WHERE itemId=?");
        pstm.setObject(1,id);
        ResultSet rst = pstm.executeQuery();
        
        if (rst.next()) {
            Item item = new Item(rst.getInt(1),rst.getString(2),rst.getInt(3),rst.getInt(4));
            return item; 
        }
        return null;
    }
    
    public int getNextItemId() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT itemId FROM item ORDER BY itemId DESC LIMIT 1");
        
        ResultSet rst = pstm.executeQuery();
        
        if (rst.next()) {
            return rst.getInt(1)+1;
        }
        return 0000;
        
        
        
    }
    
    public double getItemPrice(int id) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstence().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT unitPrice FROM item WHERE itemId=?");
        pstm.setObject(1, id);
        ResultSet rst = pstm.executeQuery();
        if (rst.next()) {
            return rst.getDouble(1);
        }
        return 0;
    }

}
