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
public class EstadoCandidaturaAExposicaoCriadaTest {
    
    public EstadoCandidaturaAExposicaoCriadaTest() {
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
         instance = new EstadoCandidaturaAExposicaoCriada(m_cand);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturaCriada method, of class 
     * EstadoCandidaturaAExposicaoCriada.
     */
    @Test
    public void testSetEstadoCandidaturaCriada() {
        System.out.println("setEstadoCandidaturaCriada");
        boolean expResult = true;
        boolean result = instance.setEstadoCandidaturaCriada();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaCriada method, of class
     * EstadoCandidaturaAExposicaoCriada.
     */
    @Test
    public void testIsEstadoCandidaturaCriada() {
        System.out.println("isEstadoCandidaturaCriada");
        boolean expResult = true;
        boolean result = instance.isEstadoCandidaturaCriada();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaAbertaAtualizacaoConflitos method, 
     * of class EstadoCandidaturaAExposicaoCriada.
     */
    @Test
    public void testSetEstadoCandidaturaAbertaAtualizacaoConflitos() {
        System.out.println("setEstadoCandidaturaAbertaAtualizacaoConflitos");
        boolean expResult = true;
        boolean result = instance.setEstadoCandidaturaAbertaAtualizacaoConflitos();
        assertEquals(expResult, result);
    }
    
}
