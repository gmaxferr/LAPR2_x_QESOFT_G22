/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.AtribuicaoStand;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.Exposicao;
import lapr.project.model.Stand;
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
public class AtribuirStandsControllerTest {
    
    public AtribuirStandsControllerTest() {
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
     * Test of getListaExposicoes method, of class AtribuirStandsController.
     */
    @Test
    public void testGetListaExposicoes() {
        System.out.println("getListaExposicoes");
        AtribuirStandsController instance = null;
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getListaExposicoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of select method, of class AtribuirStandsController.
     */
    @Test
    public void testSelect() {
        System.out.println("select");
        Exposicao expo = null;
        AtribuirStandsController instance = null;
        instance.select(expo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaCand method, of class AtribuirStandsController.
     */
    @Test
    public void testGetListaCand() {
        System.out.println("getListaCand");
        AtribuirStandsController instance = null;
        List<CandidaturaAExposicao> expResult = null;
        List<CandidaturaAExposicao> result = instance.getListaCand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaStands method, of class AtribuirStandsController.
     */
    @Test
    public void testGetListaStands() {
        System.out.println("getListaStands");
        AtribuirStandsController instance = null;
        List<Stand> expResult = null;
        List<Stand> result = instance.getListaStands();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAtribuicoes method, of class AtribuirStandsController.
     */
    @Test
    public void testSetAtribuicoes() {
        System.out.println("setAtribuicoes");
        List<AtribuicaoStand> listAtr = null;
        AtribuirStandsController instance = null;
        instance.setAtribuicoes(listAtr);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirm method, of class AtribuirStandsController.
     */
    @Test
    public void testConfirm() {
        System.out.println("confirm");
        AtribuirStandsController instance = null;
        instance.confirm();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
