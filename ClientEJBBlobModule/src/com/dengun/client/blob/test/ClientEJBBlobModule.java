/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dengun.client.blob.test;

import com.dengun.client.blob.library.EJBTester;

/**
 *
 * @author Anonymous-Dengun
 */
public class ClientEJBBlobModule {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         EJBTester testEJBBlob= new EJBTester();
         
              testEJBBlob.testEjbBlobClob();
    }
    
}
