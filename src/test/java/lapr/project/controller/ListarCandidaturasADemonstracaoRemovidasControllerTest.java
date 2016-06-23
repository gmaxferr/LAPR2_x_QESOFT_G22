package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CandidaturaADemonstracao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.model.Local;
import lapr.project.registos.RegistoCandidaturasADemonstracaoRemovidas;
import lapr.project.registos.RegistoDemonstracoes;
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
 * @author G29
 */
public class ListarCandidaturasADemonstracaoRemovidasControllerTest {
    
    
    private ListarCandidaturasADemonstracaoRemovidasController instance;
    private CentroExposicoes ce;
    private RegistoCandidaturasADemonstracaoRemovidas rcdr;
    private RegistoExposicoes re;
    private RegistoDemonstracoes rd;
    private Exposicao e;
    private Demonstracao d;
    
    public ListarCandidaturasADemonstracaoRemovidasControllerTest() {
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
        rcdr = d.getRegistoCandidaturasADemonstracaoRemovidas();
        instance = new ListarCandidaturasADemonstracaoRemovidasController(ce);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRegistoExposicoes method, of class ListarCandidaturasADemonstracaoRemovidasController.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        instance.getRegistoExposicoes();
    }

    /**
     * Test of getListaExposicoesDoOrganizador method, of class 
     * ListarCandidaturasADemonstracaoRemovidasController.
     */
    @Test
    public void testGetListaExposicoesDoOrganizador() {
        System.out.println("getListaExposicoesDoOrganizador");
        instance.getRegistoExposicoes();
        List<Exposicao> expResult = new ArrayList<Exposicao>();;
        List<Exposicao> result = instance.getListaExposicoesDoOrganizador("");
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicao method, of class 
     * ListarCandidaturasADemonstracaoRemovidasController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao e = new Exposicao("a", "b", new Data(2015,05,03), new Data(2015,05,04),  new Data(2015,05,05),  new Data(2015,05,06),  new Data(2015,05,07),new Local ("l"), ce);
        instance.setExposicao(e);
    }

    /**
     * Test of getRegistoDemonstracoes method, of class ListarCandidaturasADemonstracaoRemovidasController.
     */
    @Test
    public void testGetRegistoDemonstracoes() {
        System.out.println("getRegistoDemonstracoes");
        instance.setExposicao(e);
        instance.getRegistoDemonstracoes();
    }

    /**
     * Test of getListaDemonstracoesDoOrganizadorEstadoConfirmada 
     * method, of class ListarCandidaturasADemonstracaoRemovidasController.
     */
    @Test
    public void testGetListaDemonstracoesDoOrganizadorEstadoConfirmada() {
        System.out.println("getListaDemonstracoesDoOrganizadorEstadoConfirmada");
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        re.registaExposicao(e);
        instance.setDemonstracao(d);
        instance.getRegistoDemonstracoes();
        String usernameOrganizador = "";
        List<Demonstracao> expResult = new ArrayList<Demonstracao>();
        List<Demonstracao> result = instance.getListaDemonstracoesDoOrganizadorVariosEstados(usernameOrganizador);
        assertEquals(expResult, result);
    }

    /**
     * Test of setDemonstracao method, of class 
     * ListarCandidaturasADemonstracaoRemovidasController.
     */
    @Test
    public void testSetDemonstracao() {
        System.out.println("setDemonstracao");
        Demonstracao d = new Demonstracao();
        instance.setDemonstracao(d);
    }

    /**
     * Test of getRegistoCandidaturasADemonstracaoRemovidas method, 
     * of class ListarCandidaturasADemonstracaoRemovidasController.
     */
    @Test
    public void testGetRegistoCandidaturasADemonstracaoRemovidas() {
        System.out.println("getRegistoCandidaturasADemonstracaoRemovidas");
        instance.setExposicao(e);
        instance.setDemonstracao(d);
        instance.getRegistoCandidaturasADemonstracaoRemovidas();
    }

    /**
     * Test of getListaCandidaturasADemonstracaoRemovidas method, 
     * of class ListarCandidaturasADemonstracaoRemovidasController.
     */
    @Test
    public void testGetListaCandidaturasADemonstracaoRemovidas() {
        System.out.println("getListaCandidaturasADemonstracaoRemovidas");
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        instance.setDemonstracao(d);
        instance.getRegistoDemonstracoes();
        instance.getRegistoCandidaturasADemonstracaoRemovidas();
        List<CandidaturaADemonstracao> expResult =new ArrayList<CandidaturaADemonstracao>();
        List<CandidaturaADemonstracao> result = instance.getListaCandidaturasADemonstracaoRemovidas();
        assertEquals(expResult, result);
    }
    
}
