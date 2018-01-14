/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almundo.callcenter.model;

import java.lang.reflect.Method;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rubens
 */
public class CallTest {

    public CallTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Call.
     */
    @Test
    public void testGetId() throws Exception {
        Method method = Call.class.getDeclaredMethod("getTimeRandom");
        method.setAccessible(true);

        long time = (long) method.invoke(new Call());

        assertTrue(time >= 5 && time <= 10);
        assertTrue(time >= 5 && time <= 10);
        assertTrue(time >= 5 && time <= 10);
        assertTrue(time >= 5 && time <= 10);
    }

}
