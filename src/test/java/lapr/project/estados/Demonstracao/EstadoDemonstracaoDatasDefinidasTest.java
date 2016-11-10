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
public class EstadoDemonstracaoDatasDefinidasTest {
    
    private Demonstracao d;
    private EstadoDemonstracaoDatasDefinidas instance;
    private String descricao;
    
    public EstadoDemonstracaoDatasDefinidasTest() {
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
        instance = new EstadoDemonstracaoDatasDefinidas(d);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoDemonstracaoDatasDefinidas method, of 
     * class EstadoDemonstracaoDatasDefinidas.
     */
    @Test
    public void testSetEstadoDemonstracaoDatasDefinidas() {
        System.out.println("setEstadoDemonstracaoDatasDefinidas");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoDatasDefinidas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemonstracaoCandidaturasAbertas method, of 
     * class EstadoDemonstracaoDatasDefinidas.
     */
    @Test
    public void testSetEstadoDemonstracaoCandidaturasAbertas() {
        System.out.println("setEstadoDemonstracaoCandidaturasAbertas");
        boolean expResult = true;
        boolean result = instance.setEstadoDemonstracaoCandidaturasAbertas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoDatasDefinidas method, of class 
     * EstadoDemonstracaoDatasDefinidas.
     */
    @Test
    public void testIsEstadoDemonstracaoDatasDefinidas() {
        System.out.println("isEstadoDemonstracaoDatasDefinidas");
        boolean expResult = true;
        boolean result = instance.isEstadoDemonstracaoDatasDefinidas();
        assertEquals(expResult, result);
    }
    
}
