/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dengun.persistence.library.embedded.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Anonymous-Dengun
 */
@Embeddable
public class Publisher implements Serializable {
    
    private String name;
    private String address;
    
    public Publisher() {}
        
    public Publisher(String name, String address){
     
        this.name=name;
        this.address=address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "The publisher name is :" + name + " and \n publisher address is : " + address
                ;
    }
    
}
