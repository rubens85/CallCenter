/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.controller;

import com.almundo.callcenter.CallCenter;
import com.almundo.callcenter.model.Employee;
import com.almundo.callcenter.model.Person;
import com.almundo.callcenter.model.TypeEmployee;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Ruben Ramirez
 */
public class EmployeeControllerTest {
    private int numOper;
    private int numSuper;
    private int numDirec;
    
    private EmployeeController employeeController;
    
    public EmployeeControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        numOper = 5;
        numSuper = 5;
        numDirec = 5;
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAvailableEmpl method, of class EmployeeController.
     */
    @Test
    public void testGetAvailableEmpl() {
        employeeController = new EmployeeController(CallCenter.getEmployees(numOper, numSuper, numDirec));
        
        assertEquals(numOper, employeeController.getAvailableEmpl().get(TypeEmployee.OPERADOR).size());
        assertEquals(numSuper, employeeController.getAvailableEmpl().get(TypeEmployee.SUPERVISOR).size());
        assertEquals(numDirec, employeeController.getAvailableEmpl().get(TypeEmployee.DIRECTOR).size());
    }

    /**
     * Test of manageEmploy method, of class EmployeeController.
     */
    @Test
    public void testManageEmployAdd() {
        employeeController = new EmployeeController(CallCenter.getEmployees(numOper, numSuper, numDirec));
        
        assertTrue(employeeController.manageEmploy(new Employee(500, new Person(), TypeEmployee.OPERADOR), EmployeeController.Operation.ADD));
        
        assertEquals(numOper+1, employeeController.getAvailableEmpl().get(TypeEmployee.OPERADOR).size());
        
    }
    
    /**
     * Test of manageEmploy method, of class EmployeeController.
     */
    @Test
    public void testManageEmployRemove() {
        employeeController = new EmployeeController(CallCenter.getEmployees(numOper, numSuper, numDirec));
        
        Set<Map.Entry<TypeEmployee, List<Employee>>> entrySetEmpl = employeeController.getAvailableEmpl().entrySet();
        
        for (Map.Entry<TypeEmployee, List<Employee>> entrySetEmpl1 : entrySetEmpl) {
            
            if(entrySetEmpl1.getKey().equals(TypeEmployee.OPERADOR)){
                for(int x = 0; x < numOper; x++)
                    
                    assertTrue(employeeController.manageEmploy(entrySetEmpl1.getValue().get(0), EmployeeController.Operation.REMOVE));
                

            }
            
        }
        
        assertEquals(0, employeeController.getAvailableEmpl().get(TypeEmployee.OPERADOR).size());
        
    }
    
}
