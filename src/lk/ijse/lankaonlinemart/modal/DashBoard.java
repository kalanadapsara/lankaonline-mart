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
public class DashBoard {
    private int totalCustomers;
    private int totalItem;
    private int totalOrders;
    private int bestSeller;
    private int mostSellingItem;
    private int lastMonthSales;

    public DashBoard() {
    }

    public DashBoard(int totalCustomers, int totalItem, int totalOrders, int bestSeller, int mostSellingItem, int lastMonthSales) {
        this.totalCustomers = totalCustomers;
        this.totalItem = totalItem;
        this.totalOrders = totalOrders;
        this.bestSeller = bestSeller;
        this.mostSellingItem = mostSellingItem;
        this.lastMonthSales = lastMonthSales;
    }

    public int getTotalCustomers() {
        return totalCustomers;
    }

    public void setTotalCustomers(int totalCustomers) {
        this.totalCustomers = totalCustomers;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    public int getBestSeller() {
        return bestSeller;
    }

    public void setBestSeller(int bestSeller) {
        this.bestSeller = bestSeller;
    }

    public int getMostSellingItem() {
        return mostSellingItem;
    }

    public void setMostSellingItem(int mostSellingItem) {
        this.mostSellingItem = mostSellingItem;
    }

    public int getLastMonthSales() {
        return lastMonthSales;
    }

    public void setLastMonthSales(int lastMonthSales) {
        this.lastMonthSales = lastMonthSales;
    }

    @Override
    public String toString() {
        return "DashBoard{" + "totalCustomers=" + totalCustomers + ", totalItem=" + totalItem + ", totalOrders=" + totalOrders + ", bestSeller=" + bestSeller + ", mostSellingItem=" + mostSellingItem + ", lastMonthSales=" + lastMonthSales + '}';
    }
    
    
}
