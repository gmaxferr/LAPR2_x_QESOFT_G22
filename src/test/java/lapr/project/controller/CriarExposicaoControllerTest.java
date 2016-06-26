package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Local;
import lapr.project.model.Organizador;
import lapr.project.model.Utilizador;
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
public class CriarExposicaoControllerTest {
    
    public CriarExposicaoControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private CriarExposicaoController instance;
    private CentroExposicoes ce;
    private Exposicao e;
    private final String titulo = "titulo";
    private final String desc = "desc";
    private final Data data1 =  new Data(2012,2,3);
    private final Data data2 =  new Data(2012,2,4);
    private final Data data3 =  new Data(2012,2,5);
    private final Data data4 =  new Data(2012,2,6);
    private final Data data5 =  new Data(2012,2,7);
    private final Data data6 =  new Data(2012,2,8);
    private final Local local = new Local("Local"); 
    
    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        e = new Exposicao(titulo, desc, data1, data2, data3, data4, data5, data6, local, ce);
        ce.getRegistoExposicoes().getListaExposicoes().add(e);
        instance = new CriarExposicaoController(ce);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRegistoExposicao method, of class CriarExposicaoController.
     */
    @Test
    public void testGetRegistoExposicao() {
        System.out.println("getRegistoExposicao");
        instance.getRegistoExposicao();
    }

    /**
     * Test of getRegistoUtilizadores method, of class CriarExposicaoController.
     */
    @Test
    public void testGetRegistoUtilizadores() {
        System.out.println("getRegistoUtilizadores");
        instance.getRegistoUtilizadores();
    }

    /**
     * Test of novaExposicao method, of class CriarExposicaoController.
     */
    @Test
    public void testNovaExposicao() {
        System.out.println("novaExposicao");
        instance.novaExposicao();
    }

    /**
     * Test of getListaUtilizadores method, of class CriarExposicaoController.
     */
    @Test
    public void testGetListaUtilizadores() {
        System.out.println("getListaUtilizadores");
        List<Utilizador> expResult = new ArrayList();
        List<Utilizador> result = instance.getListaUtilizadores();
        assertEquals(expResult, result);
    }

    /**
     * Test of registaExposicao method, of class CriarExposicaoController.
     */
    @Test
    public void testRegistaExposicao() {
        System.out.println("registaExposicao");
        boolean expResult = true;
        instance.novaExposicao();
        instance.setDados(titulo, desc, data1, data2, data3, data4, data5, data6, local);
        boolean result = instance.registaExposicao();
        assertEquals(expResult, result);
    }
}
