package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.dados.DadosInstanciados;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoAceite;
import lapr.project.model.*;
import lapr.project.registos.RegistoAtribuicoes;
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
        instance.setExposicaoSelecionada(e);
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
        instance.setExposicaoSelecionada(e);
        instance.getRegistoCandidaturas();
        assertEquals(rc.getListaCandidaturas(), instance.getListaCandidaturas());
    }

    /**
     * Test of getPercentagemCandidaturasAceitesDoExpositor method, of class
     * PercentagemCandAceitesMediaRatingsController.
     */
    @Test
    public void testGetPercentagemCandidaturasAceitesDoExpositor() {
        System.out.println("getPercentagemCandidaturasAceitesDoExpositor");
        ce.getRegistoExposicoes().registaExposicao(e);
        CandidaturaAExposicao candidatura = new CandidaturaAExposicao(new Expositor(new Utilizador("nome", "username", "password".toCharArray(), "email")));
        e.getRegistoCandidaturasAExposicao().registaCandidatura(candidatura);
        candidatura.setEstado(new EstadoCandidaturaAExposicaoAceite(candidatura));
        PercentagemCandAceitesMediaRatingsController instance = new PercentagemCandAceitesMediaRatingsController(ce);
        instance.setExposicaoSelecionada(e);
        instance.getRegistoCandidaturas();
        assertEquals(100.0f, instance.getPercentagemCandidaturasAceitesDoExpositor("email"), 0.0f);
    }

    /**
     * Test of getMediaRatingsTodasCandidaturas method, of class
     * PercentagemCandAceitesMediaRatingsController.
     */
    @Test
    public void testGetMediaRatingsTodasCandidaturas() {
        System.out.println("getMediaRatingsTodasCandidaturas");

        RegistoAtribuicoes registoAtribuicoes = e.getRegistoAtribuicoes();

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
        instance.getRegistoAtribuicoes();

        float[] mediaRatings = {5.0f, 2.0f};
        assertEquals(mediaRatings[0], instance.getMediaRatingsTodasCandidaturas()[0], 0.0f);
    }

}
