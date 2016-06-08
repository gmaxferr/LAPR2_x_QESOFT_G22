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
public class DecisaoTest {
    
    public DecisaoTest() {
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
     * Test of setM_bDecisao method, of class Decisao.
     */
    @Test
    public void testSetM_bDecisao() {
        System.out.println("setM_bDecisao");
        boolean decisao = false;
        Decisao instance = new Decisao();
        instance.setM_bDecisao(decisao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getM_bDecisao method, of class Decisao.
     */
    @Test
    public void testGetM_bDecisao() {
        System.out.println("getM_bDecisao");
        Decisao instance = new Decisao();
        boolean expResult = false;
        boolean result = instance.getM_bDecisao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
