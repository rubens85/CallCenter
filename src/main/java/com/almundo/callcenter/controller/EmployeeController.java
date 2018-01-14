/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.controller;

import com.almundo.callcenter.model.Employee;
import com.almundo.callcenter.model.TypeEmployee;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Ruben Ramirez
 */
public class EmployeeController {
    private final LinkedHashMap<TypeEmployee, List<Employee>> availableEmpl;
    

    public EmployeeController(List<Employee> listEmpl) {
        availableEmpl = new LinkedHashMap<>();
        this.loadEmployees(listEmpl);
    }
    
    public boolean manageEmploy(Employee empl, Operation operation) {
        
        switch (operation) {
            case ADD:
                return this.availableEmpl.get(empl.getType()).add(empl);
            case REMOVE:
                return this.availableEmpl.get(empl.getType()).remove(empl);
            
            default:
                return false;
        }
    }
    
    /**
     * Metodo que carga los empleados en un Hash, clasificandolos por el tipo de
     * empleados que sean
     *
     * @param listEmpl
     */
    private void loadEmployees(List<Employee> listEmpl) {
        availableEmpl.put(TypeEmployee.OPERADOR, new ArrayList<>());
        availableEmpl.put(TypeEmployee.SUPERVISOR, new ArrayList<>());
        availableEmpl.put(TypeEmployee.DIRECTOR, new ArrayList<>());

        for (Employee empleado : listEmpl) {
            availableEmpl.get(empleado.getType()).add(empleado);
        }
    }
    
    public enum Operation {
        ADD, REMOVE
    }

    public LinkedHashMap<TypeEmployee, List<Employee>> getAvailableEmpl() {
        return availableEmpl;
    }
}
