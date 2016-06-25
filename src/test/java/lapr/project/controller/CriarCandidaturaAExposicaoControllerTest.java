package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.Exposicao.EstadoExposicaoCandidaturasAbertas;
import lapr.project.model.*;
import lapr.project.registos.*;
import lapr.project.utils.Data;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author G29
 */
public class CriarCandidaturaAExposicaoControllerTest {

    private CentroExposicoes ce;
    private CriarCandidaturaAExposicaoController controller;
    private Exposicao e;

    public CriarCandidaturaAExposicaoControllerTest() {
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
        e = new Exposicao("titulo", "descricao", new Data(), new Data(), new Data(), new Data(), new Data(), new Data(), new Data(), new Local("local"), ce);
        controller = new CriarCandidaturaAExposicaoController(ce);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasAbertas method, of class
     * CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAbertas() {
        System.out.println("getListaExposicoesEstadoCandidaturasAbertas");
        RegistoExposicoes re = ce.getRegistoExposicoes();
        Exposicao e = new Exposicao("titulo2", "descricao", new Data(), new Data(), new Data(), new Data(), new Data(), new Data(), new Data(), new Local("local"), ce);
        e.setEstado(new EstadoExposicaoCandidaturasAbertas(e));
        List<Exposicao> expResult = re.getListaExposicoesEstadoCandidaturasAbertas();
        controller.getRegistoExposicoes();
        List<Exposicao> result = controller.getListaExposicoesEstadoCandidaturasAbertas();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicao method, of class
     * CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");

        RegistoDemonstracoes rd = e.getRegistoDemonstracoes();
        rd.addDemo(new Demonstracao("descricao", e));
        List<Demonstracao> expResult = rd.getListaDemonstracoes();

        controller.setExposicao(e);
        controller.getRegistoDemonstracoes();
        List<Demonstracao> result = controller.getListaDemonstracoes();

        assertEquals(expResult, result);
    }

    /**
     * Test of criarCandidatura method, of class
     * CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testCriarCandidatura() {
        System.out.println("criarCandidatura");
        Utilizador utilizador = new Utilizador("nome", "username", "password".toCharArray(), "email");
        controller.setExposicao(e);
        controller.getRegistoCandidaturas();
        controller.criarCandidatura(utilizador);
        controller.setDados("nomeempresa", "moradaempresa", "912345678", "15", "200");
        //se falhar a criar a candidatura manda exceção no setDados
    }

    /**
     * Test of addProduto method, of class CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testAddProduto() {
        System.out.println("addProduto");
        boolean expResult = true;
        controller.setExposicao(e);
        controller.getRegistoCandidaturas();
        controller.criarCandidatura(new Utilizador("nome", "username", "password".toCharArray(), "email"));
        controller.getRegistoProduto();
        boolean result = controller.addProduto("nome");
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaDemonstracoes method, of class
     * CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testGetListaDemonstracoes() {
        System.out.println("getListaDemonstracoes");
        e.getRegistoDemonstracoes().addDemo(new Demonstracao("descricao", e));
        List<Demonstracao> expResult = e.getRegistoDemonstracoes().getListaDemonstracoes();

        controller.setExposicao(e);
        controller.getRegistoDemonstracoes();
        List<Demonstracao> result = controller.getListaDemonstracoes();

        assertEquals(expResult, result);
    }

    /**
     * Test of setListaProdutosCandidatura method, of class
     * CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testSetListaProdutosCandidatura() {
        System.out.println("setListaProdutosCandidatura");
        controller.setExposicao(e);
        controller.getRegistoCandidaturas();
        controller.criarCandidatura(new Utilizador("nome", "username", "password".toCharArray(), "email"));
        controller.getRegistoDemonstracoes();

        List<Produto> listaProdutos = new ArrayList<>();
        listaProdutos.add(new Produto("produto1"));
        listaProdutos.add(new Produto("produto2"));
        controller.setListaProdutosCandidatura(listaProdutos);
        controller.registaCandidatura();

        List<CandidaturaAExposicao> candCriada = e.getRegistoCandidaturasAExposicao().getCandidaturasRepresentante("email");

        assertEquals(listaProdutos, candCriada.get(0).getRegistoProdutos().getListaProdutosAExpor());
    }

    /**
     * Test of setListaDemonstracoesCandidatura method, of class
     * CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testSetListaDemonstracoesCandidatura() {
        System.out.println("setListaDemonstracoesCandidatura");
        controller.setExposicao(e);
        controller.getRegistoCandidaturas();
        controller.criarCandidatura(new Utilizador("nome", "username", "password".toCharArray(), "email"));
        controller.getRegistoDemonstracoes();

        List<Demonstracao> listaDemonstracoes = new ArrayList<>();
        listaDemonstracoes.add(new Demonstracao("descricao"));
        listaDemonstracoes.add(new Demonstracao("descricao2"));
        controller.setListaDemonstracoesCandidatura(listaDemonstracoes);
        controller.registaCandidatura();

        List<CandidaturaAExposicao> candCriada = e.getRegistoCandidaturasAExposicao().getCandidaturasRepresentante("email");

        assertEquals(listaDemonstracoes, candCriada.get(0).getRegistoDemonstracoes().getListaDemonstracoes());
    }

    /**
     * Test of setEstadoCandidaturaAExposicaoCriada method, of class
     * CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testSetEstadoCandidaturaAExposicaoCriada() {
        System.out.println("setEstadoCandidaturaAExposicaoCriada");
        controller.setExposicao(e);
        controller.getRegistoCandidaturas();
        controller.criarCandidatura(new Utilizador("nome", "username", "password".toCharArray(), "email"));
        assertEquals(true, controller.setEstadoCandidaturaAExposicaoCriada());
    }

    /**
     * Test of setKeywords method, of class
     * CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testSetKeywords() {
        System.out.println("setKeywords");
        String keywords = "keyword1;keyword2;keyword3;keyword4";
        controller.setExposicao(e);
        controller.getRegistoCandidaturas();
        controller.criarCandidatura(new Utilizador("nome", "username", "password".toCharArray(), "email"));
        controller.setKeywords(keywords);
    }

    /**
     * Test of setDados method, of class CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testSetDados() {
        System.out.println("setDados");
        controller.setExposicao(e);
        controller.getRegistoCandidaturas();
        controller.criarCandidatura(new Utilizador("nome", "username", "password".toCharArray(), "email"));
        controller.setDados("nome", "morada", "912345678", "1", "1");
        controller.registaCandidatura();

        List<CandidaturaAExposicao> candCriada = e.getRegistoCandidaturasAExposicao().getCandidaturasRepresentante("email");

        assertEquals("morada", candCriada.get(0).getMoradaEmpresa());
        assertEquals("nome", candCriada.get(0).getNomeEmpresa());
        assertEquals(1, candCriada.get(0).getNumConvites());
        assertEquals(912345678, candCriada.get(0).getTelemovel());
        assertEquals(1, candCriada.get(0).getArea());
    }

    /**
     * Test of adicionaDemonstracao method, of class
     * CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testAdicionaDemonstracao() {
        System.out.println("adicionaDemonstracao");
        controller.setExposicao(e);
        controller.getRegistoCandidaturas();
        controller.criarCandidatura(new Utilizador("nome", "username", "password".toCharArray(), "email"));
        controller.getRegistoDemonstracoes();
        Demonstracao d = new Demonstracao("descricao1");
        d.getRegistoRecursosNecessarios().criarRecurso("recurso");
        controller.adicionaDemonstracao(d);
        controller.registaCandidatura();

        List<CandidaturaAExposicao> candCriada = e.getRegistoCandidaturasAExposicao().getCandidaturasRepresentante("email");

        assertEquals(false, candCriada.get(0).getRegistoDemonstracoes().getListaDemonstracoes().isEmpty());
    }

    /**
     * Test of registaCandidatura method, of class
     * CriarCandidaturaAExposicaoController.
     */
    @Test
    public void testRegistaCandidatura() {
        System.out.println("registaCandidatura");
        controller.setExposicao(e);
        controller.getRegistoCandidaturas();
        controller.criarCandidatura(new Utilizador("nome", "username", "password".toCharArray(), "email"));
        controller.getRegistoDemonstracoes();

        controller.registaCandidatura();

        List<CandidaturaAExposicao> candCriada = e.getRegistoCandidaturasAExposicao().getCandidaturasRepresentante("email");

        assertEquals(false, candCriada.isEmpty());
    }

}
