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
public class MecanismoPredefinidoATest {
    
    public MecanismoPredefinidoATest() {
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
     * Test of getNome method, of class MecanismoPredefinidoA.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        MecanismoPredefinidoA instance = new MecanismoPredefinidoA();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescricao method, of class MecanismoPredefinidoA.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        MecanismoPredefinidoA instance = new MecanismoPredefinidoA();
        String expResult = "";
        String result = instance.getDescricao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atribui method, of class MecanismoPredefinidoA.
     */
    @Test
    public void testAtribui_Exposicao() {
        System.out.println("atribui");
        Exposicao exposicaoEscolhida = null;
        MecanismoPredefinidoA instance = new MecanismoPredefinidoA();
        List<AtribuicaoCandidatura> expResult = null;
        List<AtribuicaoCandidatura> result = instance.atribui(exposicaoEscolhida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atribui method, of class MecanismoPredefinidoA.
     */
    @Test
    public void testAtribui_Demonstracao() {
        System.out.println("atribui");
        Demonstracao demonstracaoEscolhida = null;
        MecanismoPredefinidoA instance = new MecanismoPredefinidoA();
        List<AtribuicaoCandidatura> expResult = null;
        List<AtribuicaoCandidatura> result = instance.atribui(demonstracaoEscolhida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
