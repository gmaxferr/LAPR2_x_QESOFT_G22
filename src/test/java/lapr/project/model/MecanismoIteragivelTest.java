/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author guima
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
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atribui method, of class MecanismoIteragivel.
     */
    @Test
    public void testAtribui_Demonstracao_String() {
        System.out.println("atribui");
        Demonstracao demonstracaoEscolhida = null;
        String numeroLido = "";
        MecanismoIteragivel instance = new MecanismoIteragivelImpl();
        List<AtribuicaoCandidatura> expResult = null;
        List<AtribuicaoCandidatura> result = instance.atribui(demonstracaoEscolhida, numeroLido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class MecanismoIteragivelImpl implements MecanismoIteragivel {

        public List<AtribuicaoCandidatura> atribui(Exposicao exposicaoEscolhida, String numeroLido) {
            return null;
        }

        public List<AtribuicaoCandidatura> atribui(Demonstracao demonstracaoEscolhida, String numeroLido) {
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
    }
    
}
