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
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author rubens
 */
@Ignore
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
//        LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
//        File file = new File("testJunit/log4j2.xml");
//        context.setConfigLocation(file.toURI());
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        CallCenter.txtAreaResult = new JTextArea();
        CallCenter.txtAreaQueue = new JTextArea();
    }

    @After
    public void tearDown() {
    }
    
    /**
     * Test donde se realizan 10 llamadas al tiempo y se encuentran 10 empleados creados
     *
     * @throws InterruptedException
     */
    @Test
    public void testDispatchCall10() throws InterruptedException {
        numOper = 5;
        numSuper = 3;
        numDirec = 0;
        numCalls = 11;

        dispatcher = new Dispatcher(new EmployeeController(CallCenter.getEmployees(numOper, numSuper, numDirec)));
        dispatcher.dispatchCall(CallCenter.prepareCall(numCalls));
        
        //Evaluando que las llamadas realizadas sea igual al numero de llamadas atendidas.
        assertEquals(numCalls, dispatcher.getCallsMap().get(Dispatcher.CALLS.INIT).intValue());
        //Evaluando que el numero de llamadas realizadas se hayan finalizado correctamente.
        assertEquals(numCalls, dispatcher.getCallsMap().get(Dispatcher.CALLS.ENDED).intValue());
    }

    /**
     * Test donde se realizan 10 llamadas al tiempo y se encuentran 5 empleados creados, 
     * En el proceso se deben colocar 5 llamadas en espera y luego ser atendidas
     * cuando se desocupen los empleados.
     * 
     * Este caso prueba el punto extra numero 1.
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

}
