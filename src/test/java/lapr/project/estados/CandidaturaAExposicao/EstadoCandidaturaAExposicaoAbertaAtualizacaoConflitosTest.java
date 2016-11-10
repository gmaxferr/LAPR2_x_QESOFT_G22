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
public class EstadoCandidaturaAExposicaoAbertaAtualizacaoConflitosTest {
    
    public EstadoCandidaturaAExposicaoAbertaAtualizacaoConflitosTest() {
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
         instance = new EstadoCandidaturaAExposicaoAbertaAtualizacaoConflitos(m_cand);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setEstadoCandidaturaAbertaAtualizacaoConflitos method, of class 
     * EstadoCandidaturaAExposicaoAbertaAtualizacaoConflitos.
     */
    @Test
    public void testSetEstadoCandidaturaAbertaAtualizacaoConflitos() {
        System.out.println("setEstadoCandidaturaAbertaAtualizacaoConflitos");
        boolean expResult = false;
        boolean result = instance.setEstadoCandidaturaAbertaAtualizacaoConflitos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstadoCandidaturaProntaAtribuicoes method, of class
     * EstadoCandidaturaAExposicaoAbertaAtualizacaoConflitos.
     */
    @Test
    public void testSetEstadoCandidaturaProntaAtribuicoes() {
        System.out.println("setEstadoCandidaturaProntaAtribuicoes");
        boolean expResult = true;
        boolean result = instance.setEstadoCandidaturaProntaAtribuicoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of isEstadoCandidaturaAbertaAtualizacaoConflitos method, of class 
     * EstadoCandidaturaAExposicaoAbertaAtualizacaoConflitos.
     */
    @Test
    public void testIsEstadoCandidaturaAbertaAtualizacaoConflitos() {
        System.out.println("isEstadoCandidaturaAbertaAtualizacaoConflitos");
        boolean expResult = true;
        boolean result = instance.isEstadoCandidaturaAbertaAtualizacaoConflitos();
        assertEquals(expResult, result);
    }
    
}
