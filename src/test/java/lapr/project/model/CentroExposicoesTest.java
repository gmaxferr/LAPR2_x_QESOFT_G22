/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.List;
import lapr.project.registos.RegistoExposicoes;
import lapr.project.registos.RegistoExpositores;
import lapr.project.registos.RegistoMecanismos;
import lapr.project.registos.RegistoRecursos;
import lapr.project.registos.RegistoStands;
import lapr.project.registos.RegistoTipoConflitos;
import lapr.project.registos.RegistoUtilizadores;
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
public class CentroExposicoesTest {
    
    public CentroExposicoesTest() {
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
     * Test of getRegistoExposicoes method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        CentroExposicoes instance = new CentroExposicoes();
        RegistoExposicoes expResult = null;
        RegistoExposicoes result = instance.getRegistoExposicoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoExpositores method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoExpositores() {
        System.out.println("getRegistoExpositores");
        CentroExposicoes instance = new CentroExposicoes();
        RegistoExpositores expResult = null;
        RegistoExpositores result = instance.getRegistoExpositores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoUtilizadores method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoUtilizadores() {
        System.out.println("getRegistoUtilizadores");
        CentroExposicoes instance = new CentroExposicoes();
        RegistoUtilizadores expResult = null;
        RegistoUtilizadores result = instance.getRegistoUtilizadores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoMecanismos method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoMecanismos() {
        System.out.println("getRegistoMecanismos");
        CentroExposicoes instance = new CentroExposicoes();
        RegistoMecanismos expResult = null;
        RegistoMecanismos result = instance.getRegistoMecanismos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoRecursos method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoRecursos() {
        System.out.println("getRegistoRecursos");
        CentroExposicoes instance = new CentroExposicoes();
        RegistoRecursos expResult = null;
        RegistoRecursos result = instance.getRegistoRecursos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoTiposConflitos method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoTiposConflitos() {
        System.out.println("getRegistoTiposConflitos");
        CentroExposicoes instance = new CentroExposicoes();
        RegistoTipoConflitos expResult = null;
        RegistoTipoConflitos result = instance.getRegistoTiposConflitos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoStands method, of class CentroExposicoes.
     */
    @Test
    public void testGetRegistoStands() {
        System.out.println("getRegistoStands");
        CentroExposicoes instance = new CentroExposicoes();
        RegistoStands expResult = null;
        RegistoStands result = instance.getRegistoStands();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUtilizadorRegistado method, of class CentroExposicoes.
     */
    @Test
    public void testSetUtilizadorRegistado() {
        System.out.println("setUtilizadorRegistado");
        Utilizador u = null;
        CentroExposicoes instance = new CentroExposicoes();
        instance.setUtilizadorRegistado(u);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of novoUtilizador method, of class CentroExposicoes.
     */
    @Test
    public void testNovoUtilizador() {
        System.out.println("novoUtilizador");
        CentroExposicoes instance = new CentroExposicoes();
        Utilizador expResult = null;
        Utilizador result = instance.novoUtilizador();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExpositorPeloUsername method, of class CentroExposicoes.
     */
    @Test
    public void testGetExpositorPeloUsername() {
        System.out.println("getExpositorPeloUsername");
        String m_StrUsername = "";
        CentroExposicoes instance = new CentroExposicoes();
        Expositor expResult = null;
        Expositor result = instance.getExpositorPeloUsername(m_StrUsername);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExpositores method, of class CentroExposicoes.
     */
    @Test
    public void testGetListaExpositores() {
        System.out.println("getListaExpositores");
        CentroExposicoes instance = new CentroExposicoes();
        List<Expositor> expResult = null;
        List<Expositor> result = instance.getListaExpositores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importContentFromXMLNode method, of class CentroExposicoes.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        CentroExposicoes instance = new CentroExposicoes();
        CentroExposicoes expResult = null;
        CentroExposicoes result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class CentroExposicoes.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        CentroExposicoes instance = new CentroExposicoes();
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
