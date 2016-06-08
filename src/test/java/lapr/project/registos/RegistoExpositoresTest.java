/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.List;
import lapr.project.model.Expositor;
import lapr.project.model.Utilizador;
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
public class RegistoExpositoresTest {
    
    public RegistoExpositoresTest() {
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
     * Test of addExpositor method, of class RegistoExpositores.
     */
    @Test
    public void testAddExpositor() {
        System.out.println("addExpositor");
        Utilizador utilizador = null;
        RegistoExpositores instance = new RegistoExpositores();
        boolean expResult = false;
        boolean result = instance.addExpositor(utilizador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExpositores method, of class RegistoExpositores.
     */
    @Test
    public void testGetListaExpositores() {
        System.out.println("getListaExpositores");
        RegistoExpositores instance = new RegistoExpositores();
        List<Expositor> expResult = null;
        List<Expositor> result = instance.getListaExpositores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
