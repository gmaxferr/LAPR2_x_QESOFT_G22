/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados.Exposicao;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
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
    
    private EstadoExposicaoCompleta instance;
    private Exposicao e;
    private CentroExposicoes ce;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(ce);

        instance = new EstadoExposicaoCompleta(e);
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
        boolean expResult = false;
        boolean result = instance.setEstadoCompleta();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturasAbertas method, of class EstadoExposicaoCompleta.
     */
    @Test
    public void testSetEstadoCandidaturasAbertas() {
        System.out.println("setEstadoCandidaturasAbertas");
        boolean expResult = true;
        boolean result = instance.setEstadoCandidaturasAbertas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCompleta method, of class EstadoExposicaoCompleta.
     */
    @Test
    public void testIsEstadoCompleta() {
        System.out.println("isEstadoCompleta");
        boolean expResult = true;
        boolean result = instance.isEstadoCompleta();
        assertEquals(expResult, result);
    }
    
}
