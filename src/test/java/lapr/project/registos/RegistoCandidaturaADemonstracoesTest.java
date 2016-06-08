/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import lapr.project.model.CandidaturaADemonstracao;
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
public class RegistoCandidaturaADemonstracoesTest {
    
    public RegistoCandidaturaADemonstracoesTest() {
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
     * Test of adiciona method, of class RegistoCandidaturaADemonstracoes.
     */
    @Test
    public void testAdiciona() {
        System.out.println("adiciona");
        CandidaturaADemonstracao cand = null;
        RegistoCandidaturaADemonstracoes instance = new RegistoCandidaturaADemonstracoes();
        boolean expResult = false;
        boolean result = instance.adiciona(cand);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValid method, of class RegistoCandidaturaADemonstracoes.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        CandidaturaADemonstracao cand = null;
        RegistoCandidaturaADemonstracoes instance = new RegistoCandidaturaADemonstracoes();
        boolean expResult = false;
        boolean result = instance.isValid(cand);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
