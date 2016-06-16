/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.registos.RegistoCandidaturasAExposicao;
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
 * @author guima
 */
public class AtribuicaoCandidaturaTest {
    
    public AtribuicaoCandidaturaTest() {
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
     * Test of getCandidaturaAssociada method, of class AtribuicaoCandidatura.
     */
    @Test
    public void testGetCandidaturaAssociada() {
        System.out.println("getCandidaturaAssociada");
        AtribuicaoCandidatura instance = null;
        CandidaturaAExposicao expResult = null;
        CandidaturaAExposicao result = instance.getCandidaturaAssociada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoFaeAvaliacao method, of class AtribuicaoCandidatura.
     */
    @Test
    public void testGetRegistoFaeAvaliacao() {
        System.out.println("getRegistoFaeAvaliacao");
        AtribuicaoCandidatura instance = null;
        RegistoFaeAvaliacao expResult = null;
        RegistoFaeAvaliacao result = instance.getRegistoFaeAvaliacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFaeAvaliacao method, of class AtribuicaoCandidatura.
     */
    @Test
    public void testAddFaeAvaliacao() {
        System.out.println("addFaeAvaliacao");
        FAE fae = null;
        AtribuicaoCandidatura instance = null;
        instance.addFaeAvaliacao(fae);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fix method, of class AtribuicaoCandidatura.
     */
    @Test
    public void testFix() {
        System.out.println("fix");
        RegistoCandidaturasAExposicao m_rce = null;
        RegistoUtilizadores m_registoUtilizadores = null;
        AtribuicaoCandidatura instance = null;
        instance.fix(m_rce, m_registoUtilizadores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importContentFromXMLNode method, of class AtribuicaoCandidatura.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        AtribuicaoCandidatura instance = null;
        AtribuicaoCandidatura expResult = null;
        AtribuicaoCandidatura result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class AtribuicaoCandidatura.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        AtribuicaoCandidatura instance = null;
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
