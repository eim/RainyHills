/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eim.javaeetest;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing basic ejb container functionality.
 * 
 * @author eim
 */
public class EjbVolumeSolverTest {
    
    private Context ic = null;
    
    public EjbVolumeSolverTest() {
    }
    
    /**
     * Start ejb container.
     */
    @Before
    public void setUp() {
        ic = EJBContainer.createEJBContainer().getContext();
    }

    /**
     * Testing ejb function.
     * 
     * @throws NamingException 
     */ 
    @Test
     public void testEjbSolver() throws NamingException {
        Solver ejb = (Solver)ic.lookup("java:global/Solver");
        final int volume = ejb.calculate(new int[]{2,1,3,4,5,6,7});
        final int expectedVolume = 1;
        assertEquals(volume,expectedVolume);
     }
}
