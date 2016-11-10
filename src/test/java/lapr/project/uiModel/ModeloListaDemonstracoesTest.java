package lapr.project.uiModel;

import java.util.List;
import lapr.project.model.Demonstracao;
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
public class ModeloListaDemonstracoesTest {
    
    public ModeloListaDemonstracoesTest() {
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
     * Test of getListaDemonstracoesAdicionadas method, of class ModeloListaDemonstracoes.
     */
    @Test
    public void testGetListaDemonstracoesAdicionadas() {
        System.out.println("getListaDemonstracoesAdicionadas");
        ModeloListaDemonstracoes instance = null;
        List<Demonstracao> expResult = null;
        List<Demonstracao> result = instance.getListaDemonstracoesAdicionadas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class ModeloListaDemonstracoes.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        ModeloListaDemonstracoes instance = null;
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getElementAt method, of class ModeloListaDemonstracoes.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int index = 0;
        ModeloListaDemonstracoes instance = null;
        Object expResult = null;
        Object result = instance.getElementAt(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionaDemonstracao method, of class ModeloListaDemonstracoes.
     */
    @Test
    public void testAdicionaDemonstracao() {
        System.out.println("adicionaDemonstracao");
        Demonstracao demonstracao = null;
        ModeloListaDemonstracoes instance = null;
        boolean expResult = false;
        boolean result = instance.adicionaDemonstracao(demonstracao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeDemonstracao method, of class ModeloListaDemonstracoes.
     */
    @Test
    public void testRemoveDemonstracao() {
        System.out.println("removeDemonstracao");
        String codigoIdentificacao = "";
        ModeloListaDemonstracoes instance = null;
        instance.removeDemonstracao(codigoIdentificacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
