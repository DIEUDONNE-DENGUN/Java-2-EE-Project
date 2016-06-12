/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dengun.message.library;


import com.dengun.message.entity.Books;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.persistence.Query;

/**
 *
 * @author Anonymous-Dengun
 */
@Stateless
public class LibraryPersistenceBean implements LibraryPersistenceBeanRemote {

    public LibraryPersistenceBean(){
    
    
    }
    
    @PersistenceContext(unitName = "EJBMessageDrivenBeanAppPU")
    private EntityManager entityManager;
    
    @Override
    public void addBook(Books bookName) {
        
        entityManager.persist(bookName);
    }

    @Override
    public List<Books> getBooks() {
        
        entityManager.flush();
       return  entityManager.createQuery("SELECT name FROM Books name order by name.id").getResultList();
        
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
