/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dengun.client.stateful.test;

import com.dengun.client.stateful.library.EJBClientStatefulTester;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author Anonymous-Dengun
 */
public class ClientEJBStateful {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // In this class, we will run the client application 
        
        EJBClientStatefulTester testStateful=new EJBClientStatefulTester();
        
        try {
            //run its testStateful method to execute the whole programm
            testStateful.testStatefulEjb();
        } catch (NamingException ex) {
            
            System.out.println("There were some errors running the testStateful method becuase of " +ex);
            //Logger.getLogger(ClientEJBStateful.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
