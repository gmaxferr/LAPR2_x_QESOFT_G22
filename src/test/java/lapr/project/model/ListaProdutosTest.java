/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Catalao
 */
public class ListaProdutosTest {
    
    public ListaProdutosTest() {
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
     * Test of getListaProdutos method, of class ListaProdutos.
     */
    @Test
    public void testGetListaProdutos() {
        System.out.println("getListaProdutos");
        ListaProdutos instance = new ListaProdutos();
        List<Produto> expResult = null;
        List<Produto> result = instance.getListaProdutos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class ListaProdutos.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        ListaProdutos instance = new ListaProdutos();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProdutoAt method, of class ListaProdutos.
     */
    @Test
    public void testGetProdutoAt() {
        System.out.println("getProdutoAt");
        int index = 0;
        ListaProdutos instance = new ListaProdutos();
        Produto expResult = null;
        Produto result = instance.getProdutoAt(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProduto method, of class ListaProdutos.
     */
    @Test
    public void testAddProduto() {
        System.out.println("addProduto");
        String nome = "";
        ListaProdutos instance = new ListaProdutos();
        boolean expResult = false;
        boolean result = instance.addProduto(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeProduto method, of class ListaProdutos.
     */
    @Test
    public void testRemoveProduto() {
        System.out.println("removeProduto");
        String nome = "";
        ListaProdutos instance = new ListaProdutos();
        int expResult = 0;
        int result = instance.removeProduto(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
