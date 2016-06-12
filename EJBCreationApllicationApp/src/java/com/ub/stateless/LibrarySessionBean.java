/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ub.stateless;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author nas
 */
@Stateless
public class LibrarySessionBean implements LibrarySessionBeanRemote {
    
    public List<String> bookShelf;
          
    
    public LibrarySessionBean(){
    
           bookShelf= new ArrayList<String>();
    }

    @Override
    public void addBook(String nameBook) {
        
         bookShelf.add(nameBook);
    }

    @Override
    public List getBooks() {
        
        return  bookShelf;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
