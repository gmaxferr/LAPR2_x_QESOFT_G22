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
public class EstadoCandidaturaAExposicaoAvaliadaTest {

    public EstadoCandidaturaAExposicaoAvaliadaTest() {
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
        instance = new EstadoCandidaturaAExposicaoAvaliada(m_cand);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturaAceite method, of class
     * EstadoCandidaturaAExposicaoAvaliada.
     */
    @Test
    public void testSetEstadoCandidaturaAceite() {
        System.out.println("setEstadoCandidaturaAceite");
        boolean expResult = true;
        boolean result = instance.setEstadoCandidaturaAceite();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaRejeitada method, of class
     * EstadoCandidaturaAExposicaoAvaliada.
     */
    @Test
    public void testSetEstadoCandidaturaRejeitada() {
        System.out.println("setEstadoCandidaturaRejeitada");
        boolean expResult = true;
        boolean result = instance.setEstadoCandidaturaRejeitada();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaAvaliada method, of class
     * EstadoCandidaturaAExposicaoAvaliada.
     */
    @Test
    public void testIsEstadoCandidaturaAvaliada() {
        System.out.println("isEstadoCandidaturaAvaliada");
        boolean expResult = true;
        boolean result = instance.isEstadoCandidaturaAvaliada();
        assertEquals(expResult, result);
    }

}
