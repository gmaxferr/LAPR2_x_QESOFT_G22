/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.ConflitoDeInteresse;
import lapr.project.model.Exposicao;
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
public class AtualizarConflitosDeInteresseControllerTest {
    
    public AtualizarConflitosDeInteresseControllerTest() {
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
     * Test of getListaConflitos method, of class AtualizarConflitosDeInteresseController.
     */
    @Test
    public void testGetListaConflitos() {
        System.out.println("getListaConflitos");
        AtualizarConflitosDeInteresseController instance = null;
        List<ConflitoDeInteresse> expResult = null;
        List<ConflitoDeInteresse> result = instance.getListaConflitos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeConflito method, of class AtualizarConflitosDeInteresseController.
     */
    @Test
    public void testRemoveConflito() {
        System.out.println("removeConflito");
        ConflitoDeInteresse c = null;
        AtualizarConflitosDeInteresseController instance = null;
        instance.removeConflito(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFaeExpos method, of class AtualizarConflitosDeInteresseController.
     */
    @Test
    public void testGetFaeExpos() {
        System.out.println("getFaeExpos");
        AtualizarConflitosDeInteresseController instance = null;
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getFaeExpos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectExpo method, of class AtualizarConflitosDeInteresseController.
     */
    @Test
    public void testSelectExpo() {
        System.out.println("selectExpo");
        Exposicao e = null;
        AtualizarConflitosDeInteresseController instance = null;
        instance.selectExpo(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registaConflito method, of class AtualizarConflitosDeInteresseController.
     */
    @Test
    public void testRegistaConflito() {
        System.out.println("registaConflito");
        AtualizarConflitosDeInteresseController instance = null;
        instance.registaConflito();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaCandidaturas method, of class AtualizarConflitosDeInteresseController.
     */
    @Test
    public void testGetListaCandidaturas() {
        System.out.println("getListaCandidaturas");
        AtualizarConflitosDeInteresseController instance = null;
        List<CandidaturaAExposicao> expResult = null;
        List<CandidaturaAExposicao> result = instance.getListaCandidaturas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaConflito method, of class AtualizarConflitosDeInteresseController.
     */
    @Test
    public void testValidaConflito() {
        System.out.println("validaConflito");
        AtualizarConflitosDeInteresseController instance = null;
        boolean expResult = false;
        boolean result = instance.validaConflito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCandidatura method, of class AtualizarConflitosDeInteresseController.
     */
    @Test
    public void testSetCandidatura() {
        System.out.println("setCandidatura");
        CandidaturaAExposicao cand = null;
        AtualizarConflitosDeInteresseController instance = null;
        instance.setCandidatura(cand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaFae method, of class AtualizarConflitosDeInteresseController.
     */
    @Test
    public void testGetListaFae() {
        System.out.println("getListaFae");
        AtualizarConflitosDeInteresseController instance = null;
        List<FAE> expResult = null;
        List<FAE> result = instance.getListaFae();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTipoConflito method, of class AtualizarConflitosDeInteresseController.
     */
    @Test
    public void testSetTipoConflito() {
        System.out.println("setTipoConflito");
        TipoConflito tc = null;
        AtualizarConflitosDeInteresseController instance = null;
        instance.setTipoConflito(tc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pullRegistoDeTiposDeConflito method, of class AtualizarConflitosDeInteresseController.
     */
    @Test
    public void testPullRegistoDeTiposDeConflito() {
        System.out.println("pullRegistoDeTiposDeConflito");
        AtualizarConflitosDeInteresseController instance = null;
        instance.pullRegistoDeTiposDeConflito();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaDeTiposConflito method, of class AtualizarConflitosDeInteresseController.
     */
    @Test
    public void testGetListaDeTiposConflito() {
        System.out.println("getListaDeTiposConflito");
        AtualizarConflitosDeInteresseController instance = null;
        List<TipoConflito> expResult = null;
        List<TipoConflito> result = instance.getListaDeTiposConflito();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
