/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.eim.javaeetest.itest;

import java.io.File;
import java.net.URL;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.eim.javaeetest.SolverService;
import org.jboss.arquillian.api.ArquillianResource;

import org.jboss.arquillian.api.Deployment;
import org.jboss.arquillian.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Testing of all modules.
 * Web container and ejb container are working together.
 * Ejb bean should be created and injected in the web module.
 * @author eim
 */
@RunWith(Arquillian.class)
public class RestFacadeTest { 
    /**
     * Deploy existing ear file into the embedded server.
     * @return 
     */
    @Deployment
    public static EnterpriseArchive createTestArchive() {
        EnterpriseArchive ear = ShrinkWrap.create(ZipImporter.class, "SolverEAR-ear-1.0-SNAPSHOT.ear")
            .importFrom(new File("../SolverEAR-ear/target/SolverEAR-ear-1.0-SNAPSHOT.ear")).as(EnterpriseArchive.class) ;
        return ear;
    } 

    /**
     * Testing volume calculator.
     * 
     * @param deploymentUrl - base url address.
     * @throws Exception 
     */
    @RunAsClient
    @Test
    public void testVolumeSolver(@ArquillianResource URL deploymentUrl) throws Exception {
        final HttpClient client=new HttpClient();
        final PostMethod post = new PostMethod(deploymentUrl.toString() + "example/volume");

        StringRequestEntity stringEntity = new StringRequestEntity("[4,3,6,4,7,3,4]", "application/json", "UTF-8");
        post.setRequestEntity(stringEntity);
        int responceCode = client.executeMethod(post);
        int expResponceCode = 200;
        assertEquals("Wrong http response code",expResponceCode,responceCode);
        int result = Integer.valueOf(post.getResponseBodyAsString());
        int expResult = 4;
        assertEquals("Wrong calculated volume",expResult,result);
    }

    /**
     * Testing echo message.
     * 
     * @param deploymentUrl - base url.
     * @throws Exception 
     */
    @RunAsClient
    @Test
    public void testEchoMessage(@ArquillianResource URL deploymentUrl) throws Exception {
        final HttpClient client=new HttpClient();
        final GetMethod get = new GetMethod(deploymentUrl.toString() + "example/volume/echo");
        int responceCode = client.executeMethod(get);
        int expResponceCode = 200;
        assertEquals("Wrong http response code",expResponceCode,responceCode);
        String result = get.getResponseBodyAsString();
        String expResult = "\""+SolverService.TEST_MESSAGE+"\"";
        assertEquals("Wrong response message",expResult,result);
    }
    
    
}
