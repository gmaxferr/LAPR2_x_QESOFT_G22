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
public class EstadoExposicaoCandidaturasAbertasTest {

    public EstadoExposicaoCandidaturasAbertasTest() {
    }

    private Exposicao e;
    private EstadoExposicaoCandidaturasAbertas instance;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        CentroExposicoes ce = new CentroExposicoes();
        e = new Exposicao(ce);
        e.setEstado(instance);
        instance = new EstadoExposicaoCandidaturasAbertas(e);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturasAbertas method, of class
     * EstadoExposicaoCandidaturasAbertas.
     */
    @Test
    public void testSetEstadoCandidaturasAbertas() {
        System.out.println("setEstadoCandidaturasAbertas");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturasAbertas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturasFechadas method, of class
     * EstadoExposicaoCandidaturasAbertas.
     */
    @Test
    public void testSetEstadoCandidaturasFechadas() {
        System.out.println("setEstadoCandidaturasFechadas");
        boolean expResult = true;
        boolean result = instance.setEstadoCandidaturasFechadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturasAbertas method, of class
     * EstadoExposicaoCandidaturasAbertas.
     */
    @Test
    public void testIsEstadoCandidaturasAbertas() {
        System.out.println("isEstadoCandidaturasAbertas");
        boolean expResult = true;
        boolean result = instance.isEstadoCandidaturasAbertas();
        assertEquals(expResult, result);
    }

}
