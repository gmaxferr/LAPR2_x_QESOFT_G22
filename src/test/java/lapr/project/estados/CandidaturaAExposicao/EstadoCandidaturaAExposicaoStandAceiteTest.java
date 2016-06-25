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
public class EstadoCandidaturaAExposicaoStandAceiteTest {

    public EstadoCandidaturaAExposicaoStandAceiteTest() {
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
        instance = new EstadoCandidaturaAExposicaoStandAceite(m_cand);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturaStandAceite method, of class
     * EstadoCandidaturaAExposicaoStandAceite.
     */
    @Test
    public void testSetEstadoCandidaturaStandAceite() {
        System.out.println("setEstadoCandidaturaStandAceite");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaStandAceite();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaStandAceite method, of class
     * EstadoCandidaturaAExposicaoStandAceite.
     */
    @Test
    public void testIsEstadoCandidaturaStandAceite() {
        System.out.println("isEstadoCandidaturaStandAceite");
        boolean expResult = true;
        boolean result = instance.isEstadoCandidaturaStandAceite();
        assertEquals(expResult, result);
    }

}
