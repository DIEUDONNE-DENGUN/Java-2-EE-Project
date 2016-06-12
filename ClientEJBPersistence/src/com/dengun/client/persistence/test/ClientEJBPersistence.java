/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dengun.client.persistence.test;

import com.dengun.client.persistence.library.EJBPersistenceTester;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;

/**
 *
 * @author Anonymous-Dengun
 */
public class ClientEJBPersistence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //this class will run the application client for the EJB persistence stateless bean
        
        EJBPersistenceTester testEJBPersistence= new EJBPersistenceTester();
        
        testEJBPersistence.testEjbPersistence();
    }
    
}
