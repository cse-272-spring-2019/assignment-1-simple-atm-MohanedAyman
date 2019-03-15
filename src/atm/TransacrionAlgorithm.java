/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * @author Mohannad
 */

import java.awt.Component;
import java.sql.Struct;
import java.util.Scanner;
public class TransacrionAlgorithm {
  
    String storedCardNum ="3";
    String storedpassword ="9";
   private double Balance =0;
    
    
     void deposit (long depositedAmount){
        this.Balance=this.Balance+depositedAmount;
    }
    
     void withdraw(long withdrawnAmount){
         this.Balance=this.Balance-withdrawnAmount; 
    }

    public double getBalance() {
        return Balance;
    }
    
    
    
    
    
    
};
