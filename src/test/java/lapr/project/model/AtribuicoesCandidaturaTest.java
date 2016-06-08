/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import lapr.project.registos.RegistoFaeAvaliacao;
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
public class AtribuicoesCandidaturaTest {
    
    public AtribuicoesCandidaturaTest() {
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
     * Test of getCandidaturaAssociada method, of class AtribuicoesCandidatura.
     */
    @Test
    public void testGetCandidaturaAssociada() {
        System.out.println("getCandidaturaAssociada");
        AtribuicoesCandidatura instance = null;
        CandidaturaAExposicao expResult = null;
        CandidaturaAExposicao result = instance.getCandidaturaAssociada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoFaeAvaliacao method, of class AtribuicoesCandidatura.
     */
    @Test
    public void testGetRegistoFaeAvaliacao() {
        System.out.println("getRegistoFaeAvaliacao");
        AtribuicoesCandidatura instance = null;
        RegistoFaeAvaliacao expResult = null;
        RegistoFaeAvaliacao result = instance.getRegistoFaeAvaliacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFaeAvaliacao method, of class AtribuicoesCandidatura.
     */
    @Test
    public void testAddFaeAvaliacao() {
        System.out.println("addFaeAvaliacao");
        FAE fae = null;
        AtribuicoesCandidatura instance = null;
        instance.addFaeAvaliacao(fae);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
