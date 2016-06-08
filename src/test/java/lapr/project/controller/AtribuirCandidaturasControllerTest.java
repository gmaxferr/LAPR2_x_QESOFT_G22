/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.AtribuicoesCandidatura;
import lapr.project.model.Exposicao;
import lapr.project.model.Mecanismo;
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
public class AtribuirCandidaturasControllerTest {
    
    public AtribuirCandidaturasControllerTest() {
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
     * Test of getRegistoExposicoes method, of class AtribuirCandidaturasController.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        AtribuirCandidaturasController instance = null;
        instance.getRegistoExposicoes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposicoesDoOrganizador method, of class AtribuirCandidaturasController.
     */
    @Test
    public void testGetListaExposicoesDoOrganizador() {
        System.out.println("getListaExposicoesDoOrganizador");
        AtribuirCandidaturasController instance = null;
        ArrayList<Exposicao> expResult = null;
        ArrayList<Exposicao> result = instance.getListaExposicoesDoOrganizador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExposicao method, of class AtribuirCandidaturasController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao exposicao = null;
        AtribuirCandidaturasController instance = null;
        instance.setExposicao(exposicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoMecanismos method, of class AtribuirCandidaturasController.
     */
    @Test
    public void testGetRegistoMecanismos() {
        System.out.println("getRegistoMecanismos");
        AtribuirCandidaturasController instance = null;
        instance.getRegistoMecanismos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaMecanismos method, of class AtribuirCandidaturasController.
     */
    @Test
    public void testGetListaMecanismos() {
        System.out.println("getListaMecanismos");
        AtribuirCandidaturasController instance = null;
        List<Mecanismo> expResult = null;
        List<Mecanismo> result = instance.getListaMecanismos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoCandidaturas method, of class AtribuirCandidaturasController.
     */
    @Test
    public void testGetRegistoCandidaturas() {
        System.out.println("getRegistoCandidaturas");
        AtribuirCandidaturasController instance = null;
        instance.getRegistoCandidaturas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoAtribuicoes method, of class AtribuirCandidaturasController.
     */
    @Test
    public void testGetRegistoAtribuicoes() {
        System.out.println("getRegistoAtribuicoes");
        AtribuirCandidaturasController instance = null;
        instance.getRegistoAtribuicoes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atribui method, of class AtribuirCandidaturasController.
     */
    @Test
    public void testAtribui_Mecanismo() {
        System.out.println("atribui");
        Mecanismo mec = null;
        AtribuirCandidaturasController instance = null;
        List<AtribuicoesCandidatura> expResult = null;
        List<AtribuicoesCandidatura> result = instance.atribui(mec);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atribui method, of class AtribuirCandidaturasController.
     */
    @Test
    public void testAtribui_Mecanismo_String() {
        System.out.println("atribui");
        Mecanismo mec = null;
        String numeroFAEOuExperiencia = "";
        AtribuirCandidaturasController instance = null;
        List<AtribuicoesCandidatura> expResult = null;
        List<AtribuicoesCandidatura> result = instance.atribui(mec, numeroFAEOuExperiencia);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registaAtribuicao method, of class AtribuirCandidaturasController.
     */
    @Test
    public void testRegistaAtribuicao() {
        System.out.println("registaAtribuicao");
        List<AtribuicoesCandidatura> listaAtribuicao = null;
        AtribuirCandidaturasController instance = null;
        instance.registaAtribuicao(listaAtribuicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadoCandidaturaAtribuida method, of class AtribuirCandidaturasController.
     */
    @Test
    public void testSetEstadoCandidaturaAtribuida() {
        System.out.println("setEstadoCandidaturaAtribuida");
        AtribuirCandidaturasController instance = null;
        instance.setEstadoCandidaturaAtribuida();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
