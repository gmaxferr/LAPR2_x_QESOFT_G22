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
public class EstadoCandidaturaAExposicaoRejeitadaTest {

    public EstadoCandidaturaAExposicaoRejeitadaTest() {
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
        instance = new EstadoCandidaturaAExposicaoRejeitada(m_cand);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturaRejeitada method, of class
     * EstadoCandidaturaAExposicaoRejeitada.
     */
    @Test
    public void testSetEstadoCandidaturaRejeitada() {
        System.out.println("setEstadoCandidaturaRejeitada");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaRejeitada();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaRejeitada method, of class
     * EstadoCandidaturaAExposicaoRejeitada.
     */
    @Test
    public void testIsEstadoCandidaturaRejeitada() {
        System.out.println("isEstadoCandidaturaRejeitada");
        boolean expResult = true;
        boolean result = instance.isEstadoCandidaturaRejeitada();
        assertEquals(expResult, result);
    }

}
