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
 * @author guima
 */
public class MecanismoDetecaoConflitoTest {
    
    public MecanismoDetecaoConflitoTest() {
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
     * Test of detetaConflitos method, of class MecanismoDetecaoConflito.
     */
    @Test
    public void testDetetaConflitos() {
        System.out.println("detetaConflitos");
        Exposicao e = new Exposicao(new CentroExposicoes());
        MecanismoDetecaoConflito instance = new MecanismoDetecaoConflito(new TipoConflito("id"));
        instance.detetaConflitos(e);
    }

    /**
     * Test of isConflito method, of class MecanismoDetecaoConflito.
     */
    @Test
    public void testIsConflito() {
        System.out.println("isConflito");
        FAE fae = null;
        CandidaturaAExposicao cand = null;
        MecanismoDetecaoConflito instance = new MecanismoDetecaoConflito(new TipoConflito("id"));
        boolean expResult = true;
        boolean result = instance.isConflito(fae, cand);
        assertEquals(expResult, result);
    }
    
}
