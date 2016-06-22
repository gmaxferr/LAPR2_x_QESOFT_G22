package lapr.project.controller;

import java.util.*;
import lapr.project.estados.Exposicao.*;
import lapr.project.model.*;
import lapr.project.registos.RegistoFAE;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author G29
 */
public class DefinirFAEControllerTest {

    public DefinirFAEControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private DefinirFAEController instance;
    private CentroExposicoes ce;
    private String usernameOrg;
    private Utilizador u;
    private Utilizador uFAE;
    private Organizador o;
    private Exposicao e;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        usernameOrg = "org";
        e = new Exposicao(ce);
        u = new Utilizador("organizador", "org", new char[]{'a', 'A', '1', '.'}, "1@2.3", "keyword");
        uFAE = new Utilizador("FAEnome", "fae", new char[]{'a', 'A', '1', '.'}, "a@b.c", "4eyword");
        o = new Organizador(u);
        ce.getRegistoUtilizadoresConfirmados().getListaUtilizadores().add(u);
        ce.getRegistoUtilizadoresConfirmados().getListaUtilizadores().add(uFAE);
        ce.getRegistoExposicoes().getListaExposicoes().add(e);
        e.getRegistoOrganizadores().addOrganizador(o);

        e.setEstado(new EstadoExposicaoCriada(e));
        instance = new DefinirFAEController(ce, usernameOrg);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE
     * method, of class DefinirFAEController.
     */
    @Test
    public void testGetlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE() {
        System.out.println("getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE");
        instance.getRegistoUtilizadores();
        instance.getRegistoExposicoes();
        instance.setExposicao(e);
        instance.getRegistoOrganizadores();
        instance.getRegistoFAE();

        ArrayList<Exposicao> expResult = new ArrayList<>();
        expResult.add(e);
        ArrayList<Exposicao> result = instance.getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicao method, of class DefinirFAEController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao exposicao = null;
        instance.setExposicao(exposicao);
    }

    /**
     * Test of criarEAdicionarFaePeloUsername method, of class
     * DefinirFAEController.
     */
    @Test
    public void testCriarEAdicionarFaePeloUsername() {
        System.out.println("criarEAdicionarFaePeloUsername");
        instance.getRegistoUtilizadores();
        instance.getRegistoExposicoes();
        instance.setExposicao(e);
        instance.getRegistoFAE();
        instance.getRegistoOrganizadores();
        String usernameUtilizador = uFAE.getNome();
        boolean expResult = true;
        boolean result = instance.criarEAdicionarFaePeloUsername(usernameUtilizador);
        assertEquals(expResult, result);
    }

    /**
     * Test of identificarUtilizadorPeloUsername method, of class
     * DefinirFAEController.
     */
    @Test
    public void testIdentificarUtilizadorPeloUsername() {
        System.out.println("identificarUtilizadorPeloUsername");
        instance.getRegistoUtilizadores();
        instance.getRegistoExposicoes();
        instance.setExposicao(e);
        String usernameUtilizador = u.getUsername();
        Utilizador expResult = u;
        Utilizador result = instance.identificarUtilizadorPeloUsername(usernameUtilizador);
        assertEquals(expResult, result);
    }

    /**
     * Test of adicionarFaeListaTemp method, of class DefinirFAEController.
     */
    @Test
    public void testAdicionarFaeListaTemp() {
        System.out.println("adicionarFaeListaTemp");
        instance.getRegistoUtilizadores();
        instance.getRegistoExposicoes();
        instance.setExposicao(e);
        instance.getRegistoFAE();
        instance.getRegistoOrganizadores();
        boolean expResult = true;
        boolean result = instance.adicionarFaeListaTemp(uFAE);
        assertEquals(expResult, result);
    }

    /**
     * Test of validaUtilizadorParaAdicionarComoFAE method, of class
     * DefinirFAEController.
     */
    @Test
    public void testValidaUtilizadorParaAdicionarComoFAE() {
        System.out.println("validaUtilizadorParaAdicionarComoFAE");
        instance.getRegistoUtilizadores();
        instance.getRegistoExposicoes();
        instance.setExposicao(e);
        instance.getRegistoFAE();
        instance.getRegistoOrganizadores();
        Utilizador utilizador = uFAE;
        boolean expResult = true;
        boolean result = instance.validaUtilizadorParaAdicionarComoFAE(utilizador);
        assertEquals(expResult, result);
    }

    /**
     * Test of foramAdicionadosFAE method, of class DefinirFAEController.
     */
    @Test
    public void testForamAdicionadosFAE() {
        System.out.println("foramAdicionadosFAE");
        instance.setExposicao(e);
        instance.getRegistoFAE();
        instance.getRegistoOrganizadores();
        instance.adicionarFaeListaTemp(new Utilizador("nome", "username", "password".toCharArray(), "email"));
        assertEquals(true, instance.foramAdicionadosFAE());
    }

    /**
     * Test of getListaUtilizadores method, of class DefinirFAEController.
     */
    @Test
    public void testGetListaUtilizadores() {
        System.out.println("getListaUtilizadores");
        ce.getRegistoUtilizadoresConfirmados().addUtilizador(new Utilizador("nome", "username", "password".toCharArray(), "email"));
        instance.getRegistoUtilizadores();
        assertEquals(ce.getRegistoUtilizadoresConfirmados().getListaUtilizadores(), instance.getListaUtilizadores());
    }

    /**
     * Test of getListaUtilizadoresCorrespondentesAosFae method, of class
     * DefinirFAEController.
     */
    @Test
    public void testGetListaUtilizadoresCorrespondentesAosFae() {
        System.out.println("getListaUtilizadoresCorrespondentesAosFae");
        RegistoFAE registoFAE = e.getRegistoFAE();
        Utilizador u = new Utilizador("nome", "username", "password".toCharArray(), "email");
        registoFAE.adicionaFAE(u);
        List<Utilizador> listaUtilizadores = new ArrayList<>();
        listaUtilizadores.add(u);

        instance.getRegistoUtilizadores();
        instance.setExposicao(e);
        instance.getRegistoFAE();
        instance.confirmaAddFAE();

        assertEquals(listaUtilizadores, instance.getListaUtilizadoresCorrespondentesAosFae());
    }

    /**
     * Test of confirmaAddFAE method, of class DefinirFAEController.
     */
    @Test
    public void testConfirmaAddFAE() {
        System.out.println("confirmaAddFAE");

        instance.setExposicao(e);
        instance.getRegistoFAE();
        instance.getRegistoOrganizadores();
        Utilizador u = new Utilizador("nome", "username", "password".toCharArray(), "email");
        instance.adicionarFaeListaTemp(u);
        instance.confirmaAddFAE();

        //Não conseguia com lista de FAE e assim confirma na mesma o método
        List<Utilizador> listaUtilizadoresComPapelDeFAE = e.getRegistoFAE().getListaUtilizadoresCorrespondentesAosFae();
        List<Utilizador> listaUtilizadoresComPapelDeFAEEsperada = new ArrayList<>();
        listaUtilizadoresComPapelDeFAEEsperada.add(u);

        assertEquals(listaUtilizadoresComPapelDeFAEEsperada, listaUtilizadoresComPapelDeFAE);
    }

    /**
     * Test of getEstadoExposicao method, of class DefinirFAEController.
     */
    @Test
    public void testGetEstadoExposicao() {
        System.out.println("getEstadoExposicao");

        e.getEstado().setEstadoDemosDefinidasSemFAE();

        instance.setExposicao(e);

        EstadoExposicao expResult = e.getEstado();
        EstadoExposicao result = instance.getEstadoExposicao();

        assertEquals(expResult, result);
    }

    /**
     * Test of setEstado method, of class DefinirFAEController.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");

        e.getRegistoFAE().adicionaFAE(new Utilizador("nome1", "username1", "password".toCharArray(), "email1"));
        e.getRegistoFAE().adicionaFAE(new Utilizador("nome2", "username2", "password".toCharArray(), "email2"));

        e.setEstado(new EstadoExposicaoCriada(e));

        instance.setExposicao(e);
        instance.getRegistoFAE();
        instance.setEstado();

        assertEquals(true, e.getEstado().isEstadoFAEDefinidosSemDemos());
    }

    /**
     * Test of limparFAEJaAdicionados method, of class DefinirFAEController.
     */
    @Test
    public void testLimparFAEJaAdicionados() {
        System.out.println("limparFAEJaAdicionados");

        RegistoFAE registoFAE = e.getRegistoFAE();
        List<FAE> listaFAEEsperada = registoFAE.getListaFAE();

        instance.setExposicao(e);
        instance.getRegistoFAE();
        instance.getRegistoOrganizadores();
        instance.adicionarFaeListaTemp(new Utilizador("nome", "username", "password".toCharArray(), "email"));
        instance.limparFAEJaAdicionados();

        instance.confirmaAddFAE();

        assertEquals(listaFAEEsperada, registoFAE.getListaFAE());
    }

}
