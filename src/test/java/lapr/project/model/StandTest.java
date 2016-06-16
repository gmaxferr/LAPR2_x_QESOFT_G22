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
public class StandTest {

    public StandTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    
    private Stand instance;
    private String ID;
    private int area;
    
    @Before
    public void setUp() {
        ID = "id";
        area = 10;
        instance = new Stand(ID, area);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getID method, of class Stand.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");

        String expResult = ID;
        String result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setID method, of class Stand.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        String ID = "novoID";
        instance.setID(ID);
    }

    /**
     * Test of getArea method, of class Stand.
     */
    @Test
    public void testGetArea() {
        System.out.println("getArea");

        int expResult = area;
        int result = instance.getArea();
        assertEquals(expResult, result);
    }

    /**
     * Test of setM_area method, of class Stand.
     */
    @Test
    public void testSetM_area() {
        System.out.println("setM_area");
        int area = 15;

        instance.setM_area(area);
    }

    /**
     * Test of equals method, of class Stand.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Stand s = new Stand(ID, area);
        Object obj = s;

        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
                
        s = new Stand(ID, (area-1));
        expResult = false;
        obj = s;
        result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Stand.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");

        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of importContentFromXMLNode method, of class Stand.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;

        Stand expResult = null;
        Stand result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class Stand.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");

        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
    }

}
