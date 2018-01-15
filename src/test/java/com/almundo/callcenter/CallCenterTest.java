package com.almundo.callcenter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ruben Ramirez
 */
public class CallCenterTest {
    
    public CallCenterTest() {
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
     * Test prepareCall: se evalua que la creación de las llamadas sea correcta.
     */
    @Test
    public void testPerpareCall() {
        
        assertEquals(10, CallCenter.prepareCall(10).length);
        
    }
    
}
