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
public class MecanismoIteragivelTest {

    public MecanismoIteragivelTest() {
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
     * Test of atribui method, of class MecanismoIteragivel.
     */
    @Test
    public void testAtribui_Exposicao_String() {
        System.out.println("atribui");
        Exposicao exposicaoEscolhida = null;
        String numeroLido = "";
        MecanismoIteragivel instance = new MecanismoIteragivelImpl();
        List<AtribuicaoCandidatura> expResult = null;
        List<AtribuicaoCandidatura> result = instance.atribui(exposicaoEscolhida, numeroLido);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of atribui method, of class MecanismoIteragivel.
     */
    @Test
    public void testAtribui_Demonstracao_String() {
        System.out.println("atribui");
        Exposicao exposicaoEscolhida = null;
        Demonstracao demonstracaoEscolhida = null;
        String numeroLido = "";
        MecanismoIteragivel instance = new MecanismoIteragivelImpl();
        List<AtribuicaoCandidaturaDemonstracao> expResult = null;
        List<AtribuicaoCandidaturaDemonstracao> result = instance.atribui(exposicaoEscolhida, demonstracaoEscolhida, numeroLido);
        assertEquals(expResult, result);
    }

    public class MecanismoIteragivelImpl implements MecanismoIteragivel {

        public List<AtribuicaoCandidatura> atribui(Exposicao exposicaoEscolhida, String numeroLido) {
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
        public List<AtribuicaoCandidaturaDemonstracao> atribui(Exposicao exposicaoEscolhida, Demonstracao demonstracaoEscolhida, String numeroLido) {
            return null;
        }
    }

}
