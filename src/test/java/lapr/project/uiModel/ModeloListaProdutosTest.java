/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.uiModel;

import lapr.project.uiModel.ModeloListaProdutos;
import java.util.List;
import lapr.project.model.Produto;
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
public class ModeloListaProdutosTest {
    
    public ModeloListaProdutosTest() {
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
     * Test of getSize method, of class ModeloListaProdutos.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        ModeloListaProdutos instance = new ModeloListaProdutos();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getElementAt method, of class ModeloListaProdutos.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int index = 0;
        ModeloListaProdutos instance = new ModeloListaProdutos();
        Object expResult = null;
        Object result = instance.getElementAt(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProduto method, of class ModeloListaProdutos.
     */
    @Test
    public void testAddProduto() {
        System.out.println("addProduto");
        String nome = "";
        ModeloListaProdutos instance = new ModeloListaProdutos();
        boolean expResult = false;
        boolean result = instance.addProduto(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeProduto method, of class ModeloListaProdutos.
     */
    @Test
    public void testRemoveProduto() {
        System.out.println("removeProduto");
        String nome = "";
        ModeloListaProdutos instance = new ModeloListaProdutos();
        instance.removeProduto(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaProdutos method, of class ModeloListaProdutos.
     */
    @Test
    public void testGetListaProdutos() {
        System.out.println("getListaProdutos");
        ModeloListaProdutos instance = new ModeloListaProdutos();
        List<Produto> expResult = null;
        List<Produto> result = instance.getListaProdutos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
