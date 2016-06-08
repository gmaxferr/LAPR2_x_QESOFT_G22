/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.EstadoExposicao;
import lapr.project.model.Exposicao;
import lapr.project.model.Utilizador;
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
public class DefinirFAEControllerTest {
    
    public DefinirFAEControllerTest() {
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
     * Test of getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE method, of class DefinirFAEController.
     */
    @Test
    public void testGetlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE() {
        System.out.println("getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE");
        DefinirFAEController instance = null;
        ArrayList<Exposicao> expResult = null;
        ArrayList<Exposicao> result = instance.getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoOrganizadores method, of class DefinirFAEController.
     */
    @Test
    public void testGetRegistoOrganizadores() {
        System.out.println("getRegistoOrganizadores");
        DefinirFAEController instance = null;
        instance.getRegistoOrganizadores();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExposicao method, of class DefinirFAEController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao exposicao = null;
        DefinirFAEController instance = null;
        instance.setExposicao(exposicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRegistoOrganizadoresParaValidacoes method, of class DefinirFAEController.
     */
    @Test
    public void testSetRegistoOrganizadoresParaValidacoes() {
        System.out.println("setRegistoOrganizadoresParaValidacoes");
        DefinirFAEController instance = null;
        instance.setRegistoOrganizadoresParaValidacoes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFaePeloUsername method, of class DefinirFAEController.
     */
    @Test
    public void testSetFaePeloUsername() {
        System.out.println("setFaePeloUsername");
        String usernameUtilizador = "";
        DefinirFAEController instance = null;
        boolean expResult = false;
        boolean result = instance.setFaePeloUsername(usernameUtilizador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaUtilizadores method, of class DefinirFAEController.
     */
    @Test
    public void testGetListaUtilizadores() {
        System.out.println("getListaUtilizadores");
        DefinirFAEController instance = null;
        List<Utilizador> expResult = null;
        List<Utilizador> result = instance.getListaUtilizadores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaUtilizadoresCorrespondentesAosFae method, of class DefinirFAEController.
     */
    @Test
    public void testGetListaUtilizadoresCorrespondentesAosFae() {
        System.out.println("getListaUtilizadoresCorrespondentesAosFae");
        DefinirFAEController instance = null;
        List<Utilizador> expResult = null;
        List<Utilizador> result = instance.getListaUtilizadoresCorrespondentesAosFae();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirmaAddFAE method, of class DefinirFAEController.
     */
    @Test
    public void testConfirmaAddFAE() {
        System.out.println("confirmaAddFAE");
        DefinirFAEController instance = null;
        instance.confirmaAddFAE();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoExposicoes method, of class DefinirFAEController.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        DefinirFAEController instance = null;
        instance.getRegistoExposicoes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoUtilizadores method, of class DefinirFAEController.
     */
    @Test
    public void testGetRegistoUtilizadores() {
        System.out.println("getRegistoUtilizadores");
        DefinirFAEController instance = null;
        instance.getRegistoUtilizadores();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoFAE method, of class DefinirFAEController.
     */
    @Test
    public void testGetRegistoFAE() {
        System.out.println("getRegistoFAE");
        DefinirFAEController instance = null;
        instance.getRegistoFAE();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstadoExposicao method, of class DefinirFAEController.
     */
    @Test
    public void testGetEstadoExposicao() {
        System.out.println("getEstadoExposicao");
        DefinirFAEController instance = null;
        EstadoExposicao expResult = null;
        EstadoExposicao result = instance.getEstadoExposicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class DefinirFAEController.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        DefinirFAEController instance = null;
        instance.setEstado();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
