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
import lapr.project.estados.Exposicao.EstadoExposicaoCandidaturasAbertas;
import lapr.project.registos.RegistoAtribuicoes;
import lapr.project.registos.RegistoAtribuicoesStands;
import lapr.project.registos.RegistoCandidaturasAExposicao;
import lapr.project.registos.RegistoCandidaturasAExposicaoRemovidas;
import lapr.project.registos.RegistoConflitos;
import lapr.project.registos.RegistoDemonstracoes;
import lapr.project.registos.RegistoExpositores;
import lapr.project.registos.RegistoFAE;
import lapr.project.registos.RegistoOrganizadores;
import lapr.project.registos.RegistoRecursos;
import lapr.project.registos.RegistoTipoConflitos;
import lapr.project.registos.RegistoUtilizadores;
import lapr.project.timerTasks.expo.AlterarParaAbertaCandidaturas;
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
    
    private Local local;
    private Data data1;
    private Data data2;
    private Data data3;
    private Data data4;
    private Data data5;
    private Data data6;
    private Data data7;
    private String titulo;
    private String desc;
    private CentroExposicoes ce;
    private Exposicao e;
    private Utilizador u;
    private Utilizador u2;
    private CandidaturaAExposicao c;
    
    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        titulo = "titulo";
        desc = "desc";
        local = new Local("rua");
        c = new CandidaturaAExposicao(new Expositor(u));
        c.criarProduto("p");
        c.criarProduto("q");
        c.setArea("100");
        c.setDecisao(true);
        c.setKeywords("a;b;c;D;e");
        c.setMorada("rua");
        c.setNomeEmpresa("emp");
        c.setNumConvites("15");
        c.setTelemovel("915632569");
        u = new Utilizador("a", "b", new char[]{'a', 'A', '.', '7'}, "1@2.3");
        u2 = new Utilizador("a1", "b1", new char[]{'a', 'A', '.', '7'}, "12@2.3");
        data1 = new Data("2016/10/05");
        data2 = new Data("2016/10/06");
        data3 = new Data("2016/10/07");
        data4 = new Data("2016/10/08");
        data5 = new Data("2016/10/09");
        data6 = new Data("2016/10/10");
        data7 = new Data("2016/10/11");
        e = new Exposicao(titulo, desc, data1, data2, data3, data4, data5, local, ce);
        e.setDataFimCandDemo(data6);
        e.setDataInicioCandDemo(data7);
        ce.getRegistoExposicoes().getListaExposicoes().add(e);
        
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
        
        boolean expResult = true;
        boolean result = e.valida();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getTitulo method, of class Exposicao.
     */
    @Test
    public void testGetTitulo() {
        System.out.println("getTitulo");
        
        String expResult = titulo;
        String result = e.getTitulo();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getDescricao method, of class Exposicao.
     */
    @Test
    public void testGetDescricao() {
        System.out.println("getDescricao");
        
        String expResult = desc;
        String result = e.getDescricao();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getDataInicioSubCand method, of class Exposicao.
     */
    @Test
    public void testGetDataInicioSubCand() {
        System.out.println("getDataInicioSubCand");
        
        Data expResult = data3;
        Data result = e.getDataInicioSubCand();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getDataFimSubCand method, of class Exposicao.
     */
    @Test
    public void testGetDataFimSubCand() {
        System.out.println("getDataFimSubCand");
        
        Data expResult = data4;
        Data result = e.getDataFimSubCand();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getDataFimDetecaoConflitos method, of class Exposicao.
     */
    @Test
    public void testGetDataFimDetecaoConflitos() {
        System.out.println("getDataFimDetecaoConflitos");
        
        Data expResult = data5;
        Data result = e.getDataFimDetecaoConflitos();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getDataInicio method, of class Exposicao.
     */
    @Test
    public void testGetDataInicio() {
        System.out.println("getDataInicio");
        
        Data expResult = data1;
        Data result = e.getDataInicio();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getDataFim method, of class Exposicao.
     */
    @Test
    public void testGetDataFim() {
        System.out.println("getDataFim");
        
        Data expResult = data2;
        Data result = e.getDataFim();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getLocal method, of class Exposicao.
     */
    @Test
    public void testGetLocal() {
        System.out.println("getLocal");
        
        Local expResult = local;
        Local result = e.getLocal();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getKeywordRanking method, of class Exposicao.
     */
    @Test
    public void testGetKeywordRanking() {
        System.out.println("getKeywordRanking");
        
        KeywordRanking expResult = new KeywordRanking();
        e.setKeywordRanking(expResult);
        KeywordRanking result = e.getKeywordRanking();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getRegistoCandidaturasAExposicaoRemovidas method, of class
     * Exposicao.
     */
    @Test
    public void testGetRegistoCandidaturasRemovidas() {
        System.out.println("getRegistoCandidaturasRemovidas");
        
        RegistoCandidaturasAExposicaoRemovidas expResult = new RegistoCandidaturasAExposicaoRemovidas();
        e.setRegistoCandidaturasAExposicaoRemovidas(expResult);
        RegistoCandidaturasAExposicaoRemovidas result = e.getRegistoCandidaturasAExposicaoRemovidas();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setTitulo method, of class Exposicao.
     */
    @Test
    public void testSetTitulo() {
        System.out.println("setTitulo");
        String strTitulo = "";
        
        e.setTitulo(strTitulo);
        
    }

    /**
     * Test of setDescricao method, of class Exposicao.
     */
    @Test
    public void testSetDescricao() {
        System.out.println("setDescricao");
        String strDescricao = "";
        
        e.setDescricao(strDescricao);
        
    }

    /**
     * Test of setPeriodo method, of class Exposicao.
     */
    @Test
    public void testSetPeriodo() {
        System.out.println("setPeriodo");
        Data dataInicio = null;
        Data dataFim = null;
        
        e.setPeriodo(dataInicio, dataFim);
        
    }

    /**
     * Test of setLocal method, of class Exposicao.
     */
    @Test
    public void testSetLocal() {
        System.out.println("setLocal");
        Local local = null;
        
        e.setLocal(local);
        
    }

    /**
     * Test of getListaOrganizadores method, of class Exposicao.
     */
    @Test
    public void testGetListaOrganizadores() {
        System.out.println("getListaOrganizadores");
        Organizador o = new Organizador(u);
        List<Organizador> expResult = new ArrayList<Organizador>();
        expResult.add(o);
        e.getRegistoOrganizadores().getListaOrganizadores().add(o);
        List<Organizador> result = e.getListaOrganizadores();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of validarDadosCandidatura method, of class Exposicao.
     */
    @Test
    public void testValidarDadosCandidatura() {
        System.out.println("validarDadosCandidatura");
        CandidaturaAExposicao candidaturaAValidar = null;
        
        boolean expResult = true;
        boolean result = e.validarDadosCandidatura(candidaturaAValidar);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of addFAE method, of class Exposicao.
     */
    @Test
    public void testAddFAE() {
        System.out.println("addFAE");
        Utilizador u = null;
        
        e.addFAE(u);
        
    }

    /**
     * Test of getListaCandidaturasAExposicao method, of class Exposicao.
     */
    @Test
    public void testGetListaCandidaturasAExposicao() {
        System.out.println("getListaCandidaturasAExposicao");
<<<<<<< HEAD
        CandidaturaAExposicao cand = new CandidaturaAExposicao(new Expositor(u));
        List<CandidaturaAExposicao> expResult = new ArrayList<>();
        expResult.add(cand);
        e.getRegistoCandidaturasAExposicao().getListaCandidaturas().add(cand);
        List<CandidaturaAExposicao> result = e.getListaCandidaturasAExposicao();
        assertEquals(expResult, result);
        
=======
        Exposicao instance = null;
        List<CandidaturaAExposicao> expResult = null;
        List<CandidaturaAExposicao> result = instance.getListaCandidaturasAExposicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
>>>>>>> 5dbe7dc19f3e65eaf1ac0afc6dd03f54afb5504a
    }

    /**
     * Test of getRegistoFAE method, of class Exposicao.
     */
    @Test
    public void testGetRegistoFAE() {
        System.out.println("getRegistoFAE");
        
        RegistoFAE expResult = new RegistoFAE();
        e.setRegistoFAE(expResult);
        RegistoFAE result = e.getRegistoFAE();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getRegistoCandidaturasAExposicao method, of class Exposicao.
     */
    @Test
    public void testGetRegistoCandidaturasAExposicao() {
        System.out.println("getRegistoCandidaturasAExposicao");
        
        RegistoCandidaturasAExposicao expResult = new RegistoCandidaturasAExposicao();
        e.setRegistoCandidaturasAExposicao(expResult);
        RegistoCandidaturasAExposicao result = e.getRegistoCandidaturasAExposicao();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of validarCandidatura method, of class Exposicao.
     */
    @Test
    public void testValidarCandidatura() {
        System.out.println("validarCandidatura");
        boolean expResult = true;
        boolean result = e.validarCandidatura(c);
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstado method, of class Exposicao.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        EstadoExposicao estado = new EstadoExposicaoCandidaturasAbertas(e);
        e.setEstado(estado);
    }

    /**
     * Test of setDecisao method, of class Exposicao.
     */
    @Test
    public void testSetDecisao() {
        System.out.println("setDecisao");
        CandidaturaAExposicao candidaturaAExposicao = new CandidaturaAExposicao(new Expositor(u));
        boolean decisao = true;
        e.setDecisao(candidaturaAExposicao, decisao);
    }

    /**
     * Test of getRegistoDemonstracoes method, of class Exposicao.
     */
    @Test
    public void testGetRegistoDemonstracoes() {
        System.out.println("getRegistoDemonstracoes");
        RegistoDemonstracoes expResult = new RegistoDemonstracoes();
        e.setRegistoDemonstracoes(expResult);
        RegistoDemonstracoes result = e.getRegistoDemonstracoes();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of dadosMinimosObrigatorios method, of class Exposicao.
     */
    @Test
    public void testDadosMinimosObrigatorios() {
        System.out.println("dadosMinimosObrigatorios");
        boolean expResult = true;
        List<Organizador> lista = new ArrayList<Organizador>();
        lista.add(new Organizador(u));
        lista.add(new Organizador(u2));
        e.addOrganizadores(lista);
        boolean result = e.dadosMinimosObrigatorios();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getEstado method, of class Exposicao.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        EstadoExposicao ee = new EstadoExposicaoCandidaturasAbertas(e);
        e.setEstado(ee)
        EstadoExposicao expResult = ee;
        EstadoExposicao result = e.getEstado();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getRegistoConflitos method, of class Exposicao.
     */
    @Test
    public void testGetRegistoConflitos() {
        System.out.println("getRegistoConflitos");
        
        RegistoConflitos expResult = new RegistoConflitos();
        e.setRegistoConflitos(expResult);
        RegistoConflitos result = e.getRegistoConflitos();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getRegistoAtribuicoes method, of class Exposicao.
     */
    @Test
    public void testGetRegistoAtribuicoes() {
        System.out.println("getRegistoAtribuicoes");
        RegistoAtribuicoes expResult = new RegistoAtribuicoes();
        e.setRegistoAtribuicoes(expResult);
        RegistoAtribuicoes result = e.getRegistoAtribuicoes();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getRegistoAtribuicoesStands method, of class Exposicao.
     */
    @Test
    public void testGetRegistoAtribuicoesStands() {
        System.out.println("getRegistoAtribuicoesStands");
        RegistoAtribuicoesStands expResult = new RegistoAtribuicoesStands();
        e.setRegistoAtribuicoesStands(expResult);
        RegistoAtribuicoesStands result = e.getRegistoAtribuicoesStands();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of schedule method, of class Exposicao.
     */
    @Test
    public void testSchedule() {
        System.out.println("schedule");
        TimerTask m_tt = new AlterarParaAbertaCandidaturas(e);
        Data date = data1;
        e.schedule(m_tt, date);
    }

    /**
     * Test of setDataAberturaSubCand method, of class Exposicao.
     */
    @Test
    public void testSetDataAberturaSubCand() {
        System.out.println("setDataAberturaSubCand");
        Data dataAberturaSubCand = null;
        
        e.setDataAberturaSubCand(dataAberturaSubCand);
        
    }

    /**
     * Test of setDataEncerramentoSubCand method, of class Exposicao.
     */
    @Test
    public void testSetDataEncerramentoSubCand() {
        System.out.println("setDataEncerramentoSubCand");
        Data dataEncerramentoSubCand = null;
        
        e.setDataEncerramentoSubCand(dataEncerramentoSubCand);
        
    }

    /**
     * Test of setDataFimDetecaoConflitos method, of class Exposicao.
     */
    @Test
    public void testSetDataFimDetecaoConflitos() {
        System.out.println("setDataFimDetecaoConflitos");
        Data dataFimDetecaoConflitos = null;
        
        e.setDataFimDetecaoConflitos(dataFimDetecaoConflitos);
        
    }

    /**
     * Test of getDataInicioCandDemo method, of class Exposicao.
     */
    @Test
    public void testGetDataInicioCandDemo() {
        System.out.println("getDataInicioCandDemo");
        
        Data expResult = data7;
        Data result = e.getDataInicioCandDemo();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDataInicioCandDemo method, of class Exposicao.
     */
    @Test
    public void testSetDataInicioCandDemo() {
        System.out.println("setDataInicioCandDemo");
        Data dataInicioCandDemo = null;
        
        e.setDataInicioCandDemo(dataInicioCandDemo);
        
    }

    /**
     * Test of getDataFimCandDemo method, of class Exposicao.
     */
    @Test
    public void testGetDataFimCandDemo() {
        System.out.println("getDataFimCandDemo");
        
        Data expResult = data6;
        Data result = e.getDataFimCandDemo();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDataFimCandDemo method, of class Exposicao.
     */
    @Test
    public void testSetDataFimCandDemo() {
        System.out.println("setDataFimCandDemo");
        Data dataFimCandDemo = data3;
        e.setDataFimCandDemo(dataFimCandDemo);
        
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
        
        e.fix(m_registoRecursos, m_registoTipoConflitos, m_registoUtilizadores);
        
    }

    /**
     * Test of validaOrganizador method, of class Exposicao.
     */
    @Test
    public void testValidaOrganizador() {
        System.out.println("validaOrganizador");
        Organizador utilizador = null;
        
        boolean expResult = true;
        boolean result = e.validaOrganizador(utilizador);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of recriarTimersDemo method, of class Exposicao.
     */
    @Test
    public void testRecriarTimersDemo() {
        System.out.println("recriarTimersDemo");
        e.getRegistoDemonstracoes().getListaDemonstracoes().add(new Demonstracao("d"));
        e.recriarTimersDemo();
        
    }

    /**
     * Test of recriarTimersExpo method, of class Exposicao.
     */
    @Test
    public void testRecriarTimersExpo() {
        System.out.println("recriarTimersExpo");
        
        e.recriarTimersExpo();
        
    }

    /**
     * Test of addOrganizadores method, of class Exposicao.
     */
    @Test
    public void testAddOrganizadores() {
        System.out.println("addOrganizadores");
        List<Organizador> lista = new ArrayList<Organizador>();
        lista.add(new Organizador(u));
        e.addOrganizadores(lista);
        
    }

    /**
     * Test of getRegistoCandidaturasAExposicaoRemovidas method, of class
     * Exposicao.
     */
    @Test
    public void testGetRegistoCandidaturasAExposicaoRemovidas() {
        System.out.println("getRegistoCandidaturasAExposicaoRemovidas");
        
        RegistoCandidaturasAExposicaoRemovidas expResult = new RegistoCandidaturasAExposicaoRemovidas();
        e.setRegistoCandidaturasAExposicaoRemovidas(expResult);
        RegistoCandidaturasAExposicaoRemovidas result = e.getRegistoCandidaturasAExposicaoRemovidas();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDataFimDetecaoConflitosDemo method, of class Exposicao.
     */
    @Test
    public void testSetDataFimDetecaoConflitosDemo() {
        System.out.println("setDataFimDetecaoConflitosDemo");
        Data dataFimDetecaoConflitos = null;
        
        e.setDataFimDetecaoConflitosDemo(dataFimDetecaoConflitos);
        
    }

    /**
     * Test of getCentroExposicoes method, of class Exposicao.
     */
    @Test
    public void testGetCentroExposicoes() {
        System.out.println("getCentroExposicoes");
        
        CentroExposicoes expResult = ce;
        CentroExposicoes result = e.getCentroExposicoes();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setCentroExposicoes method, of class Exposicao.
     */
    @Test
    public void testSetCentroExposicoes() {
        System.out.println("setCentroExposicoes");
        e.setCentroExposicoes(ce);
    }

    /**
     * Test of equals method, of class Exposicao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Exposicao expo = e;
        boolean expResult = true;
        boolean result = e.equals(expo);
        assertEquals(expResult, result);
    }

    /**
     * Test of getRegistoOrganizadores method, of class Exposicao.
     */
    @Test
    public void testGetRegistoOrganizadores() {
        System.out.println("getRegistoOrganizadores");
        RegistoOrganizadores expResult = new RegistoOrganizadores();
        e.setRegistoOrganizadores(expResult);
        RegistoOrganizadores result = e.getRegistoOrganizadores();
        assertEquals(expResult, result);
    }

    /**
     * Test of importContentFromXMLNode method, of class Exposicao.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        Exposicao expResult = null;
        Exposicao result = e.importContentFromXMLNode(node);
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class Exposicao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Node expResult = null;
        Node result = e.exportContentToXMLNode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setKeywordRanking method, of class Exposicao.
     */
    @Test
    public void testSetKeywordRanking() {
        System.out.println("setKeywordRanking");
        KeywordRanking m_keywordRanking = null;
        e.setKeywordRanking(m_keywordRanking);
    }

    /**
     * Test of setRegistoAtribuicoesStands method, of class Exposicao.
     */
    @Test
    public void testSetRegistoAtribuicoes_RegistoAtribuicoes() {
        System.out.println("setRegistoAtribuicoes");
        RegistoAtribuicoes m_ra = null;
        e.setRegistoAtribuicoes(m_ra);
    }

    /**
     * Test of setRegistoFAE method, of class Exposicao.
     */
    @Test
    public void testSetRegistoFAE() {
        System.out.println("setRegistoFAE");
        RegistoFAE m_rfae = null;
        e.setRegistoFAE(m_rfae);
    }

    /**
     * Test of setRegistoCandidaturasAExposicao method, of class Exposicao.
     */
    @Test
    public void testSetRegistoCandidaturasAExposicao() {
        System.out.println("setRegistoCandidaturasAExposicao");
        RegistoCandidaturasAExposicao m_rce = null;
        e.setRegistoCandidaturasAExposicao(m_rce);
    }

    /**
     * Test of setRegistoCandidaturasAExposicaoRemovidas method, of class
     * Exposicao.
     */
    @Test
    public void testSetRegistoCandidaturasAExposicaoRemovidas() {
        System.out.println("setRegistoCandidaturasAExposicaoRemovidas");
        RegistoCandidaturasAExposicaoRemovidas m_rcr = null;
        e.setRegistoCandidaturasAExposicaoRemovidas(m_rcr);
    }

    /**
     * Test of setRegistoOrganizadores method, of class Exposicao.
     */
    @Test
    public void testSetRegistoOrganizadores() {
        System.out.println("setRegistoOrganizadores");
        RegistoOrganizadores m_ro = null;
        e.setRegistoOrganizadores(m_ro);
    }

    /**
     * Test of setRegistoDemonstracoes method, of class Exposicao.
     */
    @Test
    public void testSetRegistoDemonstracoes() {
        System.out.println("setRegistoDemonstracoes");
        RegistoDemonstracoes m_rd = null;
        e.setRegistoDemonstracoes(m_rd);
    }

    /**
     * Test of setRegistoAtribuicoesStands method, of class Exposicao.
     */
    @Test
    public void testSetRegistoAtribuicoes_RegistoAtribuicoesStands() {
        System.out.println("setRegistoAtribuicoes");
        RegistoAtribuicoesStands m_ras = null;
        e.setRegistoAtribuicoesStands(m_ras);
    }

    /**
     * Test of setRegistoConflitos method, of class Exposicao.
     */
    @Test
    public void testSetRegistoConflitos() {
        System.out.println("setRegistoConflitos");
        RegistoConflitos m_rconf = null;
        e.setRegistoConflitos(m_rconf);
    }

    /**
     * Test of setRegistoExpositores method, of class Exposicao.
     */
    @Test
    public void testSetRegistoExpositores() {
        System.out.println("setRegistoExpositores");
        RegistoExpositores m_rexpositores = null;
        e.setRegistoExpositores(m_rexpositores);
        
    }
    
}
