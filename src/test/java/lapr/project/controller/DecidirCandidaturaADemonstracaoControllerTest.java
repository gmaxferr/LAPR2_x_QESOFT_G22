package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracaoAvaliada;
import lapr.project.estados.Demonstracao.EstadoDemonstracaoCandidaturasAvaliadas;
import lapr.project.model.CandidaturaADemonstracao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
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
 * @author guilherme
 */
public class DecidirCandidaturaADemonstracaoControllerTest {

    public DecidirCandidaturaADemonstracaoControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private DecidirCandidaturaADemonstracaoController instance;
    private final String username = "user";
    private final String emailRep = "emailRep";
    private final String dados = "dados";
    private final String codigo = "cod1";
    private final String descricaoDemo = "descDemo";
    private CentroExposicoes ce;
    private CandidaturaADemonstracao cand;
    private Exposicao e;
    private Demonstracao d;
    private Organizador o;
    private Utilizador u;

    @Before
    public void setUp() {
        u = new Utilizador();
        u.setUsername(username);
        o = new Organizador(u);
        ce = new CentroExposicoes();
        e = new Exposicao(ce);
        ce.getRegistoExposicoes().getListaExposicoes().add(e);
        d = new Demonstracao(descricaoDemo, e);
        e.getRegistoDemonstracoes().getListaDemonstracoes().add(d);
        cand = new CandidaturaADemonstracao(dados, emailRep);
        cand.setEstado(new EstadoCandidaturaADemonstracaoAvaliada(cand));
        d.getRegistoCandidaturasADemonstracao().getListaCandidaturasADemonstracao().add(cand);
        d.setCodigoIdentificacao(codigo);
        d.setEstado(new EstadoDemonstracaoCandidaturasAvaliadas(d));
        e.getRegistoOrganizadores().getListaOrganizadores().add(o);
        instance = new DecidirCandidaturaADemonstracaoController(ce, username);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getRegistoExposicoes method, of class
     * DecidirCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        instance.getRegistoExposicoes();
    }

    /**
     * Test of getListaExposicoes method, of class
     * DecidirCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetListaExposicoes() {
        System.out.println("getListaExposicoes");
        instance.getRegistoExposicoes();
        ArrayList<Exposicao> expResult = new ArrayList<>();
        expResult.add(e);
        ArrayList<Exposicao> result = instance.getListaExposicoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRegistoCandidaturas method, of class
     * DecidirCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetRegistoCandidaturas() {
        System.out.println("getRegistoCandidaturas");
        instance.getRegistoExposicoes();
        instance.setExposicao(e);
        instance.setDemonstracao(d);
        instance.getRegistoCandidaturas();
    }

    /**
     * Test of setDecisao method, of class
     * DecidirCandidaturaADemonstracaoController.
     */
    @Test
    public void testSetDecisao() {
        System.out.println("setDecisao");
        boolean decisao = false;
        instance.setCandidatura(cand);
        instance.setDecisao(decisao);
    }

    /**
     * Test of setExposicao method, of class
     * DecidirCandidaturaADemonstracaoController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        instance.setExposicao(e);
    }

    /**
     * Test of setCandidatura method, of class
     * DecidirCandidaturaADemonstracaoController.
     */
    @Test
    public void testSetCandidatura() {
        System.out.println("setCandidatura");
        instance.setCandidatura(cand);
    }

    /**
     * Test of getDadosCandidatura method, of class
     * DecidirCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetDadosCandidatura() {
        System.out.println("getDadosCandidatura");
        String expResult = dados;
        instance.setCandidatura(cand);
        String result = instance.getDadosCandidatura();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmailRep method, of class
     * DecidirCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetEmailRep() {
        System.out.println("getEmailRep");
        String expResult = emailRep;
        instance.setCandidatura(cand);
        String result = instance.getEmailRep();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaDemonstracoes method, of class
     * DecidirCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetListaDemonstracoes() {
        System.out.println("getListaDemonstracoes");
        ArrayList<Demonstracao> expResult = new ArrayList<>();
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        expResult.add(d);
        ArrayList<Demonstracao> result = instance.getListaDemonstracoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDemonstracao method, of class
     * DecidirCandidaturaADemonstracaoController.
     */
    @Test
    public void testSetDemonstracao() {
        System.out.println("setDemonstracao");
        instance.setDemonstracao(d);
    }

    /**
     * Test of getDescricaoDemo method, of class
     * DecidirCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetDescricaoDemo() {
        System.out.println("getDescricaoDemo");
        String expResult = descricaoDemo;
        instance.setDemonstracao(d);
        String result = instance.getDescricaoDemo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCodigoIDDemo method, of class
     * DecidirCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetCodigoIDDemo() {
        System.out.println("getCodigoIDDemo");
        String expResult = codigo;
        instance.setDemonstracao(d);
        String result = instance.getCodigoIDDemo();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCandidaturas method, of class
     * DecidirCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetCandidaturas() {
        System.out.println("getCandidaturas");
        List<CandidaturaADemonstracao> expResult = new ArrayList<>();
        expResult.add(cand);
        instance.setDemonstracao(d);
        instance.getRegistoCandidaturas();
        List<CandidaturaADemonstracao> result = instance.getCandidaturas();
        assertEquals(expResult, result);
    }
}
