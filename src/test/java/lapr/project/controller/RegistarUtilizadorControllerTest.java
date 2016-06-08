/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Catalao
 */
public class RegistarUtilizadorControllerTest {
    
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getRegistoUtilizadores method, of class RegistarUtilizadorController.
     */
    @Test
    public void testGetRegistoUtilizadores() {
        System.out.println("getRegistoUtilizadores");
        RegistarUtilizadorController instance = null;
        instance.getRegistoUtilizadores();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of novoUtilizador method, of class RegistarUtilizadorController.
     */
    @Test
    public void testNovoUtilizador() {
        System.out.println("novoUtilizador");
        RegistarUtilizadorController instance = null;
        instance.novoUtilizador();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDados method, of class RegistarUtilizadorController.
     */
    @Test
    public void testSetDados() {
        System.out.println("setDados");
        String nome = "";
        String email = "";
        char[] password = null;
        String username = "";
        RegistarUtilizadorController instance = null;
        instance.setDados(nome, email, password, username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUtilizador method, of class RegistarUtilizadorController.
     */
    @Test
    public void testAddUtilizador() {
        System.out.println("addUtilizador");
        RegistarUtilizadorController instance = null;
        instance.addUtilizador();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
