package lapr.project.controller;

import java.util.*;
import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracaoProntaAAtribuicao;
import lapr.project.model.*;
import lapr.project.registos.*;
import lapr.project.utils.Data;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author G29
 */
public class AtribuirCandidaturasADemonstracaoControllerTest {

    private AtribuirCandidaturasADemonstracaoController instance;
    private CentroExposicoes ce;
    private Exposicao e;
    private Mecanismo m;
    private RegistoExposicoes re;
    private Demonstracao d;
    private RegistoDemonstracoes rd;
    private RegistoMecanismos rm;
    private RegistoCandidaturasADemonstracao rcd;
    private RegistoAtribuicoesCandidaturasDemonstracao racd;
    private List<AtribuicaoCandidaturaDemonstracao> listaAtribuicoesGeradas;

    public AtribuirCandidaturasADemonstracaoControllerTest() {
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
        e = new Exposicao(ce);
        re = ce.getRegistoExposicoes();
        d = new Demonstracao();
        rd = e.getRegistoDemonstracoes();
        rm = ce.getRegistoMecanismos();
        rcd = d.getRegistoCandidaturasADemonstracao();
        racd = e.getRegistoAtribuicoesDemonstracao();
        instance = new AtribuirCandidaturasADemonstracaoController(ce);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getRegistoExposicoes method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        instance.getRegistoExposicoes();
    }

    /**
     * Test of getListaExposicoesDoOrganizadorEstadoConflitosAlterados method,
     * of class AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testGetListaExposicoesDoOrganizadorEstadoConflitosAlterados() {
        System.out.println("getListaExposicoesDoOrganizadorEstadoConflitosAlterados");
        instance.getRegistoExposicoes();
        String usernameOrganizador = "";
        List<Exposicao> expResult = new ArrayList<Exposicao>();
        List<Exposicao> result = instance.getListaExposicoesDoOrganizadorEstadoConflitosAlterados(usernameOrganizador);
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicao method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao e = new Exposicao("a", "b", new Data(2015, 05, 03), new Data(2015, 05, 04), new Data(2015, 05, 05), new Data(2015, 05, 06), new Data(2015, 05, 07), new Data(2015, 5, 8), new Local("l"), ce);
        instance.setExposicao(e);
    }

    /**
     * Test of getRegistoDemonstracoes method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testGetRegistoDemonstracoes() {
        System.out.println("getRegistoDemonstracoes");
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        instance.getRegistoDemonstracoes();
    }

    /**
     * Test of getListaDemonstracoesEstadoCandidaturasFechadas method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testGetListaDemonstracoesEstadoCandidaturasFechadas() {
        System.out.println("getListaDemonstracoesEstadoCandidaturasFechadas");
        String usernameOrganizador = "";
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        instance.getRegistoDemonstracoes();
        List<Demonstracao> expResult = new ArrayList<Demonstracao>();
        List<Demonstracao> result = instance.getListaDemonstracoesEstadoCandidaturasFechadas(usernameOrganizador);
        assertEquals(expResult, result);
    }

    /**
     * Test of setDemonstracao method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testSetDemonstracao() {
        System.out.println("setDemonstracao");
        Demonstracao demonstracao = new Demonstracao();
        instance.setDemonstracao(demonstracao);
    }

    /**
     * Test of getRegistoMecanismos method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testGetRegistoMecanismos() {
        System.out.println("getRegistoMecanismos");
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        instance.getRegistoMecanismos();
    }

    /**
     * Test of getListaMecanismos method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testGetListaMecanismos() {
        System.out.println("getListaMecanismos");
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        re.registaExposicao(e);
        instance.getRegistoMecanismos();
        List<Mecanismo> expResult = new ArrayList<Mecanismo>();
        expResult.addAll(ce.getRegistoMecanismos().getListaMecanismos());
        List<Mecanismo> result = instance.getListaMecanismos();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRegistoCandidaturas method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testGetRegistoCandidaturas() {
        System.out.println("getRegistoCandidaturas");
        instance.setExposicao(e);
        re.registaExposicao(e);
        instance.getRegistoExposicoes();
        instance.setDemonstracao(d);
        instance.getRegistoDemonstracoes();
        rd.addDemo(d);
        instance.getRegistoCandidaturas();
    }

    /**
     * Test of getRegistoAtribuicoes method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testGetRegistoAtribuicoes() {
        System.out.println("getRegistoAtribuicoes");
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        re.registaExposicao(e);
        instance.getRegistoAtribuicoes();
    }

    /**
     * Test of atribui method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testAtribui_Mecanismo() {
        System.out.println("atribui");
         e.getRegistoFAE().adicionaFAE(new Utilizador("nome", "username", "password".toCharArray(), "email", "1234"));
        CandidaturaADemonstracao cand = new CandidaturaADemonstracao("dados", "email");
        d.getRegistoCandidaturasADemonstracao().adiciona(cand);
        Mecanismo mec = new MecanismoPredefinidoA();
        List<AtribuicaoCandidaturaDemonstracao> expResult = new ArrayList<>();
        cand.setEstado(new EstadoCandidaturaADemonstracaoProntaAAtribuicao(cand));
        AtribuicaoCandidaturaDemonstracao atrib = new AtribuicaoCandidaturaDemonstracao(cand);
        expResult.add(atrib);

        instance.getRegistoExposicoes();
        instance.setExposicao(e);
        instance.getRegistoDemonstracoes();
        instance.setDemonstracao(d);
        instance.getRegistoAtribuicoes();
        List<AtribuicaoCandidaturaDemonstracao> result = instance.atribui(mec);
        assertEquals(expResult.get(0).getCandidaturaAssociada(), result.get(0).getCandidaturaAssociada());
    }

    /**
     * Test of atribui method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testAtribui_Mecanismo_String() {
        System.out.println("atribui");
        e.getRegistoFAE().adicionaFAE(new Utilizador("nome", "username", "password".toCharArray(), "email", "1234"));
        CandidaturaADemonstracao cand = new CandidaturaADemonstracao("dados", "email");
        d.getRegistoCandidaturasADemonstracao().adiciona(cand);
        Mecanismo mec = new MecanismoPredefinidoA();
        List<AtribuicaoCandidaturaDemonstracao> expResult = new ArrayList<>();
        cand.setEstado(new EstadoCandidaturaADemonstracaoProntaAAtribuicao(cand));
        AtribuicaoCandidaturaDemonstracao atrib = new AtribuicaoCandidaturaDemonstracao(cand);
        expResult.add(atrib);

        instance.getRegistoExposicoes();
        instance.setExposicao(e);
        instance.getRegistoDemonstracoes();
        instance.setDemonstracao(d);
        instance.getRegistoAtribuicoes();
        List<AtribuicaoCandidaturaDemonstracao> result = instance.atribui(mec);
        assertEquals(expResult.get(0).getCandidaturaAssociada(), result.get(0).getCandidaturaAssociada());
    }



}
