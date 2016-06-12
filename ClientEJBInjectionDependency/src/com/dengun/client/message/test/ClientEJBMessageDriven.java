/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dengun.client.message.test;

import com.dengun.client.message.bean.EJBMessageTester;

/**
 *
 * @author Anonymous-Dengun
 */
public class ClientEJBMessageDriven {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        EJBMessageTester messageTest= new EJBMessageTester();
        
        messageTest.testMesssageDrivenEjb();
    }
    
}
