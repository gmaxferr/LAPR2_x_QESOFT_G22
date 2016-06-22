package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.dados.DadosInstanciados;
import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracaoAceite;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoAceite;
import lapr.project.model.*;
import lapr.project.registos.RegistoAtribuicoesCandidaturasExposicao;
import lapr.project.registos.RegistoCandidaturasAExposicao;
import lapr.project.registos.RegistoFaeAvaliacao;
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
        instance.setM_exposicaoSelecionada(e);
        assertEquals("teste", e.getDescricao());
    }

    /**
     * Test of getListaCandidaturas method, of class
     * PercentagemCandAceitesMediaRatingsController.
     */
    @Test
    public void testGetListaCandidaturas() {
        System.out.println("getListaCandidaturas");
        rc = e.getRegistoCandidaturasAExposicao();
        PercentagemCandAceitesMediaRatingsController instance = new PercentagemCandAceitesMediaRatingsController(ce);
        instance.setM_exposicaoSelecionada(e);
        instance.getRegistoCandidaturas();
        assertEquals(rc.getListaCandidaturas(), instance.getListaCandidaturas());
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

        instance.setM_exposicaoSelecionada(e);
        instance.getRegistoCandidaturas();

        assertEquals(100.0f, instance.getPercentagemCandidaturasAExposicaoAceitesDoExpositor("email"), 0.0f);
    }

    /**
     * Test of getMediaRatingsTodasCandidaturasAExposicao method, of class
     * PercentagemCandAceitesMediaRatingsController.
     */
    @Test
    public void testGetMediaRatingsTodasCandidaturas() {
        System.out.println("getMediaRatingsTodasCandidaturas");

        RegistoAtribuicoesCandidaturasExposicao registoAtribuicoes = e.getRegistoAtribuicoes();

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
        instance.setM_exposicaoSelecionada(e);
        instance.getRegistoAtribuicoes();

        float[] mediaRatings = {5.0f, 2.0f};
        assertEquals(mediaRatings[0], instance.getMediaRatingsTodasCandidaturasAExposicao()[0], 0.0f);
    }

    /**
     * Test of getListaExposicoesEstadoDecididas method, of class
     * PercentagemCandAceitesMediaRatingsController.
     */
    @Test
    public void testGetListaExposicoesEstadoDecididas() {
        System.out.println("getListaExposicoesEstadoDecididas");

        Exposicao expo = new Exposicao(ce);
        ce.getRegistoExposicoes().registaExposicao(expo);
        expo = new Exposicao(ce);
        ce.getRegistoExposicoes().registaExposicao(expo);

        PercentagemCandAceitesMediaRatingsController instance = new PercentagemCandAceitesMediaRatingsController(ce);

        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getListaExposicoesEstadoDecididas();

        assertEquals(expResult, result);
    }

    /**
     * Test of setM_exposicaoSelecionada method, of class
     * PercentagemCandAceitesMediaRatingsController.
     */
    @Test
    public void testSetM_exposicaoSelecionada() {
        System.out.println("setM_exposicaoSelecionada");
        Exposicao e = null;
        PercentagemCandAceitesMediaRatingsController instance = null;
        instance.setM_exposicaoSelecionada(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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

        instance.setM_exposicaoSelecionada(e);
        instance.getRegistoCandidaturas();
        instance.getRegistoAtribuicoes();
        instance.getRegistoDemonstrações();

        assertEquals(100.0f, instance.getPercentagemCandidaturasAsDemonstracoesAceitesDoExpositor("email"), 0.0f);
    }

    /**
     * Test of getMediaRatingsTodasCandidaturasAExposicao method, of class
     * PercentagemCandAceitesMediaRatingsController.
     */
    @Test
    public void testGetMediaRatingsTodasCandidaturasAExposicao() {
        System.out.println("getMediaRatingsTodasCandidaturasAExposicao");
        PercentagemCandAceitesMediaRatingsController instance = null;
        float[] expResult = null;
        float[] result = instance.getMediaRatingsTodasCandidaturasAExposicao();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMediaRatingsTodasCandidaturasAsDemonstracoes method, of class
     * PercentagemCandAceitesMediaRatingsController.
     */
    @Test
    public void testGetMediaRatingsTodasCandidaturasAsDemonstracoes() {
        System.out.println("getMediaRatingsTodasCandidaturasAsDemonstracoes");
        PercentagemCandAceitesMediaRatingsController instance = null;
        float[] expResult = null;
        float[] result = instance.getMediaRatingsTodasCandidaturasAsDemonstracoes();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaAtribuicoesDemonstracoes method, of class
     * PercentagemCandAceitesMediaRatingsController.
     */
    @Test
    public void testGetListaAtribuicoesDemonstracoes() {
        System.out.println("getListaAtribuicoesDemonstracoes");
        PercentagemCandAceitesMediaRatingsController instance = null;
        List<AtribuicaoCandidaturaDemonstracao> expResult = null;
        List<AtribuicaoCandidaturaDemonstracao> result = instance.getListaAtribuicoesDemonstracoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
