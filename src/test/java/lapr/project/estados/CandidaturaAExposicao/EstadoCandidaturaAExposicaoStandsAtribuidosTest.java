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
public class EstadoCandidaturaAExposicaoStandsAtribuidosTest {

    public EstadoCandidaturaAExposicaoStandsAtribuidosTest() {
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
        instance = new EstadoCandidaturaAExposicaoStandsAtribuidos(m_cand);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturaStandsAtribuidos method, of class
     * EstadoCandidaturaAExposicaoStandsAtribuidos.
     */
    @Test
    public void testSetEstadoCandidaturaStandsAtribuidos() {
        System.out.println("setEstadoCandidaturaStandsAtribuidos");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaStandsAtribuidos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaStandAceite method, of class
     * EstadoCandidaturaAExposicaoStandsAtribuidos.
     */
    @Test
    public void testSetEstadoCandidaturaStandAceite() {
        System.out.println("setEstadoCandidaturaStandAceite");
        boolean expResult = true;
        boolean result = instance.setEstadoCandidaturaStandAceite();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaStandRecusado method, of class
     * EstadoCandidaturaAExposicaoStandsAtribuidos.
     */
    @Test
    public void testSetEstadoCandidaturaStandRecusado() {
        System.out.println("setEstadoCandidaturaStandRecusado");
        boolean expResult = true;
        boolean result = instance.setEstadoCandidaturaStandRecusado();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaStandsAtribuidos method, of class
     * EstadoCandidaturaAExposicaoStandsAtribuidos.
     */
    @Test
    public void testIsEstadoCandidaturaStandsAtribuidos() {
        System.out.println("isEstadoCandidaturaStandsAtribuidos");
        boolean expResult = true;
        boolean result = instance.isEstadoCandidaturaStandsAtribuidos();
        assertEquals(expResult, result);
    }

}
