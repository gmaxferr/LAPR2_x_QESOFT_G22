package lapr.project.registos;

import java.util.*;
import lapr.project.dados.DadosInstanciados;
import lapr.project.estados.Exposicao.EstadoExposicaoCandidaturasAbertas;
import lapr.project.estados.Exposicao.EstadoExposicaoCandidaturasDecididas;
import lapr.project.estados.Exposicao.EstadoExposicaoCriada;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.model.Local;
import lapr.project.model.Utilizador;
import lapr.project.utils.Data;
import org.junit.*;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author Ricardo Osorio
 */
public class RegistoExposicoesTest {

    public RegistoExposicoesTest() {
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
     * Test of registaExposicao method, of class RegistoExposicoes. Testa se
     * adiciona uma exposição válida a um centro de exposições
     */
    @Test
    public void testRegistaExposicaoValida() {
        System.out.println("registaExposicao Testa se adiciona uma exposição válida a um centro de exposições");
        DadosInstanciados x = new DadosInstanciados();
        Exposicao expo = x.getExpo1();
        CentroExposicoes ce = x.getCentroExposicoes();
        boolean adicionou = ce.getRegistoExposicoes().registaExposicao(expo);
        assertEquals(true, adicionou);
    }

    /**
     * Test of registaExposicao method, of class RegistoExposicoes. Testa se
     * adiciona uma exposição repetida a um centro de exposições
     */
    @Test
    public void testRegistaExposicaoInvalida() {
        System.out.println("registaExposicao Testa se adiciona uma exposição repetida a um centro de exposições");
        DadosInstanciados x = new DadosInstanciados();
        Exposicao expo = x.getExpo1();
        CentroExposicoes ce = x.getCentroExposicoes();
        ce.getRegistoExposicoes().registaExposicao(expo);
        boolean adicionou = ce.getRegistoExposicoes().registaExposicao(expo);
        assertEquals(false, adicionou);
    }

    /**
     * Test of getListaExposicoesValidas method, of class RegistoExposicoes.
     * Testa se o método devolve uma lista vazia quando existem apenas
     * exposições inválidas no registo de exposições em questão
     */
    @Test
    public void testGetListaExposicoesInvalidas() {
        System.out.println("getListaExposicoesValidas Testa se o método devolve uma lista vazia "
                + "quando existem apenas exposições inválidas no registo de exposições em questão");
        DadosInstanciados x = new DadosInstanciados();
        Exposicao expo = x.getExpo1();
        CentroExposicoes ce = x.getCentroExposicoes();
        ce.getRegistoExposicoes().registaExposicao(expo); //sem organizadores
        assertEquals(true, ce.getRegistoExposicoes().getListaExposicoesValidas().isEmpty());
    }

    /**
     * Test of getListaExposicoesValidas method, of class RegistoExposicoes.
     * Testa se o método devolve uma lista não vazia quando existe pelo menos
     * uma exposição válida no registo de exposições em questão"
     */
    @Test
    public void testGetListaExposicoesValidas() {
        System.out.println("getListaExposicoesValidas Testa se o método devolve uma lista não vazia "
                + "quando existe pelo menos uma exposição válida no registo de exposições em questão");
        DadosInstanciados x = new DadosInstanciados();
        Exposicao expo = x.getExpo1();
        expo.getRegistoOrganizadores().addOrganizador(new Utilizador());
        expo.getRegistoOrganizadores().addOrganizador(new Utilizador());
        CentroExposicoes ce = x.getCentroExposicoes();
        ce.getRegistoExposicoes().registaExposicao(expo); //com organizadores

        assertEquals(false, ce.getRegistoExposicoes().getListaExposicoesValidas().isEmpty());
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasAbertas method, of class
     * RegistoExposicoes. Testa se quando chamado este método apenas retorna as
     * exposições no estado certo. Para isso foram adicionadas duas exposições,
     * uma no estado certo e outra no estado Criada. Apenas uma deve de ser
     * devolvida quando o método é chamado
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAbertasUmaExpoCorretaOutraErrada() {
        System.out.println("getListaExposicoesEstadoCandidaturasAbertas");
        DadosInstanciados x = new DadosInstanciados();
        Exposicao expo = x.getExpo1();
        expo.getRegistoOrganizadores().addOrganizador(new Utilizador());
        expo.getRegistoOrganizadores().addOrganizador(new Utilizador());
        expo.setEstado(new EstadoExposicaoCandidaturasAbertas(expo));
        CentroExposicoes ce = x.getCentroExposicoes();
        Exposicao expo2 = new Exposicao("Titulo2", "Descricao2", new Data(2016, 3, 25), new Data(2016, 4, 5), new Data(2016, 3, 5), new Data(2016, 3, 10), new Data(2016, 3, 15), new Local("Local2"), ce);
        expo2.getRegistoOrganizadores().addOrganizador(new Utilizador());
        expo2.getRegistoOrganizadores().addOrganizador(new Utilizador());
        expo2.setEstado(new EstadoExposicaoCriada(expo));
        ce.getRegistoExposicoes().registaExposicao(expo); //valida
        ce.getRegistoExposicoes().registaExposicao(expo2); //valida

        assertEquals(true, ce.getRegistoExposicoes().getListaExposicoesEstadoCandidaturasAbertas().size() == 1);
    }
    /**
     * Test of getListaExposicoesEstadoCandidaturasAbertas method, of class
     * RegistoExposicoes. Testa se quando chamado este método apenas retorna as
     * exposições no estado certo. Para isso foram adicionadas duas exposições
     * num estado diferente de CandidaturasAbertas. Não devem de ser
     * devolvidas nenhuma exposição quando o método é chamado.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAbertasComExposErradasApenas() {
        System.out.println("getListaExposicoesEstadoCandidaturasAbertas");
        DadosInstanciados x = new DadosInstanciados();
        Exposicao expo = x.getExpo1();
        expo.getRegistoOrganizadores().addOrganizador(new Utilizador());
        expo.getRegistoOrganizadores().addOrganizador(new Utilizador());
        expo.setEstado(new EstadoExposicaoCandidaturasDecididas(expo));
        CentroExposicoes ce = x.getCentroExposicoes();
        Exposicao expo2 = new Exposicao("Titulo2", "Descricao2", new Data(2016, 3, 25), new Data(2016, 4, 5), new Data(2016, 3, 5), new Data(2016, 3, 10), new Data(2016, 3, 15), new Local("Local2"), ce);
        expo2.getRegistoOrganizadores().addOrganizador(new Utilizador());
        expo2.getRegistoOrganizadores().addOrganizador(new Utilizador());
        expo2.setEstado(new EstadoExposicaoCriada(expo));
        ce.getRegistoExposicoes().registaExposicao(expo); //valida
        ce.getRegistoExposicoes().registaExposicao(expo2); //valida

        assertEquals(true, ce.getRegistoExposicoes().getListaExposicoesEstadoCandidaturasAbertas().isEmpty());
    }
so para me lembrar onde ia
    /**
     * Test of getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE
     * method, of class RegistoExposicoes.
     */
    @Test
    public void testGetlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE() {
        System.out.println("getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE");
        String usernameOrganizador = "";
        RegistoExposicoes instance = null;
        ArrayList<Exposicao> expResult = null;
        ArrayList<Exposicao> result = instance.getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE(usernameOrganizador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposicoesComCanditaturasAceitesDoRepresentante method,
     * of class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesComCanditaturasAceitesRepresentante() {
        System.out.println("getListaExposicoesComCanditaturasAceitesRepresentante");
        String username = "";
        RegistoExposicoes instance = null;
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getListaExposicoesComCanditaturasAceitesDoRepresentante(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getExposicoesDoRepresentante method, of class RegistoExposicoes.
     */
    @Test
    public void testGetExposicoesDoRepresentante() {
        System.out.println("getExposicoesDoRepresentante");
        String username = "";
        RegistoExposicoes instance = null;
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getExposicoesDoRepresentante(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasAvaliadas method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAvaliadas() {
        System.out.println("getListaExposicoesEstadoCandidaturasAvaliadas");
        RegistoExposicoes instance = null;
        ArrayList<Exposicao> expResult = null;
        ArrayList<Exposicao> result = instance.getListaExposicoesEstadoCandidaturasAvaliadas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getlistaExposicoesEstadoCandidaturasAbertas method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetlistaExposicoesEstadoCandidaturasAbertas() {
        System.out.println("getlistaExposicoesEstadoCandidaturasAbertas");
        RegistoExposicoes instance = null;
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getlistaExposicoesEstadoCandidaturasAbertas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasAtribuidasDoFAE method, of
     * class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAtribuidasDoFAE() {
        System.out.println("getListaExposicoesEstadoCandidaturasAtribuidasDoFAE");
        String usernameFAE = "";
        RegistoExposicoes instance = null;
        ArrayList<Exposicao> expResult = null;
        ArrayList<Exposicao> result = instance.getListaExposicoesEstadoCandidaturasAtribuidasDoFAE(usernameFAE);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getlistaExposicoesDoOrganizadorComDemos method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetlistaExposicoesDoOrganizadorComDemos() {
        System.out.println("getlistaExposicoesDoOrganizadorComDemos");
        String usernameOrganizador = "";
        RegistoExposicoes instance = null;
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getlistaExposicoesDoOrganizadorComDemos(usernameOrganizador);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFaeExpos method, of class RegistoExposicoes.
     */
    @Test
    public void testGetFaeExpos() {
        System.out.println("getFaeExpos");
        String usernameFae = "";
        RegistoExposicoes instance = null;
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getFaeExpos(usernameFae);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasDecididas method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasDecididas() {
        System.out.println("getListaExposicoesEstadoCandidaturasDecididas");
        RegistoExposicoes instance = null;
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getListaExposicoesEstadoCandidaturasDecididas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposicoesRankingPronto method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesRankingPronto() {
        System.out.println("getListaExposicoesRankingPronto");
        RegistoExposicoes instance = null;
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getListaExposicoesRankingPronto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getlistaExposicoesDoOrganizadorEstadoCriadaOuFAEDefinidosSemDemos
     * method, of class RegistoExposicoes.
     */
    @Test
    public void testGetlistaExposicoesDoOrganizadorEstadoCriadaOuFAEDefinidosSemDemos() {
        System.out.println("getlistaExposicoesDoOrganizadorEstadoCriadaOuFAEDefinidosSemDemos");
        String usernameOrg = "";
        RegistoExposicoes instance = null;
        ArrayList<Exposicao> expResult = null;
        ArrayList<Exposicao> result = instance.getlistaExposicoesDoOrganizadorEstadoCriadaOuFAEDefinidosSemDemos(usernameOrg);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasAvaliadasOuAvancado method,
     * of class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAvaliadasOuAvancado() {
        System.out.println("getListaExposicoesEstadoCandidaturasAvaliadasOuAvancado");
        RegistoExposicoes instance = null;
        List<Exposicao> expResult = null;
        List<Exposicao> result = instance.getListaExposicoesEstadoCandidaturasAvaliadasOuAvancado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fix method, of class RegistoExposicoes.
     */
    @Test
    public void testFix() {
        System.out.println("fix");
        RegistoRecursos m_registoRecursos = null;
        RegistoTipoConflitos m_registoTipoConflitos = null;
        RegistoUtilizadores m_registoUtilizadores = null;
        RegistoExposicoes instance = null;
        instance.fix(m_registoRecursos, m_registoTipoConflitos, m_registoUtilizadores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importContentFromXMLNode method, of class RegistoExposicoes.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        RegistoExposicoes instance = null;
        RegistoExposicoes expResult = null;
        RegistoExposicoes result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class RegistoExposicoes.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        RegistoExposicoes instance = null;
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of
     * getListaExposicoesDoOrganizadorEstadoCandidaturasADemonstracoesAvaliadas
     * method, of class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesDoOrganizadorEstadoCandidaturasADemonstracoesAvaliadas() {
        System.out.println("getListaExposicoesDoOrganizadorEstadoCandidaturasADemonstracoesAvaliadas");
        String username = "";
        RegistoExposicoes instance = null;
        ArrayList<Exposicao> expResult = null;
        ArrayList<Exposicao> result = instance.getListaExposicoesDoOrganizadorEstadoCandidaturasADemonstracoesAvaliadas(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
