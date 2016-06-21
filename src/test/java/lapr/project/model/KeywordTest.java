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
public class KeywordTest {

    public KeywordTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private Keyword instance;
    private String strKey;

    @Before
    public void setUp() {

        strKey = "key";
        instance = new Keyword(strKey);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getValue method, of class Keyword.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        String expResult = strKey;
        String result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of setValue method, of class Keyword.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        String keyword = "something";
        instance.setValue(keyword);
    }

    /**
     * Test of equals method, of class Keyword.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Keyword instance2 = new Keyword("something");
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        Keyword instance3 = new Keyword(strKey);
        expResult = true;
        result = instance.equals(instance3);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Keyword.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        int expResult = new Keyword(strKey).hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of importContentFromXMLNode method, of class Keyword.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        Keyword instance = new Keyword();
        Keyword expResult = null;
        Keyword result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class Keyword.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Keyword instance = new Keyword();
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
