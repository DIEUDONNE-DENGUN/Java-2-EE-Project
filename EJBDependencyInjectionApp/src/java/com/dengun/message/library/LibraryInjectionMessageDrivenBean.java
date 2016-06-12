/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dengun.message.library;

import com.dengun.message.entity.Books;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.ejb.MessageDrivenContext;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

/**
 *
 * @author Anonymous-Dengun
 */
@JMSDestinationDefinition(name = "jms/BooksQueue2", interfaceName = "javax.jms.Queue", resourceAdapter = "jmsra", destinationName = "BooksQueue2")
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/BooksQueue2"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class LibraryInjectionMessageDrivenBean implements MessageListener {
      @Resource
    private MessageDrivenContext mdctx;
    
    @EJB
    LibraryPersistenceInjectionBeanRemote libraryBean;
    
    public LibraryInjectionMessageDrivenBean() {
        
    }
    
    @Override
    public void onMessage(Message message) {
        
        ObjectMessage objectMessage= null;
        
        try {
            objectMessage=(ObjectMessage)message;
            Books book=(Books)objectMessage.getObject();
            
            libraryBean.addBook(book);
            
        } catch (JMSException e) {
            
            mdctx.setRollbackOnly();
        }
        
    }
    
}
