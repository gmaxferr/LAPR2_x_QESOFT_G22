/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import lapr.project.estados.Exposicao.EstadoExposicao;
import lapr.project.registos.RegistoAtribuicoes;
import lapr.project.registos.RegistoAtribuicoesStands;
import lapr.project.registos.RegistoCandidaturasAExposicao;
import lapr.project.registos.RegistoCandidaturasAExposicaoRemovidas;
import lapr.project.registos.RegistoConflitos;
import lapr.project.registos.RegistoDemonstracoes;
import lapr.project.registos.RegistoFAE;
import lapr.project.registos.RegistoOrganizadores;
import lapr.project.registos.RegistoRecursos;
import lapr.project.registos.RegistoTipoConflitos;
import lapr.project.registos.RegistoUtilizadores;
import lapr.project.utils.Data;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author guima
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
        Exposicao instance = null;
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
        Exposicao instance = null;
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
        Exposicao instance = null;
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
        Exposicao instance = null;
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
        Exposicao instance = null;
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
        Exposicao instance = null;
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
        Exposicao instance = null;
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
        Exposicao instance = null;
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
        Exposicao instance = null;
        Local expResult = null;
        Local result = instance.getLocal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKeywordRanking method, of class Exposicao.
     */
    @Test
    public void testGetKeywordRanking() {
        System.out.println("getKeywordRanking");
        Exposicao instance = null;
        KeywordRanking expResult = null;
        KeywordRanking result = instance.getKeywordRanking();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoCandidaturasAExposicaoRemovidas method, of class Exposicao.
     */
    @Test
    public void testGetRegistoCandidaturasRemovidas() {
        System.out.println("getRegistoCandidaturasRemovidas");
        Exposicao instance = null;
        RegistoCandidaturasAExposicaoRemovidas expResult = null;
        RegistoCandidaturasAExposicaoRemovidas result = instance.getRegistoCandidaturasAExposicaoRemovidas();
        assertEquals(expResult, result);
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
        Exposicao instance = null;
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
        Exposicao instance = null;
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
        Exposicao instance = null;
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
        Exposicao instance = null;
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
        Exposicao instance = null;
        List<Organizador> expResult = null;
        List<Organizador> result = instance.getListaOrganizadores();
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
        CandidaturaAExposicao candidaturaAValidar = null;
        Exposicao instance = null;
        boolean expResult = false;
        boolean result = instance.validarDadosCandidatura(candidaturaAValidar);
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
        Exposicao instance = null;
        instance.addFAE(u);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaCandidaturasAExposicao method, of class Exposicao.
     */
    @Test
    public void testGetListaCandidaturasAExposicao() {
        System.out.println("getListaCandidaturasAExposicao");
        Exposicao instance = null;
        List<CandidaturaAExposicao> expResult = null;
        List<CandidaturaAExposicao> result = instance.getListaCandidaturasAExposicao();
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
        Exposicao instance = null;
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
        Exposicao instance = null;
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
        Exposicao instance = null;
        RegistoOrganizadores expResult = null;
        RegistoOrganizadores result = instance.getRo();
        assertEquals(expResult, result);
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
        Exposicao instance = null;
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
        Exposicao instance = null;
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
        Exposicao instance = null;
        instance.setDecisao(candidaturaAExposicao, decisao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRegistoDemonstracoes method, of class Exposicao.
     */
    @Test
    public void testGetRegistoDemonstracoes() {
        System.out.println("getRegistoDemonstracoes");
        Exposicao instance = null;
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
        Exposicao instance = null;
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
        Exposicao instance = null;
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
        Exposicao instance = null;
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
        Exposicao instance = null;
        RegistoAtribuicoes expResult = null;
        RegistoAtribuicoes result = instance.getRegistoAtribuicoes();
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
        Exposicao instance = null;
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
        Exposicao instance = null;
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
        Exposicao instance = null;
        instance.schedule(m_tt, date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataAberturaSubCand method, of class Exposicao.
     */
    @Test
    public void testSetDataAberturaSubCand() {
        System.out.println("setDataAberturaSubCand");
        Data dataAberturaSubCand = null;
        Exposicao instance = null;
        instance.setDataAberturaSubCand(dataAberturaSubCand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataEncerramentoSubCand method, of class Exposicao.
     */
    @Test
    public void testSetDataEncerramentoSubCand() {
        System.out.println("setDataEncerramentoSubCand");
        Data dataEncerramentoSubCand = null;
        Exposicao instance = null;
        instance.setDataEncerramentoSubCand(dataEncerramentoSubCand);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataFimDetecaoConflitos method, of class Exposicao.
     */
    @Test
    public void testSetDataFimDetecaoConflitos() {
        System.out.println("setDataFimDetecaoConflitos");
        Data dataFimDetecaoConflitos = null;
        Exposicao instance = null;
        instance.setDataFimDetecaoConflitos(dataFimDetecaoConflitos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataInicioCandDemo method, of class Exposicao.
     */
    @Test
    public void testGetDataInicioCandDemo() {
        System.out.println("getDataInicioCandDemo");
        Exposicao instance = null;
        Data expResult = null;
        Data result = instance.getDataInicioCandDemo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataInicioCandDemo method, of class Exposicao.
     */
    @Test
    public void testSetDataInicioCandDemo() {
        System.out.println("setDataInicioCandDemo");
        Data dataInicioCandDemo = null;
        Exposicao instance = null;
        instance.setDataInicioCandDemo(dataInicioCandDemo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDataFimCandDemo method, of class Exposicao.
     */
    @Test
    public void testGetDataFimCandDemo() {
        System.out.println("getDataFimCandDemo");
        Exposicao instance = null;
        Data expResult = null;
        Data result = instance.getDataFimCandDemo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDataFimCandDemo method, of class Exposicao.
     */
    @Test
    public void testSetDataFimCandDemo() {
        System.out.println("setDataFimCandDemo");
        Data dataFimCandDemo = null;
        Exposicao instance = null;
        instance.setDataFimCandDemo(dataFimCandDemo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fix method, of class Exposicao.
     */
    @Test
    public void testFix() {
        System.out.println("fix");
        RegistoRecursos m_registoRecursos = null;
        RegistoTipoConflitos m_registoTipoConflitos = null;
        RegistoUtilizadores m_registoUtilizadores = null;
        Exposicao instance = null;
        instance.fix(m_registoRecursos, m_registoTipoConflitos, m_registoUtilizadores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validaOrganizador method, of class Exposicao.
     */
    @Test
    public void testValidaOrganizador() {
        System.out.println("validaOrganizador");
        Organizador utilizador = null;
        Exposicao instance = null;
        boolean expResult = false;
        boolean result = instance.validaOrganizador(utilizador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recriarTimersDemo method, of class Exposicao.
     */
    @Test
    public void testRecriarTimersDemo() {
        System.out.println("recriarTimersDemo");
        Exposicao instance = null;
        instance.recriarTimersDemo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recriarTimersExpo method, of class Exposicao.
     */
    @Test
    public void testRecriarTimersExpo() {
        System.out.println("recriarTimersExpo");
        Exposicao instance = null;
        instance.recriarTimersExpo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importContentFromXMLNode method, of class Exposicao.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        Exposicao instance = null;
        Exposicao expResult = null;
        Exposicao result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class Exposicao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Exposicao instance = null;
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addOrganizadores method, of class Exposicao.
     */
    @Test
    public void testAddOrganizadores() {
        System.out.println("addOrganizadores");
        List<Organizador> m_organizadoresSelecionados = null;
        Exposicao instance = null;
        instance.addOrganizadores(m_organizadoresSelecionados);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
