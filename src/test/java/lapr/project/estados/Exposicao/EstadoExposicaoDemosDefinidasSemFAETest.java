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
public class EstadoExposicaoDemosDefinidasSemFAETest {
    
    public EstadoExposicaoDemosDefinidasSemFAETest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private EstadoExposicaoDemosDefinidasSemFAE instance;
    private Exposicao e;
    private CentroExposicoes ce;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(ce);

        instance = new EstadoExposicaoDemosDefinidasSemFAE(e);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoDemosDefinidasSemFAE method, of class EstadoExposicaoDemosDefinidasSemFAE.
     */
    @Test
    public void testSetEstadoDemosDefinidasSemFAE() {
        System.out.println("setEstadoDemosDefinidasSemFAE");
        boolean expResult = false;
        boolean result = instance.setEstadoDemosDefinidasSemFAE();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCompleta method, of class EstadoExposicaoDemosDefinidasSemFAE.
     */
    @Test
    public void testSetEstadoCompleta() {
        System.out.println("setEstadoCompleta");
        boolean expResult = true;
        boolean result = instance.setEstadoCompleta();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoDemosDefinidasSemFAE method, of class EstadoExposicaoDemosDefinidasSemFAE.
     */
    @Test
    public void testIsEstadoDemosDefinidasSemFAE() {
        System.out.println("isEstadoDemosDefinidasSemFAE");
        boolean expResult = true;
        boolean result = instance.isEstadoDemosDefinidasSemFAE();
        assertEquals(expResult, result);
    }
    
}
