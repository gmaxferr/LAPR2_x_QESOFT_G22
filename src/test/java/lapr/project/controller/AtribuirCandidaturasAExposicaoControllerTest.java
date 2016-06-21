package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.dados.DadosInstanciados;
import lapr.project.estados.Exposicao.EstadoExposicaoConflitosAlterados;
import lapr.project.estados.Exposicao.EstadoExposicaoDemosDefinidasSemFAE;
import lapr.project.model.*;
import lapr.project.utils.*;
import lapr.project.registos.RegistoExposicoes;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author G29
 */
public class AtribuirCandidaturasAExposicaoControllerTest {

    private AtribuirCandidaturasAExposicaoController instance;
    private CentroExposicoes ce;

    public AtribuirCandidaturasAExposicaoControllerTest() {
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
        instance = new AtribuirCandidaturasAExposicaoController(ce, "usernameOrganizador");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getListaMecanismos method, of class
     * AtribuirCandidaturasAExposicaoController.
     */
    @Test
    public void testGetListaMecanismos() {
        System.out.println("getListaMecanismos");
        List<Mecanismo> expResult = ce.getRegistoMecanismos().getListaMecanismos();
        instance.getRegistoMecanismos();
        assertEquals(expResult, instance.getListaMecanismos());
    }

    /**
     * Test of getListaExposicoesDoOrganizadorEstadoConflitosAlterados method,
     * of class AtribuirCandidaturasAExposicaoController.
     */
    @Test
    public void testGetListaExposicoesDoOrganizadorEstadoConflitosAlterados() {
        System.out.println("getListaExposicoesDoOrganizadorEstadoConflitosAlterados");

        List<Exposicao> listaExposicoes = new ArrayList<>();

        RegistoExposicoes re = ce.getRegistoExposicoes();
        Exposicao expo = new Exposicao("titulo1", "descricao1", new Data(), new Data(), new Data(), new Data(), new Data(), new Local("morada1"), ce);
        expo.getRegistoOrganizadores().addOrganizador(new Utilizador("nome", "usernameOrganizador", "password".toCharArray(), "email"));
        expo.getRegistoOrganizadores().addOrganizador(new Utilizador("nome", "username2", "password".toCharArray(), "email2"));
        re.registaExposicao(expo);
        expo.setEstado(new EstadoExposicaoConflitosAlterados(expo));
        listaExposicoes.add(expo);

        expo = new Exposicao("titulo2", "descricao2", new Data(), new Data(), new Data(), new Data(), new Data(), new Local("morada2"), ce);
        re.registaExposicao(expo);
        expo.getRegistoOrganizadores().addOrganizador(new Utilizador("nome", "usernameOrganizador", "password".toCharArray(), "email"));
        expo.getRegistoOrganizadores().addOrganizador(new Utilizador("nome", "username2", "password".toCharArray(), "email2"));
        expo.setEstado(new EstadoExposicaoDemosDefinidasSemFAE(expo));

        instance.getRegistoExposicoes();

        assertEquals(listaExposicoes, instance.getListaExposicoesDoOrganizadorEstadoConflitosAlterados());
    }

    /**
     * Test of setExposicao method, of class
     * AtribuirCandidaturasAExposicaoController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao exposicao = new DadosInstanciados().getExpo1();
        instance.setExposicao(exposicao);
    }

    /**
     * Test of setEstadoCandidaturaAtribuida method, of class
     * AtribuirCandidaturasAExposicaoController.
     */
    @Test
    public void testSetEstadoCandidaturaAtribuida() {
        System.out.println("setEstadoCandidaturaAtribuida");
        AtribuirCandidaturasAExposicaoController instance = null;
        instance.setEstadoCandidaturaAtribuida();
    }

    /**
     * Test of atribui method, of class
     * AtribuirCandidaturasAExposicaoController.
     */
    @Test
    public void testAtribui_Mecanismo() {
        System.out.println("atribui");
        Mecanismo mec = null;
        AtribuirCandidaturasAExposicaoController instance = null;
        List<AtribuicaoCandidatura> expResult = null;
        List<AtribuicaoCandidatura> result = instance.atribui(mec);
        assertEquals(expResult, result);
    }

    /**
     * Test of atribui method, of class
     * AtribuirCandidaturasAExposicaoController.
     */
    @Test
    public void testAtribui_Mecanismo_String() {
        System.out.println("atribui");
        Mecanismo mec = null;
        String numeroFAEOuExperiencia = "";
        AtribuirCandidaturasAExposicaoController instance = null;
        List<AtribuicaoCandidatura> expResult = null;
        List<AtribuicaoCandidatura> result = instance.atribui(mec, numeroFAEOuExperiencia);
        assertEquals(expResult, result);
    }

}
