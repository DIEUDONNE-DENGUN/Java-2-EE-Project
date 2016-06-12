/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.database.library.beans;

import com.ejb.database.entity.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

//import javax.persistence.Query;
/**
 *
 * @author Anonymous-Dengun
 */
@Stateless
public class LibraryPersistenceBean implements LibraryPersistenceBeanRemote {

    public LibraryPersistenceBean() {

    }

    @Override
    public void addBook(Book bookName) {

        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/books";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
        List<Book> books = new ArrayList<Book>();
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, userName, password);
            PreparedStatement st
                    = con.prepareStatement("insert into books(name) values(?)");
            st.setString(1, bookName.getName());
            int result = st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Book> getBooks() {

        Connection con = null;
        String url = "jdbc:mysql://localhost:3306/books";
        String driver = "com.mysql.jdbc.Driver";

        String userName = "root";
        String password = "root";
        List<Book> books = new ArrayList<Book>();
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, userName, password);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from books");
            Book book;
            while (rs.next()) {
                book = new Book();
                book.setId(rs.getInt(1));
                book.setName(rs.getString(2));
                books.add(book);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return books;
    }
}

    // Add business logic below. (Right-click in editor and choose
// "Insert Code > Add Business Method")

