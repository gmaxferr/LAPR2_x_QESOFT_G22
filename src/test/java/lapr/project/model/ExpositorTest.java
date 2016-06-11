/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Catalao
 */
public class ExpositorTest {
    
    public ExpositorTest() {
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
     * Test of getM_strUsername method, of class Expositor.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getM_strUsername");
        Utilizador u = new Utilizador("", "us3r", "".toCharArray(), "");
        Expositor instance = new Expositor(u);
        String expResult = "us3r";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }
    
}
