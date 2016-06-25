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
public class EstadoExposicaoCandidaturasFechadasTest {

    public EstadoExposicaoCandidaturasFechadasTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private EstadoExposicaoCandidaturasFechadas instance;
    private Exposicao e;
    private CentroExposicoes ce;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(ce);

        instance = new EstadoExposicaoCandidaturasFechadas(e);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturasFechadas method, of class
     * EstadoExposicaoCandidaturasFechadas.
     */
    @Test
    public void testSetEstadoCandidaturasFechadas() {
        System.out.println("setEstadoCandidaturasFechadas");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturasFechadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoConflitosDetetados method, of class
     * EstadoExposicaoCandidaturasFechadas.
     */
    @Test
    public void testSetEstadoConflitosDetetados() {
        System.out.println("setEstadoConflitosDetetados");
        boolean expResult = true;
        boolean result = instance.setEstadoConflitosDetetados();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturasFechadas method, of class
     * EstadoExposicaoCandidaturasFechadas.
     */
    @Test
    public void testIsEstadoCandidaturasFechadas() {
        System.out.println("isEstadoCandidaturasFechadas");
        boolean expResult = true;
        boolean result = instance.isEstadoCandidaturasFechadas();
        assertEquals(expResult, result);
    }
}
