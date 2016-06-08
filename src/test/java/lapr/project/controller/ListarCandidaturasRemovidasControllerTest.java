/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

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
public class ListarCandidaturasRemovidasControllerTest {
    
    public ListarCandidaturasRemovidasControllerTest() {
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
     * Test of getRegistoExposicoes method, of class ListarCandidaturasRemovidasController.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        ListarCandidaturasRemovidasController instance = null;
        instance.getRegistoExposicoes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposicoesDoOrganizador method, of class ListarCandidaturasRemovidasController.
     */
    @Test
    public void testGetListaExposicoesDoOrganizador() {
        System.out.println("getListaExposicoesDoOrganizador");
        String usernameOrganizador = "";
        ListarCandidaturasRemovidasController instance = null;
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getListaExposicoesDoOrganizador(usernameOrganizador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExposicao method, of class ListarCandidaturasRemovidasController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao e = null;
        ListarCandidaturasRemovidasController instance = null;
        instance.setExposicao(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoCandidaturasRemovidas method, of class ListarCandidaturasRemovidasController.
     */
    @Test
    public void testGetRegistoCandidaturasRemovidas() {
        System.out.println("getRegistoCandidaturasRemovidas");
        ListarCandidaturasRemovidasController instance = null;
        instance.getRegistoCandidaturasRemovidas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaCandidaturasRemovidas method, of class ListarCandidaturasRemovidasController.
     */
    @Test
    public void testGetListaCandidaturasRemovidas() {
        System.out.println("getListaCandidaturasRemovidas");
        ListarCandidaturasRemovidasController instance = null;
        List<CandidaturaAExposicao> expResult = null;
        List<CandidaturaAExposicao> result = instance.getListaCandidaturasRemovidas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
