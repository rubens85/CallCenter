package com.almundo.callcenter.controller;

import com.almundo.callcenter.model.Employee;
import com.almundo.callcenter.model.TypeEmployee;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Clase controladora para la gestion de empleados. Esta clase
 * inicializa los empleados de acuerdo al tipo que pertenezcan, tambien permite
 * tener un empleado disponible o no para atender una llamada.
 * 
 * @author Ruben Ramirez
 */
public class EmployeeController {
    private final LinkedHashMap<TypeEmployee, List<Employee>> availableEmpl;
    
    /**
     * Constructor de la clase donde se inicializa un Map de empleados
     * distribuidos de acuerdo a su tipo.
     * 
     * @param listEmpl listado de empleados a clasificar.
     */
    public EmployeeController(List<Employee> listEmpl) {
        availableEmpl = new LinkedHashMap<>();
        this.loadEmployees(listEmpl);
    }
    
    /**
     * Metodo para agregar o quitar un empleado del Map de empleados. Estas
     * operaciones se realizan con el fin de validar si un empleado está o no 
     * está disponible para atender una llamada.
     * 
     * @param empl Empleado
     * @param operation ADD - Operación para establecer un empleado disponible para una llamada.
     * REMOVE - Operación para establcer un empleado no disponible para una llamada.
     * @return true si la operación fue exitosa.
     */
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
    
    /**
     * Enum de operacion a realizar con el empleado.
     */
    public enum Operation {
        ADD, REMOVE
    }

    /**
     * Retorna el Map de empleados clasificados segun el tipo.
     * @return Map de empleados disponibles. 
     */
    public LinkedHashMap<TypeEmployee, List<Employee>> getAvailableEmpl() {
        return availableEmpl;
    }
}
