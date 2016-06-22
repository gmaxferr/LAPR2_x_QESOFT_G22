package lapr.project.controller;

import java.util.*;
import lapr.project.dados.DadosInstanciados;
import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracaoAceite;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoAceite;
import lapr.project.model.*;
import lapr.project.registos.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author G29
 */
public class PercentagemCandAceitesMediaRatingsControllerTest {

    private CentroExposicoes ce;
    private Exposicao e;
    private RegistoCandidaturasAExposicao rc;

    public PercentagemCandAceitesMediaRatingsControllerTest() {
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
        e = new DadosInstanciados().getExpo1();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setExposicaoSelecionada method, of class
     * PercentagemCandAceitesMediaRatingsController.
     */
    @Test
    public void testSetExposicaoSelecionada() {
        System.out.println("setExposicaoSelecionada");
        e.setDescricao("teste");
        PercentagemCandAceitesMediaRatingsController instance = new PercentagemCandAceitesMediaRatingsController(ce);
        instance.setExposicaoSelecionada(e);
        assertEquals("teste", e.getDescricao());
    }

    /**
     * Test of getListaCandidaturasAExposicao method, of class
     * PercentagemCandAceitesMediaRatingsController.
     */
    @Test
    public void testGetListaCandidaturas() {
        System.out.println("getListaCandidaturas");
        rc = e.getRegistoCandidaturasAExposicao();
        PercentagemCandAceitesMediaRatingsController instance = new PercentagemCandAceitesMediaRatingsController(ce);
        instance.setExposicaoSelecionada(e);
        instance.getRegistoCandidaturasAExposicao();
        assertEquals(rc.getListaCandidaturas(), instance.getListaCandidaturasAExposicao());
    }

    /**
     * Test of getPercentagemCandidaturasAExposicaoAceitesDoExpositor method, of
     * class PercentagemCandAceitesMediaRatingsController.
     *
     */
    @Test
    public void getPercentagemCandidaturasAExposicaoAceitesDoExpositor() {
        System.out.println("getPercentagemCandidaturasAceitesDoExpositor");

        ce.getRegistoExposicoes().registaExposicao(e);
        CandidaturaAExposicao candidatura = new CandidaturaAExposicao(new Expositor(new Utilizador("nome", "username", "password".toCharArray(), "email")));
        e.getRegistoCandidaturasAExposicao().registaCandidatura(candidatura);
        candidatura.setEstado(new EstadoCandidaturaAExposicaoAceite(candidatura));
        PercentagemCandAceitesMediaRatingsController instance = new PercentagemCandAceitesMediaRatingsController(ce);

        instance.setExposicaoSelecionada(e);
        instance.getRegistoCandidaturasAExposicao();

        assertEquals(100.0f, instance.getPercentagemCandidaturasAExposicaoAceitesDoExpositor("email"), 0.0f);
    }

    /**
     * Test of getMediaRatingsTodasCandidaturasAExposicao method, of class
     * PercentagemCandAceitesMediaRatingsController.
     */
    @Test
    public void getMediaRatingsTodasCandidaturasAExposicao() {
        System.out.println("getMediaRatingsTodasCandidaturasAExposicao");

        RegistoAtribuicoesCandidaturasExposicao registoAtribuicoes = e.getRegistoAtribuicoesExposicao();

        List<AtribuicaoCandidatura> listaAtribuicoes = new ArrayList<>();

        CandidaturaAExposicao candidatura = new CandidaturaAExposicao(new Expositor(new Utilizador("nome", "username", "password".toCharArray(), "email")));
        AtribuicaoCandidatura atribuicao = new AtribuicaoCandidatura(candidatura);
        RegistoFaeAvaliacao registoFAEAvaliacao = atribuicao.getRegistoFaeAvaliacao();
        registoFAEAvaliacao.addFaeAvaliacao(new FAE(new Utilizador("nome", "username1", "password".toCharArray(), "email")));
        registoFAEAvaliacao.getAvaliacaoDoFae("username1").setAvalicao(5, 5, 5, 5, 5);
        listaAtribuicoes.add(atribuicao);

        candidatura = new CandidaturaAExposicao(new Expositor(new Utilizador("nome", "username", "password".toCharArray(), "email")));
        atribuicao = new AtribuicaoCandidatura(candidatura);
        registoFAEAvaliacao = atribuicao.getRegistoFaeAvaliacao();
        registoFAEAvaliacao.addFaeAvaliacao(new FAE(new Utilizador("nome", "username2", "password".toCharArray(), "email")));
        registoFAEAvaliacao.getAvaliacaoDoFae("username2").setAvalicao(2, 2, 2, 2, 2);
        listaAtribuicoes.add(atribuicao);

        registoAtribuicoes.setListaAtribuicao(listaAtribuicoes);

        PercentagemCandAceitesMediaRatingsController instance = new PercentagemCandAceitesMediaRatingsController(ce);
        instance.setExposicaoSelecionada(e);
        instance.getRegistoAtribuicoesExposicao();

        float[] mediaRatings = {5.0f, 2.0f};
        assertEquals(mediaRatings[0], instance.getMediaRatingsTodasCandidaturasAExposicao()[0], 0.0f);
    }

    /**
     * Test of setExposicaoSelecionada method, of class
     * PercentagemCandAceitesMediaRatingsController.
     */
    @Test
    public void testSetM_exposicaoSelecionada() {
        System.out.println("setM_exposicaoSelecionada");
        Exposicao e = new Exposicao(ce);
        e.getRegistoCandidaturasAExposicao().criarCandidatura(new Utilizador());

        PercentagemCandAceitesMediaRatingsController instance = new PercentagemCandAceitesMediaRatingsController(ce);
        instance.setExposicaoSelecionada(e);
        instance.getRegistoCandidaturasAExposicao();

        assertEquals(e.getRegistoCandidaturasAExposicao().getListaCandidaturas(), instance.getListaCandidaturasAExposicao());
    }

    /**
     * Test of getPercentagemCandidaturasAsDemonstracoesAceitesDoExpositor
     * method, of class PercentagemCandAceitesMediaRatingsController.
     *
     */
    @Test
    public void testGetPercentagemCandidaturasAsDemonstracoesAceitesDoExpositor() {
        System.out.println("getPercentagemCandidaturasAceitesDoExpositor");

        ce.getRegistoExposicoes().registaExposicao(e);
        CandidaturaADemonstracao candidatura = new CandidaturaADemonstracao("dados", "email");
        e.getRegistoDemonstracoes().getListaDemonstracoes().get(0).getRegistoCandidaturasADemonstracao().adiciona(candidatura);
        candidatura.setEstado(new EstadoCandidaturaADemonstracaoAceite(candidatura));
        PercentagemCandAceitesMediaRatingsController instance = new PercentagemCandAceitesMediaRatingsController(ce);

        instance.setExposicaoSelecionada(e);
        instance.getRegistoCandidaturasAExposicao();
        instance.getRegistoAtribuicoesExposicao();
        instance.getRegistoDemonstracoes();

        assertEquals(100.0f, instance.getPercentagemCandidaturasAsDemonstracoesAceitesDoExpositor("email"), 0.0f);
    }

    /**
     * Test of getMediaRatingsTodasCandidaturasAsDemonstracoes method, of class
     * PercentagemCandAceitesMediaRatingsController.
     */
    @Test
    public void testGetMediaRatingsTodasCandidaturasAsDemonstracoes() {
        System.out.println("getMediaRatingsTodasCandidaturasAsDemonstracoes");

        RegistoAtribuicoesCandidaturasDemonstracao registoAtribuicoes = e.getRegistoAtribuicoesDemonstracao();

        List<AtribuicaoCandidaturaDemonstracao> listaAtribuicoes = new ArrayList<>();

        CandidaturaADemonstracao candidatura = new CandidaturaADemonstracao("dados", "email");
        AtribuicaoCandidaturaDemonstracao atribuicao = new AtribuicaoCandidaturaDemonstracao(candidatura);
        RegistoFaeAvaliacao registoFAEAvaliacao = atribuicao.getRegistoFaeAvaliacao();
        registoFAEAvaliacao.addFaeAvaliacao(new FAE(new Utilizador("nome", "username1", "password".toCharArray(), "email")));
        registoFAEAvaliacao.getAvaliacaoDoFae("username1").setAvalicao(5, 5, 5, 5, 5);
        listaAtribuicoes.add(atribuicao);

        candidatura = new CandidaturaADemonstracao("dados", "email");
        atribuicao = new AtribuicaoCandidaturaDemonstracao(candidatura);
        registoFAEAvaliacao = atribuicao.getRegistoFaeAvaliacao();
        registoFAEAvaliacao.addFaeAvaliacao(new FAE(new Utilizador("nome", "username2", "password".toCharArray(), "email")));
        registoFAEAvaliacao.getAvaliacaoDoFae("username2").setAvalicao(2, 2, 2, 2, 2);
        listaAtribuicoes.add(atribuicao);

        registoAtribuicoes.setListaAtribuicao(listaAtribuicoes);

        PercentagemCandAceitesMediaRatingsController instance = new PercentagemCandAceitesMediaRatingsController(ce);
        instance.setExposicaoSelecionada(e);
        instance.getRegistoAtribuicoesDemonstracoes();

        float[] mediaRatings = {5.0f, 2.0f};
        assertEquals(mediaRatings[0], instance.getMediaRatingsTodasCandidaturasAsDemonstracoes()[0], 0.0f);
    }

    /**
     * Test of getListaAtribuicoesDemonstracoes method, of class
     * PercentagemCandAceitesMediaRatingsController.
     */
    @Test
    public void testGetListaAtribuicoesDemonstracoes() {
        System.out.println("getListaAtribuicoesDemonstracoes");

        List<AtribuicaoCandidaturaDemonstracao> listaExpected = e.getRegistoAtribuicoesDemonstracao().getListaAtribuicoes();

        PercentagemCandAceitesMediaRatingsController instance = new PercentagemCandAceitesMediaRatingsController(ce);
        instance.setExposicaoSelecionada(e);
        instance.getRegistoAtribuicoesDemonstracoes();

        assertEquals(listaExpected, instance.getListaAtribuicoesDemonstracoes());
    }

    /**
     * Test of getListaCandidaturasAExposicao method, of class
     * PercentagemCandAceitesMediaRatingsController.
     */
    @Test
    public void testGetListaCandidaturasAExposicao() {
        System.out.println("getListaCandidaturasAExposicao");

        List<CandidaturaAExposicao> listaExpected = e.getRegistoCandidaturasAExposicao().getListaCandidaturas();

        PercentagemCandAceitesMediaRatingsController instance = new PercentagemCandAceitesMediaRatingsController(ce);
        instance.setExposicaoSelecionada(e);
        instance.getRegistoCandidaturasAExposicao();

        assertEquals(listaExpected, instance.getListaCandidaturasAExposicao());
    }

    /**
     * Test of getMediaRatingsPorCriterioDasCandidaturasAExposicao method, of
     * class PercentagemCandAceitesMediaRatingsController.
     */
    @Test
    public void testGetMediaRatingsPorCriterioDasCandidaturasAExposicao() {
        System.out.println("getMediaRatingsPorCriterioDasCandidaturasAExposicao");
        PercentagemCandAceitesMediaRatingsController instance = null;
        float[][] expResult = null;
        float[][] result = instance.getMediaRatingsPorCriterioDasCandidaturasAExposicao();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMediaRatingsPorCriterioDasCandidaturasAsDemonstracoes method,
     * of class PercentagemCandAceitesMediaRatingsController.
     */
    @Test
    public void testGetMediaRatingsPorCriterioDasCandidaturasAsDemonstracoes() {
        System.out.println("getMediaRatingsPorCriterioDasCandidaturasAsDemonstracoes");

        RegistoAtribuicoesCandidaturasDemonstracao registoAtribuicoes = e.getRegistoAtribuicoesDemonstracao();

        List<AtribuicaoCandidaturaDemonstracao> listaAtribuicoes = new ArrayList<>();

        CandidaturaADemonstracao candidatura = new CandidaturaADemonstracao("dados", "email");
        AtribuicaoCandidaturaDemonstracao atribuicao = new AtribuicaoCandidaturaDemonstracao(candidatura);
        RegistoFaeAvaliacao registoFAEAvaliacao = atribuicao.getRegistoFaeAvaliacao();
        registoFAEAvaliacao.addFaeAvaliacao(new FAE(new Utilizador("nome", "username1", "password".toCharArray(), "email")));
        registoFAEAvaliacao.getAvaliacaoDoFae("username1").setAvalicao(5, 5, 5, 5, 5);
        listaAtribuicoes.add(atribuicao);

        candidatura = new CandidaturaADemonstracao("dados", "email");
        atribuicao = new AtribuicaoCandidaturaDemonstracao(candidatura);
        registoFAEAvaliacao = atribuicao.getRegistoFaeAvaliacao();
        registoFAEAvaliacao.addFaeAvaliacao(new FAE(new Utilizador("nome", "username2", "password".toCharArray(), "email")));
        registoFAEAvaliacao.getAvaliacaoDoFae("username2").setAvalicao(2, 2, 2, 2, 2);
        listaAtribuicoes.add(atribuicao);

        registoAtribuicoes.setListaAtribuicao(listaAtribuicoes);

        PercentagemCandAceitesMediaRatingsController instance = new PercentagemCandAceitesMediaRatingsController(ce);
        instance.setExposicaoSelecionada(e);
        instance.getRegistoAtribuicoesDemonstracoes();

        float[][] mediaRatings = new float[2][5];
        mediaRatings[0][0] = 5;
        mediaRatings[0][1] = 5;
        mediaRatings[0][2] = 5;
        mediaRatings[0][3] = 5;
        mediaRatings[0][4] = 5;
        mediaRatings[1][0] = 2;
        mediaRatings[1][1] = 2;
        mediaRatings[1][2] = 2;
        mediaRatings[1][3] = 2;
        mediaRatings[1][4] = 2;
        assertEquals(mediaRatings[0][1], instance.getMediaRatingsPorCriterioDasCandidaturasAsDemonstracoes()[0][1], 0.0f);
        assertEquals(mediaRatings[0][4], instance.getMediaRatingsPorCriterioDasCandidaturasAsDemonstracoes()[0][4], 0.0f);
        assertEquals(mediaRatings[1][3], instance.getMediaRatingsPorCriterioDasCandidaturasAsDemonstracoes()[1][3], 0.0f);
    }

    /**
     * Test of getListaExposicoesEstadoAvaliadas method, of class
     * PercentagemCandAceitesMediaRatingsController.
     */
    @Test
    public void testGetListaExposicoesEstadoAvaliadas() {
        System.out.println("getListaExposicoesEstadoAvaliadas");

        PercentagemCandAceitesMediaRatingsController instance = new PercentagemCandAceitesMediaRatingsController(ce);

        assertEquals(expResult, instance.getListaExposicoesEstadoAvaliadas());
    }
}
