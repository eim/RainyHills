/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eim.javaeetest;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

/**
 * Testing of the algorithm.
 * 
 * @author eim
 */
public class VolumeSolverTest {
    @Rule 
    public TestName name = new TestName();
    private final String FORMAT_STRING = "Method: %16s Expected: %2d Result: %2d\n";
    private int[] src;
    private VolumeSolver instance;
    
    public VolumeSolverTest() {
    }

    @Before
    public void setUp() {
        instance = new VolumeSolver();
    }
    
    /**
     * Test for the data that permanently increase.
     * 
     * @throws java.lang.Exception
     */
    @Test
    public void testCalculateIncreasingValues() throws Exception {
        src = new int[]{1,2,3,4,5,6,7};
        int expResult = 0;
        int result = instance.calculate(src);
        print(name.getMethodName(),expResult,result);
        assertEquals(expResult, result);
    }
    
    /**
     * Test for the data that permanently decrease.
     * 
     * @throws Exception 
     */
    @Test
    public void testCalculateDecreasingValues() throws Exception {
        src = new int[]{7,6,5,4,3,2,1};
        int expResult = 0;
        int result = instance.calculate(src);
        print(name.getMethodName(),expResult,result);     
        assertEquals(expResult, result);
    }

    /**
     * Test for the data that increase and later decrease.
     * 
     * @throws Exception 
     */
    @Test
    public void testCalculatePyramidalValues() throws Exception {
        src = new int[]{1,2,3,4,3,2,1};
        int expResult = 0;
        int result = instance.calculate(src);
        print(name.getMethodName(),expResult,result);
        assertEquals(expResult, result);
    }

    /**
     * Test for the data that have a volume.
     * 
     * @throws Exception 
     */
    @Test
    public void testCalculateOneUnitLeft() throws Exception {
        src = new int[]{2,1,4};
        int expResult = 1;
        int result = instance.calculate(src);
        print(name.getMethodName(),expResult,result);
        assertEquals(expResult, result);
    }

    /**
     * Test for the data that have a volume.
     * 
     * @throws Exception 
     */
    @Test
    public void testCalculateOneUnitRight() throws Exception {
        src = new int[]{4,1,2};
        int expResult = 1;
        int result = instance.calculate(src);
        print(name.getMethodName(),expResult,result);
        assertEquals(expResult, result);
    }

    /**
     * More complex test a little bit.
     * @throws Exception 
     */
    @Test
    public void testCalculateAbitComplex() throws Exception {
        src = new int[]{4,3,6,4,7,3,4};
        int expResult = 4;
        int result = instance.calculate(src);
        print(name.getMethodName(),expResult,result);
        assertEquals(expResult, result);
    }
    
    /**
     * Print log message
     * 
     * @param methodName
     * @param expResult
     * @param result 
     */
    private void print(String methodName, int expResult, int result) {
        System.out.printf(FORMAT_STRING,
        new Object[]{methodName.substring(13, methodName.length()), 
            expResult, result});
    }
        
    
}
