/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.stateless;

import java.util.List;

import javax.ejb.Remote;

/**
 *
 * @author nas
 */
@Remote
public interface LibrarySessionBeanRemote {
    
    void addBook(String nameBook);
    List getBooks();
    
}
