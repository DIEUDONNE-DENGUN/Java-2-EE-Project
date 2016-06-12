/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dengun.timer.beans;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;

/**
 *
 * @author Anonymous-Dengun
 */
@Stateless
public class TimerSessionBean implements TimerSessionBeanRemote {

    @Resource
    private SessionContext context;

    public void createTimer(long duration) {
        context.getTimerService().createTimer(duration, "Hello World!");
    }

    @Timeout
    public void timeOutHandler(Timer timer) {
        System.out.println("timeoutHandler : " + timer.getInfo());
        timer.cancel();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
