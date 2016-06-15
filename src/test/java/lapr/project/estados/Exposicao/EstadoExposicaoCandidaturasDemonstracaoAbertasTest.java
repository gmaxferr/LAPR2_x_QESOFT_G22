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
public class EstadoExposicaoCandidaturasDemonstracaoAbertasTest {

    public EstadoExposicaoCandidaturasDemonstracaoAbertasTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private EstadoExposicaoCandidaturasDemonstracaoAbertas instance;
    private Exposicao e;
    private CentroExposicoes ce;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(ce);

        instance = new EstadoExposicaoCandidaturasDemonstracaoAbertas(e);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturasDemonstracaoAbertas method, of class
     * EstadoExposicaoCandidaturasDemonstracaoAbertas.
     */
    @Test
    public void testSetEstadoCandidaturasDemonstracaoAbertas() {
        System.out.println("setEstadoCandidaturasDemonstracaoAbertas");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturasDemonstracaoAbertas();
        assertEquals(expResult, result);

    }

    /**
     * Test of setEstadoCandidaturasDemonstracaoFechadas method, of class
     * EstadoExposicaoCandidaturasDemonstracaoAbertas.
     */
    @Test
    public void testSetEstadoCandidaturasDemonstracaoFechadas() {
        System.out.println("setEstadoCandidaturasDemonstracaoFechadas");
        boolean expResult = true;
        boolean result = instance.setEstadoCandidaturasDemonstracaoFechadas();
        assertEquals(expResult, result);

    }

    /**
     * Test of valida method, of class
     * EstadoExposicaoCandidaturasDemonstracaoAbertas.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        boolean expResult = true;
        boolean result = instance.valida();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturasDemonstracaoAbertas method, of class
     * EstadoExposicaoCandidaturasDemonstracaoAbertas.
     */
    @Test
    public void testIsEstadoCandidaturasDemonstracaoAbertas() {
        System.out.println("isEstadoCandidaturasDemonstracaoAbertas");
        boolean expResult = true;
        boolean result = instance.isEstadoCandidaturasDemonstracaoAbertas();
        assertEquals(expResult, result);
    }

}
