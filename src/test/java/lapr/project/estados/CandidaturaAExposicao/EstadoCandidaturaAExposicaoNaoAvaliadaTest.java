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
public class EstadoCandidaturaAExposicaoNaoAvaliadaTest {
    
    public EstadoCandidaturaAExposicaoNaoAvaliadaTest() {
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
         Utilizador utilizador = new Utilizador("pedro", "pedro", new char[] {'a', '.', '2', 'f'}, "aaa@dd.com");
         Expositor expositor = new Expositor(utilizador);
         m_cand = new CandidaturaAExposicao(expositor);
         instance = new EstadoCandidaturaAExposicaoNaoAvaliada(m_cand);
    
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturaNaoAvaliada method, of class 
     * EstadoCandidaturaAExposicaoNaoAvaliada.
     */
    @Test
    public void testSetEstadoCandidaturaNaoAvaliada() {
        System.out.println("setEstadoCandidaturaNaoAvaliada");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaNaoAvaliada();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaNaoAvaliada method, of class 
     * EstadoCandidaturaAExposicaoNaoAvaliada.
     */
    @Test
    public void testIsEstadoCandidaturaNaoAvaliada() {
        System.out.println("isEstadoCandidaturaNaoAvaliada");
        boolean expResult = true;
        boolean result = instance.isEstadoCandidaturaNaoAvaliada();
        assertEquals(expResult, result);
    }
    
}
