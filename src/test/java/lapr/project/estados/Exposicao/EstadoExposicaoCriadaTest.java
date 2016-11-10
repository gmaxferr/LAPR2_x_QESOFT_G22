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
public class EstadoExposicaoCriadaTest {
    
    public EstadoExposicaoCriadaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private EstadoExposicaoCriada instance;
    private Exposicao e;
    private CentroExposicoes ce;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(ce);

        instance = new EstadoExposicaoCriada(e);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoFAEDefinidosSemDemos method, of class EstadoExposicaoCriada.
     */
    @Test
    public void testSetEstadoFAEDefinidosSemDemos() {
        System.out.println("setEstadoFAEDefinidosSemDemos");
        boolean expResult = true;
        boolean result = instance.setEstadoFAEDefinidosSemDemos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoDemosDefinidasSemFAE method, of class EstadoExposicaoCriada.
     */
    @Test
    public void testSetEstadoDemosDefinidasSemFAE() {
        System.out.println("setEstadoDemosDefinidasSemFAE");
        boolean expResult = true;
        boolean result = instance.setEstadoDemosDefinidasSemFAE();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCriada method, of class EstadoExposicaoCriada.
     */
    @Test
    public void testIsEstadoCriada() {
        System.out.println("isEstadoCriada");
        boolean expResult = true;
        boolean result = instance.isEstadoCriada();
        assertEquals(expResult, result);
    }
    
}
