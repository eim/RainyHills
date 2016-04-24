/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eim.javaeetest.test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import org.eim.javaeetest.SolverService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing basic web server functionality.
 * 
 * @author eim
 */
public class WebModuleTest extends JerseyTest {
        
    @Override
    protected Application configure() {
        return new ResourceConfig(SolverService.class);
    }
    
    /**
     * Testing rest "get" request.
     * 
     * @throws Exception 
     */
    @Test
    public void testEchoMessage() throws Exception {
        final String hello = target("/volume/echo").request().get(String.class);
        assertEquals(SolverService.TEST_MESSAGE, hello);
    }
    
    /**
     * Ejb wasn't injected. It's just a web container.
     * 
     * @throws Exception 
     */
    @Test(expected = Exception.class) 
    public void testJsonResult() throws Exception {
        int[] array = new int[] {1,2,3,4,5,6};
        final int hello = target("/volume").request().
                post(Entity.entity(array,MediaType.APPLICATION_JSON_TYPE), int.class);
        assertEquals(178, hello);
    }

}
