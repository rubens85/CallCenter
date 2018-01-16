/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.controller;

import com.almundo.callcenter.CallCenter;
import javax.swing.JTextArea;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author Ruben Ramirez
 */
public class DispatcherTest {

    private int numOper;
    private int numSuper;
    private int numDirec;
    private int numCalls;

    private Dispatcher dispatcher;

    public DispatcherTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        CallCenter.txtAreaResult = new JTextArea();
    }

    @After
    public void tearDown() {
    }
    
    /**
     * Test dispatchCall: Se realizan 10 llamadas al tiempo y se encuentran 10 empleados creados.
     * Todas las llamadas deberan ser atentidas sin colocar ninguna en espera.
     * 
     * @throws InterruptedException
     */
    @Test
    public void testDispatchCall10() throws InterruptedException {
        numOper = 5;
        numSuper = 3;
        numDirec = 2;
        numCalls = 10;

        dispatcher = new Dispatcher(new EmployeeController(CallCenter.getEmployees(numOper, numSuper, numDirec)));
        dispatcher.dispatchCall(CallCenter.prepareCall(numCalls));
        
        //Evaluando que las llamadas realizadas sea igual al numero de llamadas atendidas.
        assertEquals(numCalls, dispatcher.getCallsMap().get(Dispatcher.CALLS.INIT).intValue());
        //Evaluando que el numero de llamadas realizadas se hayan finalizado correctamente.
        assertEquals(numCalls, dispatcher.getCallsMap().get(Dispatcher.CALLS.ENDED).intValue());
        //Evaluando que el numero de llamadas puestas en espera sea cero, ya que hay empleados disponibles para atender.
        assertEquals(0, dispatcher.getCallsMap().get(Dispatcher.CALLS.AWAIT).intValue());
    }

    /**
     * Test dispatchCall: Se realizan 10 llamadas al tiempo y se encuentran 5 empleados creados, 
     * En el proceso se deben colocar 5 llamadas en espera y luego ser atendidas
     * cuando se desocupen los empleados.
     * 
     * @throws InterruptedException
     */
    @Test
    public void testDispatchCall10_2() throws InterruptedException {
        numOper = 4;
        numSuper = 1;
        numDirec = 0;
        numCalls = 10;

        dispatcher = new Dispatcher(new EmployeeController(CallCenter.getEmployees(numOper, numSuper, numDirec)));
        dispatcher.dispatchCall(CallCenter.prepareCall(numCalls));
        
        
        //Se espera que en total se atiendan 10 llamadas.
        assertEquals(10, dispatcher.getCallsMap().get(Dispatcher.CALLS.INIT).intValue());
        //Se espera que se coloquen 5 llamadas en espera.
        assertEquals(5, dispatcher.getCallsMap().get(Dispatcher.CALLS.AWAIT).intValue());
        //Se espera que las 5 llamadas en espera sean atendidas.
        assertEquals(5, dispatcher.getCallsMap().get(Dispatcher.CALLS.RESUMED).intValue());
        //Se espera en total que las diez llamadas sean atendidas.
        assertEquals(10, dispatcher.getCallsMap().get(Dispatcher.CALLS.ENDED).intValue());
    }    

     /**
     * Test dispatchCall: Se realizan 12 llamadas al tiempo y se encuentran 8 empleados creados, 
     * En el proceso se deben colocar 4 llamadas en espera y luego ser atendidas
     * cuando se desocupen los empleados. Nota: como el Dispatcher solo puede atender 10 llamadas
     * el servicio de hilos, iniciará las dos llamadas restantes una vez se desocupen los hilos del pool.
     * 
     * @throws InterruptedException
     */
    @Test
    public void testDispatchCall10_3() throws InterruptedException {
        numOper = 5;
        numSuper = 2;
        numDirec = 1;
        numCalls = 12;

        dispatcher = new Dispatcher(new EmployeeController(CallCenter.getEmployees(numOper, numSuper, numDirec)));
        dispatcher.dispatchCall(CallCenter.prepareCall(numCalls));
        
        
        //Se espera que en total se atiendan 12 llamadas.
        assertEquals(12, dispatcher.getCallsMap().get(Dispatcher.CALLS.INIT).intValue());
        //Se espera que se coloquen 4 llamadas en espera.
        assertEquals(4, dispatcher.getCallsMap().get(Dispatcher.CALLS.AWAIT).intValue());
        //Se espera que las 5 llamadas en espera sean atendidas.
        assertEquals(4, dispatcher.getCallsMap().get(Dispatcher.CALLS.RESUMED).intValue());
        //Se espera en total que las diez llamadas sean atendidas.
        assertEquals(12, dispatcher.getCallsMap().get(Dispatcher.CALLS.ENDED).intValue());
    }  
    
}
