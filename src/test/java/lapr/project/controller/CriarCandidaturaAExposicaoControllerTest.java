/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.model.Expositor;
import lapr.project.model.Produto;
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
public class CriarCandidaturaAExposicaoControllerTest {
    
    public CriarCandidaturaAExposicaoControllerTest() {
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
     * Test of getRegistoExposicoes method, of class CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        CriarCandidaturaAExposicaoController instance = null;
        instance.getRegistoExposicoes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasAbertas method, of class CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAbertas() {
        System.out.println("getListaExposicoesEstadoCandidaturasAbertas");
        CriarCandidaturaAExposicaoController instance = null;
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getListaExposicoesEstadoCandidaturasAbertas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExposicao method, of class CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao exposicaoEscolhida = null;
        CriarCandidaturaAExposicaoController instance = null;
        instance.setExposicao(exposicaoEscolhida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoCandidaturas method, of class CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetRegistoCandidaturas() {
        System.out.println("getRegistoCandidaturas");
        CriarCandidaturaAExposicaoController instance = null;
        instance.getRegistoCandidaturas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of criarCandidatura method, of class CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testCriarCandidatura() {
        System.out.println("criarCandidatura");
        Expositor expositor = null;
        CriarCandidaturaAExposicaoController instance = null;
        instance.criarCandidatura(expositor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDados method, of class CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testSetDados() {
        System.out.println("setDados");
        String nomeEmpresa = "";
        String moradaEmpresa = "";
        String telemovelEmpresa = "";
        String area = "";
        String numConvites = "";
        CriarCandidaturaAExposicaoController instance = null;
        instance.setDados(nomeEmpresa, moradaEmpresa, telemovelEmpresa, area, numConvites);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoProduto method, of class CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetRegistoProduto() {
        System.out.println("getRegistoProduto");
        CriarCandidaturaAExposicaoController instance = null;
        instance.getRegistoProduto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProduto method, of class CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testAddProduto() {
        System.out.println("addProduto");
        String nome = "";
        CriarCandidaturaAExposicaoController instance = null;
        boolean expResult = false;
        boolean result = instance.addProduto(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoDemonstracoes method, of class CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetRegistoDemonstracoes() {
        System.out.println("getRegistoDemonstracoes");
        CriarCandidaturaAExposicaoController instance = null;
        instance.getRegistoDemonstracoes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaDemonstracoes method, of class CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetListaDemonstracoes() {
        System.out.println("getListaDemonstracoes");
        CriarCandidaturaAExposicaoController instance = null;
        List<Demonstracao> expResult = null;
        List<Demonstracao> result = instance.getListaDemonstracoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionaDemonstracao method, of class CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testAdicionaDemonstracao() {
        System.out.println("adicionaDemonstracao");
        Demonstracao demonstracaoEscolhida = null;
        CriarCandidaturaAExposicaoController instance = null;
        instance.adicionaDemonstracao(demonstracaoEscolhida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registaCandidatura method, of class CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testRegistaCandidatura() {
        System.out.println("registaCandidatura");
        CriarCandidaturaAExposicaoController instance = null;
        boolean expResult = false;
        boolean result = instance.registaCandidatura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaProdutosCandidatura method, of class CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testSetListaProdutosCandidatura() {
        System.out.println("setListaProdutosCandidatura");
        List<Produto> listaProdutos = null;
        CriarCandidaturaAExposicaoController instance = null;
        instance.setListaProdutosCandidatura(listaProdutos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaDemonstracoesCandidatura method, of class CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testSetListaDemonstracoesCandidatura() {
        System.out.println("setListaDemonstracoesCandidatura");
        List<Demonstracao> listaDemonstracoes = null;
        CriarCandidaturaAExposicaoController instance = null;
        instance.setListaDemonstracoesCandidatura(listaDemonstracoes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadoCandidaturaAExposicaoCriada method, of class CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testSetEstadoCandidaturaAExposicaoCriada() {
        System.out.println("setEstadoCandidaturaAExposicaoCriada");
        CriarCandidaturaAExposicaoController instance = null;
        instance.setEstadoCandidaturaAExposicaoCriada();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarDadosCandidatura method, of class CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testValidarDadosCandidatura() {
        System.out.println("validarDadosCandidatura");
        CriarCandidaturaAExposicaoController instance = null;
        boolean expResult = false;
        boolean result = instance.validarDadosCandidatura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setKeywords method, of class CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testSetKeywords() {
        System.out.println("setKeywords");
        String keywords = "";
        CriarCandidaturaAExposicaoController instance = null;
        instance.setKeywords(keywords);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
