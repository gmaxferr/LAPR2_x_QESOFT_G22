/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.model.Exposicao;
import lapr.project.model.Local;
import lapr.project.model.Utilizador;
import lapr.project.utils.Data;
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
public class CriarExposicaoControllerTest {
    
    public CriarExposicaoControllerTest() {
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
     * Test of getRegistoExposicao method, of class CriarExposicaoController.
     */
    @Test
    public void testGetRegistoExposicao() {
        System.out.println("getRegistoExposicao");
        CriarExposicaoController instance = null;
        instance.getRegistoExposicao();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoUtilizadores method, of class CriarExposicaoController.
     */
    @Test
    public void testGetRegistoUtilizadores() {
        System.out.println("getRegistoUtilizadores");
        CriarExposicaoController instance = null;
        instance.getRegistoUtilizadores();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of novaExposicao method, of class CriarExposicaoController.
     */
    @Test
    public void testNovaExposicao() {
        System.out.println("novaExposicao");
        CriarExposicaoController instance = null;
        instance.novaExposicao();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaUtilizadores method, of class CriarExposicaoController.
     */
    @Test
    public void testGetListaUtilizadores() {
        System.out.println("getListaUtilizadores");
        CriarExposicaoController instance = null;
        List<Utilizador> expResult = null;
        List<Utilizador> result = instance.getListaUtilizadores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDados method, of class CriarExposicaoController.
     */
    @Test
    public void testSetDados() {
        System.out.println("setDados");
        String strTitulo = "";
        String strDescricao = "";
        Data dataInicio = null;
        Data dataFim = null;
        Data dataAberturaSubCand = null;
        Data dataEncerramentoSubCand = null;
        Data dataFimDetecaoConflitos = null;
        Local strLocal = null;
        List<Utilizador> lstUtz = null;
        CriarExposicaoController instance = null;
        Exposicao expResult = null;
        Exposicao result = instance.setDados(strTitulo, strDescricao, dataInicio, dataFim, dataAberturaSubCand, dataEncerramentoSubCand, dataFimDetecaoConflitos, strLocal, lstUtz);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registaExposicao method, of class CriarExposicaoController.
     */
    @Test
    public void testRegistaExposicao() {
        System.out.println("registaExposicao");
        CriarExposicaoController instance = null;
        boolean expResult = false;
        boolean result = instance.registaExposicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadoCriada method, of class CriarExposicaoController.
     */
    @Test
    public void testSetEstadoCriada() {
        System.out.println("setEstadoCriada");
        CriarExposicaoController instance = null;
        instance.setEstadoCriada();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
