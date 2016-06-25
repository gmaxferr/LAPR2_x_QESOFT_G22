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
public class EstadoCandidaturaAExposicaoStandRecusadoTest {

    public EstadoCandidaturaAExposicaoStandRecusadoTest() {
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
        instance = new EstadoCandidaturaAExposicaoStandRecusado(m_cand);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturaStandRecusado method, of class
     * EstadoCandidaturaAExposicaoStandRecusado.
     */
    @Test
    public void testSetEstadoCandidaturaStandRecusado() {
        System.out.println("setEstadoCandidaturaStandRecusado");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaStandRecusado();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaStandRecusado method, of class
     * EstadoCandidaturaAExposicaoStandRecusado.
     */
    @Test
    public void testIsEstadoCandidaturaStandRecusado() {
        System.out.println("isEstadoCandidaturaStandRecusado");
        boolean expResult = true;
        boolean result = instance.isEstadoCandidaturaStandRecusado();
        assertEquals(expResult, result);
    }

}
