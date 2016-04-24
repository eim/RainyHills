/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eim.javaeetest.test;

import org.eim.javaeetest.Solver;
import org.eim.javaeetest.SolverService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;

/**
 * Simple unit test for basic functionality.
 * 
 * @author eim
 */
@RunWith(MockitoJUnitRunner.class)
public class MockServiceTest {
    
    @InjectMocks
    SolverService sService = new SolverService();
    
    @Mock
    Solver solver;
    
    /**
     * Test passing parameters into method.
     * @throws Exception 
     */
    @Test
    public void testJsonResult() throws Exception {
        /* Mock object with the algorithm */
        when(solver.calculate(any(int[].class))).thenReturn(178);
        int hello = sService.service(new int[]{1,2,3});
        assertEquals(178, hello);
    }
}