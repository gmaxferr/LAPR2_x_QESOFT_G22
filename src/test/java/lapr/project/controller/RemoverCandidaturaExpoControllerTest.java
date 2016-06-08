/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.AtribuicoesCandidatura;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.Exposicao;
import lapr.project.registos.RegistoAtribuicoes;
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
public class RemoverCandidaturaExpoControllerTest {
    
    public RemoverCandidaturaExpoControllerTest() {
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
     * Test of getListaAtribuicoesComOFAE method, of class RemoverCandidaturaExpoController.
     */
    @Test
    public void testGetListaAtribuicoesComOFAE() {
        System.out.println("getListaAtribuicoesComOFAE");
        RemoverCandidaturaExpoController instance = null;
        ArrayList<AtribuicoesCandidatura> expResult = null;
        ArrayList<AtribuicoesCandidatura> result = instance.getListaAtribuicoesComOFAE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoAtribuicoes method, of class RemoverCandidaturaExpoController.
     */
    @Test
    public void testGetRegistoAtribuicoes() {
        System.out.println("getRegistoAtribuicoes");
        RemoverCandidaturaExpoController instance = null;
        RegistoAtribuicoes expResult = null;
        RegistoAtribuicoes result = instance.getRegistoAtribuicoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExposicao method, of class RemoverCandidaturaExpoController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao e = null;
        RemoverCandidaturaExpoController instance = null;
        instance.setExposicao(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExposRepresentante method, of class RemoverCandidaturaExpoController.
     */
    @Test
    public void testGetExposRepresentante() {
        System.out.println("getExposRepresentante");
        String username = "";
        RemoverCandidaturaExpoController instance = null;
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getExposRepresentante(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaCandidaturas method, of class RemoverCandidaturaExpoController.
     */
    @Test
    public void testGetListaCandidaturas() {
        System.out.println("getListaCandidaturas");
        String username = "";
        RemoverCandidaturaExpoController instance = null;
        List<CandidaturaAExposicao> expResult = null;
        List<CandidaturaAExposicao> result = instance.getListaCandidaturas(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCandidaturaARemover method, of class RemoverCandidaturaExpoController.
     */
    @Test
    public void testSetCandidaturaARemover() {
        System.out.println("setCandidaturaARemover");
        CandidaturaAExposicao c = null;
        RemoverCandidaturaExpoController instance = null;
        instance.setCandidaturaARemover(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removerCandidatura method, of class RemoverCandidaturaExpoController.
     */
    @Test
    public void testRemoverCandidatura() {
        System.out.println("removerCandidatura");
        RemoverCandidaturaExpoController instance = null;
        instance.removerCandidatura();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
