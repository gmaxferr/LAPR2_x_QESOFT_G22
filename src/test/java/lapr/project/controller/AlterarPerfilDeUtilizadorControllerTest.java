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
public class AlterarPerfilDeUtilizadorControllerTest {
    
    public AlterarPerfilDeUtilizadorControllerTest() {
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
     * Test of getRegistoutilizadores method, of class AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testGetRegistoutilizadores() {
        System.out.println("getRegistoutilizadores");
        AlterarPerfilDeUtilizadorController instance = null;
        instance.getRegistoutilizadores();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of identificaUtilizador method, of class AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testIdentificaUtilizador_0args() {
        System.out.println("identificaUtilizador");
        AlterarPerfilDeUtilizadorController instance = null;
        instance.identificaUtilizador();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of identificaUtilizador method, of class AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testIdentificaUtilizador_String() {
        System.out.println("identificaUtilizador");
        String username = "";
        AlterarPerfilDeUtilizadorController instance = null;
        instance.identificaUtilizador(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNomeUtilizador method, of class AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testGetNomeUtilizador() {
        System.out.println("getNomeUtilizador");
        AlterarPerfilDeUtilizadorController instance = null;
        String expResult = "";
        String result = instance.getNomeUtilizador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmailUtilizador method, of class AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testGetEmailUtilizador() {
        System.out.println("getEmailUtilizador");
        AlterarPerfilDeUtilizadorController instance = null;
        String expResult = "";
        String result = instance.getEmailUtilizador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPasswordUtilizador method, of class AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testGetPasswordUtilizador() {
        System.out.println("getPasswordUtilizador");
        AlterarPerfilDeUtilizadorController instance = null;
        char[] expResult = null;
        char[] result = instance.getPasswordUtilizador();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDadosUtilizador method, of class AlterarPerfilDeUtilizadorController.
     */
    @Test
    public void testSetDadosUtilizador() {
        System.out.println("setDadosUtilizador");
        String nome = "";
        String email = "";
        String username = "";
        String password = "";
        AlterarPerfilDeUtilizadorController instance = null;
        instance.setDadosUtilizador(nome, email, username, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
