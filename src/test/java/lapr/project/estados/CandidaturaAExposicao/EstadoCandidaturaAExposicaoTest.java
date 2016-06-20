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
 * @author guima
 */
public class EstadoCandidaturaAExposicaoTest {

    public EstadoCandidaturaAExposicaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }
   
    private EstadoCandidaturaAExposicao instance;

    @Before
    public void setUp() {
        Utilizador u = new Utilizador();
        CandidaturaAExposicao cand = new CandidaturaAExposicao(new Expositor(u));
        instance = new EstadoCandidaturaAExposicao(cand) {
        };
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturaInicial method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testSetEstadoCandidaturaInicial() {
        System.out.println("setEstadoCandidaturaInicial");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaInicial();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaCriada method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testSetEstadoCandidaturaCriada() {
        System.out.println("setEstadoCandidaturaCriada");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaCriada();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaAbertaAtualizacaoConflitos method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testSetEstadoCandidaturaAbertaAtualizacaoConflitos() {
        System.out.println("setEstadoCandidaturaAbertaAtualizacaoConflitos");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaAbertaAtualizacaoConflitos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaAtribuida method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testSetEstadoCandidaturaAtribuida() {
        System.out.println("setEstadoCandidaturaAtribuida");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaAtribuida();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaAvaliada method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testSetEstadoCandidaturaAvaliada() {
        System.out.println("setEstadoCandidaturaAvaliada");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaAvaliada();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaAceite method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testSetEstadoCandidaturaAceite() {
        System.out.println("setEstadoCandidaturaAceite");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaAceite();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaRejeitada method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testSetEstadoCandidaturaRejeitada() {
        System.out.println("setEstadoCandidaturaRejeitada");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaRejeitada();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaProntaAtribuicoes method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testSetEstadoCandidaturaProntaAtribuicoes() {
        System.out.println("setEstadoCandidaturaProntaAtribuicoes");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaProntaAtribuicoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaNaoAvaliada method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testSetEstadoCandidaturaNaoAvaliada() {
        System.out.println("setEstadoCandidaturaNaoAvaliada");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaNaoAvaliada();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaStandAceite method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testSetEstadoCandidaturaStandAceite() {
        System.out.println("setEstadoCandidaturaStandAceite");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaStandAceite();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaStandRecusado method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testSetEstadoCandidaturaStandRecusado() {
        System.out.println("setEstadoCandidaturaStandRecusado");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaStandRecusado();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaStandsAtribuidos method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testSetEstadoCandidaturaStandsAtribuidos() {
        System.out.println("setEstadoCandidaturaStandsAtribuidos");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaStandsAtribuidos();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaIncial method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testIsEstadoCandidaturaIncial() {
        System.out.println("isEstadoCandidaturaIncial");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaIncial();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaCriada method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testIsEstadoCandidaturaCriada() {
        System.out.println("isEstadoCandidaturaCriada");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaCriada();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaAbertaAtualizacaoConflitos method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testIsEstadoCandidaturaAbertaAtualizacaoConflitos() {
        System.out.println("isEstadoCandidaturaAbertaAtualizacaoConflitos");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaAbertaAtualizacaoConflitos();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaAtribuida method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testIsEstadoCandidaturaAtribuida() {
        System.out.println("isEstadoCandidaturaAtribuida");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaAtribuida();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaAvaliada method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testIsEstadoCandidaturaAvaliada() {
        System.out.println("isEstadoCandidaturaAvaliada");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaAvaliada();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaAceite method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testIsEstadoCandidaturaAceite() {
        System.out.println("isEstadoCandidaturaAceite");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaAceite();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaRejeitada method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testIsEstadoCandidaturaRejeitada() {
        System.out.println("isEstadoCandidaturaRejeitada");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaRejeitada();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaProntaAtribuicoes method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testIsEstadoCandidaturaProntaAtribuicoes() {
        System.out.println("isEstadoCandidaturaProntaAtribuicoes");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaProntaAtribuicoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaNaoAvaliada method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testIsEstadoCandidaturaNaoAvaliada() {
        System.out.println("isEstadoCandidaturaNaoAvaliada");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaNaoAvaliada();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaStandAceite method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testIsEstadoCandidaturaStandAceite() {
        System.out.println("isEstadoCandidaturaStandAceite");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaStandAceite();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaStandRecusado method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testIsEstadoCandidaturaStandRecusado() {
        System.out.println("isEstadoCandidaturaStandRecusado");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaStandRecusado();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaStandsAtribuidos method, of class
     * EstadoCandidaturaAExposicao.
     */
    @Test
    public void testIsEstadoCandidaturaStandsAtribuidos() {
        System.out.println("isEstadoCandidaturaStandsAtribuidos");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaStandsAtribuidos();
        assertEquals(expResult, result);
    }

    public class EstadoCandidaturaAExposicaoImpl extends EstadoCandidaturaAExposicao {

        public EstadoCandidaturaAExposicaoImpl() {
            super(null);
        }
    }

}
