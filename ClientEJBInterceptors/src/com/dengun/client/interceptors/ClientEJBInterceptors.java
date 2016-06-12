/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dengun.client.interceptors;

import com.dengun.client.interceptors.test.EJBTester;

/**
 *
 * @author Anonymous-Dengun
 */
public class ClientEJBInterceptors {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        EJBTester interceptorTest= new EJBTester();
        
            //run the application
        interceptorTest.testStatelessEjbInterceptors();
    }
    
}
