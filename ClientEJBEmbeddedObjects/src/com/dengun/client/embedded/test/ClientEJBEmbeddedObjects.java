/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dengun.client.embedded.test;

import com.dengun.client.embedded.library.EJBEmbeddedTester;

/**
 *
 * @author Anonymous-Dengun
 */
public class ClientEJBEmbeddedObjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         EJBEmbeddedTester testEmbeddedObject = new EJBEmbeddedTester();
         
             testEmbeddedObject.testEjbEmbeddedObject();
    }
    
}
