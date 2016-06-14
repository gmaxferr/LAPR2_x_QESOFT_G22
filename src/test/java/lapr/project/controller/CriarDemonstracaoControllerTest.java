package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.model.Local;
import lapr.project.model.Recurso;
import lapr.project.registos.RegistoDemonstracoes;
import lapr.project.utils.Data;
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
public class CriarDemonstracaoControllerTest {
    
    public CriarDemonstracaoControllerTest() {
    }
    
    private CentroExposicoes ce = new CentroExposicoes();
    private RegistoDemonstracoes rd;
    private Demonstracao d;
    private Exposicao e;
    private CriarDemonstracaoController instance = new CriarDemonstracaoController("organizador", ce);
    
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of pullRegistosCE method, of class CriarDemonstracaoController.
     */
    @Test
    public void testPullRegistosCE() {
        System.out.println("pullRegistosCE");
        instance.pullRegistosCE();
    }

    /**
     * Test of getListaExposicoesDoOrganizador method, of class CriarDemonstracaoController.
     */
    @Test
    public void testGetListaExposicoesDoOrganizador() {
        System.out.println("getListaExposicoesDoOrganizador");
        ArrayList<Exposicao> expResult = null;
        ArrayList<Exposicao> result = instance.getListaExposicoesDoOrganizador();
        assertEquals(expResult, result);
    }

    /**
     * Test of setExposicao method, of class CriarDemonstracaoController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao e = new Exposicao("a", "b", new Data("21/05/05"), new Data("21/05/05"),new Data("21/05/05"), new Data("21/05/05"), new Data("21/05/05"), new Local("s"), ce);
        instance.setExposicao(e);
    }

    /**
     * Test of pullRegistoDemonstracaoDaExposicao method, of class CriarDemonstracaoController.
     */
    @Test
    public void testPullRegistoDemonstracaoDaExposicao() {
        System.out.println("pullRegistoDemonstracaoDaExposicao");
        instance.pullRegistoDemonstracaoDaExposicao();
    }

    /**
     * Test of novaDemonstracao method, of class CriarDemonstracaoController.
     */
    @Test
    public void testNovaDemonstracao() {
        System.out.println("novaDemonstracao");
        String descricaoIntroduzidaPeloUtilizador = "";
        instance.novaDemonstracao(descricaoIntroduzidaPeloUtilizador);
    }

    /**
     * Test of getListaDeRecursos method, of class CriarDemonstracaoController.
     */
    @Test
    public void testGetListaDeRecursos() {
        System.out.println("getListaDeRecursos");
        List<Recurso> expResult = null;
        List<Recurso> result = instance.getListaDeRecursos();
        assertEquals(expResult, result);
    }

    /**
     * Test of addRecurso method, of class CriarDemonstracaoController.
     */
    @Test
    public void testAddRecurso() {
        System.out.println("addRecurso");
        Recurso rec = null;
        instance.addRecurso(rec);
    }

    /**
     * Test of valida method, of class CriarDemonstracaoController.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        boolean expResult = false;
        boolean result = instance.valida();
        assertEquals(expResult, result);
    }

    /**
     * Test of mudaEstado method, of class CriarDemonstracaoController.
     */
    @Test
    public void testMudaEstado() {
        System.out.println("mudaEstado");
        instance.mudaEstado();
    }

    /**
     * Test of exists method, of class CriarDemonstracaoController.
     */
    @Test
    public void testExists() {
        System.out.println("exists");
        Recurso r = null;
        boolean expResult = false;
        boolean result = instance.exists(r);
        assertEquals(expResult, result);
    }

    /**
     * Test of setRecursos method, of class CriarDemonstracaoController.
     */
    @Test
    public void testSetRecursos() {
        System.out.println("setRecursos");
        instance.setRecursos();
    }

    /**
     * Test of registaDemo method, of class CriarDemonstracaoController.
     */
    @Test
    public void testRegistaDemo() {
        System.out.println("registaDemo");
        instance.registaDemo();
    }
    
}
