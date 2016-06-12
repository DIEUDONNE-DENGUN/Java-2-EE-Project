/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dengun.client.message.bean;

import com.dengun.message.entity.Books;
import com.dengun.message.library.LibraryPersistenceInjectionBeanRemote;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import javax.jms.ObjectMessage;
import javax.jms.QueueConnectionFactory;

import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Anonymous-Dengun
 */
public class EJBMessageTester {

    // This class will contains the client implementation for the Message Driven Bean Example
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

    public void testMesssageDrivenEjb() {
        try {
            int choice = 1;
            Queue queue = (Queue) ctx.lookup("jms/BooksQueue2");

            //Create a new connection factory to acceess and communicate with the queue
            QueueConnectionFactory factory = (QueueConnectionFactory) ctx.lookup("BooksFactory");

            QueueConnection connection = factory.createQueueConnection();
            QueueSession session
                    = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
            QueueSender sender = session.createSender(queue);

            //java:global/StatefulEJbModule/LibraryStatefulSessionBean!com.ubLibrary.stateful.LibraryStatefulSessionBeanRemote
            while (choice != 2) {
                String bookName;
                showGUI();
                String strChoice = brConsoleReader.readLine();
                choice = Integer.parseInt(strChoice);
                if (choice == 1) {
                    System.out.print("Enter book name: ");
                    bookName = brConsoleReader.readLine();

                    Books book = new Books();

                    book.setName(bookName);

                    ObjectMessage objectMessage
                            = session.createObjectMessage(book);
                    sender.send(objectMessage);
                } else if (choice == 2) {
                    break;
                }
            }
          
            LibraryPersistenceInjectionBeanRemote libraryBean1 = (LibraryPersistenceInjectionBeanRemote) ctx.lookup(LibraryPersistenceInjectionBeanRemote.class.getName());

            List<Books> booksList1 = libraryBean1.getBooks();
            
            System.out.println(
                    "***Using second lookup to get library stateless object***");
            System.out.println(
                    "Book(s) entered so far: " + booksList1.size()
            );
             int i = 0;
             
            for ( Books book:booksList1) {
                System.out.println((i + 1) + ". " + book.getName());
                
                 i ++;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
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
