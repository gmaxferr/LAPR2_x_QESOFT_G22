package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.Exposicao.EstadoExposicao;
import lapr.project.estados.Exposicao.EstadoExposicaoCriada;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Organizador;
import lapr.project.model.Utilizador;
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
     * Test of getRegistoOrganizadores method, of class DefinirFAEController.
     */
    @Test
    public void testGetRegistoOrganizadores() {
        System.out.println("getRegistoOrganizadores");
        instance.setExposicao(e);
        instance.getRegistoOrganizadores();
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
        boolean expResult = false;
        boolean result = instance.foramAdicionadosFAE();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaUtilizadores method, of class DefinirFAEController.
     */
    @Test
    public void testGetListaUtilizadores() {
        System.out.println("getListaUtilizadores");
        instance.getRegistoUtilizadores();
        List<Utilizador> expResult = new ArrayList<>();
        expResult.add(u);
        expResult.add(uFAE);
        List<Utilizador> result = instance.getListaUtilizadores();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaUtilizadoresCorrespondentesAosFae method, of class
     * DefinirFAEController.
     */
    @Test
    public void testGetListaUtilizadoresCorrespondentesAosFae() {
        System.out.println("getListaUtilizadoresCorrespondentesAosFae");
        instance.getRegistoUtilizadores();
        instance.getRegistoExposicoes();
        instance.setExposicao(e);
        instance.getRegistoFAE();
        instance.getRegistoOrganizadores();
        instance.criarEAdicionarFaePeloUsername(uFAE.getUsername());
        instance.confirmaAddFAE();
        List<Utilizador> expResult = new ArrayList<>();
        expResult.add(uFAE);
        List<Utilizador> result = instance.getListaUtilizadoresCorrespondentesAosFae();
        assertEquals(expResult, result);
    }

    /**
     * Test of confirmaAddFAE method, of class DefinirFAEController.
     */
    @Test
    public void testConfirmaAddFAE() {
        System.out.println("confirmaAddFAE");
        instance.getRegistoUtilizadores();
        instance.getRegistoExposicoes();
        instance.setExposicao(e);
        instance.getRegistoFAE();
        instance.getRegistoOrganizadores();
        instance.confirmaAddFAE();
    }

    /**
     * Test of getRegistoExposicoes method, of class DefinirFAEController.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        instance.getRegistoExposicoes();
    }

    /**
     * Test of getRegistoUtilizadores method, of class DefinirFAEController.
     */
    @Test
    public void testGetRegistoUtilizadores() {
        System.out.println("getRegistoUtilizadores");
        instance.getRegistoUtilizadores();
    }

    /**
     * Test of getRegistoFAE method, of class DefinirFAEController.
     */
    @Test
    public void testGetRegistoFAE() {
        System.out.println("getRegistoFAE");
        instance.setExposicao(e);
        instance.getRegistoFAE();
    }

    /**
     * Test of getEstadoExposicao method, of class DefinirFAEController.
     */
    @Test
    public void testGetEstadoExposicao() {
        System.out.println("getEstadoExposicao");
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
        instance.setExposicao(e);
        instance.setEstado();
    }

    /**
     * Test of limparFAEJaAdicionados method, of class DefinirFAEController.
     */
    @Test
    public void testLimparFAEJaAdicionados() {
        System.out.println("limparFAEJaAdicionados");
        instance.limparFAEJaAdicionados();
    }

}
