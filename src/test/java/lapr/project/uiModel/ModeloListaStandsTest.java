/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.uiModel;

import lapr.project.uiModel.ModeloListaStands;
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
public class ModeloListaStandsTest {
    
    public ModeloListaStandsTest() {
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
     * Test of getSize method, of class ModeloListaStands.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        ModeloListaStands instance = null;
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getElementAt method, of class ModeloListaStands.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int index = 0;
        ModeloListaStands instance = null;
        Object expResult = null;
        Object result = instance.getElementAt(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
