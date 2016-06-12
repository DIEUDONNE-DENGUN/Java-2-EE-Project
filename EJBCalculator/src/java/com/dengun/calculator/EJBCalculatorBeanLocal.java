/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dengun.calculator;


import javax.ejb.Remote;

/**
 *
 * @author Anonymous-Dengun
 */
@Remote
public interface EJBCalculatorBeanLocal {
    
    public float addition(float a,float b);
    public float substraction(float a,float b);
    public float division(float a,float b);
    public float multiplication(float a,float b);
   // public int IndexPower(a)
}
