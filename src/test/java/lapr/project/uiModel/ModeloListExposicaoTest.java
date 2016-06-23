/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.uiModel;

import lapr.project.uiModel.ModeloListExposicao;
import java.util.List;
import lapr.project.model.Exposicao;
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
public class ModeloListExposicaoTest {
    
    public ModeloListExposicaoTest() {
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
     * Test of add method, of class ModeloListExposicao.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        List<Exposicao> l = null;
        ModeloListExposicao instance = new ModeloListExposicao();
        instance.add(l);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class ModeloListExposicao.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        ModeloListExposicao instance = new ModeloListExposicao();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getElementAt method, of class ModeloListExposicao.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int i = 0;
        ModeloListExposicao instance = new ModeloListExposicao();
        Object expResult = null;
        Object result = instance.getElementAt(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
