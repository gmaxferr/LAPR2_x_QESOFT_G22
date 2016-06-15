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
public class OrganizadorTest {
    
    public OrganizadorTest() {
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
     * Test of getUtilizador method, of class Organizador.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        Organizador instance = new Organizador();
        Utilizador expResult = null;
        Utilizador result = instance.getUtilizador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUtilizador method, of class Organizador.
     */
    @Test
    public void testSetUtilizador() {
        System.out.println("setUtilizador");
        Utilizador u = null;
        Organizador instance = new Organizador();
        instance.setUtilizador(u);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsernameOrganizador method, of class Organizador.
     */
    @Test
    public void testGetUsernameOrganizador() {
        System.out.println("getUsernameOrganizador");
        Organizador instance = new Organizador();
        String expResult = "";
        String result = instance.getUsernameOrganizador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Organizador.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Organizador instance = new Organizador();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importContentFromXMLNode method, of class Organizador.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        Organizador instance = new Organizador();
        Organizador expResult = null;
        Organizador result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class Organizador.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Organizador instance = new Organizador();
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
