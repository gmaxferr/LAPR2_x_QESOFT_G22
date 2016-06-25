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
public class EstadoDemonstracaoCandidaturasAtribuidasTest {
    
    private Demonstracao d;
    private EstadoDemonstracaoCandidaturasAtribuidas instance;
    private String descricao;
    
    public EstadoDemonstracaoCandidaturasAtribuidasTest() {
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
        instance = new EstadoDemonstracaoCandidaturasAtribuidas(d);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoDemonstracaoCandidaturasAtribuidas method, 
     * of class EstadoDemonstracaoCandidaturasAtribuidas.
     */
    @Test
    public void testSetEstadoDemonstracaoCandidaturasAtribuidas() {
        System.out.println("setEstadoDemonstracaoCandidaturasAtribuidas");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoCandidaturasAtribuidas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemonstracaoCandidaturasAvaliadas method, 
     * of class EstadoDemonstracaoCandidaturasAtribuidas.
     */
    @Test
    public void testSetEstadoDemonstracaoCandidaturasAvaliadas() {
        System.out.println("setEstadoDemonstracaoCandidaturasAvaliadas");
        boolean expResult = true;
        boolean result = instance.setEstadoDemonstracaoCandidaturasAvaliadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoCandidaturasAtribuidas method, 
     * of class EstadoDemonstracaoCandidaturasAtribuidas.
     */
    @Test
    public void testIsEstadoDemonstracaoCandidaturasAtribuidas() {
        System.out.println("isEstadoDemonstracaoCandidaturasAtribuidas");
        boolean expResult = true;
        boolean result = instance.isEstadoDemonstracaoCandidaturasAtribuidas();
        assertEquals(expResult, result);
    }
    
}
