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
 * @author Ruben Ramirez
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
     * Test getTimeRandom: Pruba el tiempo de llamada aleatorio
     * que debe estar entre 5 y 10 segundos.
     */
    @Test
    public void testGetTimeRandom() throws Exception {
        Method method = Call.class.getDeclaredMethod("getTimeRandom");
        method.setAccessible(true);

        long time = (long) method.invoke(new Call());
        long time1 = (long) method.invoke(new Call());
        long time2 = (long) method.invoke(new Call());

        assertTrue(time >= 5 && time <= 10);
        assertTrue(time1 >= 5 && time1 <= 10);
        assertTrue(time2 >= 5 && time2 <= 10);
    }

}
