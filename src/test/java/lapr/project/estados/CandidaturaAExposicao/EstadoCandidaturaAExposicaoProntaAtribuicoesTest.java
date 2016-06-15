/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;
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
 * @author Ana
 */
public class EstadoCandidaturaAExposicaoProntaAtribuicoesTest {

    public EstadoCandidaturaAExposicaoProntaAtribuicoesTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private CandidaturaAExposicao m_cand;
    private EstadoCandidaturaAExposicao instance;

    @Before
    public void setUp() {
        Utilizador utilizador = new Utilizador("pedro", "pedro", new char[]{'a', '.', '2', 'f'}, "aaa@dd.com");
        Expositor expositor = new Expositor(utilizador);
        m_cand = new CandidaturaAExposicao(expositor);
        instance = new EstadoCandidaturaAExposicaoProntaAtribuicoes(m_cand);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturaAtribuida method, of class
     * EstadoCandidaturaAExposicaoProntaAtribuicoes.
     */
    @Test
    public void testSetEstadoCandidaturaAtribuida() {
        System.out.println("setEstadoCandidaturaAtribuida");
        boolean expResult = true;
        boolean result = instance.setEstadoCandidaturaAtribuida();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaProntaAtribuicoes method, of class
     * EstadoCandidaturaAExposicaoProntaAtribuicoes.
     */
    @Test
    public void testSetEstadoCandidaturaProntaAtribuicoes() {
        System.out.println("setEstadoCandidaturaProntaAtribuicoes");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaProntaAtribuicoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaProntaAtribuicoes method, of class
     * EstadoCandidaturaAExposicaoProntaAtribuicoes.
     */
    @Test
    public void testIsEstadoCandidaturaProntaAtribuicoes() {
        System.out.println("isEstadoCandidaturaProntaAtribuicoes");
        boolean expResult = true;
        boolean result = instance.isEstadoCandidaturaProntaAtribuicoes();
        assertEquals(expResult, result);
    }

}
