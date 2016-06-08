/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import lapr.project.model.Exposicao;
import lapr.project.model.Recurso;
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
public class CriarDemonstracaoControllerTest {
    
    public CriarDemonstracaoControllerTest() {
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
     * Test of getRegistoExposicoes method, of class CriarDemonstracaoController.
     */
    @Test
    public void testGetRegistoExposicoes() {
        System.out.println("getRegistoExposicoes");
        CriarDemonstracaoController instance = new CriarDemonstracaoController();
        instance.getRegistoExposicoes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposicoesDoOrganizador method, of class CriarDemonstracaoController.
     */
    @Test
    public void testGetListaExposicoesDoOrganizador() {
        System.out.println("getListaExposicoesDoOrganizador");
        String username = "";
        CriarDemonstracaoController instance = new CriarDemonstracaoController();
        ArrayList<Exposicao> expResult = null;
        ArrayList<Exposicao> result = instance.getListaExposicoesDoOrganizador(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExposicao method, of class CriarDemonstracaoController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao e = null;
        CriarDemonstracaoController instance = new CriarDemonstracaoController();
        instance.setExposicao(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoRecursos method, of class CriarDemonstracaoController.
     */
    @Test
    public void testGetRegistoRecursos() {
        System.out.println("getRegistoRecursos");
        CriarDemonstracaoController instance = new CriarDemonstracaoController();
        instance.getRegistoRecursos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of novaDemonstracao method, of class CriarDemonstracaoController.
     */
    @Test
    public void testNovaDemonstracao() {
        System.out.println("novaDemonstracao");
        String descricaoIntroduzidaPeloUtilizador = "";
        CriarDemonstracaoController instance = new CriarDemonstracaoController();
        instance.novaDemonstracao(descricaoIntroduzidaPeloUtilizador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoDemonstracoes method, of class CriarDemonstracaoController.
     */
    @Test
    public void testGetRegistoDemonstracoes() {
        System.out.println("getRegistoDemonstracoes");
        CriarDemonstracaoController instance = new CriarDemonstracaoController();
        instance.getRegistoDemonstracoes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaDeRecursos method, of class CriarDemonstracaoController.
     */
    @Test
    public void testGetListaDeRecursos() {
        System.out.println("getListaDeRecursos");
        CriarDemonstracaoController instance = new CriarDemonstracaoController();
        ArrayList<Recurso> expResult = null;
        ArrayList<Recurso> result = instance.getListaDeRecursos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRecurso method, of class CriarDemonstracaoController.
     */
    @Test
    public void testSetRecurso() {
        System.out.println("setRecurso");
        Recurso rec = null;
        CriarDemonstracaoController instance = new CriarDemonstracaoController();
        instance.setRecurso(rec);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoRecursosDemo method, of class CriarDemonstracaoController.
     */
    @Test
    public void testGetRegistoRecursosDemo() {
        System.out.println("getRegistoRecursosDemo");
        CriarDemonstracaoController instance = new CriarDemonstracaoController();
        instance.getRegistoRecursosDemo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirma method, of class CriarDemonstracaoController.
     */
    @Test
    public void testConfirma() {
        System.out.println("confirma");
        CriarDemonstracaoController instance = new CriarDemonstracaoController();
        instance.confirma();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class CriarDemonstracaoController.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        CriarDemonstracaoController instance = new CriarDemonstracaoController();
        instance.setEstado();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
