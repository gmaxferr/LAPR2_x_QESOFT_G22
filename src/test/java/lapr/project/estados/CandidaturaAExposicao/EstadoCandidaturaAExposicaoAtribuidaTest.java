package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.Expositor;
import lapr.project.model.Utilizador;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ana
 */
public class EstadoCandidaturaAExposicaoAtribuidaTest {

    public EstadoCandidaturaAExposicaoAtribuidaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private CandidaturaAExposicao m_cand;
    private EstadoCandidaturaAExposicao instance;

    @Before
    public void setUp() {
        Utilizador utilizador = new Utilizador("pedro", "pedro", new char[]{'a', '.', '2', 'f'}, "aaa@dd.com");
        Expositor expositor = new Expositor(utilizador);
        m_cand = new CandidaturaAExposicao(expositor);
        instance = new EstadoCandidaturaAExposicaoAtribuida(m_cand);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturaAtribuida method, of class
     * EstadoCandidaturaAExposicaoAtribuida.
     */
    @Test
    public void testSetEstadoCandidaturaAtribuida() {
        System.out.println("setEstadoCandidaturaAtribuida");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaAtribuida();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaAvaliada method, of class
     * EstadoCandidaturaAExposicaoAtribuida.
     */
    @Test
    public void testSetEstadoCandidaturaAvaliada() {
        System.out.println("setEstadoCandidaturaAvaliada");
        boolean expResult = true;
        boolean result = instance.setEstadoCandidaturaAvaliada();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaAtribuida method, of class
     * EstadoCandidaturaAExposicaoAtribuida.
     */
    @Test
    public void testIsEstadoCandidaturaAtribuida() {
        System.out.println("isEstadoCandidaturaAtribuida");
        boolean expResult = true;
        boolean result = instance.isEstadoCandidaturaAtribuida();
        assertEquals(expResult, result);
    }

}
