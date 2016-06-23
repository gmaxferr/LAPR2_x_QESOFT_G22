/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.uiModel;

import lapr.project.uiModel.ComboBoxModelTipoDeConflitoDemonstracao;
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
public class ComboBoxModelTipoDeConflitoDemonstracaoTest {
    
    public ComboBoxModelTipoDeConflitoDemonstracaoTest() {
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
     * Test of getSize method, of class ComboBoxModelTipoDeConflitoDemonstracao.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        ComboBoxModelTipoDeConflitoDemonstracao instance = null;
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getElementAt method, of class ComboBoxModelTipoDeConflitoDemonstracao.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int index = 0;
        ComboBoxModelTipoDeConflitoDemonstracao instance = null;
        Object expResult = null;
        Object result = instance.getElementAt(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSelectedItem method, of class ComboBoxModelTipoDeConflitoDemonstracao.
     */
    @Test
    public void testSetSelectedItem() {
        System.out.println("setSelectedItem");
        Object anItem = null;
        ComboBoxModelTipoDeConflitoDemonstracao instance = null;
        instance.setSelectedItem(anItem);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSelectedItem method, of class ComboBoxModelTipoDeConflitoDemonstracao.
     */
    @Test
    public void testGetSelectedItem() {
        System.out.println("getSelectedItem");
        ComboBoxModelTipoDeConflitoDemonstracao instance = null;
        Object expResult = null;
        Object result = instance.getSelectedItem();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
