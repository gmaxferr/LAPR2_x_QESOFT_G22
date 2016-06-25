package lapr.project.estados.Exposicao;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
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
public class EstadoExposicaoTest {

    public EstadoExposicaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private EstadoExposicao instance;
    private Exposicao e;
    private CentroExposicoes ce;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(ce);

        instance = new EstadoExposicao(e) {
        };
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCriada method, of class EstadoExposicao.
     */
    @Test
    public void testSetEstadoCriada() {
        System.out.println("setEstadoCriada");
        boolean expResult = false;
        boolean result = instance.setEstadoCriada();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoFAEDefinidosSemDemos method, of class EstadoExposicao.
     */
    @Test
    public void testSetEstadoFAEDefinidosSemDemos() {
        System.out.println("setEstadoFAEDefinidosSemDemos");
        boolean expResult = false;
        boolean result = instance.setEstadoFAEDefinidosSemDemos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemosDefinidasSemFAE method, of class EstadoExposicao.
     */
    @Test
    public void testSetEstadoDemosDefinidasSemFAE() {
        System.out.println("setEstadoDemosDefinidasSemFAE");
        boolean expResult = false;
        boolean result = instance.setEstadoDemosDefinidasSemFAE();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCompleta method, of class EstadoExposicao.
     */
    @Test
    public void testSetEstadoCompleta() {
        System.out.println("setEstadoCompleta");
        boolean expResult = false;
        boolean result = instance.setEstadoCompleta();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturasAbertas method, of class EstadoExposicao.
     */
    @Test
    public void testSetEstadoCandidaturasAbertas() {
        System.out.println("setEstadoCandidaturasAbertas");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturasAbertas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturasFechadas method, of class EstadoExposicao.
     */
    @Test
    public void testSetEstadoCandidaturasFechadas() {
        System.out.println("setEstadoCandidaturasFechadas");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturasFechadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoConflitosDetetados method, of class EstadoExposicao.
     */
    @Test
    public void testSetEstadoConflitosDetetados() {
        System.out.println("setEstadoConflitosDetetados");
        boolean expResult = false;
        boolean result = instance.setEstadoConflitosDetetados();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoConflitosAlterados method, of class EstadoExposicao.
     */
    @Test
    public void testSetEstadoConflitosAlterados() {
        System.out.println("setEstadoConflitosAlterados");
        boolean expResult = false;
        boolean result = instance.setEstadoConflitosAlterados();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturasAtribuidas method, of class EstadoExposicao.
     */
    @Test
    public void testSetEstadoCandidaturasAtribuidas() {
        System.out.println("setEstadoCandidaturasAtribuidas");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturasAtribuidas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturasAvaliadas method, of class EstadoExposicao.
     */
    @Test
    public void testSetEstadoCandidaturasAvaliadas() {
        System.out.println("setEstadoCandidaturasAvaliadas");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturasAvaliadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturasDecididas method, of class EstadoExposicao.
     */
    @Test
    public void testSetEstadoCandidaturasDecididas() {
        System.out.println("setEstadoCandidaturasDecididas");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturasDecididas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoInicial method, of class EstadoExposicao.
     */
    @Test
    public void testIsEstadoInicial() {
        System.out.println("isEstadoInicial");
        boolean expResult = false;
        boolean result = instance.isEstadoInicial();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCriada method, of class EstadoExposicao.
     */
    @Test
    public void testIsEstadoCriada() {
        System.out.println("isEstadoCriada");
        boolean expResult = false;
        boolean result = instance.isEstadoCriada();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoFAEDefinidosSemDemos method, of class EstadoExposicao.
     */
    @Test
    public void testIsEstadoFAEDefinidosSemDemos() {
        System.out.println("isEstadoFAEDefinidosSemDemos");
        boolean expResult = false;
        boolean result = instance.isEstadoFAEDefinidosSemDemos();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemosDefinidasSemFAE method, of class EstadoExposicao.
     */
    @Test
    public void testIsEstadoDemosDefinidasSemFAE() {
        System.out.println("isEstadoDemosDefinidasSemFAE");
        boolean expResult = false;
        boolean result = instance.isEstadoDemosDefinidasSemFAE();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCompleta method, of class EstadoExposicao.
     */
    @Test
    public void testIsEstadoCompleta() {
        System.out.println("isEstadoCompleta");
        boolean expResult = false;
        boolean result = instance.isEstadoCompleta();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturasAbertas method, of class EstadoExposicao.
     */
    @Test
    public void testIsEstadoCandidaturasAbertas() {
        System.out.println("isEstadoCandidaturasAbertas");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturasAbertas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturasFechadas method, of class EstadoExposicao.
     */
    @Test
    public void testIsEstadoCandidaturasFechadas() {
        System.out.println("isEstadoCandidaturasFechadas");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturasFechadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoConflitosDetetados method, of class EstadoExposicao.
     */
    @Test
    public void testIsEstadoConflitosDetetados() {
        System.out.println("isEstadoConflitosDetetados");
        boolean expResult = false;
        boolean result = instance.isEstadoConflitosDetetados();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoConflitosAlterados method, of class EstadoExposicao.
     */
    @Test
    public void testIsEstadoConflitosAlterados() {
        System.out.println("isEstadoConflitosAlterados");
        boolean expResult = false;
        boolean result = instance.isEstadoConflitosAlterados();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturasAtribuidas method, of class EstadoExposicao.
     */
    @Test
    public void testIsEstadoCandidaturasAtribuidas() {
        System.out.println("isEstadoCandidaturasAtribuidas");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturasAtribuidas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturasAvaliadas method, of class EstadoExposicao.
     */
    @Test
    public void testIsEstadoCandidaturasAvaliadas() {
        System.out.println("isEstadoCandidaturasAvaliadas");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturasAvaliadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturasDecididas method, of class EstadoExposicao.
     */
    @Test
    public void testIsEstadoCandidaturasDecididas() {
        System.out.println("isEstadoCandidaturasDecididas");
        boolean expResult = false;
        boolean result = instance.isEstadoCandidaturasDecididas();
        assertEquals(expResult, result);
    }

    public class EstadoExposicaoImpl extends EstadoExposicao {

        public EstadoExposicaoImpl() {
            super(null);
        }
    }
}
