package com.almundo.callcenter.model;

/**
 *
 * @author Ruben Ramirez
 */
public class Employee extends Person {
    
    private Integer id;
    private Person person;
    private TypeEmployee type;

    public Employee() {
    }
    
    public Employee(Integer id, Person person, TypeEmployee type) {
        this.id = id;
        this.person = person;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return person.getFirstName()+ " " + person.getLastName();
    }

    public TypeEmployee getType() {
        return type;
    }

    public void setType(TypeEmployee type) {
        this.type = type;
    }

    
    
    
}
