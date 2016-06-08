/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
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
public class RegistarCandidaturaADemonstracaoControllerTest {
    
    public RegistarCandidaturaADemonstracaoControllerTest() {
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
     * Test of getListaDeExposicoes method, of class RegistarCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetListaDeExposicoes() {
        System.out.println("getListaDeExposicoes");
        RegistarCandidaturaADemonstracaoController instance = null;
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getListaDeExposicoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExpo method, of class RegistarCandidaturaADemonstracaoController.
     */
    @Test
    public void testSetExpo() {
        System.out.println("setExpo");
        Exposicao e = null;
        RegistarCandidaturaADemonstracaoController instance = null;
        instance.setExpo(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDemo method, of class RegistarCandidaturaADemonstracaoController.
     */
    @Test
    public void testSetDemo() {
        System.out.println("setDemo");
        int indexSelectedDemo = 0;
        RegistarCandidaturaADemonstracaoController instance = null;
        instance.setDemo(indexSelectedDemo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaDemos method, of class RegistarCandidaturaADemonstracaoController.
     */
    @Test
    public void testGetListaDemos() {
        System.out.println("getListaDemos");
        RegistarCandidaturaADemonstracaoController instance = null;
        List<Demonstracao> expResult = null;
        List<Demonstracao> result = instance.getListaDemos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValidDados method, of class RegistarCandidaturaADemonstracaoController.
     */
    @Test
    public void testIsValidDados() {
        System.out.println("isValidDados");
        String dados = "";
        RegistarCandidaturaADemonstracaoController instance = null;
        boolean expResult = false;
        boolean result = instance.isValidDados(dados);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFormularioDados method, of class RegistarCandidaturaADemonstracaoController.
     */
    @Test
    public void testSetFormularioDados() {
        System.out.println("setFormularioDados");
        String dados = "";
        RegistarCandidaturaADemonstracaoController instance = null;
        boolean expResult = false;
        boolean result = instance.setFormularioDados(dados);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RegistaCandADemo method, of class RegistarCandidaturaADemonstracaoController.
     */
    @Test
    public void testRegistaCandADemo() {
        System.out.println("RegistaCandADemo");
        RegistarCandidaturaADemonstracaoController instance = null;
        boolean expResult = false;
        boolean result = instance.RegistaCandADemo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transitaEstado method, of class RegistarCandidaturaADemonstracaoController.
     */
    @Test
    public void testTransitaEstado() {
        System.out.println("transitaEstado");
        RegistarCandidaturaADemonstracaoController instance = null;
        instance.transitaEstado();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
