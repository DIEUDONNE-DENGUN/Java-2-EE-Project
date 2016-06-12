/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.test;

import javax.naming.NamingException;

/**
 *
 * @author Anonymous-Dengun
 */
public class EJBClientMain {
    
    
     public static void main(String[] args) throws NamingException {
        // TODO code application logic here
        
         EJBClientApp testEJBClient= new EJBClientApp();
         
            testEJBClient.testStatelessEjb();
    }
}
