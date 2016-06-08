/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados;

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
public class EstadoCandidaturaADemonstracaoTest {
    
    public EstadoCandidaturaADemonstracaoTest() {
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
     * Test of setEstadoCandidaturaInstanciada method, of class EstadoCandidaturaADemonstracao.
     */
    @Test
    public void testSetEstadoCandidaturaInstanciada() {
        System.out.println("setEstadoCandidaturaInstanciada");
        EstadoCandidaturaADemonstracao instance = new EstadoCandidaturaADemonstracaoImpl();
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaInstanciada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadoCandidaturaCriada method, of class EstadoCandidaturaADemonstracao.
     */
    @Test
    public void testSetEstadoCandidaturaCriada() {
        System.out.println("setEstadoCandidaturaCriada");
        EstadoCandidaturaADemonstracao instance = new EstadoCandidaturaADemonstracaoImpl();
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaCriada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEstadoCandidaturaInstanciada method, of class EstadoCandidaturaADemonstracao.
     */
    @Test
    public void testIsEstadoCandidaturaInstanciada() {
        System.out.println("isEstadoCandidaturaInstanciada");
        EstadoCandidaturaADemonstracao instance = new EstadoCandidaturaADemonstracaoImpl();
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaInstanciada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEstadoCandidaturaCriada method, of class EstadoCandidaturaADemonstracao.
     */
    @Test
    public void testIsEstadoCandidaturaCriada() {
        System.out.println("isEstadoCandidaturaCriada");
        EstadoCandidaturaADemonstracao instance = new EstadoCandidaturaADemonstracaoImpl();
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaCriada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class EstadoCandidaturaADemonstracaoImpl implements EstadoCandidaturaADemonstracao {

        public boolean setEstadoCandidaturaInstanciada() {
            return false;
        }

        public boolean setEstadoCandidaturaCriada() {
            return false;
        }

        public boolean isEstadoCandidaturaInstanciada() {
            return false;
        }

        public boolean isEstadoCandidaturaCriada() {
            return false;
        }
    }
    
}
