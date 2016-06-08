/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model.exemplo;

import java.util.List;
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
public class CandidaturaExampleTest {
    
    public CandidaturaExampleTest() {
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
     * Test of addKeyword method, of class CandidaturaExample.
     */
    @Test
    public void testAddKeyword() {
        System.out.println("addKeyword");
        KeywordExample keyword = null;
        CandidaturaExample instance = new CandidaturaExample();
        instance.addKeyword(keyword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKeywordList method, of class CandidaturaExample.
     */
    @Test
    public void testGetKeywordList() {
        System.out.println("getKeywordList");
        CandidaturaExample instance = new CandidaturaExample();
        List<KeywordExample> expResult = null;
        List<KeywordExample> result = instance.getKeywordList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class CandidaturaExample.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        CandidaturaExample instance = new CandidaturaExample();
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importContentFromXMLNode method, of class CandidaturaExample.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        CandidaturaExample instance = new CandidaturaExample();
        CandidaturaExample expResult = null;
        CandidaturaExample result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class CandidaturaExample.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        CandidaturaExample instance = new CandidaturaExample();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class CandidaturaExample.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        CandidaturaExample instance = new CandidaturaExample();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
