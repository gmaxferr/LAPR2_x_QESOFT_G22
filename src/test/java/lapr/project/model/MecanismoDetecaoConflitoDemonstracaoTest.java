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
 * @author JoãoCardoso aka K4rd050
 */
public class MecanismoDetecaoConflitoDemonstracaoTest {
    
    public MecanismoDetecaoConflitoDemonstracaoTest() {
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
     * Test of detetaConflitos method, of class MecanismoDetecaoConflitoDemonstracao.
     */
    @Test
    public void testDetetaConflitos() {
        System.out.println("detetaConflitos");
        Demonstracao d = null;
        MecanismoDetecaoConflitoDemonstracao instance = null;
        instance.detetaConflitos(d);
    }

    /**
     * Test of isConflito method, of class MecanismoDetecaoConflitoDemonstracao.
     */
    @Test
    public void testIsConflito() {
        System.out.println("isConflito");
        FAE fae = null;
        CandidaturaADemonstracao cand = null;
        MecanismoDetecaoConflitoDemonstracao instance = null;
        boolean expResult = false;
        boolean result = instance.isConflito(fae, cand);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
