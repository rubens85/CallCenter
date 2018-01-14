package com.almundo.callcenter.model;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author Ruben Ramirez
 */
public class Call implements Callable<Call>{
    private Integer id;
    private String client;
    private Long time;
    private Employee employee;

    public Call() {
    }

    
    public Call(Integer id, String client) {
        this.id = id;
        this.client = client;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getTime() {
        return time;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    
    

    @Override
    public Call call() throws Exception {
        this.time = this.getTimeRandom();
        Thread.sleep(this.getTime()*1000);
        return this;
    }
    
    private long getTimeRandom() {
        return ThreadLocalRandom.current().nextLong(5, 10 + 1);
    }
    
}
