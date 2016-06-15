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
public class LocalTest {
    
    public LocalTest() {
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
     * Test of getMorada method, of class Local.
     */
    @Test
    public void testGetMorada() {
        System.out.println("getMorada");
        Local instance = null;
        String expResult = "";
        String result = instance.getMorada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMorada method, of class Local.
     */
    @Test
    public void testSetMorada() {
        System.out.println("setMorada");
        String nomeLocal = "";
        Local instance = null;
        instance.setMorada(nomeLocal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importContentFromXMLNode method, of class Local.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        Local instance = null;
        Local expResult = null;
        Local result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class Local.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Local instance = null;
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
