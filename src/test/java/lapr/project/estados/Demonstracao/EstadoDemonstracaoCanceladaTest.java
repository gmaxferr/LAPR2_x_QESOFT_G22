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
public class EstadoDemonstracaoCanceladaTest {
    
    private Demonstracao d;
    private EstadoDemonstracaoCancelada instance;
    private String descricao;
    
    public EstadoDemonstracaoCanceladaTest() {
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
        instance = new EstadoDemonstracaoCancelada(d);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoDemonstracaoCancelada method, of class 
     * EstadoDemonstracaoCancelada.
     */
    @Test
    public void testSetEstadoDemonstracaoCancelada() {
        System.out.println("setEstadoDemonstracaoCancelada");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoCancelada();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoCancelada method, of class 
     * EstadoDemonstracaoCancelada.
     */
    @Test
    public void testIsEstadoDemonstracaoCancelada() {
        System.out.println("isEstadoDemonstracaoCancelada");
        boolean expResult = true;
        boolean result = instance.isEstadoDemonstracaoCancelada();
        assertEquals(expResult, result);
    }
    
}
