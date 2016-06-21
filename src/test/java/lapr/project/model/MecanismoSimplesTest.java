package lapr.project.model;

import java.util.List;
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
public class MecanismoSimplesTest {
    
    public MecanismoSimplesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of atribui method, of class MecanismoSimples.
     */
    @Test
    public void testAtribui_Exposicao() {
        System.out.println("atribui");
        Exposicao exposicaoEscolhida = null;
        MecanismoSimples instance = new MecanismoSimplesImpl();
        List<AtribuicaoCandidatura> expResult = null;
        List<AtribuicaoCandidatura> result = instance.atribui(exposicaoEscolhida);
        assertEquals(expResult, result);
    }

    /**
     * Test of atribui method, of class MecanismoSimples.
     */
    @Test
    public void testAtribui_Demonstracao() {
        System.out.println("atribui");
        Exposicao exposicaoEscolhida = null;
        Demonstracao demonstracaoEscolhida = null;
        MecanismoSimples instance = new MecanismoSimplesImpl();
        List<AtribuicaoCandidaturaDemonstracao> expResult = null;
        List<AtribuicaoCandidaturaDemonstracao> result = instance.atribui(exposicaoEscolhida, demonstracaoEscolhida);
        assertEquals(expResult, result);
    }

    public class MecanismoSimplesImpl implements MecanismoSimples {

        public List<AtribuicaoCandidatura> atribui(Exposicao exposicaoEscolhida) {
            return null;
        } 

        @Override
        public String getNome() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String getDescricao() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public List<AtribuicaoCandidaturaDemonstracao> atribui(Exposicao exposicaoEscolhida, Demonstracao demonstracaoEscolhida) {
            return null;
        }
    }

    }
    
