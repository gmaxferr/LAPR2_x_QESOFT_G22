/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.registos.RegistoCandidaturasAExposicao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class ConflitoDeInteresseDemonstracaoTest {
    
    public ConflitoDeInteresseDemonstracaoTest() {
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
     * Test of getFae method, of class ConflitoDeInteresseDemonstracao.
     */
    @Test
    public void testGetFae() {
        System.out.println("getFae");
        ConflitoDeInteresseDemonstracao instance = null;
        FAE expResult = null;
        FAE result = instance.getFae();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCandidatura method, of class ConflitoDeInteresseDemonstracao.
     */
    @Test
    public void testGetCandidatura() {
        System.out.println("getCandidatura");
        ConflitoDeInteresseDemonstracao instance = null;
        CandidaturaADemonstracao expResult = null;
        CandidaturaADemonstracao result = instance.getCandidatura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTipo method, of class ConflitoDeInteresseDemonstracao.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        ConflitoDeInteresseDemonstracao instance = null;
        TipoConflitoDemonstracao expResult = null;
        TipoConflitoDemonstracao result = instance.getTipo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fix method, of class ConflitoDeInteresseDemonstracao.
     */
    @Test
    public void testFix() {
        System.out.println("fix");
        RegistoCandidaturasAExposicao rc = null;
        ConflitoDeInteresseDemonstracao instance = null;
        instance.fix(rc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importContentFromXMLNode method, of class ConflitoDeInteresseDemonstracao.
     */
    @Test
    public void testImportContentFromXMLNode() throws Exception {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        ConflitoDeInteresseDemonstracao instance = null;
        ConflitoDeInteresseDemonstracao expResult = null;
        ConflitoDeInteresseDemonstracao result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class ConflitoDeInteresseDemonstracao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        ConflitoDeInteresseDemonstracao instance = null;
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
