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
public class MecanismoPredefinidoBTest {
    
    public MecanismoPredefinidoBTest() {
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
     * Test of getNome method, of class MecanismoPredefinidoB.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        MecanismoPredefinidoB instance = new MecanismoPredefinidoB();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescricao method, of class MecanismoPredefinidoB.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        MecanismoPredefinidoB instance = new MecanismoPredefinidoB();
        String expResult = "";
        String result = instance.getDescricao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atribui method, of class MecanismoPredefinidoB.
     */
    @Test
    public void testAtribui_Exposicao_String() {
        System.out.println("atribui");
        Exposicao exposicaoEscolhida = null;
        String numeroFAEStr = "";
        MecanismoPredefinidoB instance = new MecanismoPredefinidoB();
        List<AtribuicaoCandidatura> expResult = null;
        List<AtribuicaoCandidatura> result = instance.atribui(exposicaoEscolhida, numeroFAEStr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atribui method, of class MecanismoPredefinidoB.
     */
    @Test
    public void testAtribui_Demonstracao_String() {
        System.out.println("atribui");
        Demonstracao demonstracaoEscolhida = null;
        String numeroLido = "";
        MecanismoPredefinidoB instance = new MecanismoPredefinidoB();
        List<AtribuicaoCandidatura> expResult = null;
        List<AtribuicaoCandidatura> result = instance.atribui(demonstracaoEscolhida, numeroLido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
