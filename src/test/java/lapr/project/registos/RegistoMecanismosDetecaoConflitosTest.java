/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.FAE;
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
public class RegistoMecanismosDetecaoConflitosTest {
    
    public RegistoMecanismosDetecaoConflitosTest() {
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
     * Test of detetarConflitos method, of class RegistoMecanismosDetecaoConflitos.
     */
    @Test
    public void testDetetarConflitos() {
        System.out.println("detetarConflitos");
        FAE fae = null;
        CandidaturaAExposicao cand = null;
        RegistoMecanismosDetecaoConflitos instance = new RegistoMecanismosDetecaoConflitos();
        boolean expResult = false;
        boolean result = instance.detetarConflitos(fae, cand);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
