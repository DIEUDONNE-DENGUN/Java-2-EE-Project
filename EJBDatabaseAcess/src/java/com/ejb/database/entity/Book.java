/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejb.database.entity;

import java.io.Serializable;


/**
 *
 * @author Anonymous-Dengun
 */

public class Book implements Serializable {

     private int id;
     private String name;

     public Book(){
     
     }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
