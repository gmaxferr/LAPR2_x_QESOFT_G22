/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CandidaturaAExposicao;
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
public class DecidirCandidaturasAExposicaoControllerTest {
    
    public DecidirCandidaturasAExposicaoControllerTest() {
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
     * Test of getRegistoExposicoes method, of class DecidirCandidaturasAExposicaoController.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        DecidirCandidaturasAExposicaoController instance = null;
        instance.getRegistoExposicoes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasAvaliadas method, of class DecidirCandidaturasAExposicaoController.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAvaliadas() {
        System.out.println("getListaExposicoesEstadoCandidaturasAvaliadas");
        DecidirCandidaturasAExposicaoController instance = null;
        ArrayList<Exposicao> expResult = null;
        ArrayList<Exposicao> result = instance.getListaExposicoesEstadoCandidaturasAvaliadas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExposicao method, of class DecidirCandidaturasAExposicaoController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao exposicao = null;
        DecidirCandidaturasAExposicaoController instance = null;
        instance.setExposicao(exposicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoCandidaturas method, of class DecidirCandidaturasAExposicaoController.
     */
    @Test
    public void testGetRegistoCandidaturas() {
        System.out.println("getRegistoCandidaturas");
        DecidirCandidaturasAExposicaoController instance = null;
        instance.getRegistoCandidaturas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoProdutos method, of class DecidirCandidaturasAExposicaoController.
     */
    @Test
    public void testGetRegistoProdutos() {
        System.out.println("getRegistoProdutos");
        DecidirCandidaturasAExposicaoController instance = null;
        instance.getRegistoProdutos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaCandidaturas method, of class DecidirCandidaturasAExposicaoController.
     */
    @Test
    public void testGetListaCandidaturas() {
        System.out.println("getListaCandidaturas");
        DecidirCandidaturasAExposicaoController instance = null;
        List<CandidaturaAExposicao> expResult = null;
        List<CandidaturaAExposicao> result = instance.getListaCandidaturas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDadosEstatisticosGerais method, of class DecidirCandidaturasAExposicaoController.
     */
    @Test
    public void testGetDadosEstatisticosGerais() {
        System.out.println("getDadosEstatisticosGerais");
        DecidirCandidaturasAExposicaoController instance = null;
        instance.getDadosEstatisticosGerais();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCandidatura method, of class DecidirCandidaturasAExposicaoController.
     */
    @Test
    public void testSetCandidatura() {
        System.out.println("setCandidatura");
        CandidaturaAExposicao cand = null;
        DecidirCandidaturasAExposicaoController instance = null;
        instance.setCandidatura(cand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNomeEmpresa method, of class DecidirCandidaturasAExposicaoController.
     */
    @Test
    public void testGetNomeEmpresa() {
        System.out.println("getNomeEmpresa");
        DecidirCandidaturasAExposicaoController instance = null;
        String expResult = "";
        String result = instance.getNomeEmpresa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMoradaEmpresa method, of class DecidirCandidaturasAExposicaoController.
     */
    @Test
    public void testGetMoradaEmpresa() {
        System.out.println("getMoradaEmpresa");
        DecidirCandidaturasAExposicaoController instance = null;
        String expResult = "";
        String result = instance.getMoradaEmpresa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTelemovel method, of class DecidirCandidaturasAExposicaoController.
     */
    @Test
    public void testGetTelemovel() {
        System.out.println("getTelemovel");
        DecidirCandidaturasAExposicaoController instance = null;
        int expResult = 0;
        int result = instance.getTelemovel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArea method, of class DecidirCandidaturasAExposicaoController.
     */
    @Test
    public void testGetArea() {
        System.out.println("getArea");
        DecidirCandidaturasAExposicaoController instance = null;
        int expResult = 0;
        int result = instance.getArea();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumeroConvites method, of class DecidirCandidaturasAExposicaoController.
     */
    @Test
    public void testGetNumeroConvites() {
        System.out.println("getNumeroConvites");
        DecidirCandidaturasAExposicaoController instance = null;
        int expResult = 0;
        int result = instance.getNumeroConvites();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKeywords method, of class DecidirCandidaturasAExposicaoController.
     */
    @Test
    public void testGetKeywords() {
        System.out.println("getKeywords");
        DecidirCandidaturasAExposicaoController instance = null;
        instance.getKeywords();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDecisao method, of class DecidirCandidaturasAExposicaoController.
     */
    @Test
    public void testSetDecisao() {
        System.out.println("setDecisao");
        boolean decisao = false;
        DecidirCandidaturasAExposicaoController instance = null;
        instance.setDecisao(decisao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
