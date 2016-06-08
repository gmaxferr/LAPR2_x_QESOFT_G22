/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.AtribuicaoStand;
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
public class ConfirmarStandsControllerTest {
    
    public ConfirmarStandsControllerTest() {
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
     * Test of getRegistoExposicoes method, of class ConfirmarStandsController.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        ConfirmarStandsController instance = null;
        instance.getRegistoExposicoes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposicoesDoRepresentante method, of class ConfirmarStandsController.
     */
    @Test
    public void testGetListaExposicoesDoRepresentante() {
        System.out.println("getListaExposicoesDoRepresentante");
        String usernameRepresentante = "";
        ConfirmarStandsController instance = null;
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getListaExposicoesDoRepresentante(usernameRepresentante);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExposicao method, of class ConfirmarStandsController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao e = null;
        ConfirmarStandsController instance = null;
        instance.setExposicao(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoAtribuicoesDeStand method, of class ConfirmarStandsController.
     */
    @Test
    public void testGetRegistoAtribuicoesDeStand() {
        System.out.println("getRegistoAtribuicoesDeStand");
        ConfirmarStandsController instance = null;
        instance.getRegistoAtribuicoesDeStand();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAtribuicao method, of class ConfirmarStandsController.
     */
    @Test
    public void testGetAtribuicao() {
        System.out.println("getAtribuicao");
        ConfirmarStandsController instance = null;
        AtribuicaoStand expResult = null;
        AtribuicaoStand result = instance.getAtribuicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDecisao method, of class ConfirmarStandsController.
     */
    @Test
    public void testSetDecisao() {
        System.out.println("setDecisao");
        boolean decisao = false;
        ConfirmarStandsController instance = null;
        instance.setDecisao(decisao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
