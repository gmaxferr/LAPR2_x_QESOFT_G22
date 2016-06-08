/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

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
public class AtribuicaoStandTest {
    
    public AtribuicaoStandTest() {
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
     * Test of getStand method, of class AtribuicaoStand.
     */
    @Test
    public void testGetStand() {
        System.out.println("getStand");
        AtribuicaoStand instance = null;
        Stand expResult = null;
        Stand result = instance.getStand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStand method, of class AtribuicaoStand.
     */
    @Test
    public void testSetStand() {
        System.out.println("setStand");
        Stand stand = null;
        AtribuicaoStand instance = null;
        instance.setStand(stand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCand method, of class AtribuicaoStand.
     */
    @Test
    public void testGetCand() {
        System.out.println("getCand");
        AtribuicaoStand instance = null;
        CandidaturaAExposicao expResult = null;
        CandidaturaAExposicao result = instance.getCand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCand method, of class AtribuicaoStand.
     */
    @Test
    public void testSetCand() {
        System.out.println("setCand");
        CandidaturaAExposicao cand = null;
        AtribuicaoStand instance = null;
        instance.setCand(cand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
