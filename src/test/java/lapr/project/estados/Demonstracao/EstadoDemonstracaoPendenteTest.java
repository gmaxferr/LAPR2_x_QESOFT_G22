package lapr.project.estados.Demonstracao;

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
public class EstadoDemonstracaoPendenteTest {
    
    private Demonstracao d;
    private EstadoDemonstracaoPendente instance;
    private String descricao;
    
    public EstadoDemonstracaoPendenteTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        d = new Demonstracao(descricao);
        d.setEstado(instance);
        instance = new EstadoDemonstracaoPendente(d);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoDemonstracaoPendente method, of 
     * class EstadoDemonstracaoPendente.
     */
    @Test
    public void testSetEstadoDemonstracaoPendente() {
        System.out.println("setEstadoDemonstracaoPendente");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoPendente();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemonstracaoConfirmada method, of 
     * class EstadoDemonstracaoPendente.
     */
    @Test
    public void testSetEstadoDemonstracaoConfirmada() {
        System.out.println("setEstadoDemonstracaoConfirmada");
        boolean expResult = true;
        boolean result = instance.setEstadoDemonstracaoConfirmada();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemonstracaoCancelada method, of 
     * class EstadoDemonstracaoPendente.
     */
    @Test
    public void testSetEstadoDemonstracaoCancelada() {
        System.out.println("setEstadoDemonstracaoCancelada");
        boolean expResult = true;
        boolean result = instance.setEstadoDemonstracaoCancelada();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoPendente method, of 
     * class EstadoDemonstracaoPendente.
     */
    @Test
    public void testIsEstadoDemonstracaoPendente() {
        System.out.println("isEstadoDemonstracaoPendente");
        boolean expResult = true;
        boolean result = instance.isEstadoDemonstracaoPendente();
        assertEquals(expResult, result);
    }
    
}
