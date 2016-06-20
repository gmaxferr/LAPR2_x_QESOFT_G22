package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.Exposicao.EstadoExposicaoFAEDefinidosSemDemos;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Local;
import lapr.project.model.Organizador;
import lapr.project.model.Recurso;
import lapr.project.model.Utilizador;
import lapr.project.registos.RegistoExposicoes;
import lapr.project.utils.Data;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author guilherme
 */
public class CriarDemonstracaoControllerTest {

    public CriarDemonstracaoControllerTest() {
    }

    private CentroExposicoes ce;
    private Exposicao e;
    List<Organizador> listOrg;
    private CriarDemonstracaoController instance;
    private RegistoExposicoes re;

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
        e.setTitulo("titulo");
        e.setDataAberturaSubCand(new Data("21/05/45"));
        e.setDataEncerramentoSubCand(new Data("12/12/2015"));
        e.setDescricao("desc");
        e.setPeriodo(new Data("10/05/2014"), new Data("11/05/2014"));
        e.setDataFimDetecaoConflitos(new Data("30/1/3018"));
        e.setLocal(new Local("local"));
        
        
        instance = new CriarDemonstracaoController("b", ce);
        Utilizador u = new Utilizador("a", "b", new char[]{'a', 'b', 'c', 's'}, "d");
        Organizador o = new Organizador(u);
        Utilizador u1 = new Utilizador("c", "d", new char[]{'a', 'b', 'c', 's'}, "e");
        Organizador o1 = new Organizador(u1);
        listOrg = new ArrayList<>();
        listOrg.add(o);
        listOrg.add(o1);
        e.addOrganizadores(listOrg);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of pullRegistosCE method, of class CriarDemonstracaoController.
     */
    @Test
    public void testPullRegistosCE() {
        System.out.println("pullRegistosCE");
        instance.pullRegistosCE();
    }

    /**
     * Test of getListaExposicoesDoOrganizador method, of class
     * CriarDemonstracaoController.
     */
    @Test
    public void testGetListaExposicoesDoOrganizador() {
        System.out.println("getListaExposicoesDoOrganizador");
        instance.setExposicao(e);
        instance.pullRegistosCE();
        e.setEstado(new EstadoExposicaoFAEDefinidosSemDemos(e));
        re = ce.getRegistoExposicoes();
        re.registaExposicao(e);
        ArrayList<Exposicao> expResult = new ArrayList<Exposicao>();
        expResult.add(e);
        List<Exposicao> result = instance.getListaExposicoesDoOrganizador();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicao method, of class CriarDemonstracaoController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao e = new Exposicao("a", "b", new Data("21/05/05"), new Data("21/05/05"), new Data("21/05/05"), new Data("21/05/05"), new Data("21/05/05"), new Local("s"), ce);
        instance.setExposicao(e);
    }

    /**
     * Test of pullRegistoDemonstracaoDaExposicao method, of class
     * CriarDemonstracaoController.
     */
    @Test
    public void testPullRegistoDemonstracaoDaExposicao() {
        System.out.println("pullRegistoDemonstracaoDaExposicao");
        instance.setExposicao(e);
        instance.pullRegistoDemonstracaoDaExposicao();
    }

    /**
     * Test of novaDemonstracao method, of class CriarDemonstracaoController.
     */
    @Test
    public void testNovaDemonstracao() {
        System.out.println("novaDemonstracao");
        String descricaoIntroduzidaPeloUtilizador = "";

        instance.setExposicao(e);
        instance.pullRegistoDemonstracaoDaExposicao();
        instance.novaDemonstracao(descricaoIntroduzidaPeloUtilizador);
    }

    /**
     * Test of getListaDeRecursos method, of class CriarDemonstracaoController.
     */
    @Test
    public void testGetListaDeRecursos() {
        System.out.println("getListaDeRecursos");
        instance.pullRegistosCE();
        List<Recurso> expResult = ce.getRegistoRecursos().getListaDeRecursos();
        List<Recurso> result = instance.getListaDeRecursos();
        assertEquals(expResult, result);
    }

    /**
     * Test of addRecurso method, of class CriarDemonstracaoController.
     */
    @Test
    public void testAddRecurso() {
        System.out.println("addRecurso");
        Recurso rec = new Recurso("nomeRecurso");
        instance.setExposicao(e);
        instance.pullRegistoDemonstracaoDaExposicao();
        instance.novaDemonstracao("novaDemo");
        instance.addRecurso(rec);
    }

    /**
     * Test of valida method, of class CriarDemonstracaoController.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        boolean expResult = true;
        instance.setExposicao(e);
        instance.pullRegistoDemonstracaoDaExposicao();
        instance.novaDemonstracao("demo");
        instance.addRecurso(new Recurso("novoRecurso"));
        instance.addRecurso(new Recurso("novoRecurso1"));
        instance.addRecurso(new Recurso("novoRecurso2"));
        instance.addRecurso(new Recurso("novoRecurso3"));
        instance.setRecursos();
        boolean result = instance.valida();
        assertEquals(expResult, result);
    }

    /**
     * Test of mudaEstado method, of class CriarDemonstracaoController.
     */
    @Test
    public void testMudaEstado() {
        System.out.println("mudaEstado");
        instance.setExposicao(e);
        instance.mudaEstado();
    }

    /**
     * Test of exists method, of class CriarDemonstracaoController.
     */
    @Test
    public void testExists() {
        System.out.println("exists");
        instance.setExposicao(e);
        instance.pullRegistoDemonstracaoDaExposicao();
        instance.novaDemonstracao("novaDemo");
        Recurso r = new Recurso("novoRecurso");
        Recurso r2 = new Recurso("novoRecurso2");
        boolean expResult = true;
        boolean expResult2 = false;
        instance.addRecurso(new Recurso("novoRecurso"));
        boolean result = instance.exists(r);
        boolean result2 = instance.exists(r2);
        assertEquals(expResult, result);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of setRecursos method, of class CriarDemonstracaoController.
     */
    @Test
    public void testSetRecursos() {
        System.out.println("setRecursos");
        instance.setExposicao(e);
        instance.pullRegistoDemonstracaoDaExposicao();
        instance.novaDemonstracao("novaDemo");
        instance.addRecurso(new Recurso("novoRecurso"));
        instance.setRecursos();
    }

    /**
     * Test of registaDemo method, of class CriarDemonstracaoController.
     */
    @Test
    public void testRegistaDemo() {
        System.out.println("registaDemo");
        instance.setExposicao(e);
        instance.pullRegistoDemonstracaoDaExposicao();
        instance.novaDemonstracao("novaDemo");
        instance.registaDemo();
    }

}
