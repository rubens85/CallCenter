/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.model;

/**
 *
 * @author rubens
 */
public class Person {
    private Integer ident;
    private String firstName;
    private String lastName;

    public Person() {
    }

    
    public Person(Integer ident, String firstName, String lastName) {
        this.ident = ident;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getIdent() {
        return ident;
    }

    public void setIdent(Integer ident) {
        this.ident = ident;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    
}
