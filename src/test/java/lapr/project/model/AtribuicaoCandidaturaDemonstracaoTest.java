/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.registos.RegistoCandidaturasADemonstracao;
import lapr.project.registos.RegistoFaeAvaliacao;
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
 * @author JoãoCardoso aka K4rd050
 */
public class AtribuicaoCandidaturaDemonstracaoTest {
    
    public AtribuicaoCandidaturaDemonstracaoTest() {
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
     * Test of getCandidaturaAssociada method, of class AtribuicaoCandidaturaDemonstracao.
     */
    @Test
    public void testGetCandidaturaAssociada() {
        System.out.println("getCandidaturaAssociada");
        AtribuicaoCandidaturaDemonstracao instance = null;
        CandidaturaADemonstracao expResult = null;
        CandidaturaADemonstracao result = instance.getCandidaturaAssociada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoFaeAvaliacao method, of class AtribuicaoCandidaturaDemonstracao.
     */
    @Test
    public void testGetRegistoFaeAvaliacao() {
        System.out.println("getRegistoFaeAvaliacao");
        AtribuicaoCandidaturaDemonstracao instance = null;
        RegistoFaeAvaliacao expResult = null;
        RegistoFaeAvaliacao result = instance.getRegistoFaeAvaliacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFaeAvaliacao method, of class AtribuicaoCandidaturaDemonstracao.
     */
    @Test
    public void testAddFaeAvaliacao() {
        System.out.println("addFaeAvaliacao");
        FAE fae = null;
        AtribuicaoCandidaturaDemonstracao instance = null;
        instance.addFaeAvaliacao(fae);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fix method, of class AtribuicaoCandidaturaDemonstracao.
     */
    @Test
    public void testFix() {
        System.out.println("fix");
        RegistoCandidaturasADemonstracao m_rce = null;
        RegistoUtilizadores m_registoUtilizadores = null;
        AtribuicaoCandidaturaDemonstracao instance = null;
        instance.fix(m_rce, m_registoUtilizadores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRegistoFaeAvaliacao method, of class AtribuicaoCandidaturaDemonstracao.
     */
    @Test
    public void testSetRegistoFaeAvaliacao() {
        System.out.println("setRegistoFaeAvaliacao");
        RegistoFaeAvaliacao m_rFaeAvaliacao = null;
        AtribuicaoCandidaturaDemonstracao instance = null;
        instance.setRegistoFaeAvaliacao(m_rFaeAvaliacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importContentFromXMLNode method, of class AtribuicaoCandidaturaDemonstracao.
     */
    @Test
    public void testImportContentFromXMLNode() throws Exception {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        AtribuicaoCandidaturaDemonstracao instance = null;
        AtribuicaoCandidaturaDemonstracao expResult = null;
        AtribuicaoCandidaturaDemonstracao result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class AtribuicaoCandidaturaDemonstracao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        AtribuicaoCandidaturaDemonstracao instance = null;
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
