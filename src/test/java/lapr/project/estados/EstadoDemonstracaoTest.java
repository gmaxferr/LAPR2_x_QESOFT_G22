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
public class EstadoDemonstracaoTest {
    
    public EstadoDemonstracaoTest() {
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
     * Test of setEstadoDemonstracaoPendente method, of class EstadoDemonstracao.
     */
    @Test
    public void testSetEstadoDemonstracaoPendente() {
        System.out.println("setEstadoDemonstracaoPendente");
        EstadoDemonstracao instance = new EstadoDemonstracaoImpl();
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoPendente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadoDemonstracaoConfirmada method, of class EstadoDemonstracao.
     */
    @Test
    public void testSetEstadoDemonstracaoConfirmada() {
        System.out.println("setEstadoDemonstracaoConfirmada");
        EstadoDemonstracao instance = new EstadoDemonstracaoImpl();
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoConfirmada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadoDemonstracaoCancelada method, of class EstadoDemonstracao.
     */
    @Test
    public void testSetEstadoDemonstracaoCancelada() {
        System.out.println("setEstadoDemonstracaoCancelada");
        EstadoDemonstracao instance = new EstadoDemonstracaoImpl();
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoCancelada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEstadoDemonstracaoPendente method, of class EstadoDemonstracao.
     */
    @Test
    public void testIsEstadoDemonstracaoPendente() {
        System.out.println("isEstadoDemonstracaoPendente");
        EstadoDemonstracao instance = new EstadoDemonstracaoImpl();
        boolean expResult = false;
        boolean result = instance.isEstadoDemonstracaoPendente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEstadoDemonstracaoConfirmada method, of class EstadoDemonstracao.
     */
    @Test
    public void testIsEstadoDemonstracaoConfirmada() {
        System.out.println("isEstadoDemonstracaoConfirmada");
        EstadoDemonstracao instance = new EstadoDemonstracaoImpl();
        boolean expResult = false;
        boolean result = instance.isEstadoDemonstracaoConfirmada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEstadoDemonstracaoCancelada method, of class EstadoDemonstracao.
     */
    @Test
    public void testIsEstadoDemonstracaoCancelada() {
        System.out.println("isEstadoDemonstracaoCancelada");
        EstadoDemonstracao instance = new EstadoDemonstracaoImpl();
        boolean expResult = false;
        boolean result = instance.isEstadoDemonstracaoCancelada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class EstadoDemonstracaoImpl implements EstadoDemonstracao {

        public boolean setEstadoDemonstracaoPendente() {
            return false;
        }

        public boolean setEstadoDemonstracaoConfirmada() {
            return false;
        }

        public boolean setEstadoDemonstracaoCancelada() {
            return false;
        }

        public boolean isEstadoDemonstracaoPendente() {
            return false;
        }

        public boolean isEstadoDemonstracaoConfirmada() {
            return false;
        }

        public boolean isEstadoDemonstracaoCancelada() {
            return false;
        }
    }
    
}
