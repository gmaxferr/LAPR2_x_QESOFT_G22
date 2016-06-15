package lapr.project.registos;

import java.util.*;
import lapr.project.dados.DadosInstanciados;
import lapr.project.estados.Exposicao.*;
import lapr.project.model.*;
import lapr.project.utils.Data;
import org.junit.*;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author G29
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
     * num estado diferente de CandidaturasAbertas. Não devem de ser devolvidas
     * nenhuma exposição quando o método é chamado.
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

    /**
     * Test of getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE
     * method, of class RegistoExposicoes. Testa se o método retorna
     * corretamente as exposiões do organizador e que se encontram no estado
     * Criada ou DemosDefinidasSemFAE. Para testar foram criadas duas exposições
     * válidas e apenas uma se encontrava no estado correta. Chamando o método a
     * ser testado com parametro (username de um dos organizadores de apenas uma
     * das exposições) deve de devolver essa exposição.
     */
    @Test
    public void testGetlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE() {
        System.out.println("getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE");
        DadosInstanciados x = new DadosInstanciados();
        Exposicao expo = x.getExpo1();
        Utilizador u = new Utilizador("Ricardo", "Ricardo", "password".toCharArray(), "email@email.com");
        expo.getRegistoOrganizadores().addOrganizador(u);
        expo.getRegistoOrganizadores().addOrganizador(new Utilizador("Joao", "Joao", "password".toCharArray(), "email@email.com"));
        expo.setEstado(new EstadoExposicaoCriada(expo));
        CentroExposicoes ce = x.getCentroExposicoes();
        Exposicao expo2 = new Exposicao("Titulo2", "Descricao2", new Data(2016, 3, 25), new Data(2016, 4, 5), new Data(2016, 3, 5), new Data(2016, 3, 10), new Data(2016, 3, 15), new Local("Local2"), ce);
        expo2.getRegistoOrganizadores().addOrganizador(u);
        expo2.getRegistoOrganizadores().addOrganizador(new Utilizador("Joao2", "Joao2", "password".toCharArray(), "email@email.com"));
        expo2.setEstado(new EstadoExposicaoCriada(expo));
        ce.getRegistoExposicoes().registaExposicao(expo); //valida
        ce.getRegistoExposicoes().registaExposicao(expo2); //valida

        if (ce.getRegistoExposicoes().getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE("Ricardo").size() == 1) {
            assertEquals(expo, ce.getRegistoExposicoes().getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE("Ricardo").get(0));
        } else {
            fail("O método devolveu exposições inválidas.");
        }
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getListaExposicoesComCanditaturasAceitesDoRepresentante method,
     * of class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesComCanditaturasAceitesRepresentante() {
        System.out.println("getListaExposicoesComCanditaturasAceitesRepresentante");
        
    }

    /**
     * Test of getExposicoesDoRepresentante method, of class RegistoExposicoes.
     */
    @Test
    public void testGetExposicoesDoRepresentante() {
        System.out.println("getExposicoesDoRepresentante");
        
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasAvaliadas method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAvaliadas() {
        System.out.println("getListaExposicoesEstadoCandidaturasAvaliadas");
        
    }

    /**
     * Test of getlistaExposicoesEstadoCandidaturasAbertas method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetlistaExposicoesEstadoCandidaturasAbertas() {
        System.out.println("getlistaExposicoesEstadoCandidaturasAbertas");
        
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasAtribuidasDoFAE method, of
     * class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAtribuidasDoFAE() {
        System.out.println("getListaExposicoesEstadoCandidaturasAtribuidasDoFAE");
        
    }

    /**
     * Test of getlistaExposicoesDoOrganizadorComDemos method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetlistaExposicoesDoOrganizadorComDemos() {
        System.out.println("getlistaExposicoesDoOrganizadorComDemos");
        
    }

    /**
     * Test of getFaeExpos method, of class RegistoExposicoes.
     */
    @Test
    public void testGetFaeExpos() {
        System.out.println("getFaeExpos");
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasDecididas method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasDecididas() {
        System.out.println("getListaExposicoesEstadoCandidaturasDecididas");
    }

    /**
     * Test of getListaExposicoesRankingPronto method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesRankingPronto() {
        System.out.println("getListaExposicoesRankingPronto");
    }

    /**
     * Test of getlistaExposicoesDoOrganizadorEstadoCriadaOuFAEDefinidosSemDemos
     * method, of class RegistoExposicoes.
     */
    @Test
    public void testGetlistaExposicoesDoOrganizadorEstadoCriadaOuFAEDefinidosSemDemos() {
        System.out.println("getlistaExposicoesDoOrganizadorEstadoCriadaOuFAEDefinidosSemDemos");
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasAvaliadasOuAvancado method,
     * of class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAvaliadasOuAvancado() {
        System.out.println("getListaExposicoesEstadoCandidaturasAvaliadasOuAvancado");
    }

    /**
     * Test of
     * getListaExposicoesDoOrganizadorEstadoCandidaturasADemonstracoesAvaliadas
     * method, of class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesDoOrganizadorEstadoCandidaturasADemonstracoesAvaliadas() {
        System.out.println("getListaExposicoesDoOrganizadorEstadoCandidaturasADemonstracoesAvaliadas");
    }

}
