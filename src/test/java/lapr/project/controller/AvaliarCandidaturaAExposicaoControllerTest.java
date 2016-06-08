/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import lapr.project.model.AtribuicoesCandidatura;
import lapr.project.model.Avaliacao;
import lapr.project.model.Exposicao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Catalao
 */
public class AvaliarCandidaturaAExposicaoControllerTest {
    
    public AvaliarCandidaturaAExposicaoControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRegistoExposicoes method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        AvaliarCandidaturaAExposicaoController instance = null;
        instance.getRegistoExposicoes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasAtribuidasDoFAE method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAtribuidasDoFAE() {
        System.out.println("getListaExposicoesEstadoCandidaturasAtribuidasDoFAE");
        AvaliarCandidaturaAExposicaoController instance = null;
        ArrayList<Exposicao> expResult = null;
        ArrayList<Exposicao> result = instance.getListaExposicoesEstadoCandidaturasAtribuidasDoFAE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExposicao method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao exposicao = null;
        AvaliarCandidaturaAExposicaoController instance = null;
        instance.setExposicao(exposicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoAtribuicoes method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetRegistoAtribuicoes() {
        System.out.println("getRegistoAtribuicoes");
        AvaliarCandidaturaAExposicaoController instance = null;
        instance.getRegistoAtribuicoes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaAtribuicoesDoAE method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetListaAtribuicoesDoAE() {
        System.out.println("getListaAtribuicoesDoAE");
        AvaliarCandidaturaAExposicaoController instance = null;
        ArrayList<AtribuicoesCandidatura> expResult = null;
        ArrayList<AtribuicoesCandidatura> result = instance.getListaAtribuicoesDoAE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoFaeAvalicao method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetRegistoFaeAvalicao() {
        System.out.println("getRegistoFaeAvalicao");
        AvaliarCandidaturaAExposicaoController instance = null;
        instance.getRegistoFaeAvalicao();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAtribuicao method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testSetAtribuicao() {
        System.out.println("setAtribuicao");
        AtribuicoesCandidatura atribuicao = null;
        AvaliarCandidaturaAExposicaoController instance = null;
        instance.setAtribuicao(atribuicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDadosCandidaturaNomeEmpresa method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetDadosCandidaturaNomeEmpresa() {
        System.out.println("getDadosCandidaturaNomeEmpresa");
        AvaliarCandidaturaAExposicaoController instance = null;
        String expResult = "";
        String result = instance.getDadosCandidaturaNomeEmpresa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDadosCandidaturaMoradaEmpresa method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetDadosCandidaturaMoradaEmpresa() {
        System.out.println("getDadosCandidaturaMoradaEmpresa");
        AvaliarCandidaturaAExposicaoController instance = null;
        String expResult = "";
        String result = instance.getDadosCandidaturaMoradaEmpresa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDadosCandidaturaTelemovel method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetDadosCandidaturaTelemovel() {
        System.out.println("getDadosCandidaturaTelemovel");
        AvaliarCandidaturaAExposicaoController instance = null;
        int expResult = 0;
        int result = instance.getDadosCandidaturaTelemovel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDadosCandidaturaArea method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetDadosCandidaturaArea() {
        System.out.println("getDadosCandidaturaArea");
        AvaliarCandidaturaAExposicaoController instance = null;
        int expResult = 0;
        int result = instance.getDadosCandidaturaArea();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDadosCandidaturaNumConvites method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetDadosCandidaturaNumConvites() {
        System.out.println("getDadosCandidaturaNumConvites");
        AvaliarCandidaturaAExposicaoController instance = null;
        int expResult = 0;
        int result = instance.getDadosCandidaturaNumConvites();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvaliacaoDoFae method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetAvaliacaoDoFae() {
        System.out.println("getAvaliacaoDoFae");
        AvaliarCandidaturaAExposicaoController instance = null;
        Avaliacao expResult = null;
        Avaliacao result = instance.getAvaliacaoDoFae();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaAvalicaoJaTomada method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testVerificaAvalicaoJaTomada() {
        System.out.println("verificaAvalicaoJaTomada");
        AvaliarCandidaturaAExposicaoController instance = null;
        boolean expResult = false;
        boolean result = instance.verificaAvalicaoJaTomada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvaliacao method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetAvaliacao() {
        System.out.println("getAvaliacao");
        AvaliarCandidaturaAExposicaoController instance = null;
        boolean expResult = false;
        boolean result = instance.getAvaliacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJustificacao method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetJustificacao() {
        System.out.println("getJustificacao");
        AvaliarCandidaturaAExposicaoController instance = null;
        String expResult = "";
        String result = instance.getJustificacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRatingConhecimentoSobreTema method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetRatingConhecimentoSobreTema() {
        System.out.println("getRatingConhecimentoSobreTema");
        AvaliarCandidaturaAExposicaoController instance = null;
        int expResult = 0;
        int result = instance.getRatingConhecimentoSobreTema();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRatingAdequacaoAExposicao method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetRatingAdequacaoAExposicao() {
        System.out.println("getRatingAdequacaoAExposicao");
        AvaliarCandidaturaAExposicaoController instance = null;
        int expResult = 0;
        int result = instance.getRatingAdequacaoAExposicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRatingAdequacaoAsDemos method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetRatingAdequacaoAsDemos() {
        System.out.println("getRatingAdequacaoAsDemos");
        AvaliarCandidaturaAExposicaoController instance = null;
        int expResult = 0;
        int result = instance.getRatingAdequacaoAsDemos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRatingAdequacaoNumConvites method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetRatingAdequacaoNumConvites() {
        System.out.println("getRatingAdequacaoNumConvites");
        AvaliarCandidaturaAExposicaoController instance = null;
        int expResult = 0;
        int result = instance.getRatingAdequacaoNumConvites();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRatingRecomendacaoGlobal method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetRatingRecomendacaoGlobal() {
        System.out.println("getRatingRecomendacaoGlobal");
        AvaliarCandidaturaAExposicaoController instance = null;
        int expResult = 0;
        int result = instance.getRatingRecomendacaoGlobal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvalicao method, of class AvaliarCandidaturaAExposicaoController.
     */
    @Test
    public void testSetAvalicao() {
        System.out.println("setAvalicao");
        boolean avaliacao = false;
        String justificacao = "";
        int ratingConhecimentoSobreTema = 0;
        int ratingAdequacaoAExposicao = 0;
        int ratingAdequacaoAsDemos = 0;
        int ratingAdequacaoNumConvites = 0;
        int ratingRecomendacaoGlobal = 0;
        AvaliarCandidaturaAExposicaoController instance = null;
        instance.setAvalicao(avaliacao, justificacao, ratingConhecimentoSobreTema, ratingAdequacaoAExposicao, ratingAdequacaoAsDemos, ratingAdequacaoNumConvites, ratingRecomendacaoGlobal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
