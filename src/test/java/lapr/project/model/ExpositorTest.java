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
 * @author Ricardo Catalao
 */
public class ExpositorTest {
    
    public ExpositorTest() {
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
     * Test of getM_strUsername method, of class Expositor.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getM_strUsername");
        Utilizador u = new Utilizador("", "us3r", "".toCharArray(), "");
        Expositor instance = new Expositor(u);
        String expResult = "us3r";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Expositor.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Expositor instance = null;
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUtilizador method, of class Expositor.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        Expositor instance = null;
        Utilizador expResult = null;
        Utilizador result = instance.getUtilizador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUtilizador method, of class Expositor.
     */
    @Test
    public void testSetUtilizador() {
        System.out.println("setUtilizador");
        Utilizador m_utilizador = null;
        Expositor instance = null;
        instance.setUtilizador(m_utilizador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importContentFromXMLNode method, of class Expositor.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        Expositor instance = null;
        Expositor expResult = null;
        Expositor result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class Expositor.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Expositor instance = null;
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
