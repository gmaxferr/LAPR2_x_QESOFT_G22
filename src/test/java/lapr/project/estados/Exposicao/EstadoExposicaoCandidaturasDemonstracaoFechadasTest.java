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
public class EstadoExposicaoCandidaturasDemonstracaoFechadasTest {
    
    public EstadoExposicaoCandidaturasDemonstracaoFechadasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private EstadoExposicaoCandidaturasDemonstracaoFechadas instance;
    private Exposicao e;
    private CentroExposicoes ce;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(ce);

        instance = new EstadoExposicaoCandidaturasDemonstracaoFechadas(e);
    }

    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturasDemonstracaoFechadas method, of class EstadoExposicaoCandidaturasDemonstracaoFechadas.
     */
    @Test
    public void testSetEstadoCandidaturasDemonstracaoFechadas() {
        System.out.println("setEstadoCandidaturasDemonstracaoFechadas");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturasDemonstracaoFechadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoConflitosDetetados method, of class EstadoExposicaoCandidaturasDemonstracaoFechadas.
     */
    @Test
    public void testSetEstadoConflitosDetetados() {
        System.out.println("setEstadoConflitosDetetados");
        boolean expResult = true;
        boolean result = instance.setEstadoConflitosDetetados();
        assertEquals(expResult, result);
    }

    /**
     * Test of valida method, of class EstadoExposicaoCandidaturasDemonstracaoFechadas.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        boolean expResult = true;
        boolean result = instance.valida();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturasDemonstracaoFechadas method, of class EstadoExposicaoCandidaturasDemonstracaoFechadas.
     */
    @Test
    public void testIsEstadoCandidaturasDemonstracaoFechadas() {
        System.out.println("isEstadoCandidaturasDemonstracaoFechadas");
        boolean expResult = true;
        boolean result = instance.isEstadoCandidaturasDemonstracaoFechadas();
        assertEquals(expResult, result);
    }
    
}
