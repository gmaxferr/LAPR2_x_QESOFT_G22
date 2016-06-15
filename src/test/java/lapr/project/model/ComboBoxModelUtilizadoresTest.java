/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.ui.ComboBoxModelUtilizadores;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author guima
 */
public class ComboBoxModelUtilizadoresTest {
    
    public ComboBoxModelUtilizadoresTest() {
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
     * Test of getSize method, of class ComboBoxModelUtilizadores.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        ComboBoxModelUtilizadores instance = null;
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getElementAt method, of class ComboBoxModelUtilizadores.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int index = 0;
        ComboBoxModelUtilizadores instance = null;
        Object expResult = null;
        Object result = instance.getElementAt(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSelectedItem method, of class ComboBoxModelUtilizadores.
     */
    @Test
    public void testSetSelectedItem() {
        System.out.println("setSelectedItem");
        Object anItem = null;
        ComboBoxModelUtilizadores instance = null;
        instance.setSelectedItem(anItem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelectedItem method, of class ComboBoxModelUtilizadores.
     */
    @Test
    public void testGetSelectedItem() {
        System.out.println("getSelectedItem");
        ComboBoxModelUtilizadores instance = null;
        Object expResult = null;
        Object result = instance.getSelectedItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
