package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.estados.Demonstracao.EstadoDemonstracaoConfirmada;
import lapr.project.estados.Exposicao.*;
import lapr.project.registos.*;
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
 * @author G29
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
    private Demonstracao demo;

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        desc = "desc";
        ce.getRegistoExposicoes().getListaExposicoes().add(e);
        titulo = "titulo";
        local = new Local("rua");
        c = new CandidaturaAExposicao(e, new Expositor(u));
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
        data1 = new Data("2016-10-05T00:00:00Z");
        data2 = new Data("2016-10-06T00:00:00Z");
        data3 = new Data("2016-10-07T00:00:00Z");
        data4 = new Data("2016-10-08T00:00:00Z");
        data5 = new Data("2016-10-09T00:00:00Z");
        data6 = new Data("2016-10-10T00:00:00Z");
        data7 = new Data("2016-10-11T00:00:00Z");
        e = new Exposicao(titulo, desc, data1, data2, data3, data4, data5,data6, local, ce);
        e.setDataFimCandDemo(data6);
        e.setDataInicioCandDemo(data7);
        demo = new Demonstracao("descr");
        demo.setEstado(new EstadoDemonstracaoConfirmada(demo));
        demo.setDataInicioCandidaturas(data4);
        demo.setDataFimDetecaoConflitos(data4);
        demo.setDataFimCandidaturas(data4, new CentroExposicoes());
        e.getRegistoDemonstracoes().getListaDemonstracoes().add(demo);
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

        Exposicao testExpo = new Exposicao(ce);

        boolean expResult;
        boolean result;
        for (int i = 0; i < Math.pow(2, 7); i++) {
            testExpo.setTitulo((i & 0x01) > 0 ? "titulo" : null);
            testExpo.setDescricao((i & 0x02) > 0 ? "descricao" : null);
            testExpo.setDataAberturaSubCand((i & 0x04) > 0 ? new Data(2018, 4, 15) : null);
            testExpo.setDataEncerramentoSubCand((i & 0x08) > 0 ? new Data(2018, 4, 15) : null);
            testExpo.setPeriodo((i & 0x10) > 0 ? new Data(2018, 4, 15) : null, (i & 0x20) > 0 ? new Data(2018, 4, 15) : null);
            testExpo.setDataFimDetecaoConflitos((i & 0x40) > 0 ? new Data(2018, 4, 15) : null);

            expResult = i == 0x7f;
            result = testExpo.valida();
            assertEquals(expResult, result);
        }
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

        RegistoCandidaturasAExposicaoRemovidas expResult = new RegistoCandidaturasAExposicaoRemovidas(e);
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

        Expositor expositor = new Expositor(u);
        Expositor expositor2 = new Expositor(u2);

        CandidaturaAExposicao candidaturaAValidar = new CandidaturaAExposicao(e, expositor);

        boolean expResult = true;
        boolean result = e.validarDadosCandidatura(candidaturaAValidar);
        assertEquals(expResult, result);

        e.getRegistoCandidaturasAExposicao().getListaCandidaturas().add(new CandidaturaAExposicao(e, expositor2));
        result = e.validarDadosCandidatura(candidaturaAValidar);
        assertEquals(expResult, result);

        expResult = false;
        e.getRegistoCandidaturasAExposicao().getListaCandidaturas().add(new CandidaturaAExposicao(e, expositor));
        result = e.validarDadosCandidatura(candidaturaAValidar);
        assertEquals(expResult, result);
    }

    /**
     * Test of addFAE method, of class Exposicao.
     */
    @Test
    public void testAddFAE() {
        System.out.println("addFAE");

        List<Organizador> list = new ArrayList<>();
        list.add(new Organizador(u));
        e.addOrganizadores(list);

        boolean expResult = false;
        boolean result = e.addFAE(u);
        assertEquals(expResult, result);

        e.getRegistoOrganizadores().getListaOrganizadores().clear();

        expResult = true;
        result = e.addFAE(u);
        assertEquals(expResult, result);

        expResult = false;
        result = e.addFAE(u);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaCandidaturasAExposicao method, of class Exposicao.
     */
    @Test
    public void testGetListaCandidaturasAExposicao() {
        System.out.println("getListaCandidaturasAExposicao");
        CandidaturaAExposicao cand = new CandidaturaAExposicao(e, new Expositor(u));
        List<CandidaturaAExposicao> expResult = new ArrayList<>();
        expResult.add(cand);
        e.getRegistoCandidaturasAExposicao().getListaCandidaturas().add(cand);
        List<CandidaturaAExposicao> result = e.getListaCandidaturasAExposicao();
        assertEquals(expResult, result);
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

        RegistoCandidaturasAExposicao expResult = new RegistoCandidaturasAExposicao(e);
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
        CandidaturaAExposicao candidaturaAExposicao = new CandidaturaAExposicao(e, new Expositor(u));
        boolean decisao = true;
        e.setDecisao(candidaturaAExposicao, decisao);
    }

    /**
     * Test of getRegistoDemonstracoes method, of class Exposicao.
     */
    @Test
    public void testGetRegistoDemonstracoes() {
        System.out.println("getRegistoDemonstracoes");
        RegistoDemonstracoes expResult = new RegistoDemonstracoes(true);
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

        Exposicao testExpo;

        for (int i = 0; i < Math.pow(2, 9); i++) {
            testExpo = new Exposicao(ce);
            testExpo.setTitulo((i & 0x01) > 0 ? "titulo" : null);
            testExpo.setDescricao((i & 0x02) > 0 ? "descricao" : null);
            testExpo.setDataAberturaSubCand((i & 0x04) > 0 ? new Data(2018, 4, 15) : null);
            testExpo.setDataEncerramentoSubCand((i & 0x08) > 0 ? new Data(2018, 4, 15) : null);
            testExpo.setPeriodo((i & 0x10) > 0 ? new Data(2018, 4, 15) : null, (i & 0x20) > 0 ? new Data(2018, 4, 15) : null);
            testExpo.setDataFimDetecaoConflitos((i & 0x40) > 0 ? new Data(2018, 4, 15) : null);
            testExpo.setLocal((i & 0x80) > 0 ? new Local("morada") : null);
            if ((i & 0x100) > 0) {
                testExpo.addOrganizadores(lista);
            }

            expResult = i == 0x1ff;
            result = testExpo.dadosMinimosObrigatorios();
            assertEquals(expResult, result);
        }
    }

    /**
     * Test of getEstado method, of class Exposicao.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        EstadoExposicao ee = new EstadoExposicaoCandidaturasAbertas(e);
        e.setEstado(ee);
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
     * Test of getRegistoAtribuicoesExposicao method, of class Exposicao.
     */
    @Test
    public void testGetRegistoAtribuicoes() {
        System.out.println("getRegistoAtribuicoes");
        RegistoAtribuicoesCandidaturasExposicao expResult = new RegistoAtribuicoesCandidaturasExposicao();
        e.setRegistoAtribuicoes(expResult);
        RegistoAtribuicoesCandidaturasExposicao result = e.getRegistoAtribuicoesExposicao();
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
     * Test of setDataInicioCandDemo method, of class Exposicao.
     */
    @Test
    public void testSetDataInicioCandDemo() {
        System.out.println("setDataInicioCandDemo");
        Data dataInicioCandDemo = null;

        e.setDataInicioCandDemo(dataInicioCandDemo);

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
     * Test of recriarTimersDemo method, of class Exposicao.
     */
    @Test
    public void testRecriarTimersDemo() {
        System.out.println("recriarTimersDemo");
        e.setEstado(new EstadoExposicaoCandidaturasDecididas(e));
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

        RegistoCandidaturasAExposicaoRemovidas expResult = new RegistoCandidaturasAExposicaoRemovidas(e);
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

        Object obj = null;
        boolean expResult = false;
        boolean result = e.equals(obj);
        assertEquals(expResult, result);

        obj = 7;
        expResult = false;
        result = e.equals(obj);
        assertEquals(expResult, result);

        Exposicao testExpo;
        Exposicao expo;
        for (int i = 0; i <= 10; i++) {
            expo = new Exposicao(ce);
            expo.setLocal(i >= 1 ? new Local("local") : null);
            expo.setDataAberturaSubCand(i >= 2 ? new Data(2018, 2, i) : null);
            expo.setDataEncerramentoSubCand(i >= 3 ? new Data(2018, 2, i) : null);
            expo.setDataFim(i >= 4 ? new Data(2018, 2, i) : null);
            expo.setDataFimCandDemo(i >= 5 ? new Data(2018, 2, i) : null);
            expo.setDataFimDetecaoConflitos(i >= 6 ? new Data(2018, 2, i) : null);
            expo.setDataInicio(i >= 7 ? new Data(2018, 2, i) : null);
            expo.setDataInicioCandDemo(i >= 8 ? new Data(2018, 2, i) : null);
            expo.setTitulo(i >= 9 ? "titulo" : null);
            expo.setDescricao(i >= 10 ? "descr" : null);

            for (int j = 0; j <= 10; j++) {
                testExpo = new Exposicao(ce);
                testExpo.setLocal(j >= 1 ? new Local("local") : null);
                testExpo.setDataAberturaSubCand(j >= 2 ? new Data(2018, 2, j) : null);
                testExpo.setDataEncerramentoSubCand(j >= 3 ? new Data(2018, 2, j) : null);
                testExpo.setDataFim(j >= 4 ? new Data(2018, 2, j) : null);
                testExpo.setDataFimCandDemo(j >= 5 ? new Data(2018, 2, j) : null);
                testExpo.setDataFimDetecaoConflitos(j >= 6 ? new Data(2018, 2, j) : null);
                testExpo.setDataInicio(j >= 7 ? new Data(2018, 2, j) : null);
                testExpo.setDataInicioCandDemo(j >= 8 ? new Data(2018, 2, j) : null);
                testExpo.setTitulo(j >= 9 ? "titulo" : null);
                testExpo.setDescricao(j >= 10 ? "descr" : null);

                expResult = i == j;
                result = expo.equals(testExpo);
                assertEquals(expResult, result);
            }
        }
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
        try {
            System.out.println("importContentFromXMLNode");

            Exposicao instance = new Exposicao(ce);
            instance.setDataAberturaSubCand(data1);
            instance.setDataEncerramentoSubCand(data2);
            instance.setDataFimDetecaoConflitos(data3);

            Node node = instance.exportContentToXMLNode();
            Exposicao expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            boolean result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoCandidaturasAbertas(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoCandidaturasAtribuidas(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoCandidaturasAvaliadas(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoCandidaturasDecididas(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoCandidaturasFechadas(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoCompleta(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoConflitosAlterados(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoConflitosDetetados(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoCriada(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoDemosDefinidasSemFAE(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoFAEDefinidosSemDemos(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoInicial(expResult, ce));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);
        } catch (ParserConfigurationException ex) {
            fail("Foi lançada uma exceção no teste que não permitiu a correta execuçãod o mesmo.");
        }
    }

    /**
     * Test of exportContentToXMLNode method, of class Exposicao.
     */
    @Test
    public void testExportContentToXMLNode() {
        try {
            System.out.println("exportContentToXMLNode");

            Exposicao instance = new Exposicao(ce);

            Node node = instance.exportContentToXMLNode();
            Exposicao expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            boolean result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setDataFim(data1);
            instance.setDataFimCandDemo(data1);
            instance.setDataAberturaSubCand(data1);
            instance.setDataEncerramentoSubCand(data2);
            instance.setDataFimDetecaoConflitos(data3);
            instance.setDataFimDetecaoConflitosDemo(data1);
            instance.setDataInicio(data1);
            instance.setDataInicioCandDemo(data1);

            instance.setEstado(new EstadoExposicaoCandidaturasAbertas(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoCandidaturasAtribuidas(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoCandidaturasAvaliadas(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoCandidaturasDecididas(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoCandidaturasFechadas(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoCompleta(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoConflitosAlterados(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoConflitosDetetados(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoCriada(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoDemosDefinidasSemFAE(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoFAEDefinidosSemDemos(expResult));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);

            instance.setEstado(new EstadoExposicaoInicial(expResult, ce));
            node = instance.exportContentToXMLNode();
            expResult = new Exposicao(ce);
            expResult.importContentFromXMLNode(node);
            expResult.fix(ce.getRegistoRecursos(), ce.getRegistoTiposConflitos(), ce.getRegistoUtilizadoresPendentes());
            result = instance.equals(expResult);
            assertEquals(true, result);
        } catch (ParserConfigurationException ex) {
            fail("Foi lançada uma exceção no teste que não permitiu a correta execuçãod o mesmo.");
        }
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
        RegistoAtribuicoesCandidaturasExposicao m_ra = null;
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

    /**
     * Test of hashCode method, of class Exposicao.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Exposicao expo = new Exposicao(titulo, desc, data1, data2, data3, data4, data5,data6, local, ce);
        expo.setDataFimCandDemo(data6);
        expo.setDataInicioCandDemo(data7);
        int expResult = expo.hashCode();
        int result = e.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRegistoAtribuicoes method, of class Exposicao.
     */
    @Test
    public void testSetRegistoAtribuicoes() {
        System.out.println("setRegistoAtribuicoes");
        RegistoAtribuicoesCandidaturasExposicao m_ra = new RegistoAtribuicoesCandidaturasExposicao();
        e.setRegistoAtribuicoes(m_ra);
    }

    /**
     * Test of setRegistoAtribuicoesStands method, of class Exposicao.
     */
    @Test
    public void testSetRegistoAtribuicoesStands() {
        System.out.println("setRegistoAtribuicoesStands");
        RegistoAtribuicoesStands m_ras = new RegistoAtribuicoesStands();
        e.setRegistoAtribuicoesStands(m_ras);
    }

    /**
     * Test of setDataInicio method, of class Exposicao.
     */
    @Test
    public void testSetDataInicio() {
        System.out.println("setDataInicio");
        Data dataInicio = new Data(1997, 01, 15);
        e.setDataInicio(dataInicio);
    }

    /**
     * Test of setDataFim method, of class Exposicao.
     */
    @Test
    public void testSetDataFim() {
        System.out.println("setDataFim");
        Data dataFim = new Data(1998,2,20);
        e.setDataFim(dataFim);
    }

    /**
     * Test of getListaFAE method, of class Exposicao.
     */
    @Test
    public void testGetListaFAE() {
        System.out.println("getListaFAE");
        Exposicao instance = e;
        List<FAE> expResult = new ArrayList<>();
        List<FAE> result = instance.getListaFAE();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRegistoAtribuicoesExposicao method, of class Exposicao.
     */
    @Test
    public void testGetRegistoAtribuicoesExposicao() {
        System.out.println("getRegistoAtribuicoesExposicao");
        Exposicao instance = e;
        RegistoAtribuicoesCandidaturasExposicao expResult = new RegistoAtribuicoesCandidaturasExposicao();
        RegistoAtribuicoesCandidaturasExposicao result = instance.getRegistoAtribuicoesExposicao();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRegistoAtribuicoesDemonstracao method, of class Exposicao.
     */
    @Test
    public void testGetRegistoAtribuicoesDemonstracao() {
        System.out.println("getRegistoAtribuicoesDemonstracao");
        Exposicao instance = e;
        RegistoAtribuicoesCandidaturasDemonstracao expResult = new RegistoAtribuicoesCandidaturasDemonstracao();
        RegistoAtribuicoesCandidaturasDemonstracao result = instance.getRegistoAtribuicoesDemonstracao();
        assertEquals(expResult, result);
    }

}
