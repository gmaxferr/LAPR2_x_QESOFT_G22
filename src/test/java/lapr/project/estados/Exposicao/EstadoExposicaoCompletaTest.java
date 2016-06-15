/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados.Exposicao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author guima
 */
public class EstadoExposicaoCompletaTest {
    
    public EstadoExposicaoCompletaTest() {
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
     * Test of setEstadoCompleta method, of class EstadoExposicaoCompleta.
     */
    @Test
    public void testSetEstadoCompleta() {
        System.out.println("setEstadoCompleta");
        EstadoExposicaoCompleta instance = null;
        boolean expResult = false;
        boolean result = instance.setEstadoCompleta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadoCandidaturasAbertas method, of class EstadoExposicaoCompleta.
     */
    @Test
    public void testSetEstadoCandidaturasAbertas() {
        System.out.println("setEstadoCandidaturasAbertas");
        EstadoExposicaoCompleta instance = null;
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturasAbertas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEstadoCompleta method, of class EstadoExposicaoCompleta.
     */
    @Test
    public void testIsEstadoCompleta() {
        System.out.println("isEstadoCompleta");
        EstadoExposicaoCompleta instance = null;
        boolean expResult = false;
        boolean result = instance.isEstadoCompleta();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
