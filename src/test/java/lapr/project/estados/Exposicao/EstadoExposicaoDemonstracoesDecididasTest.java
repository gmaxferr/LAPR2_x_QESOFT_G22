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
public class EstadoExposicaoDemonstracoesDecididasTest {
    
    public EstadoExposicaoDemonstracoesDecididasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private EstadoExposicaoDemonstracoesDecididas instance;
    private Exposicao e;
    private CentroExposicoes ce;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(ce);

        instance = new EstadoExposicaoDemonstracoesDecididas(e);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoDemonstracoesDecididas method, of class EstadoExposicaoDemonstracoesDecididas.
     */
    @Test
    public void testSetEstadoDemonstracoesDecididas() {
        System.out.println("setEstadoDemonstracoesDecididas");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracoesDecididas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturasDemonstracaoAbertas method, of class EstadoExposicaoDemonstracoesDecididas.
     */
    @Test
    public void testSetEstadoCandidaturasDemonstracaoAbertas() {
        System.out.println("setEstadoCandidaturasDemonstracaoAbertas");
        boolean expResult = true;
        boolean result = instance.setEstadoCandidaturasDemonstracaoAbertas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracoesDecididas method, of class EstadoExposicaoDemonstracoesDecididas.
     */
    @Test
    public void testIsEstadoDemonstracoesDecididas() {
        System.out.println("isEstadoDemonstracoesDecididas");
        boolean expResult = true;
        boolean result = instance.isEstadoDemonstracoesDecididas();
        assertEquals(expResult, result);
    }
}
