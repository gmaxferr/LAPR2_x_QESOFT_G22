package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author G29
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

    private ListaProdutos instance;
    private String prod1;
    private String prod2;
    private final int size = 2;

    @Before
    public void setUp() {
        prod1 = "prod1";
        prod2 = "prod2";
        instance = new ListaProdutos();
        instance.addProduto(prod1);
        instance.addProduto(prod2);
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
        List<Produto> expResult = new ArrayList<Produto>();
        expResult.add(new Produto(prod1));
        expResult.add(new Produto(prod2));
        List<Produto> result = instance.getListaProdutos();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSize method, of class ListaProdutos.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        int expResult = 2;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProdutoAt method, of class ListaProdutos.
     */
    @Test
    public void testGetProdutoAt() {
        System.out.println("getProdutoAt");
        int index = 0;
        Produto expResult = new Produto(prod1);
        Produto result = instance.getProdutoAt(index);
        assertEquals(expResult, result);
    }

    /**
     * Test of addProduto method, of class ListaProdutos.
     */
    @Test
    public void testAddProduto() {
        System.out.println("addProduto");
        String nome = "prod3";
        boolean expResult = true;
        boolean result = instance.addProduto(nome);
        assertEquals(expResult, result);
        String nome2 = "prod1";
        boolean expResult2 = false;
        boolean result2 = instance.addProduto(nome2);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of removeProduto method, of class ListaProdutos.
     */
    @Test
    public void testRemoveProduto() {
        System.out.println("removeProduto");
        String nome = prod1;
        int expResult = 0;
        int result = instance.removeProduto(nome);
        assertEquals(expResult, result);
    }

}
