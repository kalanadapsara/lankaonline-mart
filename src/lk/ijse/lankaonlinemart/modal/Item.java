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
public class Item {

    private int itemId;
    private String itemName;
    private int itemUnitPrice;
    private int itemQty;

    public Item() {
    }

    public Item(int itemId, String itemName, int itemUnitPrice, int itemQty) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.itemUnitPrice = itemUnitPrice;
        this.itemQty = itemQty;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemUnitPrice() {
        return itemUnitPrice;
    }

    public void setItemUnitPrice(int itemUnitPrice) {
        this.itemUnitPrice = itemUnitPrice;
    }

    public int getItemQty() {
        return itemQty;
    }

    public void setItemQty(int itemQty) {
        this.itemQty = itemQty;
    }

    @Override
    public String toString() {
        return "Item{" + "itemId=" + itemId + ", itemName=" + itemName + ", itemUnitPrice=" + itemUnitPrice + ", itemQty=" + itemQty + '}';
    }



}

