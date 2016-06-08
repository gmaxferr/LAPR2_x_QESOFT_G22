/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

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
 * @author Ricardo Catalao
 */
public class RegistoProdutosTest {
    
    public RegistoProdutosTest() {
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
     * Test of getListaProdutosAExpor method, of class RegistoProdutos.
     */
    @Test
    public void testGetListaProdutosAExpor() {
        System.out.println("getListaProdutosAExpor");
        RegistoProdutos instance = new RegistoProdutos();
        List<Produto> expResult = null;
        List<Produto> result = instance.getListaProdutosAExpor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class RegistoProdutos.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        RegistoProdutos instance = new RegistoProdutos();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of criarProduto method, of class RegistoProdutos.
     */
    @Test
    public void testCriarProduto() {
        System.out.println("criarProduto");
        String nome = "";
        RegistoProdutos instance = new RegistoProdutos();
        Produto expResult = null;
        Produto result = instance.criarProduto(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionaProduto method, of class RegistoProdutos.
     */
    @Test
    public void testAdicionaProduto() {
        System.out.println("adicionaProduto");
        Produto produto = null;
        RegistoProdutos instance = new RegistoProdutos();
        boolean expResult = false;
        boolean result = instance.adicionaProduto(produto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProduto method, of class RegistoProdutos.
     */
    @Test
    public void testAddProduto() {
        System.out.println("addProduto");
        Produto p = null;
        RegistoProdutos instance = new RegistoProdutos();
        instance.addProduto(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaProduto method, of class RegistoProdutos.
     */
    @Test
    public void testValidaProduto() {
        System.out.println("validaProduto");
        Produto produto = null;
        RegistoProdutos instance = new RegistoProdutos();
        boolean expResult = false;
        boolean result = instance.validaProduto(produto);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarDadosRepetidosOuInvalidos method, of class RegistoProdutos.
     */
    @Test
    public void testValidarDadosRepetidosOuInvalidos() {
        System.out.println("validarDadosRepetidosOuInvalidos");
        RegistoProdutos instance = new RegistoProdutos();
        boolean expResult = false;
        boolean result = instance.validarDadosRepetidosOuInvalidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaProdutos method, of class RegistoProdutos.
     */
    @Test
    public void testSetListaProdutos() {
        System.out.println("setListaProdutos");
        List<Produto> listaProdutos = null;
        RegistoProdutos instance = new RegistoProdutos();
        instance.setListaProdutos(listaProdutos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class RegistoProdutos.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        RegistoProdutos instance = new RegistoProdutos();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
