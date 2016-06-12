/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ublibrary.relation.beans;

import com.ulibrary.relationships.entity.Book;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Diuedonne dengun
 */
@Stateless
public class LibraryPersistentBean implements LibraryPersistentBeanRemote {

    @PersistenceContext(unitName="EntityRelationShipModulePU")
    private EntityManager entityManager ; 
    @Override
    public void addBook(Book bookName) {
               entityManager.persist(bookName);

    }

    @Override
    public List<Book> getBooks() {
        TypedQuery<Book> book = entityManager.createQuery("SELECT b FROM Book b", Book.class);
        return book.getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
