package com.almundo.callcenter.model;

/**
 *
 * Clase Person, la cual tiene los datos basicos de una persona.
 * 
 * @author Ruben Ramirez
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
