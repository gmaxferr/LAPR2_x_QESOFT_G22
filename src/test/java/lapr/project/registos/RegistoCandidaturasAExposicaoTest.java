/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.List;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.Expositor;
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
public class RegistoCandidaturasAExposicaoTest {
    
    public RegistoCandidaturasAExposicaoTest() {
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
     * Test of getListaCandidaturas method, of class RegistoCandidaturasAExposicao.
     */
    @Test
    public void testGetListaCandidaturas() {
        System.out.println("getListaCandidaturas");
        RegistoCandidaturasAExposicao instance = new RegistoCandidaturasAExposicao();
        List<CandidaturaAExposicao> expResult = null;
        List<CandidaturaAExposicao> result = instance.getListaCandidaturas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of criarCandidatura method, of class RegistoCandidaturasAExposicao.
     */
    @Test
    public void testCriarCandidatura() {
        System.out.println("criarCandidatura");
        Expositor expositor = null;
        RegistoCandidaturasAExposicao instance = new RegistoCandidaturasAExposicao();
        CandidaturaAExposicao expResult = null;
        CandidaturaAExposicao result = instance.criarCandidatura(expositor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarDadosCandidatura method, of class RegistoCandidaturasAExposicao.
     */
    @Test
    public void testValidarDadosCandidatura() {
        System.out.println("validarDadosCandidatura");
        CandidaturaAExposicao c = null;
        RegistoCandidaturasAExposicao instance = new RegistoCandidaturasAExposicao();
        boolean expResult = false;
        boolean result = instance.validarDadosCandidatura(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registaCandidatura method, of class RegistoCandidaturasAExposicao.
     */
    @Test
    public void testRegistaCandidatura() {
        System.out.println("registaCandidatura");
        CandidaturaAExposicao candidaturaAExposicao = null;
        RegistoCandidaturasAExposicao instance = new RegistoCandidaturasAExposicao();
        boolean expResult = false;
        boolean result = instance.registaCandidatura(candidaturaAExposicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaCandidatua method, of class RegistoCandidaturasAExposicao.
     */
    @Test
    public void testValidaCandidatua() {
        System.out.println("validaCandidatua");
        CandidaturaAExposicao c = null;
        RegistoCandidaturasAExposicao instance = new RegistoCandidaturasAExposicao();
        boolean expResult = false;
        boolean result = instance.validaCandidatua(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCandidatura method, of class RegistoCandidaturasAExposicao.
     */
    @Test
    public void testAddCandidatura() {
        System.out.println("addCandidatura");
        CandidaturaAExposicao c = null;
        RegistoCandidaturasAExposicao instance = new RegistoCandidaturasAExposicao();
        instance.addCandidatura(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCandidatura method, of class RegistoCandidaturasAExposicao.
     */
    @Test
    public void testRemoveCandidatura() {
        System.out.println("removeCandidatura");
        CandidaturaAExposicao c = null;
        RegistoCandidaturasAExposicao instance = new RegistoCandidaturasAExposicao();
        instance.removeCandidatura(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCandidaturasRepresentante method, of class RegistoCandidaturasAExposicao.
     */
    @Test
    public void testGetCandidaturasRepresentante() {
        System.out.println("getCandidaturasRepresentante");
        String username = "";
        RegistoCandidaturasAExposicao instance = new RegistoCandidaturasAExposicao();
        List<CandidaturaAExposicao> expResult = null;
        List<CandidaturaAExposicao> result = instance.getCandidaturasRepresentante(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaCandidaturasAceites method, of class RegistoCandidaturasAExposicao.
     */
    @Test
    public void testGetListaCandidaturasAceites() {
        System.out.println("getListaCandidaturasAceites");
        RegistoCandidaturasAExposicao instance = new RegistoCandidaturasAExposicao();
        List<CandidaturaAExposicao> expResult = null;
        List<CandidaturaAExposicao> result = instance.getListaCandidaturasAceites();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
