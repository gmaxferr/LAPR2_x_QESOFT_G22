/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.List;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.ConflitoDeInteresse;
import lapr.project.model.FAE;
import lapr.project.model.TipoConflito;
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
public class RegistoConflitosTest {
    
    public RegistoConflitosTest() {
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
     * Test of criarConflito method, of class RegistoConflitos.
     */
    @Test
    public void testCriarConflito() {
        System.out.println("criarConflito");
        FAE fae = null;
        CandidaturaAExposicao cand = null;
        TipoConflito tipoConflito = null;
        RegistoConflitos instance = new RegistoConflitos();
        instance.criarConflito(fae, cand, tipoConflito);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valida method, of class RegistoConflitos.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        FAE fae = null;
        CandidaturaAExposicao cand = null;
        TipoConflito tipo = null;
        RegistoConflitos instance = new RegistoConflitos();
        boolean expResult = false;
        boolean result = instance.valida(fae, cand, tipo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaConflitos method, of class RegistoConflitos.
     */
    @Test
    public void testGetListaConflitos() {
        System.out.println("getListaConflitos");
        RegistoConflitos instance = new RegistoConflitos();
        List<ConflitoDeInteresse> expResult = null;
        List<ConflitoDeInteresse> result = instance.getListaConflitos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class RegistoConflitos.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        ConflitoDeInteresse c = null;
        RegistoConflitos instance = new RegistoConflitos();
        instance.remove(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adiciona method, of class RegistoConflitos.
     */
    @Test
    public void testAdiciona() {
        System.out.println("adiciona");
        ConflitoDeInteresse c = null;
        RegistoConflitos instance = new RegistoConflitos();
        instance.adiciona(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
