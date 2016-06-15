/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracao;
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
public class CandidaturaADemonstracaoTest {
    
    public CandidaturaADemonstracaoTest() {
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
     * Test of getDadosCandidatura method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testGetDadosCandidatura() {
        System.out.println("getDadosCandidatura");
        CandidaturaADemonstracao instance = null;
        String expResult = "";
        String result = instance.getDadosCandidatura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmailExpositor method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testGetEmailExpositor() {
        System.out.println("getEmailExpositor");
        CandidaturaADemonstracao instance = null;
        String expResult = "";
        String result = instance.getEmailExpositor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        CandidaturaADemonstracao instance = null;
        EstadoCandidaturaADemonstracao expResult = null;
        EstadoCandidaturaADemonstracao result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        EstadoCandidaturaADemonstracao novoEstado = null;
        CandidaturaADemonstracao instance = null;
        instance.setEstado(novoEstado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDados method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testSetDados() {
        System.out.println("setDados");
        String novosDados = "";
        CandidaturaADemonstracao instance = null;
        instance.setDados(novosDados);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object outraCand = null;
        CandidaturaADemonstracao instance = null;
        boolean expResult = false;
        boolean result = instance.equals(outraCand);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importContentFromXMLNode method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        CandidaturaADemonstracao instance = null;
        CandidaturaADemonstracao expResult = null;
        CandidaturaADemonstracao result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        CandidaturaADemonstracao instance = null;
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
