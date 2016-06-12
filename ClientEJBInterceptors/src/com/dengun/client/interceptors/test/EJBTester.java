/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dengun.client.interceptors.test;

import com.dengun.libary.stateless.beans.LibrarySessionBeanRemote;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Anonymous-Dengun
 */
public class EJBTester {
    
    
    BufferedReader brConsoleReader = null;
    Properties props;
    InitialContext ctx;

    {
        props = new Properties();
        props.put("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");
        props.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");
        props.setProperty("java.naming.factory.state",
                "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        try {
            ctx = new InitialContext(props);
        } catch (NamingException ex) {
            ex.printStackTrace();
        }
        brConsoleReader
                = new BufferedReader(new InputStreamReader(System.in));
    }

    private void showGUI() {
        System.out.println("**********************");
        System.out.println("Welcome to Book Store");
        System.out.println("**********************");
        System.out.print("Options \n1. Add Book\n2. Exit \nEnter Choice: ");
    }

    public  void testStatelessEjbInterceptors() {
        try{
            int choice = 1;
            LibrarySessionBeanRemote
                  libraryBean   = (LibrarySessionBeanRemote) ctx.lookup(LibrarySessionBeanRemote.class.getName());
            
            //java:global/StatefulEJbModule/LibraryStatefulSessionBean!com.ubLibrary.stateful.LibraryStatefulSessionBeanRemote
            while (choice != 2) {
                String bookName;
                showGUI();
                String strChoice = brConsoleReader.readLine();
                choice = Integer.parseInt(strChoice);
                if (choice == 1) {
                    System.out.print("Enter book name: ");
                    bookName = brConsoleReader.readLine();
                    libraryBean.addBook(bookName);
                } else if (choice == 2) {
                    break;
                }
            }
            List<String> booksList = libraryBean.getBooks();
            System.out.println("Book(s) entered so far: " + booksList.size());
            for (int i = 0; i < booksList.size(); ++i) {
                System.out.println((i + 1) + ". " + booksList.get(i));
            }
        
    }
    catch(Exception e){
System.out.println(e.getMessage());
        e.printStackTrace();
    }

    
    
        finally {
try {
            if (brConsoleReader != null) {
                brConsoleReader.close();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    }
}
