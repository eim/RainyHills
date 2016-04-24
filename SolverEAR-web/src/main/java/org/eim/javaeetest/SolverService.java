/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eim.javaeetest;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author eim
 */
@Path("/volume")
@javax.enterprise.context.RequestScoped
public class SolverService {
    
    public static final String TEST_MESSAGE = "Test message";
    
    @EJB
    Solver solver;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public int service(int[] heights) {
        return solver.calculate(heights);
    }

    @GET
    @Path("/echo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String echo() {
        return TEST_MESSAGE;
    }
    
}
