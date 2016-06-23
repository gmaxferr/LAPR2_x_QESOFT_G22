package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.AtribuicaoCandidaturaDemonstracao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.model.Local;
import lapr.project.model.Mecanismo;
import lapr.project.registos.RegistoAtribuicoesCandidaturasDemonstracao;
import lapr.project.registos.RegistoCandidaturasADemonstracao;
import lapr.project.registos.RegistoDemonstracoes;
import lapr.project.registos.RegistoExposicoes;
import lapr.project.registos.RegistoMecanismos;
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
public class AtribuirCandidaturasADemonstracaoControllerTest {

    private AtribuirCandidaturasADemonstracaoController instance;
    private CentroExposicoes ce;
    private Exposicao e;
    private Mecanismo m;
    private RegistoExposicoes re;
    private Demonstracao d;
    private RegistoDemonstracoes rd;
    private RegistoMecanismos rm;
    private RegistoCandidaturasADemonstracao rcd;
    private RegistoAtribuicoesCandidaturasDemonstracao racd;
    private List<AtribuicaoCandidaturaDemonstracao> listaAtribuicoesGeradas;

    public AtribuirCandidaturasADemonstracaoControllerTest() {
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
        rm = ce.getRegistoMecanismos();
        rcd = d.getRegistoCandidaturasADemonstracao();
        racd = e.getRegistoAtribuicoesDemonstracao();
        instance = new AtribuirCandidaturasADemonstracaoController(ce);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getRegistoExposicoes method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        instance.getRegistoExposicoes();
    }

    /**
     * Test of getListaExposicoesDoOrganizadorEstadoConflitosAlterados method,
     * of class AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testGetListaExposicoesDoOrganizadorEstadoConflitosAlterados() {
        System.out.println("getListaExposicoesDoOrganizadorEstadoConflitosAlterados");
        instance.getRegistoExposicoes();
        String usernameOrganizador = "";
        List<Exposicao> expResult = new ArrayList<Exposicao>();
        List<Exposicao> result = instance.getListaExposicoesDoOrganizadorEstadoConflitosAlterados(usernameOrganizador);
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicao method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao e = new Exposicao("a", "b", new Data(2015, 05, 03), new Data(2015, 05, 04), new Data(2015, 05, 05), new Data(2015, 05, 06), new Data(2015, 05, 07), new Local("l"), ce);
        instance.setExposicao(e);
    }

    /**
     * Test of getRegistoDemonstracoes method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testGetRegistoDemonstracoes() {
        System.out.println("getRegistoDemonstracoes");
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        instance.getRegistoDemonstracoes();
    }

    /**
     * Test of getListaDemonstracoesEstadoCandidaturasFechadas method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testGetListaDemonstracoesEstadoCandidaturasFechadas() {
        System.out.println("getListaDemonstracoesEstadoCandidaturasFechadas");
        String usernameOrganizador = "";
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        instance.getRegistoDemonstracoes();
        List<Demonstracao> expResult = new ArrayList<Demonstracao>();
        List<Demonstracao> result = instance.getListaDemonstracoesEstadoCandidaturasFechadas(usernameOrganizador);
        assertEquals(expResult, result);
    }

    /**
     * Test of setDemonstracao method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testSetDemonstracao() {
        System.out.println("setDemonstracao");
        Demonstracao demonstracao = new Demonstracao();
        instance.setDemonstracao(demonstracao);
    }

    /**
     * Test of getRegistoMecanismos method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testGetRegistoMecanismos() {
        System.out.println("getRegistoMecanismos");
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        instance.getRegistoMecanismos();
    }

    /**
     * Test of getListaMecanismos method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testGetListaMecanismos() {
        System.out.println("getListaMecanismos");
        instance.setExposicao(e);
        instance.getRegistoExposicoes();
        re.registaExposicao(e);
        instance.getRegistoMecanismos();
        List<Mecanismo> expResult = new ArrayList<Mecanismo>();
        expResult.addAll(ce.getRegistoMecanismos().getListaMecanismos());
        List<Mecanismo> result = instance.getListaMecanismos();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRegistoCandidaturas method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testGetRegistoCandidaturas() {
        System.out.println("getRegistoCandidaturas");
        instance.setExposicao(e);
        re.registaExposicao(e);
        instance.getRegistoExposicoes();
        instance.setDemonstracao(d);
        instance.getRegistoDemonstracoes();
        rd.addDemo(d);
        instance.getRegistoCandidaturas();
    }

    /**
     * Test of getRegistoAtribuicoes method, of class
     * AtribuirCandidaturasADemonstracaoController.
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
     * Test of atribui method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testAtribui_Mecanismo() {
        System.out.println("atribui");
        instance.setExposicao(e); 
        re.registaExposicao(e);
        instance.getRegistoExposicoes();
       
        instance.getRegistoAtribuicoes();
        Mecanismo mec = new Mecanismo() {
            @Override
            public String getNome() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String getDescricao() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        List<AtribuicaoCandidaturaDemonstracao> expResult = new ArrayList<>();
        List<AtribuicaoCandidaturaDemonstracao> result = instance.atribui(mec);
        assertEquals(expResult, result);
    }

    /**
     * Test of atribui method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testAtribui_Mecanismo_String() {
        System.out.println("atribui");
        Mecanismo mec = null;
        String numeroFAEOuExperiencia = "";
        List<AtribuicaoCandidaturaDemonstracao> expResult = null;
        List<AtribuicaoCandidaturaDemonstracao> result = instance.atribui(mec, numeroFAEOuExperiencia);
        assertEquals(expResult, result);
    }

    /**
     * Test of registaAtribuicao method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testRegistaAtribuicao() {
        System.out.println("registaAtribuicao");
        List<AtribuicaoCandidaturaDemonstracao> listaAtribuicao = new ArrayList<>();
        instance.getRegistoAtribuicoes();
        instance.registaAtribuicao(listaAtribuicao);
    }

    /**
     * Test of setEstadoCandidaturaAtribuida method, of class
     * AtribuirCandidaturasADemonstracaoController.
     */
    @Test
    public void testSetEstadoCandidaturaAtribuida() {
        System.out.println("setEstadoCandidaturaAtribuida");
        instance.setEstadoCandidaturaAtribuida();
    }

}
