package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testFound() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertEquals(5,new App().summary(array, 1, 2));
    }

    public void testOneLengthArr() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1));
        assertEquals(0, new App().summary(array, 1, 2));
    }

    public void testEmptyArray() {
        ArrayList<Integer> array = new ArrayList<>();
        assertEquals(0, new App().summary(array, 1, 2));
    }

        public void testNull() {
        assertEquals(0, new App().summary(null, 1, 2));
    }

    public void testOutOfBounds(){
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertEquals(0, new App().summary(array, -3 , 6));
    }
}
