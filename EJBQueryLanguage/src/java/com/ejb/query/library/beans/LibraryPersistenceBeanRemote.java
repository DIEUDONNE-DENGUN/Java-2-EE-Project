/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.query.library.beans;

//import javax.ejb.Local;

import com.ejb.query.library.entity.Books;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Anonymous-Dengun
 */
@Remote
public interface LibraryPersistenceBeanRemote {
    void addBook(Books bookName);
    
    List<Books> getBooks();
}
