package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.registos.RegistoUtilizadores;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ana
 */
public class RegistarUtilizadorControllerTest {

    private RegistarUtilizadorController instance;
    private RegistoUtilizadores ru;
    private Utilizador u;
    private Utilizador u1;
    private CentroExposicoes ce;
    private final String nome = "nome";
    private final String email = "aaaa@dfg.com";
    private final String username = "username";
    private final String keyword = "abcdef";
    private final char[] password = {'D', 'v', '.', '2', '3'};

    public RegistarUtilizadorControllerTest() {
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
        ru = ce.getRegistoUtilizadores();
        u = new Utilizador();
        u.setNome(nome);
        u.setUsername(username);
        u.setEmail(email);
        u.setPwd(password);
        ru.addUtilizador(u);
        instance = new RegistarUtilizadorController(ce);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getRegistoUtilizadores method, of class
     * RegistarUtilizadorController.
     */
    @Test
    public void testGetRegistoUtilizadores() {
        System.out.println("getRegistoUtilizadores");
        instance.getRegistoUtilizadores();
    }

    /**
     * Test of novoUtilizador method, of class RegistarUtilizadorController.
     */
    @Test
    public void testNovoUtilizador() {
        System.out.println("novoUtilizador");
        instance.getRegistoUtilizadores();
        u1 = ce.novoUtilizador();
        Utilizador expResult = u1;
        expResult.setPasswordTestUseOnly(password);
        expResult.setNome(nome);
        expResult.setUsername(username);
        expResult.setEmail(email);
        Utilizador result = instance.novoUtilizador();
        result.setNome(nome);
        result.setEmail(email);
        result.setUsername(username);
        result.setPasswordTestUseOnly(password);
        expResult = result;
        assertEquals(expResult, result);
    }

    /**
     * Test of setDadosDoUtilizador method, of class
     * RegistarUtilizadorController.
     */
    @Test
    public void testSetDadosDoUtilizador() {
        System.out.println("setDadosDoUtilizador");
        instance.getRegistoUtilizadores();
        instance.novoUtilizador();

        instance.setDadosDoUtilizador(nome, email, password, username, keyword);
    }

    /**
     * Test of validaDadosDoUtilizador method, of class
     * RegistarUtilizadorController.
     */
    @Test
    public void testValidaDadosDoUtilizador() {
        System.out.println("validaDadosDoUtilizador");
        instance.getRegistoUtilizadores();
        instance.novoUtilizador();
        boolean expResult = true;
        boolean result = instance.validaDadosDoUtilizador(nome, email, password, username);
        assertEquals(expResult, result);
    }

    /**
     * Test of addUtilizador method, of class RegistarUtilizadorController.
     */
    @Test
    public void testAddUtilizador() {
        System.out.println("addUtilizador");
        instance.getRegistoUtilizadores();
        Utilizador u = new Utilizador(nome, email, password, username);
        boolean expResult = true;
        boolean result = instance.addUtilizador(u);
        assertEquals(expResult, result);
    }

}
