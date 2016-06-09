/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

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
public class UtilizadorTest {
    
    public UtilizadorTest() {
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
     * Test of getBoolConfirmaRegisto method, of class Utilizador.
     */
    @Test
    public void testGetBoolConfirmaRegisto() {
        System.out.println("getBoolConfirmaRegisto");
        Utilizador instance = new Utilizador();
        boolean expResult = false;
        boolean result = instance.getBoolConfirmaRegisto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Utilizador.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Utilizador instance = new Utilizador();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPwd method, of class Utilizador.
     */
    @Test
    public void testGetPwd() {
        System.out.println("getPwd");
        Utilizador instance = new Utilizador();
        char[] expResult = null;
        char[] result = instance.getPwd();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Utilizador.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Utilizador instance = new Utilizador();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getID method, of class Utilizador.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Utilizador instance = new Utilizador();
        String expResult = "";
        String result = instance.getID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUsername method, of class Utilizador.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Utilizador instance = new Utilizador();
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirmarRegistoDoUtilizador method, of class Utilizador.
     */
    @Test
    public void testSetBoolConfirmaRegisto() {
        System.out.println("setBoolConfirmaRegisto");
        boolean m_boolConfirmaRegisto = false;
        Utilizador instance = new Utilizador();
        instance.confirmarRegistoDoUtilizador(m_boolConfirmaRegisto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class Utilizador.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String strNome = "";
        Utilizador instance = new Utilizador();
        instance.setNome(strNome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Utilizador.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String strEmail = "";
        Utilizador instance = new Utilizador();
        instance.setEmail(strEmail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUsername method, of class Utilizador.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Utilizador instance = new Utilizador();
        instance.setUsername(username);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPwd method, of class Utilizador.
     */
    @Test
    public void testSetPwd() {
        System.out.println("setPwd");
        char[] strPwd = null;
        Utilizador instance = new Utilizador();
        instance.setPwd(strPwd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUtilizadorRegistado method, of class Utilizador.
     */
    @Test
    public void testSetUtilizadorRegistado() {
        System.out.println("setUtilizadorRegistado");
        Utilizador instance = new Utilizador();
        instance.setUtilizadorRegistado();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valida method, of class Utilizador.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Utilizador instance = new Utilizador();
        boolean expResult = false;
        boolean result = instance.valida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of VerificaCorrespondenciaPassword method, of class Utilizador.
     */
    @Test
    public void testIsValidPassword() {
        System.out.println("isValidPassword");
        char[] password = null;
        Utilizador instance = new Utilizador();
        boolean expResult = false;
        boolean result = instance.VerificaCorrespondenciaPassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Utilizador.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Utilizador instance = new Utilizador();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaUtilizador method, of class Utilizador.
     */
    @Test
    public void testValidaUtilizador() {
        System.out.println("validaUtilizador");
        String username = "";
        String email = "";
        Utilizador instance = new Utilizador();
        instance.validaUtilizador(username, email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarDadosRepetidosOuInvalidos method, of class Utilizador.
     */
    @Test
    public void testValidarDadosRepetidosOuInvalidos() {
        System.out.println("validarDadosRepetidosOuInvalidos");
        String username = "";
        String email = "";
        Utilizador instance = new Utilizador();
        boolean expResult = false;
        boolean result = instance.validarDadosRepetidosOuInvalidos(username, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getnAvaliacoesDesdeSempre method, of class Utilizador.
     */
    @Test
    public void testGetnAvaliacoesDesdeSempre() {
        System.out.println("getnAvaliacoesDesdeSempre");
        Utilizador instance = new Utilizador();
        int expResult = 0;
        int result = instance.getnAvaliacoesDesdeSempre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setnAvaliacoesDesdeSempre method, of class Utilizador.
     */
    @Test
    public void testSetnAvaliacoesDesdeSempre() {
        System.out.println("setnAvaliacoesDesdeSempre");
        int nAvaliacoesDesdeSempre = 0;
        Utilizador instance = new Utilizador();
        instance.setnAvaliacoesDesdeSempre(nAvaliacoesDesdeSempre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
