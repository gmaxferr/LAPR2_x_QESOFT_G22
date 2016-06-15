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
public class EstadoExposicaoCriadaTest {
    
    public EstadoExposicaoCriadaTest() {
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
     * Test of setEstadoFAEDefinidosSemDemos method, of class EstadoExposicaoCriada.
     */
    @Test
    public void testSetEstadoFAEDefinidosSemDemos() {
        System.out.println("setEstadoFAEDefinidosSemDemos");
        EstadoExposicaoCriada instance = null;
        boolean expResult = false;
        boolean result = instance.setEstadoFAEDefinidosSemDemos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadoDemosDefinidasSemFAE method, of class EstadoExposicaoCriada.
     */
    @Test
    public void testSetEstadoDemosDefinidasSemFAE() {
        System.out.println("setEstadoDemosDefinidasSemFAE");
        EstadoExposicaoCriada instance = null;
        boolean expResult = false;
        boolean result = instance.setEstadoDemosDefinidasSemFAE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEstadoCriada method, of class EstadoExposicaoCriada.
     */
    @Test
    public void testIsEstadoCriada() {
        System.out.println("isEstadoCriada");
        EstadoExposicaoCriada instance = null;
        boolean expResult = false;
        boolean result = instance.isEstadoCriada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
