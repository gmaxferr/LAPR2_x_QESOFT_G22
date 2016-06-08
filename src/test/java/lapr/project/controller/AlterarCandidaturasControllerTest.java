/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.estados.EstadoCandidaturaAExposicao;
import lapr.project.estados.EstadoExposicao;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.Exposicao;
import lapr.project.model.Produto;
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
public class AlterarCandidaturasControllerTest {
    
    public AlterarCandidaturasControllerTest() {
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
     * Test of getM_EstadoExposicao method, of class AlterarCandidaturasController.
     */
    @Test
    public void testGetM_EstadoExposicao() {
        System.out.println("getM_EstadoExposicao");
        AlterarCandidaturaExpoController instance = null;
        boolean expResult = false;
        boolean result = instance.getM_EstadoExposicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaEstadoExposicao method, of class AlterarCandidaturasController.
     */
    @Test
    public void testVerificaEstadoExposicao() {
        System.out.println("verificaEstadoExposicao");
        EstadoExposicao estado = null;
        AlterarCandidaturaExpoController instance = null;
        boolean expResult = false;
        boolean result = instance.verificaEstadoExposicao(estado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstadoCandidatura method, of class AlterarCandidaturasController.
     */
    @Test
    public void testGetEstadoCandidatura() {
        System.out.println("getEstadoCandidatura");
        AlterarCandidaturaExpoController instance = null;
        boolean expResult = false;
        boolean result = instance.getEstadoCandidatura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of verificaCandidatura method, of class AlterarCandidaturasController.
     */
    @Test
    public void testVerificaCandidatura() {
        System.out.println("verificaCandidatura");
        EstadoCandidaturaAExposicao estado = null;
        AlterarCandidaturaExpoController instance = null;
        boolean expResult = false;
        boolean result = instance.verificaCandidatura(estado);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getM_RegistoCandidaturas method, of class AlterarCandidaturasController.
     */
    @Test
    public void testGetM_RegistoCandidaturas() {
        System.out.println("getM_RegistoCandidaturas");
        AlterarCandidaturaExpoController instance = null;
        instance.getM_RegistoCandidaturas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExposRepresentante method, of class AlterarCandidaturasController.
     */
    @Test
    public void testGetExposRepresentante() {
        System.out.println("getExposRepresentante");
        AlterarCandidaturaExpoController instance = null;
        List<CandidaturaAExposicao> expResult = null;
        List<CandidaturaAExposicao> result = instance.getExposRepresentante();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExposicao method, of class AlterarCandidaturasController.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao m_exposicao = null;
        AlterarCandidaturaExpoController instance = null;
        instance.setExposicao(m_exposicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNomeEmpresa method, of class AlterarCandidaturasController.
     */
    @Test
    public void testGetNomeEmpresa() {
        System.out.println("getNomeEmpresa");
        AlterarCandidaturaExpoController instance = null;
        String expResult = "";
        String result = instance.getNomeEmpresa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMorada method, of class AlterarCandidaturasController.
     */
    @Test
    public void testGetMorada() {
        System.out.println("getMorada");
        AlterarCandidaturaExpoController instance = null;
        String expResult = "";
        String result = instance.getMorada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTelemovel method, of class AlterarCandidaturasController.
     */
    @Test
    public void testGetTelemovel() {
        System.out.println("getTelemovel");
        AlterarCandidaturaExpoController instance = null;
        int expResult = 0;
        int result = instance.getTelemovel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArea method, of class AlterarCandidaturasController.
     */
    @Test
    public void testGetArea() {
        System.out.println("getArea");
        AlterarCandidaturaExpoController instance = null;
        float expResult = 0.0F;
        float result = instance.getArea();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumConvites method, of class AlterarCandidaturasController.
     */
    @Test
    public void testGetNumConvites() {
        System.out.println("getNumConvites");
        AlterarCandidaturaExpoController instance = null;
        int expResult = 0;
        int result = instance.getNumConvites();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removerProduto method, of class AlterarCandidaturasController.
     */
    @Test
    public void testRemoverProduto() {
        System.out.println("removerProduto");
        int index = 0;
        AlterarCandidaturaExpoController instance = null;
        instance.removerProduto(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionarProduto method, of class AlterarCandidaturasController.
     */
    @Test
    public void testAdicionarProduto() {
        System.out.println("adicionarProduto");
        Produto p = null;
        AlterarCandidaturaExpoController instance = null;
        instance.adicionarProduto(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editarProduto method, of class AlterarCandidaturasController.
     */
    @Test
    public void testEditarProduto() {
        System.out.println("editarProduto");
        int index = 0;
        String novoProduto = "";
        AlterarCandidaturaExpoController instance = null;
        instance.editarProduto(index, novoProduto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDadosCandidatura method, of class AlterarCandidaturasController.
     */
    @Test
    public void testSetDadosCandidatura() {
        System.out.println("setDadosCandidatura");
        String nomeEmpresa = "";
        String moradaEmpresa = "";
        int telemovel = 0;
        int area = 0;
        int numConvites = 0;
        AlterarCandidaturaExpoController instance = null;
        instance.setDadosCandidatura(nomeEmpresa, moradaEmpresa, telemovel, area, numConvites);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
