package lapr.project.model;

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
public class GestorDeExposicoesTest {
    
    public GestorDeExposicoesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private Utilizador u;
    private GestorDeExposicoes instance;
    
    @Before
    public void setUp() {
        u = new Utilizador();
        instance = new GestorDeExposicoes(u);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUtilizador method, of class GestorDeExposicoes.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        Utilizador expResult = u;
        Utilizador result = instance.getUtilizador();
        assertEquals(expResult, result);
    }
    
}
