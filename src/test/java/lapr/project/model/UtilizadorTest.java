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
import org.w3c.dom.Node;

/**
 *
 * @author guima
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
     * Test of getConfirmacaoRegisto method, of class Utilizador.
     */
    @Test
    public void testGetConfirmacaoRegisto() {
        System.out.println("getConfirmacaoRegisto");
        Utilizador instance = new Utilizador();
        boolean expResult = false;
        boolean result = instance.getConfirmacaoRegisto();
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
     * Test of setIsGestor method, of class Utilizador.
     */
    @Test
    public void testSetIsGestor() {
        System.out.println("setIsGestor");
        Utilizador instance = new Utilizador();
        instance.setIsGestor();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsGestor method, of class Utilizador.
     */
    @Test
    public void testGetIsGestor() {
        System.out.println("getIsGestor");
        Utilizador instance = new Utilizador();
        boolean expResult = false;
        boolean result = instance.isGestor();
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
    public void testConfirmarRegistoDoUtilizador() {
        System.out.println("confirmarRegistoDoUtilizador");
        Utilizador instance = new Utilizador();
        instance.confirmarRegistoDoUtilizador();
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
     * Test of VerificaCorrespondenciaPassword method, of class Utilizador.
     */
    @Test
    public void testVerificaCorrespondenciaPassword() {
        System.out.println("VerificaCorrespondenciaPassword");
        char[] password = null;
        Utilizador instance = new Utilizador();
        boolean expResult = false;
        boolean result = instance.VerificaCorrespondenciaPassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaPassword method, of class Utilizador.
     */
    @Test
    public void testValidaPassword_charArr() {
        System.out.println("validaPassword");
        char[] password = null;
        Utilizador instance = new Utilizador();
        boolean expResult = false;
        boolean result = instance.validaPassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaPassword method, of class Utilizador.
     */
    @Test
    public void testValidaPassword_0args() {
        System.out.println("validaPassword");
        Utilizador instance = new Utilizador();
        boolean expResult = false;
        boolean result = instance.validaPassword();
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
     * Test of validaDadosDoUtilizador method, of class Utilizador.
     */
    @Test
    public void testValidaDadosDoUtilizador() {
        System.out.println("validaDadosDoUtilizador");
        String nome = "";
        char[] password = null;
        String username = "";
        String email = "";
        Utilizador instance = new Utilizador();
        boolean expResult = false;
        boolean result = instance.validaDadosDoUtilizador(nome, password, username, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarDadosRepetidosOuInvalidos method, of class Utilizador.
     */
    @Test
    public void testValidarDadosRepetidosOuInvalidos() {
        System.out.println("validarDadosRepetidosOuInvalidos");
        String nome = "";
        char[] password = null;
        String username = "";
        String email = "";
        Utilizador instance = new Utilizador();
        boolean expResult = false;
        boolean result = instance.validarDadosRepetidosOuInvalidos(nome, password, username, email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaEmail method, of class Utilizador.
     */
    @Test
    public void testValidaEmail() {
        System.out.println("validaEmail");
        String email = "";
        Utilizador instance = new Utilizador();
        boolean expResult = false;
        boolean result = instance.validaEmail(email);
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

    /**
     * Test of importContentFromXMLNode method, of class Utilizador.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        Utilizador instance = new Utilizador();
        Utilizador expResult = null;
        Utilizador result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class Utilizador.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Utilizador instance = new Utilizador();
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
