package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.Demonstracao.EstadoDemonstracaoCandidaturasAbertas;
import lapr.project.model.CandidaturaADemonstracao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
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
public class AlterarCandidaturaDemonstracaoControllerTest {

    public AlterarCandidaturaDemonstracaoControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private AlterarCandidaturaDemonstracaoController instance;
    private Exposicao e;
    private CentroExposicoes ce;
    private Demonstracao d;
    private Utilizador u;
    private CandidaturaADemonstracao cand;
    
    private final String nome = "nome";
    private final String email = "112sss@aaa444.ccc888";
    private final String username = "username";
    private final char[] password = {'A', '.', 'c', '1', 'e'};

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(ce);
        u = new Utilizador(nome, username, password, email);
        d = new Demonstracao("descricao");
        d.setEstado(new EstadoDemonstracaoCandidaturasAbertas(d));
        e.getRegistoDemonstracoes().getListaDemonstracoesEmEstadoCandidaturasAvaliadas().add(d);
        ce.getRegistoExposicoes().getListaExposicoes().add(e);
        ce.getRegistoUtilizadoresPendentes().getListaUtilizadores().add(u);
        cand = new CandidaturaADemonstracao("daods", email);
        d.getRegistoCandidaturasADemonstracao().getListaCandidaturasADemonstracao().add(cand);
        instance = new AlterarCandidaturaDemonstracaoController(email, e);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getNovosDados method, of class
     * AlterarCandidaturaDemonstracaoController.
     */
    @Test
    public void testGetNovosDados() {
        System.out.println("getNovosDados");
        String expResult = "dados";
        instance.setDados("dados");
        String result = instance.getNovosDados();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCandidaturaDemonstracao method, of class
     * AlterarCandidaturaDemonstracaoController.
     */
    @Test
    public void testGetCandidaturaDemonstracao() {
        System.out.println("getCandidaturaDemonstracao");
        CandidaturaADemonstracao expResult = null;
        CandidaturaADemonstracao result = instance.getCandidaturaDemonstracao();
        assertEquals(expResult, result);
    }

    /**
     * Test of selectCand method, of class
     * AlterarCandidaturaDemonstracaoController.
     */
    @Test
    public void testSelectCand() {
        System.out.println("selectCand");
        CandidaturaADemonstracao c = null;
        instance.selectCand(c);
    }

    /**
     * Test of setDados method, of class
     * AlterarCandidaturaDemonstracaoController.
     */
    @Test
    public void testSetDados() {
        System.out.println("setDados");
        String dados = "";
        instance.setDados(dados);
    }

    /**
     * Test of alterarCandidatura method, of class
     * AlterarCandidaturaDemonstracaoController.
     */
    @Test
    public void testAlterarCandidatura() {
        System.out.println("alterarCandidatura");
        instance.setDados("dados");
        instance.selectCand(cand);
        instance.alterarCandidatura();
    }

    /**
     * Test of getCandidaturasRepresentante method, of class
     * AlterarCandidaturaDemonstracaoController.
     */
    @Test
    public void testGetCandidaturasRepresentante() {
        System.out.println("getCandidaturasRepresentante");

        List<CandidaturaADemonstracao> expResult = new ArrayList<>();
        List<CandidaturaADemonstracao> result = instance.getCandidaturasRepresentante();
        assertEquals(expResult, result);
    }

}
