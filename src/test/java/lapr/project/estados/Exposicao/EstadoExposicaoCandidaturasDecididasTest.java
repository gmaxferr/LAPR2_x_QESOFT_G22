/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados.Exposicao;

import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Expositor;
import lapr.project.model.Utilizador;
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
public class EstadoExposicaoCandidaturasDecididasTest {

    public EstadoExposicaoCandidaturasDecididasTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private EstadoExposicaoCandidaturasDecididas instance;
    private Exposicao e;
    private CentroExposicoes ce;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(ce);
        CandidaturaAExposicao cand = new CandidaturaAExposicao(e, new Expositor(new Utilizador("a", "b", new char[]{'a', 'A', '.', '1', 'd'}, "a@b.c")));
        cand.setDecisao(true);
        ce.getRegistoExposicoes().getListaExposicoes().add(e);
        e.getRegistoCandidaturasAExposicao().getListaCandidaturas().add(cand);

        instance = new EstadoExposicaoCandidaturasDecididas(e);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturasDecididas method, of class
     * EstadoExposicaoCandidaturasDecididas.
     */
    @Test
    public void testSetEstadoCandidaturasDecididas() {
        System.out.println("setEstadoCandidaturasDecididas");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturasDecididas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoStandsAtribuidos method, of class
     * EstadoExposicaoCandidaturasDecididas.
     */
    @Test
    public void testSetEstadoStandsAtribuidos() {
        System.out.println("setEstadoStandsAtribuidos");
        boolean expResult = true;
        boolean result = instance.setEstadoStandsAtribuidos();
        assertEquals(expResult, result);
    }

    /**
     * Test of valida method, of class EstadoExposicaoCandidaturasDecididas.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        boolean expResult = true;
        boolean result = instance.valida();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturasDecididas method, of class
     * EstadoExposicaoCandidaturasDecididas.
     */
    @Test
    public void testIsEstadoCandidaturasDecididas() {
        System.out.println("isEstadoCandidaturasDecididas");
        boolean expResult = true;
        boolean result = instance.isEstadoCandidaturasDecididas();
        assertEquals(expResult, result);
    }

}
