package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracaoAvaliada;
import lapr.project.estados.Demonstracao.EstadoDemonstracaoCandidaturasAtribuidas;
import lapr.project.estados.Exposicao.EstadoExposicaoCandidaturasDecididas;
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
    private AtribuicaoCandidaturaDemonstracao a;
    private Avaliacao avaliacao;
    private Avaliacao avaliacaoDoFAE;
    private RegistoFaeAvaliacao rfa;
    private CandidaturaADemonstracao cd;
    private FAE fae;
    private Utilizador u;
    
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
        u = new Utilizador("a", "b", "Aa.1".toCharArray(), "a@b.c");
        ce = new CentroExposicoes();
        ce.getRegistoUtilizadoresConfirmados().getListaUtilizadores().add(u);
        e = new Exposicao("a", "b", new Data(2015, 05, 03), new Data(2015, 05, 04), new Data(2015, 05, 05), new Data(2015, 05, 06), new Data(2015, 05, 07),new Data(2015,5,8), new Local("l"), ce);
        re = ce.getRegistoExposicoes();
        d = new Demonstracao();
        rd = e.getRegistoDemonstracoes();
        racd = e.getRegistoAtribuicoesDemonstracao();
        cd = new CandidaturaADemonstracao("dados", "email");
        a = new AtribuicaoCandidaturaDemonstracao(cd);
        fae = new FAE(u);
        a.addFaeAvaliacao(fae);
        racd.getListaAtribuicoes().add(a);
        a = new AtribuicaoCandidaturaDemonstracao(cd);
        rfa = a.getRegistoFaeAvaliacao();
        avaliacao = a.getRegistoFaeAvaliacao().getAvaliacaoDoFae("b");
        instance = new AvaliarCandidaturaADemonstracaoController(ce);
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
     * Test of setExposicao method, of class
     * AvaliarCandidaturaADemonstracaoController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
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
    public void testGetListaAtribuicoesDoFAE(){
        System.out.println("getListaAtribuicoesDoFAE");
        String usernameFAE = "b";
        instance = new AvaliarCandidaturaADemonstracaoController(ce);
        instance.getRegistoExposicoes();
        instance.setExposicao(e);
        ce.getRegistoExposicoes().getListaExposicoes().add(e);
        instance.getRegistoAtribuicoes();
        instance.getRegistoDemonstracoes();
        Demonstracao demo = new Demonstracao("descricao", e);
        CandidaturaADemonstracao candDemo = new CandidaturaADemonstracao("dados", "mail");
        demo.setCodigoIdentificacao("codigoID");
        instance.setDemonstracao(demo);
        candDemo.setDemonstracao(demo);
        candDemo.setEstado(new EstadoCandidaturaADemonstracaoAvaliada(candDemo));
        demo.getRegistoCandidaturasADemonstracao().getListaCandidaturasADemonstracao().add(candDemo);
        AtribuicaoCandidaturaDemonstracao atCandDemo = new AtribuicaoCandidaturaDemonstracao(candDemo);
        atCandDemo.addFaeAvaliacao(fae);
        e.getRegistoAtribuicoesDemonstracao().getListaAtribuicoes().add(atCandDemo);
        e.getRegistoDemonstracoes().getListaDemonstracoes().add(demo);
        ArrayList<AtribuicaoCandidaturaDemonstracao> expResult = new ArrayList<>();
        expResult.add(atCandDemo);
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
        a.getRegistoFaeAvaliacao();
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
        instance.setAtribuicao(a);
        String expResult = "dados";
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
        String usernameFAE = "b";
        instance.setExposicao(e);
        instance.setAtribuicao(a);
        instance.getRegistoAtribuicoes();
        a.getRegistoFaeAvaliacao();
        Avaliacao expResult = this.avaliacao;
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
        int ratingConhecimentoSobreTema = 3;
        int ratingAdequacaoDadosCandidatura = 3;
        int ratingRecomendacaoGlobal = 3;
        instance.setAtribuicao(a);
        FaeAvaliacao fav = new FaeAvaliacao(fae);
        a.getRegistoFaeAvaliacao().getListaFaeAvaliacao().add(fav);
        instance.getAvaliacaoDoFae("b");
        instance.setAvaliacao(ratingConhecimentoSobreTema, ratingAdequacaoDadosCandidatura, ratingRecomendacaoGlobal);
    }

    /**
     * Test of setEstadoCandiaturaAvaliada method, of class
     * AvaliarCandidaturaADemonstracaoController.
     */
    @Test
    public void testSetEstadoCandiaturaAvaliada() {
        System.out.println("setEstadoCandiaturaAvaliada");
        CandidaturaADemonstracao cand = new CandidaturaADemonstracao("dados", "email");
        instance.setEstadoCandiaturaAvaliada(cand);
    }

    /**
     * Test of getListaExposicoes method, of class
     * AvaliarCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetListaExposicoes() {
        System.out.println("getListaExposicoes");
        instance.getRegistoExposicoes();
        d.setEstado(new EstadoDemonstracaoCandidaturasAtribuidas(d));
        d.getRegistoFAE().getListaFAE().add(fae);
        e.getRegistoDemonstracoes().getListaDemonstracoes().add(d);
        e.setEstado(new EstadoExposicaoCandidaturasDecididas(e));
        ArrayList<Exposicao> expResult = new ArrayList<>();
        ArrayList<Exposicao> result = instance.getListaExposicoes("b");
        assertEquals(expResult, result);
    }
    
}
