package lapr.project.controller;

import java.util.*;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoAceite;
import lapr.project.model.*;
import lapr.project.registos.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author G29
 */
public class RegistarCandidaturaADemonstracaoControllerTest {

    private CentroExposicoes ce;
    private Utilizador u;
    private String username;
    private CandidaturaADemonstracao cand;
    private RegistoExposicoes re;
    private Exposicao e;
    private RegistarCandidaturaADemonstracaoController instance;
    private CandidaturaAExposicao c;
    private RegistoDemonstracoes rd;
    private Demonstracao d;

    public RegistarCandidaturaADemonstracaoControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        re = ce.getRegistoExposicoes();
        username = "rep";
        e = new Exposicao(ce);
        re.getListaExposicoes().add(e);
        u = new Utilizador("nome", "rep", new char[]{'a', 'A', '.', '1'}, "a@b.c");
        c = new CandidaturaAExposicao(new Expositor(u));
        c.setEstado(new EstadoCandidaturaAExposicaoAceite(c));
        e.getRegistoCandidaturasAExposicao().getListaCandidaturas().add(c);
        rd = e.getRegistoDemonstracoes();
        d = new Demonstracao("descricao");
        rd.getListaDemonstracoes().add(d);
        instance = new RegistarCandidaturaADemonstracaoController(ce, username);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getListaDeExposicoes method, of class
     * RegistarCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetListaDeExposicoes() {
        System.out.println("getListaDeExposicoes");
        List<Exposicao> expResult = new ArrayList<Exposicao>();
        expResult.add(e);
        List<Exposicao> result = instance.getListaDeExposicoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExpo method, of class
     * RegistarCandidaturaADemonstracaoController.
     */
    @Test
    public void testSetExpo() {
        System.out.println("setExpo");
        instance.setExpo(e);
    }

    /**
     * Test of setDemo method, of class
     * RegistarCandidaturaADemonstracaoController.
     */
    @Test
    public void testSetDemo() {
        System.out.println("setDemo");
        int indexSelectedDemo = 0;
        instance.setExpo(e);
        instance.getListaDemos();
        instance.setDemo(indexSelectedDemo);
    }

    /**
     * Test of getListaDemos method, of class
     * RegistarCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetListaDemos() {
        instance.setExpo(e);
        System.out.println("getListaDemos");
        List<Demonstracao> expResult = new ArrayList<Demonstracao>();
        expResult.add(d);
        List<Demonstracao> result = instance.getListaDemos();
        assertEquals(expResult, result);
    }

    /**
     * Test of isValidDados method, of class
     * RegistarCandidaturaADemonstracaoController.
     */
    @Test
    public void testIsValidDados() {
        System.out.println("isValidDados");
        String dados = "";
        boolean expResult = false;
        boolean result = instance.isValidDados(dados);
        assertEquals(expResult, result);
    }

    /**
     * Test of setFormularioDados method, of class
     * RegistarCandidaturaADemonstracaoController.
     */
    @Test
    public void testSetFormularioDados() {
        System.out.println("setFormularioDados");
        String dados = "";
        boolean expResult = false;
        boolean result = instance.setFormularioDados(dados);
        assertEquals(expResult, result);
    }

    /**
     * Test of RegistaCandADemo method, of class
     * RegistarCandidaturaADemonstracaoController.
     */
    @Test
    public void testRegistaCandADemo() {
        System.out.println("RegistaCandADemo");
        instance.setExpo(e);
        instance.getListaDemos();
        instance.setDemo(0);
        instance.setFormularioDados("dados");

        boolean expResult = true;
        boolean result = instance.RegistaCandADemo();
        assertEquals(expResult, result);
    }

    /**
     * Test of transitaEstado method, of class
     * RegistarCandidaturaADemonstracaoController.
     */
    @Test
    public void testTransitaEstado() {
        System.out.println("transitaEstado");
        instance.setExpo(e);
        instance.getListaDemos();
        instance.setDemo(0);
        instance.setFormularioDados("dados");
        instance.RegistaCandADemo();
        instance.transitaEstado();
    }

}
