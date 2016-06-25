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
public class EstadoDemonstracaoCandidaturasAvaliadasTest {
    
    
    private Demonstracao d;
    private EstadoDemonstracaoCandidaturasAvaliadas instance;
    private String descricao;
    
    public EstadoDemonstracaoCandidaturasAvaliadasTest() {
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
        instance = new EstadoDemonstracaoCandidaturasAvaliadas(d);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoDemonstracaoCandidaturasAvaliadas method, 
     * of class EstadoDemonstracaoCandidaturasAvaliadas.
     */
    @Test
    public void testSetEstadoDemonstracaoCandidaturasAvaliadas() {
        System.out.println("setEstadoDemonstracaoCandidaturasAvaliadas");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoCandidaturasAvaliadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemonstracaoCandidaturasDecididas method, 
     * of class EstadoDemonstracaoCandidaturasAvaliadas.
     */
    @Test
    public void testSetEstadoDemonstracaoCandidaturasDecididas() {
        System.out.println("setEstadoDemonstracaoCandidaturasDecididas");
        boolean expResult = true;
        boolean result = instance.setEstadoDemonstracaoCandidaturasDecididas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoCandidaturasAvaliadas method, 
     * of class EstadoDemonstracaoCandidaturasAvaliadas.
     */
    @Test
    public void testIsEstadoDemonstracaoCandidaturasAvaliadas() {
        System.out.println("isEstadoDemonstracaoCandidaturasAvaliadas");
        boolean expResult = true;
        boolean result = instance.isEstadoDemonstracaoCandidaturasAvaliadas();
        assertEquals(expResult, result);
    }
    
}
