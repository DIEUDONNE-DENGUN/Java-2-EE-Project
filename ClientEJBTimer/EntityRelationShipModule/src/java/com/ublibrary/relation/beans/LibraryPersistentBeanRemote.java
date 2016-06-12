/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ublibrary.relation.beans;

import com.ulibrary.relationships.entity.Book;
import java.util.List;

import javax.ejb.Remote;

/**
 *
 * @author Dieuddonne Dengun
 */
@Remote
public interface LibraryPersistentBeanRemote {
             void addBook(Book bookName);
   
        List<Book> getBooks();
}
