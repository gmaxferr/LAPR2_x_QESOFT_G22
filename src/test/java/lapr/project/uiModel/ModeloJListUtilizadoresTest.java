package lapr.project.uiModel;

import java.util.List;
import lapr.project.model.Utilizador;
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
public class ModeloJListUtilizadoresTest {
    
    public ModeloJListUtilizadoresTest() {
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
     * Test of adicionarUtilizador method, of class ModeloJListUtilizadores.
     */
    @Test
    public void testAdicionarUtilizador() {
        System.out.println("adicionarUtilizador");
        Utilizador utilizadorNovo = null;
        ModeloJListUtilizadores instance = new ModeloJListUtilizadores();
        instance.adicionarUtilizador(utilizadorNovo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removerUtilizador method, of class ModeloJListUtilizadores.
     */
    @Test
    public void testRemoverUtilizador() {
        System.out.println("removerUtilizador");
        Utilizador utilizador = null;
        int index = 0;
        ModeloJListUtilizadores instance = new ModeloJListUtilizadores();
        instance.removerUtilizador(utilizador, index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setList method, of class ModeloJListUtilizadores.
     */
    @Test
    public void testSetList() {
        System.out.println("setList");
        List<Utilizador> listaUtilizadores = null;
        ModeloJListUtilizadores instance = new ModeloJListUtilizadores();
        instance.setList(listaUtilizadores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaDeUtilizadoresAdicionados method, of class ModeloJListUtilizadores.
     */
    @Test
    public void testGetListaDeUtilizadoresAdicionados() {
        System.out.println("getListaDeUtilizadoresAdicionados");
        ModeloJListUtilizadores instance = new ModeloJListUtilizadores();
        List<Utilizador> expResult = null;
        List<Utilizador> result = instance.getListaDeUtilizadoresAdicionados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSize method, of class ModeloJListUtilizadores.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        ModeloJListUtilizadores instance = new ModeloJListUtilizadores();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getElementAt method, of class ModeloJListUtilizadores.
     */
    @Test
    public void testGetElementAt() {
        System.out.println("getElementAt");
        int index = 0;
        ModeloJListUtilizadores instance = new ModeloJListUtilizadores();
        Object expResult = null;
        Object result = instance.getElementAt(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
