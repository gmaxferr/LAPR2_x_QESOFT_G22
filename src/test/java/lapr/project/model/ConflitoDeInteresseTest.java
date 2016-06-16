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
public class ConflitoDeInteresseTest {
    
    public ConflitoDeInteresseTest() {
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
     * Test of getFae method, of class ConflitoDeInteresse.
     */
    @Test
    public void testGetFae() {
        System.out.println("getFae");
        ConflitoDeInteresse instance = null;
        FAE expResult = null;
        FAE result = instance.getFae();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCandidatura method, of class ConflitoDeInteresse.
     */
    @Test
    public void testGetCandidatura() {
        System.out.println("getCandidatura");
        ConflitoDeInteresse instance = null;
        CandidaturaAExposicao expResult = null;
        CandidaturaAExposicao result = instance.getCandidatura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class ConflitoDeInteresse.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        ConflitoDeInteresse instance = null;
        TipoConflito expResult = null;
        TipoConflito result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importContentFromXMLNode method, of class ConflitoDeInteresse.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        ConflitoDeInteresse instance = null;
        ConflitoDeInteresse expResult = null;
        ConflitoDeInteresse result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class ConflitoDeInteresse.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        ConflitoDeInteresse instance = null;
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
