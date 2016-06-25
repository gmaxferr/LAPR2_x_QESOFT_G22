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
public class EstadoCandidaturaAExposicaoInicialTest {
    
    public EstadoCandidaturaAExposicaoInicialTest() {
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
        Utilizador utilizador = new Utilizador("pedro", "pedro", new char[] {'a', '.', '2', 'f'}, "aaa@dd.com");
         Expositor expositor = new Expositor(utilizador);
         m_cand = new CandidaturaAExposicao(expositor);
         instance = new EstadoCandidaturaAExposicaoInicial(m_cand);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturaInicial method, of class 
     * EstadoCandidaturaAExposicaoInicial.
     */
    @Test
    public void testSetEstadoCandidaturaInicial() {
        System.out.println("setEstadoCandidaturaInicial");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaInicial();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaCriada method, of class 
     * EstadoCandidaturaAExposicaoInicial.
     */
    @Test
    public void testSetEstadoCandidaturaCriada() {
        System.out.println("setEstadoCandidaturaCriada");
        boolean expResult = true;
        boolean result = instance.setEstadoCandidaturaCriada();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaIncial method, of class 
     * EstadoCandidaturaAExposicaoInicial.
     */
    @Test
    public void testIsEstadoCandidaturaIncial() {
        System.out.println("isEstadoCandidaturaIncial");
        boolean expResult = true;
        boolean result = instance.isEstadoCandidaturaIncial();
        assertEquals(expResult, result);
    }
    
}
