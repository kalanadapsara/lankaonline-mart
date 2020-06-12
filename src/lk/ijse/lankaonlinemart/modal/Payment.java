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
public class Payment {
    private int paymentID;
    
    private Double totalPrie;

    public Payment() {
    }

    public Payment(int paymentID, Double totalPrie) {
        this.paymentID = paymentID;
        this.totalPrie = totalPrie;
    }

    

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

   

  

    public Double getTotalPrie() {
        return totalPrie;
    }

    public void setTotalPrie(Double totalPrie) {
        this.totalPrie = totalPrie;
    }

    @Override
    public String toString() {
        return "Payment{" + "paymentID=" + paymentID + ", totalPrie=" + totalPrie + '}';
    }

   
    
}
