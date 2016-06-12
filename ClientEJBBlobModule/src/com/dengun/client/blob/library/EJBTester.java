/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dengun.client.blob.library;

import com.ublibrary.blobEntity.Book;
import com.ublibrary.stateless.blob.LibraryPersistentBean;
import com.ublibrary.stateless.blob.LibraryPersistentBeanRemote;
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

    public void testEjbBlobClob() {
        try {
            int choice = 1;
            LibraryPersistentBeanRemote libraryBean = (LibraryPersistentBeanRemote) ctx.lookup(LibraryPersistentBeanRemote.class.getName());

            //java:global/StatefulEJbModule/LibraryStatefulSessionBean!com.ubLibrary.stateful.LibraryStatefulSessionBeanRemote
            while (choice != 2) {
                String bookName;
                String publisherName;
                String publisherAddress;
                showGUI();
                String strChoice = brConsoleReader.readLine();
                choice = Integer.parseInt(strChoice);
                if (choice == 1) {
                    System.out.print("Enter book name: ");

                    bookName = brConsoleReader.readLine();

                    //create a new book entity and persist to the database
                    Book newBook = new Book();
                    String xml = "<book><name>" + bookName + "</name></book>";
                    newBook.setName(bookName);
                    byte[] imageBytes = {0x32, 0x32, 0x32, 0x32, 0x32,
                        0x32, 0x32, 0x32,
                        0x32, 0x32, 0x32, 0x32, 0x32, 0x32, 0x32, 0x32,
                        0x32, 0x32, 0x32, 0x32, 0x32, 0x32, 0x32, 0x32
                    };
                    newBook.setImage(imageBytes);
                    newBook.setXml(xml);

                    libraryBean.addBook(newBook);
                } else if (choice == 2) {
                    break;
                }
            }
            List<Book> booksList = libraryBean.getBooks();
            System.out.println("Book(s) entered so far: " + booksList.size());

            int i = 0;
            for (Book book : booksList) {
                System.out.println((i + 1) + ". " + book.getName());

                byte[] imageByts = book.getImage();
                
                if (imageByts != null) {
                    System.out.print("image bytes: [");
                    for (int j = 0; j < imageByts.length; j++) {
                        System.out.print("0x"
                                + String.format("%x", imageByts[j]) + " ");
                    }
                    System.out.println("]");
                }
                System.out.println(book.getXml());
                i++;
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
