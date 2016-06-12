/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.client.timer.test;

import com.client.timer.library.EJBTimerTester;

/**
 * * @author Anonymous-Dengun

 */
public class ClientEJBTimer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         EJBTimerTester timer= new EJBTimerTester();
         
          timer.testEjbTimerService();
        // TODO code application logic here
    }
    
}
