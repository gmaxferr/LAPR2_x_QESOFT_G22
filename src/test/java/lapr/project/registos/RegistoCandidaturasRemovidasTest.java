/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.List;
import lapr.project.model.CandidaturaAExposicao;
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
public class RegistoCandidaturasRemovidasTest {
    
    public RegistoCandidaturasRemovidasTest() {
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
     * Test of adicionarCandidatura method, of class RegistoCandidaturasRemovidas.
     */
    @Test
    public void testAdicionarCandidatura() {
        System.out.println("adicionarCandidatura");
        CandidaturaAExposicao c = null;
        RegistoCandidaturasRemovidas instance = new RegistoCandidaturasRemovidas();
        instance.adicionarCandidatura(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaCandidaturasRemovidas method, of class RegistoCandidaturasRemovidas.
     */
    @Test
    public void testGetListaCandidaturasRemovidas() {
        System.out.println("getListaCandidaturasRemovidas");
        RegistoCandidaturasRemovidas instance = new RegistoCandidaturasRemovidas();
        List<CandidaturaAExposicao> expResult = null;
        List<CandidaturaAExposicao> result = instance.getListaCandidaturasRemovidas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
