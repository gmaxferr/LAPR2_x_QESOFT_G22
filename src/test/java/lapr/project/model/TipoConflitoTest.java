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
public class TipoConflitoTest {
    
    public TipoConflitoTest() {
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
     * Test of setDadosTipoConflito method, of class TipoConflito.
     */
    @Test
    public void testSetDadosTipoConflito() {
        System.out.println("setDadosTipoConflito");
        TipoConflito instance = null;
        instance.setDadosTipoConflito();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMecanismoDetecaoConflito method, of class TipoConflito.
     */
    @Test
    public void testGetMecanismoDetecaoConflito() {
        System.out.println("getMecanismoDetecaoConflito");
        TipoConflito instance = null;
        MecanismoDetecaoConflito expResult = null;
        MecanismoDetecaoConflito result = instance.getMecanismoDetecaoConflito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importContentFromXMLNode method, of class TipoConflito.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        TipoConflito instance = null;
        TipoConflito expResult = null;
        TipoConflito result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class TipoConflito.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        TipoConflito instance = null;
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
