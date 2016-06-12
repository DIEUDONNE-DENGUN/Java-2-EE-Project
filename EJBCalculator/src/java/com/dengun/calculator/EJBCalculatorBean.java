/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dengun.calculator;

import javax.ejb.Stateless;

/**
 *
 * @author Anonymous-Dengun
 * This class implements all abstract methods of the EJBCalculator Interface class
 */
@Stateless
public class EJBCalculatorBean implements EJBCalculatorBeanLocal {
    
    

    @Override
    public float addition(float a, float b) {
       
        return a + b;
    }

    @Override
    public float substraction(float a, float b) {
        
        return a - b;
    }

    @Override
    public float division(float a, float b) {
        
        try{
            
         return a / b;
        }catch(Exception e){
        
             System.out.println("Whoosp, division by 0 is not allowed.");
             
             return 0;
        }
      
    }

    @Override
    public float multiplication(float a, float b) {
        
         return a * b;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
