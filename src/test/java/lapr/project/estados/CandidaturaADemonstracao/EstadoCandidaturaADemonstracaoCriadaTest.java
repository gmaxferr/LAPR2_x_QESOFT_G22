package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;
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
public class EstadoCandidaturaADemonstracaoCriadaTest {

    public EstadoCandidaturaADemonstracaoCriadaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private final CandidaturaADemonstracao m_cand = new CandidaturaADemonstracao("dado", "a@b.c");
    private EstadoCandidaturaADemonstracao instance = new EstadoCandidaturaADemonstracaoCriada(m_cand);

    @Before
    public void setUp() {
        m_cand.setEstado(new EstadoCandidaturaADemonstracaoCriada(m_cand));
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturaADemonstracaoInstanciada method, of class
     * EstadoCandidaturaADemonstracaoCriada.
     */
    @Test
    public void testSetEstadoCandidaturaADemonstracaoInstanciada() {
        System.out.println("setEstadoCandidaturaADemonstracaoInstanciada");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaADemonstracaoInstanciada();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaADemonstracaoCriada method, of class
     * EstadoCandidaturaADemonstracaoCriada.
     */
    @Test
    public void testSetEstadoCandidaturaADemonstracaoCriada() {
        System.out.println("setEstadoCandidaturaADemonstracaoCriada");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaADemonstracaoCriada();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaADemonstracaoAtribuida method, of class
     * EstadoCandidaturaADemonstracaoCriada.
     */
    @Test
    public void testSetEstadoCandidaturaADemonstracaoAtribuida() {
        System.out.println("setEstadoCandidaturaADemonstracaoAtribuida");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaADemonstracaoAtribuida();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaADemonstracaoAvaliada method, of class
     * EstadoCandidaturaADemonstracaoCriada.
     */
    @Test
    public void testSetEstadoCandidaturaADemonstracaoAvaliada() {
        System.out.println("setEstadoCandidaturaADemonstracaoAvaliada");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaADemonstracaoAvaliada();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaADemonstracaoInstanciada method, of class
     * EstadoCandidaturaADemonstracaoCriada.
     */
    @Test
    public void testIsEstadoCandidaturaADemonstracaoInstanciada() {
        System.out.println("isEstadoCandidaturaADemonstracaoInstanciada");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaADemonstracaoInstanciada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to .
    }

    /**
     * Test of isEstadoCandidaturaADemonstracaoCriada method, of class
     * EstadoCandidaturaADemonstracaoCriada.
     */
    @Test
    public void testIsEstadoCandidaturaADemonstracaoCriada() {
        System.out.println("isEstadoCandidaturaADemonstracaoCriada");
        boolean expResult = true;
        boolean result = instance.isEstadoCandidaturaADemonstracaoCriada();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaADemonstracaoAtribuida method, of class
     * EstadoCandidaturaADemonstracaoCriada.
     */
    @Test
    public void testIsEstadoCandidaturaADemonstracaoAtribuida() {
        System.out.println("isEstadoCandidaturaADemonstracaoAtribuida");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaADemonstracaoAtribuida();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaADemonstracaoAvaliada method, of class
     * EstadoCandidaturaADemonstracaoCriada.
     */
    @Test
    public void testIsEstadoCandidaturaADemonstracaoAvaliada() {
        System.out.println("isEstadoCandidaturaADemonstracaoAvaliada");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaADemonstracaoAvaliada();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaADemonstracaoRecusada method, of class
     * EstadoCandidaturaADemonstracaoCriada.
     */
    @Test
    public void testSetEstadoCandidaturaADemonstracaoRecusada() {
        System.out.println("setEstadoCandidaturaADemonstracaoRecusada");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaADemonstracaoRecusada();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaADemonstracaoProntaAAtribuicao method, of
     * class EstadoCandidaturaADemonstracaoCriada.
     */
    @Test
    public void testSetEstadoCandidaturaADemonstracaoProntaAAtribuicao() {
        System.out.println("setEstadoCandidaturaADemonstracaoProntaAAtribuicao");
        boolean expResult = true;
        boolean result = instance.setEstadoCandidaturaADemonstracaoProntaAAtribuicao();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaADemonstracaoAceite method, of class
     * EstadoCandidaturaADemonstracaoCriada.
     */
    @Test
    public void testIsEstadoCandidaturaADemonstracaoAceite() {
        System.out.println("isEstadoCandidaturaADemonstracaoAceite");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaADemonstracaoAceite();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaADemonstracaoRecusada method, of class
     * EstadoCandidaturaADemonstracaoCriada.
     */
    @Test
    public void testIsEstadoCandidaturaADemonstracaoRejeitada() {
        System.out.println("isEstadoCandidaturaADemonstracaoRejeitada");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaADemonstracaoRecusada();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaADemonstracaoProntaAAtribuicao method, of
     * class EstadoCandidaturaADemonstracaoCriada.
     */
    @Test
    public void testIsEstadoCandidaturaADemonstracaoProntaAAtribuicao() {
        System.out.println("isEstadoCandidaturaADemonstracaoProntaAAtribuicao");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaADemonstracaoProntaAAtribuicao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaADemonstracaoAceite method, of class
     * EstadoCandidaturaADemonstracaoCriada.
     */
    @Test
    public void testSetEstadoCandidaturaADemonstracaoAceite() {
        System.out.println("setEstadoCandidaturaADemonstracaoAceite");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaADemonstracaoAceite();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaADemonstracaoRemovida method, of class
     * EstadoCandidaturaADemonstracaoCriada.
     */
    @Test
    public void testSetEstadoCandidaturaADemonstracaoRemovida() {
        System.out.println("setEstadoCandidaturaADemonstracaoRemovida");
        boolean expResult = true;
        boolean result = instance.setEstadoCandidaturaADemonstracaoRemovida();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaADemonstracaoRemovida method, of class
     * EstadoCandidaturaADemonstracaoCriada.
     */
    @Test
    public void testIsEstadoCandidaturaADemonstracaoRemovida() {
        System.out.println("isEstadoCandidaturaADemonstracaoRemovida");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturaADemonstracaoRemovida();
        assertEquals(expResult, result);
    }
}