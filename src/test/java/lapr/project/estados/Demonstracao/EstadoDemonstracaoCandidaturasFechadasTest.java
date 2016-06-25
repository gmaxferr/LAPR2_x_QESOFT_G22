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
public class EstadoDemonstracaoCandidaturasFechadasTest {

    private Demonstracao d;
    private EstadoDemonstracaoCandidaturasFechadas instance;
    private String descricao;

    public EstadoDemonstracaoCandidaturasFechadasTest() {
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
        instance = new EstadoDemonstracaoCandidaturasFechadas(d);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoDemonstracaoCandidaturasFechadas method, of class
     * EstadoDemonstracaoCandidaturasFechadas.
     */
    @Test
    public void testSetEstadoDemonstracaoCandidaturasFechadas() {
        System.out.println("setEstadoDemonstracaoCandidaturasFechadas");
        boolean expResult = false;
        boolean result = instance.setEstadoDemonstracaoCandidaturasFechadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemonstracaoCandidaturasAtribuidas method, of class
     * EstadoDemonstracaoCandidaturasFechadas.
     */
    @Test
    public void testSetEstadoDemonstracaoCandidaturasAtribuidas() {
        System.out.println("setEstadoDemonstracaoCandidaturasAtribuidas");
        boolean expResult = true;
        boolean result = instance.setEstadoDemonstracaoCandidaturasAtribuidas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemonstracaoCandidaturasFechadas method, of class
     * EstadoDemonstracaoCandidaturasFechadas.
     */
    @Test
    public void testIsEstadoDemonstracaoCandidaturasFechadas() {
        System.out.println("isEstadoDemonstracaoCandidaturasFechadas");
        boolean expResult = true;
        boolean result = instance.isEstadoDemonstracaoCandidaturasFechadas();
        assertEquals(expResult, result);
    }

}
