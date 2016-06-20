/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.Utilizador;
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
public class RegistarUtilizadorControllerTest {

    private RegistarUtilizadorController instance;
    private Utilizador u;
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
        u = new Utilizador();
        u.setNome(nome);
        u.setUsername(username);
        u.setEmail(email);
        u.setPwd(password);
        u.setKeyword(keyword);
        ce.getRegistoUtilizadoresPendentes().getListaUtilizadores().add(u);
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
        boolean expResult = true;
        instance.getRegistoUtilizadores();
        Utilizador u1 = instance.novoUtilizador();
        boolean result = u1.getEmail() == null
                && u1.getKeyword() == null
                && u1.getNome() == null
                && u1.getUsername() == null
                && u1.getPwd() == null;
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
        Utilizador utilizador = new Utilizador(nome, username, password, email, keyword);
        boolean expResult = false;
        boolean result = instance.addUtilizador(utilizador);
        assertEquals(expResult, result);
        Utilizador utilizador2 = new Utilizador("user", "usernameeee", password, "hehe@com.hotmail", "pokemon");
        expResult = true;
        result = instance.addUtilizador(utilizador2);
        assertEquals(expResult, result);
    }
}
