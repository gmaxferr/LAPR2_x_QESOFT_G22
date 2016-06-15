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
import org.w3c.dom.Node;

/**
 *
 * @author guima
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

    /**
     * Test of importContentFromXMLNode method, of class Decisao.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        Decisao instance = new Decisao();
        Decisao expResult = null;
        Decisao result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class Decisao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Decisao instance = new Decisao();
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
