/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados.Exposicao;

import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoAvaliada;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoNaoAvaliada;
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
public class EstadoExposicaoCandidaturasAvaliadasTest {

    public EstadoExposicaoCandidaturasAvaliadasTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private EstadoExposicaoCandidaturasAvaliadas instance;
    private Exposicao e;
    private CentroExposicoes ce;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(ce);
        CandidaturaAExposicao cand = new CandidaturaAExposicao(new Expositor(new Utilizador("a", "b", new char[]{'a', 'A', '.', '1', 'd'}, "a@b.c")));
        cand.setEstado(new EstadoCandidaturaAExposicaoAvaliada(cand));
        ce.getRegistoExposicoes().getListaExposicoes().add(e);
        e.getRegistoCandidaturasAExposicao().getListaCandidaturas().add(cand);

        instance = new EstadoExposicaoCandidaturasAvaliadas(e);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturasDecididas method, of class
     * EstadoExposicaoCandidaturasAvaliadas.
     */
    @Test
    public void testSetEstadoCandidaturasDecididas() {
        System.out.println("setEstadoCandidaturasDecididas");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturasDecididas();
        assertEquals(expResult, result);

    }

    /**
     * Test of valida method, of class EstadoExposicaoCandidaturasAvaliadas.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        boolean expResult = false; //porque já esta neste estado
        boolean result = instance.valida();
        assertEquals(expResult, result);

    }

    /**
     * Test of isEstadoCandidaturasAvaliadas method, of class
     * EstadoExposicaoCandidaturasAvaliadas.
     */
    @Test
    public void testIsEstadoCandidaturasAvaliadas() {
        System.out.println("isEstadoCandidaturasAvaliadas");
        boolean expResult = true; 
        boolean result = instance.isEstadoCandidaturasAvaliadas();
        assertEquals(expResult, result);

    }

}
