/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import lapr.project.estados.EstadoExposicao;
import lapr.project.registos.RegistoAtribuicoes;
import lapr.project.registos.RegistoAtribuicoesStands;
import lapr.project.registos.RegistoCandidaturasAExposicao;
import lapr.project.registos.RegistoCandidaturasRemovidas;
import lapr.project.registos.RegistoConflitos;
import lapr.project.registos.RegistoDemonstracoes;
import lapr.project.registos.RegistoFAE;
import lapr.project.registos.RegistoOrganizadores;
import lapr.project.registos.RegistoStands;
import lapr.project.utils.Data;
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
public class ExposicaoTest {
    
    public ExposicaoTest() {
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
     * Test of valida method, of class Exposicao.
     */
    @Test
    public void testValida() {
        System.out.println("valida");
        Exposicao instance = new Exposicao();
        boolean expResult = false;
        boolean result = instance.valida();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitulo method, of class Exposicao.
     */
    @Test
    public void testGetTitulo() {
        System.out.println("getTitulo");
        Exposicao instance = new Exposicao();
        String expResult = "";
        String result = instance.getTitulo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescricao method, of class Exposicao.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        Exposicao instance = new Exposicao();
        String expResult = "";
        String result = instance.getDescricao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataInicioSubCand method, of class Exposicao.
     */
    @Test
    public void testGetDataInicioSubCand() {
        System.out.println("getDataInicioSubCand");
        Exposicao instance = new Exposicao();
        Data expResult = null;
        Data result = instance.getDataInicioSubCand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataFimSubCand method, of class Exposicao.
     */
    @Test
    public void testGetDataFimSubCand() {
        System.out.println("getDataFimSubCand");
        Exposicao instance = new Exposicao();
        Data expResult = null;
        Data result = instance.getDataFimSubCand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataFimDetecaoConflitos method, of class Exposicao.
     */
    @Test
    public void testGetDataFimDetecaoConflitos() {
        System.out.println("getDataFimDetecaoConflitos");
        Exposicao instance = new Exposicao();
        Data expResult = null;
        Data result = instance.getDataFimDetecaoConflitos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataInicio method, of class Exposicao.
     */
    @Test
    public void testGetDataInicio() {
        System.out.println("getDataInicio");
        Exposicao instance = new Exposicao();
        Data expResult = null;
        Data result = instance.getDataInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataFim method, of class Exposicao.
     */
    @Test
    public void testGetDataFim() {
        System.out.println("getDataFim");
        Exposicao instance = new Exposicao();
        Data expResult = null;
        Data result = instance.getDataFim();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLocal method, of class Exposicao.
     */
    @Test
    public void testGetLocal() {
        System.out.println("getLocal");
        Exposicao instance = new Exposicao();
        Local expResult = null;
        Local result = instance.getLocal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoCandidaturasRemovidas method, of class Exposicao.
     */
    @Test
    public void testGetRegistoCandidaturasRemovidas() {
        System.out.println("getRegistoCandidaturasRemovidas");
        Exposicao instance = new Exposicao();
        RegistoCandidaturasRemovidas expResult = null;
        RegistoCandidaturasRemovidas result = instance.getRegistoCandidaturasRemovidas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addOrganizador method, of class Exposicao.
     */
    @Test
    public void testAddOrganizador() {
        System.out.println("addOrganizador");
        Utilizador utilizador = null;
        Exposicao instance = new Exposicao();
        instance.addOrganizador(utilizador);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitulo method, of class Exposicao.
     */
    @Test
    public void testSetTitulo() {
        System.out.println("setTitulo");
        String strTitulo = "";
        Exposicao instance = new Exposicao();
        instance.setTitulo(strTitulo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescricao method, of class Exposicao.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String strDescricao = "";
        Exposicao instance = new Exposicao();
        instance.setDescricao(strDescricao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPeriodo method, of class Exposicao.
     */
    @Test
    public void testSetPeriodo() {
        System.out.println("setPeriodo");
        Data dataInicio = null;
        Data dataFim = null;
        Exposicao instance = new Exposicao();
        instance.setPeriodo(dataInicio, dataFim);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLocal method, of class Exposicao.
     */
    @Test
    public void testSetLocal() {
        System.out.println("setLocal");
        Local local = null;
        Exposicao instance = new Exposicao();
        instance.setLocal(local);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaOrganizadores method, of class Exposicao.
     */
    @Test
    public void testGetListaOrganizadores() {
        System.out.println("getListaOrganizadores");
        Exposicao instance = new Exposicao();
        ArrayList<Organizador> expResult = null;
        ArrayList<Organizador> result = instance.getListaOrganizadores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarUtilizador method, of class Exposicao.
     */
    @Test
    public void testValidarUtilizador() {
        System.out.println("validarUtilizador");
        Utilizador u = null;
        Exposicao instance = new Exposicao();
        boolean expResult = false;
        boolean result = instance.validarUtilizador(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarDadosCandidatura method, of class Exposicao.
     */
    @Test
    public void testValidarDadosCandidatura() {
        System.out.println("validarDadosCandidatura");
        CandidaturaAExposicao c = null;
        Exposicao instance = new Exposicao();
        boolean expResult = false;
        boolean result = instance.validarDadosCandidatura(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addFAE method, of class Exposicao.
     */
    @Test
    public void testAddFAE() {
        System.out.println("addFAE");
        Utilizador u = null;
        Exposicao instance = new Exposicao();
        instance.addFAE(u);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of confirmaAddFAE method, of class Exposicao.
     */
    @Test
    public void testConfirmaAddFAE() {
        System.out.println("confirmaAddFAE");
        boolean b = false;
        Exposicao instance = new Exposicao();
        instance.confirmaAddFAE(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaCandidaturasAExposicao method, of class Exposicao.
     */
    @Test
    public void testGetListaCandidaturasAExposicao() {
        System.out.println("getListaCandidaturasAExposicao");
        Exposicao instance = new Exposicao();
        List<CandidaturaAExposicao> expResult = null;
        List<CandidaturaAExposicao> result = instance.getListaCandidaturasAExposicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarDecisao method, of class Exposicao.
     */
    @Test
    public void testValidarDecisao() {
        System.out.println("validarDecisao");
        CandidaturaAExposicao c = null;
        Exposicao instance = new Exposicao();
        boolean expResult = false;
        boolean result = instance.validarDecisao(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDadosCandidatura method, of class Exposicao.
     */
    @Test
    public void testGetDadosCandidatura() {
        System.out.println("getDadosCandidatura");
        CandidaturaAExposicao c = null;
        Exposicao instance = new Exposicao();
        ArrayList expResult = null;
        ArrayList result = instance.getDadosCandidatura(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRa method, of class Exposicao.
     */
    @Test
    public void testGetRa() {
        System.out.println("getRa");
        Exposicao instance = new Exposicao();
        RegistoAtribuicoes expResult = null;
        RegistoAtribuicoes result = instance.getRa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoFAE method, of class Exposicao.
     */
    @Test
    public void testGetRegistoFAE() {
        System.out.println("getRegistoFAE");
        Exposicao instance = new Exposicao();
        RegistoFAE expResult = null;
        RegistoFAE result = instance.getRegistoFAE();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoCandidaturasAExposicao method, of class Exposicao.
     */
    @Test
    public void testGetRegistoCandidaturasAExposicao() {
        System.out.println("getRegistoCandidaturasAExposicao");
        Exposicao instance = new Exposicao();
        RegistoCandidaturasAExposicao expResult = null;
        RegistoCandidaturasAExposicao result = instance.getRegistoCandidaturasAExposicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRo method, of class Exposicao.
     */
    @Test
    public void testGetRo() {
        System.out.println("getRo");
        Exposicao instance = new Exposicao();
        RegistoOrganizadores expResult = null;
        RegistoOrganizadores result = instance.getRo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRd method, of class Exposicao.
     */
    @Test
    public void testGetRd() {
        System.out.println("getRd");
        Exposicao instance = new Exposicao();
        RegistoDemonstracoes expResult = null;
        RegistoDemonstracoes result = instance.getRd();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removerCandidaturasRepetidas method, of class Exposicao.
     */
    @Test
    public void testRemoverCandidaturasRepetidas() {
        System.out.println("removerCandidaturasRepetidas");
        Exposicao instance = new Exposicao();
        instance.removerCandidaturasRepetidas();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarCandidatura method, of class Exposicao.
     */
    @Test
    public void testValidarCandidatura() {
        System.out.println("validarCandidatura");
        CandidaturaAExposicao c = null;
        Exposicao instance = new Exposicao();
        boolean expResult = false;
        boolean result = instance.validarCandidatura(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstado method, of class Exposicao.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        EstadoExposicao estado = null;
        Exposicao instance = new Exposicao();
        instance.setEstado(estado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDecisao method, of class Exposicao.
     */
    @Test
    public void testSetDecisao() {
        System.out.println("setDecisao");
        CandidaturaAExposicao candidaturaAExposicao = null;
        boolean decisao = false;
        Exposicao instance = new Exposicao();
        instance.setDecisao(candidaturaAExposicao, decisao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaDecidirCandidatura method, of class Exposicao.
     */
    @Test
    public void testValidaDecidirCandidatura() {
        System.out.println("validaDecidirCandidatura");
        Exposicao instance = new Exposicao();
        boolean expResult = false;
        boolean result = instance.validaDecidirCandidatura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoDemonstracoes method, of class Exposicao.
     */
    @Test
    public void testGetRegistoDemonstracoes() {
        System.out.println("getRegistoDemonstracoes");
        Exposicao instance = new Exposicao();
        RegistoDemonstracoes expResult = null;
        RegistoDemonstracoes result = instance.getRegistoDemonstracoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dadosMinimosObrigatorios method, of class Exposicao.
     */
    @Test
    public void testDadosMinimosObrigatorios() {
        System.out.println("dadosMinimosObrigatorios");
        Exposicao instance = new Exposicao();
        boolean expResult = false;
        boolean result = instance.dadosMinimosObrigatorios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstado method, of class Exposicao.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        Exposicao instance = new Exposicao();
        EstadoExposicao expResult = null;
        EstadoExposicao result = instance.getEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoConflitos method, of class Exposicao.
     */
    @Test
    public void testGetRegistoConflitos() {
        System.out.println("getRegistoConflitos");
        Exposicao instance = new Exposicao();
        RegistoConflitos expResult = null;
        RegistoConflitos result = instance.getRegistoConflitos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoAtribuicoes method, of class Exposicao.
     */
    @Test
    public void testGetRegistoAtribuicoes() {
        System.out.println("getRegistoAtribuicoes");
        Exposicao instance = new Exposicao();
        RegistoAtribuicoes expResult = null;
        RegistoAtribuicoes result = instance.getRegistoAtribuicoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoStands method, of class Exposicao.
     */
    @Test
    public void testGetRegistoStands() {
        System.out.println("getRegistoStands");
        Exposicao instance = new Exposicao();
        RegistoStands expResult = null;
        RegistoStands result = instance.getRegistoStands();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoOrganizadores method, of class Exposicao.
     */
    @Test
    public void testGetRegistoOrganizadores() {
        System.out.println("getRegistoOrganizadores");
        Exposicao instance = new Exposicao();
        RegistoOrganizadores expResult = null;
        RegistoOrganizadores result = instance.getRegistoOrganizadores();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoAtribuicoesStands method, of class Exposicao.
     */
    @Test
    public void testGetRegistoAtribuicoesStands() {
        System.out.println("getRegistoAtribuicoesStands");
        Exposicao instance = new Exposicao();
        RegistoAtribuicoesStands expResult = null;
        RegistoAtribuicoesStands result = instance.getRegistoAtribuicoesStands();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of schedule method, of class Exposicao.
     */
    @Test
    public void testSchedule() {
        System.out.println("schedule");
        TimerTask m_tt = null;
        Data date = null;
        Exposicao instance = new Exposicao();
        instance.schedule(m_tt, date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
