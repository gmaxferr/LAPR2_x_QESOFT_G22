package lapr.project.controller;

import java.util.List;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;
import lapr.project.registos.RegistoUtilizadores;
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
public class ConfirmarRegistoControllerTest {

    private ConfirmarRegistoController instance;
    private RegistoUtilizadores rup;
    private RegistoUtilizadores ruc;
    private List<Utilizador> listaUtilizadores;
    private CentroExposicoes ce;

    public ConfirmarRegistoControllerTest() {
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
        rup = ce.getRegistoUtilizadoresPendentes();
        ruc = ce.getRegistoUtilizadoresConfirmados();
        
        listaUtilizadores = rup.getListaUtilizadores();
        instance = new ConfirmarRegistoController(ce);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getRegistoUtilizadores method, of class
     * ConfirmarRegistoController.
     */
    @Test
    public void testGetRegistoUtilizadores() {
        System.out.println("getRegistoUtilizadores");
        instance.getRegistoUtilizadores();
    }

    /**
     * Test of getListaNovosRegistos method, of class
     * ConfirmarRegistoController.
     */
    @Test
    public void testGetListaNovosRegistos() {
        System.out.println("getListaNovosRegistos");
        instance.getRegistoUtilizadores();
        List<Utilizador> expResult = listaUtilizadores;
        List<Utilizador> result = instance.getListaNovosRegistos();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUtilizadorRegistado method, of class
     * ConfirmarRegistoController.
     */
    @Test
    public void testSetUtilizadorRegistado() {
        System.out.println("setUtilizadorRegistado");
        Utilizador u = new Utilizador();
        instance.setUtilizadorRegistado(u);
    }

}
