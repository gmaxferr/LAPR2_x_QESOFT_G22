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
public class EstadoDemonstracaoConfirmadaTest {
    
    
    private Demonstracao d;
    private EstadoDemonstracaoConfirmada instance;
    private String descricao;
    
    public EstadoDemonstracaoConfirmadaTest() {
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
        instance = new EstadoDemonstracaoConfirmada(d);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoDemonstracaoConfirmada method, of class 
     * EstadoDemonstracaoConfirmada.
     */
    @Test
    public void testSetEstadoDemonstracaoConfirmada() {
        System.out.println("setEstadoDemonstracaoConfirmada");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoConfirmada();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemonstracaoDatasDefinidas method, of 
     * class EstadoDemonstracaoConfirmada.
     */
    @Test
    public void testSetEstadoDemonstracaoDatasDefinidas() {
        System.out.println("setEstadoDemonstracaoDatasDefinidas");
        boolean expResult = true;
        boolean result = instance.setEstadoDemonstracaoDatasDefinidas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoConfirmada method, of class 
     * EstadoDemonstracaoConfirmada.
     */
    @Test
    public void testIsEstadoDemonstracaoConfirmada() {
        System.out.println("isEstadoDemonstracaoConfirmada");
        boolean expResult = true;
        boolean result = instance.isEstadoDemonstracaoConfirmada();
        assertEquals(expResult, result);
    }
    
}
