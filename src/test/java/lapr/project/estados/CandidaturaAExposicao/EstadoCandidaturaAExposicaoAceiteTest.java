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
 * @author G29
 */
public class EstadoCandidaturaAExposicaoAceiteTest {

    public EstadoCandidaturaAExposicaoAceiteTest() {
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
        instance = new EstadoCandidaturaAExposicaoAceite(m_cand);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturaAceite method, of class
     * EstadoCandidaturaAExposicaoAceite.
     */
    @Test
    public void testSetEstadoCandidaturaAceite() {
        System.out.println("setEstadoCandidaturaAceite");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaAceite();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaStandsAtribuidos method, of class
     * EstadoCandidaturaAExposicaoAceite.
     */
    @Test
    public void testSetEstadoCandidaturaStandsAtribuidos() {
        System.out.println("setEstadoCandidaturaStandsAtribuidos");
        boolean expResult = true;
        boolean result = instance.setEstadoCandidaturaStandsAtribuidos();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaAceite method, of class
     * EstadoCandidaturaAExposicaoAceite.
     */
    @Test
    public void testIsEstadoCandidaturaAceite() {
        System.out.println("isEstadoCandidaturaAceite");
        boolean expResult = true;
        boolean result = instance.isEstadoCandidaturaAceite();
        assertEquals(expResult, result);
    }

}
