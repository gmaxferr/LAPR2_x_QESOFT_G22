package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracaoProntaAAtribuicao;
import lapr.project.estados.Demonstracao.EstadoDemonstracaoConflitosDetetados;
import lapr.project.model.AtribuicaoCandidaturaDemonstracao;
import lapr.project.model.CandidaturaADemonstracao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.ConflitoDeInteresseDemonstracao;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.model.FAE;
import lapr.project.model.TipoConflitoDemonstracao;
import lapr.project.model.Utilizador;
import lapr.project.registos.RegistoAtribuicoesCandidaturasDemonstracao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author guima
 */
public class AtualizarConflitoDeInteresseCandidaturaADemonstracaoControllerTest {

    public AtualizarConflitoDeInteresseCandidaturaADemonstracaoControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private AtualizarConflitoDeInteresseCandidaturaADemonstracaoController instance;
    private ConflitoDeInteresseDemonstracao conf;
    private FAE fae;
    private CandidaturaADemonstracao cand;
    private TipoConflitoDemonstracao tipo;
    private Utilizador u;
    private final String username = "user";
    private final String email = "email";
    private final String id = "idTipo";
    private CentroExposicoes ce;
    private Exposicao e;
    private Demonstracao d;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        u = new Utilizador();
        e = new Exposicao(ce);
        d = new Demonstracao("desc", e);
        cand = new CandidaturaADemonstracao("dados", "emailRep");

        fae = new FAE(u);
        e.getRegistoFAE().getListaFAE().add(fae);
        e.getRegistoDemonstracoes().getListaDemonstracoes().add(d);
        d.getRegistoCandidaturasADemonstracao().getListaCandidaturasADemonstracao().add(cand);
        ce.getRegistoExposicoes().getListaExposicoes().add(e);
        u.setEmail(email);
        u.setUsername(username);
        d.getRegistoFAE().getListaFAE().add(fae);
        e.getRegistoFAE().getListaFAE().add(fae);
        conf = new ConflitoDeInteresseDemonstracao(fae, cand, tipo);
        d.getRegistoConflitosDemonstracao().getListaConflitos().add(conf);
        tipo = new TipoConflitoDemonstracao(id);
        instance = new AtualizarConflitoDeInteresseCandidaturaADemonstracaoController(username, ce);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getListaConflitos method, of class
     * AtualizarConflitoDeInteresseCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetListaConflitos() {
        System.out.println("getListaConflitos");
        instance.selectExpo(e);
        instance.selectDemo(d);
        List<ConflitoDeInteresseDemonstracao> expResult = new ArrayList<>();
        expResult.add(conf);
        List<ConflitoDeInteresseDemonstracao> result = instance.getListaConflitos();
        assertEquals(expResult, result);
    }

    /**
     * Test of removeConflito method, of class
     * AtualizarConflitoDeInteresseCandidaturaADemonstracaoController.
     */
    @Test
    public void testRemoveConflito() {
        System.out.println("removeConflito");
        instance.selectDemo(d);
        instance.getListaConflitos();
        instance.removeConflito(conf);
    }

    /**
     * Test of getFaeExpos method, of class
     * AtualizarConflitoDeInteresseCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetFaeExpos() {
        System.out.println("getFaeExpos");
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(e);
        List<Exposicao> result = instance.getFaeExpos();
        assertEquals(expResult, result);
    }

    /**
     * Test of selectExpo method, of class
     * AtualizarConflitoDeInteresseCandidaturaADemonstracaoController.
     */
    @Test
    public void testSelectExpo() {
        System.out.println("selectExpo");
        instance.selectExpo(e);
    }

    /**
     * Test of selectDemo method, of class
     * AtualizarConflitoDeInteresseCandidaturaADemonstracaoController.
     */
    @Test
    public void testSelectDemo() {
        System.out.println("selectDemo");
        instance.selectDemo(d);
    }

    /**
     * Test of setCandidatura method, of class
     * AtualizarConflitoDeInteresseCandidaturaADemonstracaoController.
     */
    @Test
    public void testSetCandidatura() {
        System.out.println("setCandidatura");
        instance.setCandidatura(cand);
    }

    /**
     * Test of getListaFae method, of class
     * AtualizarConflitoDeInteresseCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetListaFae() {
        System.out.println("getListaFae");
        List<FAE> expResult = new ArrayList<>();
        expResult.add(fae);
        instance.selectExpo(e);
        instance.selectDemo(d);
        List<FAE> result = instance.getListaFae();
        assertEquals(expResult, result);
    }

    /**
     * Test of pullRegistoDeTiposDeConflito method, of class
     * AtualizarConflitoDeInteresseCandidaturaADemonstracaoController.
     */
    @Test
    public void testPullRegistoDeTiposDeConflito() {
        System.out.println("pullRegistoDeTiposDeConflito");
        instance.pullRegistoDeTiposDeConflito();
    }

    /**
     * Test of getListaDeTiposConflito method, of class
     * AtualizarConflitoDeInteresseCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetListaDeTiposConflito() {
        System.out.println("getListaDeTiposConflito");
        List<TipoConflitoDemonstracao> expResult = new ArrayList<>();
        expResult.add(tipo);
        instance.pullRegistoDeTiposDeConflito();
        ce.getRegistoTiposConflitosDemonstracao().getListaTipoConflitos().add(tipo);
        List<TipoConflitoDemonstracao> result = instance.getListaDeTiposConflito();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaDemonstracoes method, of class
     * AtualizarConflitoDeInteresseCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetListaDemonstracoes() {
        System.out.println("getListaDemonstracoes");
        instance.selectExpo(e);
        List<Demonstracao> expResult = new ArrayList<>();
        d.setEstado(new EstadoDemonstracaoConflitosDetetados(d));
        expResult.add(d);
        List<Demonstracao> result = instance.getListaDemonstracoes();
        assertEquals(expResult, result);
    }

}
