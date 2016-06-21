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
public class MecanismoPredefinidoCTest {
    
    public MecanismoPredefinidoCTest() {
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
     * Test of atribui method, of class MecanismoPredefinidoC.
     */
    @Test
    public void testAtribui_Exposicao_String() {
        System.out.println("atribui");
        Exposicao e = null;
        String numeroLido = "";
        MecanismoPredefinidoC instance = new MecanismoPredefinidoC();
        List<AtribuicaoCandidatura> expResult = null;
        List<AtribuicaoCandidatura> result = instance.atribui(e, numeroLido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class MecanismoPredefinidoC.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        MecanismoPredefinidoC instance = new MecanismoPredefinidoC();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescricao method, of class MecanismoPredefinidoC.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        MecanismoPredefinidoC instance = new MecanismoPredefinidoC();
        String expResult = "";
        String result = instance.getDescricao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atribui method, of class MecanismoPredefinidoC.
     */
    @Test
    public void testAtribui_Demonstracao_String() {
        System.out.println("atribui");
        Demonstracao demonstracaoEscolhida = null;
        String numeroLido = "";
        MecanismoPredefinidoC instance = new MecanismoPredefinidoC();
        List<AtribuicaoCandidatura> expResult = null;
        List<AtribuicaoCandidatura> result = instance.atribui(demonstracaoEscolhida, numeroLido);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
