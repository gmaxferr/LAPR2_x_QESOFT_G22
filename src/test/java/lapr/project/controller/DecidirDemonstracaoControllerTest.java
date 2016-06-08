/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Demonstracao;
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
public class DecidirDemonstracaoControllerTest {
    
    public DecidirDemonstracaoControllerTest() {
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
     * Test of getDecisoesTemp method, of class DecidirDemonstracaoController.
     */
    @Test
    public void testGetDecisoesTemp() {
        System.out.println("getDecisoesTemp");
        DecidirDemonstracaoController instance = null;
        boolean[] expResult = null;
        boolean[] result = instance.getDecisoesTemp();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposOrganizador method, of class DecidirDemonstracaoController.
     */
    @Test
    public void testGetListaExposOrganizador() {
        System.out.println("getListaExposOrganizador");
        DecidirDemonstracaoController instance = null;
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getListaExposOrganizador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExposicao method, of class DecidirDemonstracaoController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao e = null;
        DecidirDemonstracaoController instance = null;
        List<Demonstracao> expResult = null;
        List<Demonstracao> result = instance.setExposicao(e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registarDecisoes method, of class DecidirDemonstracaoController.
     */
    @Test
    public void testRegistarDecisoes() {
        System.out.println("registarDecisoes");
        DecidirDemonstracaoController instance = null;
        instance.registarDecisoes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
