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
public class EstadoExposicaoInicialTest {
    
    public EstadoExposicaoInicialTest() {
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
     * Test of setEstadoCriada method, of class EstadoExposicaoInicial.
     */
    @Test
    public void testSetEstadoCriada() {
        System.out.println("setEstadoCriada");
        EstadoExposicaoInicial instance = null;
        boolean expResult = false;
        boolean result = instance.setEstadoCriada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEstadoInicial method, of class EstadoExposicaoInicial.
     */
    @Test
    public void testIsEstadoInicial() {
        System.out.println("isEstadoInicial");
        EstadoExposicaoInicial instance = null;
        boolean expResult = false;
        boolean result = instance.isEstadoInicial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
