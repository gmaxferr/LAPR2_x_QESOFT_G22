/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.Produto;
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
public class RegistoProdutosTest {
    
    private RegistoProdutos instance;
    private Produto prod1;
    private Produto prod2;
    private Produto prod3;
    
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
        instance = new RegistoProdutos();
        prod1 = new Produto("prod1");
        prod2 = new Produto("prod2");
        prod3 = new Produto("prod3");
        instance.addProduto(prod1);
        instance.addProduto(prod2);
        instance.addProduto(prod3);
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
        List<Produto> expResult = new ArrayList<>();
        expResult.add(prod1);
        expResult.add(prod2);
        expResult.add(prod3);
        List<Produto> result = instance.getListaProdutosAExpor();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class RegistoProdutos.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "prod1%nprod2%nprod3%n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of criarProduto method, of class RegistoProdutos.
     */
    @Test
    public void testCriarProduto() {
        System.out.println("criarProduto");
        String nome = "novoProd";
        Produto expResult = new Produto(nome);
        Produto result = instance.criarProduto(nome);
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionaProduto method, of class RegistoProdutos.
     */
    @Test
    public void testAdicionaProduto() {
        System.out.println("adicionaProduto");
        Produto produto = new Produto("prod1");
        boolean expResult = false;
        boolean result = instance.adicionaProduto(produto);
        assertEquals(expResult, result);

        produto = new Produto("prod4");
        expResult = true;
        result = instance.adicionaProduto(produto);
        assertEquals(expResult, result);
    }

    /**
     * Test of addProduto method, of class RegistoProdutos.
     */
    @Test
    public void testAddProduto() {
        System.out.println("addProduto");
        Produto p = new Produto("prod4");
        instance.addProduto(p);
        
        List<Produto> expResult = new ArrayList<>();
        expResult.add(prod1);
        expResult.add(prod2);
        expResult.add(prod3);
        expResult.add(p);
        List<Produto> result = instance.getListaProdutosAExpor();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of validarDadosRepetidosOuInvalidos method, of class RegistoProdutos.
     */
    @Test
    public void testValidarDadosRepetidosOuInvalidos() {
        System.out.println("validarDadosRepetidosOuInvalidos");
        boolean expResult = true;
        boolean result = instance.validarDadosRepetidosOuInvalidos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setListaProdutos method, of class RegistoProdutos.
     */
    @Test
    public void testSetListaProdutos() {
        System.out.println("setListaProdutos");
        List<Produto> listaProdutos = new ArrayList<>();
        listaProdutos.add(new Produto("prod4"));
        listaProdutos.add(new Produto("prod5"));
        instance.setListaProdutos(listaProdutos);

        List<Produto> expResult = new ArrayList<>();
        expResult.add(new Produto("prod4"));
        expResult.add(new Produto("prod5"));
        List<Produto> result = instance.getListaProdutosAExpor();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class RegistoProdutos.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        RegistoProdutos obj = new RegistoProdutos();
        obj.addProduto(prod1);
        obj.addProduto(prod2);
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);

        obj.addProduto(prod3);
        expResult = true;
        result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class RegistoProdutos.
     */
    @Test
    public void testHashCode() {
        RegistoProdutos obj = new RegistoProdutos();
        obj.addProduto(prod1);
        obj.addProduto(prod2);
        obj.addProduto(prod3);
        int expResult = obj.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of importContentFromXMLNode method, of class RegistoProdutos.
     */
    @Test
    public void testImportContentFromXMLNode() throws Exception {
        System.out.println("importContentFromXMLNode");
        Node node = instance.exportContentToXMLNode();
        RegistoProdutos expResult = instance;
        RegistoProdutos result = new RegistoProdutos();
        try {
            result.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            result = null;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class RegistoProdutos.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Node node = instance.exportContentToXMLNode();
        RegistoProdutos expResult = instance;
        RegistoProdutos result = new RegistoProdutos();
        try {
            result.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            result = null;
        }
        assertEquals(expResult, result);
    }
    
}
