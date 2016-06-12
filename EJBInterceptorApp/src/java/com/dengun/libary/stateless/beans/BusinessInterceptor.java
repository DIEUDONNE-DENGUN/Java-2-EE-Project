/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dengun.libary.stateless.beans;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import javax.persistence.criteria.CriteriaBuilder.In;

/**
 *
 * @author Anonymous-Dengun
 */
public class BusinessInterceptor {

    @AroundInvoke
    public Object methodInterceptor(InvocationContext ctx) throws Exception {
        System.out.println("*** Intercepting calls to  the LibraryBean method  " + ctx.getMethod().getName());

        return ctx.proceed();
    }

}
