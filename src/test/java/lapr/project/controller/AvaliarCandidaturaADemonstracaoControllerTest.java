package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracao;
import lapr.project.estados.Demonstracao.EstadoDemonstracao;
import lapr.project.model.*;
import lapr.project.registos.*;
import lapr.project.utils.Data;
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
public class AvaliarCandidaturaADemonstracaoControllerTest {

    private AvaliarCandidaturaADemonstracaoController instance;
    private CentroExposicoes ce;
    private Exposicao e;
    private RegistoExposicoes re;
    private Demonstracao d;
    private RegistoDemonstracoes rd;
    private RegistoAtribuicoesCandidaturasDemonstracao racd;
    private AtribuicaoCandidaturaDemonstracao acd;
    private Avaliacao avaliacao;
    private RegistoFaeAvaliacao rfa;
    private CandidaturaADemonstracao cd;

    public AvaliarCandidaturaADemonstracaoControllerTest() {
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
        racd = e.getRegistoAtribuicoesDemonstracao();
        cd = new CandidaturaADemonstracao("", "");
        acd = new AtribuicaoCandidaturaDemonstracao(cd);
        rfa = acd.getRegistoFaeAvaliacao();
        avaliacao = acd.getRegistoFaeAvaliacao().getAvaliacaoDoFae("");

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getRegistoExposicoes method, of class
     * AvaliarCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        instance.getRegistoExposicoes();
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasAtribuidasDoFAE method, of
     * class AvaliarCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAtribuidasDoFAE() {
        System.out.println("getListaExposicoesEstadoCandidaturasAtribuidasDoFAE");
        String usernameFAE = "";
        ArrayList<Exposicao> expResult = new ArrayList<>();
        ArrayList<Exposicao> result = instance.getListaExposicoesEstadoCandidaturasAtribuidasDoFAE(usernameFAE);
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicao method, of class
     * AvaliarCandidaturaADemonstracaoController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao e = new Exposicao("a", "b", new Data(2015, 05, 03), new Data(2015, 05, 04), new Data(2015, 05, 05), new Data(2015, 05, 06), new Data(2015, 05, 07), new Local("l"), ce);
        instance.setExposicao(e);
    }

    /**
     * Test of getRegistoDemonstracoes method, of class
     * AvaliarCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetRegistoDemonstracoes() {
        System.out.println("getRegistoDemonstracoes");
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        instance.getRegistoDemonstracoes();
    }

    /**
     * Test of getListaDemonstracoesEstadoCandidaturasAtribuidas method, of
     * class AvaliarCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetListaDemonstracoesEstadoCandidaturasAtribuidas() {
        System.out.println("getListaDemonstracoesEstadoCandidaturasAtribuidas");
        String usernameFAE = "";
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        instance.getRegistoDemonstracoes();
        List<Demonstracao> expResult = new ArrayList<>();
        List<Demonstracao> result = instance.getListaDemonstracoesEstadoCandidaturasAtribuidas(usernameFAE);
        assertEquals(expResult, result);
    }

    /**
     * Test of setDemonstracao method, of class
     * AvaliarCandidaturaADemonstracaoController.
     */
    @Test
    public void testSetDemonstracao() {
        System.out.println("setDemonstracao");
        Demonstracao demonstracao = new Demonstracao();
        instance.setDemonstracao(demonstracao);
    }

    /**
     * Test of getRegistoAtribuicoes method, of class
     * AvaliarCandidaturaADemonstracaoController.
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
     * Test of getListaAtribuicoesDoFAE method, of class
     * AvaliarCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetListaAtribuicoesDoFAE() {
        System.out.println("getListaAtribuicoesDoFAE");
        String usernameFAE = "";
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        re.registaExposicao(e);
        instance.getRegistoAtribuicoes();
        ArrayList<AtribuicaoCandidaturaDemonstracao> expResult = new ArrayList<>();
        ArrayList<AtribuicaoCandidaturaDemonstracao> result = instance.getListaAtribuicoesDoFAE(usernameFAE);
        assertEquals(expResult, result);
    }

    /**
     * Test of getRegistoFaeAvalicao method, of class
     * AvaliarCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetRegistoFaeAvalicao() {
        System.out.println("getRegistoFaeAvalicao");
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        re.registaExposicao(e);
        instance.getRegistoAtribuicoes();
        acd.getRegistoFaeAvaliacao();
    }

    /**
     * Test of setAtribuicao method, of class
     * AvaliarCandidaturaADemonstracaoController.
     */
    @Test
    public void testSetAtribuicao() {
        System.out.println("setAtribuicao");
        AtribuicaoCandidaturaDemonstracao atribuicao = null;
        instance.setAtribuicao(atribuicao);
    }

    /**
     * Test of getDadosCandidatura method, of class
     * AvaliarCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetDadosCandidatura() {
        System.out.println("getDadosCandidatura");
        acd = new AtribuicaoCandidaturaDemonstracao(cd);
        String expResult = "";
        String result = instance.getDadosCandidatura();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAvaliacaoDoFae method, of class
     * AvaliarCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetAvaliacaoDoFae() {
        System.out.println("getAvaliacaoDoFae");
        String usernameFAE = "";
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        re.registaExposicao(e);
        instance.getRegistoAtribuicoes();
        acd.getRegistoFaeAvaliacao();
        Avaliacao expResult = null;
        Avaliacao result = instance.getAvaliacaoDoFae(usernameFAE);
        assertEquals(expResult, result);
    }

    /**
     * Test of setAvaliacao method, of class
     * AvaliarCandidaturaADemonstracaoController.
     */
    @Test
    public void testSetAvaliacao() {
        System.out.println("setAvaliacao");
        int ratingConhecimentoSobreTema = 0;
        int ratingAdequacaoDadosCandidatura = 0;
        int ratingRecomendacaoGlobal = 0;
        instance.setAvaliacao(ratingConhecimentoSobreTema, ratingAdequacaoDadosCandidatura, ratingRecomendacaoGlobal);
    }

    /**
     * Test of setEstadoCandiaturaAvaliada method, of class
     * AvaliarCandidaturaADemonstracaoController.
     */
    @Test
    public void testSetEstadoCandiaturaAvaliada() {
        System.out.println("setEstadoCandiaturaAvaliada");
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        instance.getRegistoDemonstracoes();
        instance.setDemonstracao(d);
        instance.setEstadoCandiaturaAvaliada();
    }

}
