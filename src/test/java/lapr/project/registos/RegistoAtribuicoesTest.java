/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.AtribuicoesCandidatura;
import lapr.project.model.CandidaturaAExposicao;
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
public class RegistoAtribuicoesTest {
    
    public RegistoAtribuicoesTest() {
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
     * Test of getListaAtribuicoes method, of class RegistoAtribuicoes.
     */
    @Test
    public void testGetListaAtribuicoes() {
        System.out.println("getListaAtribuicoes");
        RegistoAtribuicoes instance = new RegistoAtribuicoes();
        List<AtribuicoesCandidatura> expResult = null;
        List<AtribuicoesCandidatura> result = instance.getListaAtribuicoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDadosCandidatura method, of class RegistoAtribuicoes.
     */
    @Test
    public void testGetDadosCandidatura() {
        System.out.println("getDadosCandidatura");
        CandidaturaAExposicao c = null;
        RegistoAtribuicoes instance = new RegistoAtribuicoes();
        ArrayList expResult = null;
        ArrayList result = instance.getDadosCandidatura(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarCandidatura method, of class RegistoAtribuicoes.
     */
    @Test
    public void testValidarCandidatura() {
        System.out.println("validarCandidatura");
        CandidaturaAExposicao c = null;
        RegistoAtribuicoes instance = new RegistoAtribuicoes();
        boolean expResult = false;
        boolean result = instance.validarCandidatura(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvaliacao method, of class RegistoAtribuicoes.
     */
    @Test
    public void testSetAvaliacao() {
        System.out.println("setAvaliacao");
        CandidaturaAExposicao candidaturaAExposicao = null;
        boolean decisao = false;
        RegistoAtribuicoes instance = new RegistoAtribuicoes();
        instance.setAvaliacao(candidaturaAExposicao, decisao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaDecidirCandidatura method, of class RegistoAtribuicoes.
     */
    @Test
    public void testValidaDecidirCandidatura() {
        System.out.println("validaDecidirCandidatura");
        RegistoAtribuicoes instance = new RegistoAtribuicoes();
        boolean expResult = false;
        boolean result = instance.validaDecidirCandidatura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaAtribuicao method, of class RegistoAtribuicoes.
     */
    @Test
    public void testSetListaAtribuicao() {
        System.out.println("setListaAtribuicao");
        List<AtribuicoesCandidatura> listaAtribuicao = null;
        RegistoAtribuicoes instance = new RegistoAtribuicoes();
        instance.setListaAtribuicao(listaAtribuicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaAtribuicoesDoFAE method, of class RegistoAtribuicoes.
     */
    @Test
    public void testGetListaAtribuicoesDoFAE() {
        System.out.println("getListaAtribuicoesDoFAE");
        String usernameFAE = "";
        RegistoAtribuicoes instance = new RegistoAtribuicoes();
        ArrayList<AtribuicoesCandidatura> expResult = null;
        ArrayList<AtribuicoesCandidatura> result = instance.getListaAtribuicoesDoFAE(usernameFAE);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
