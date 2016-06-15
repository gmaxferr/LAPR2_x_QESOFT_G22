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
 * @author guilherme
 */
public class EstadoExposicaoConflitosDetetadosTest {
    
    public EstadoExposicaoConflitosDetetadosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private EstadoExposicaoConflitosDetetados instance;
    private Exposicao e;
    private CentroExposicoes ce;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(ce);

        instance = new EstadoExposicaoConflitosDetetados(e);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoConflitosDetetados method, of class EstadoExposicaoConflitosDetetados.
     */
    @Test
    public void testSetEstadoConflitosDetetados() {
        System.out.println("setEstadoConflitosDetetados");
        boolean expResult = false;
        boolean result = instance.setEstadoConflitosDetetados();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoConflitosAlterados method, of class EstadoExposicaoConflitosDetetados.
     */
    @Test
    public void testSetEstadoConflitosAlterados() {
        System.out.println("setEstadoConflitosAlterados");
        boolean expResult = true;
        boolean result = instance.setEstadoConflitosAlterados();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoConflitosDetetados method, of class EstadoExposicaoConflitosDetetados.
     */
    @Test
    public void testIsEstadoConflitosDetetados() {
        System.out.println("isEstadoConflitosDetetados");
        boolean expResult = true;
        boolean result = instance.isEstadoConflitosDetetados();
        assertEquals(expResult, result);
    }
    
}
