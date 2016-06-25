/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoAceite;
import lapr.project.estados.Demonstracao.EstadoDemonstracaoCandidaturasAvaliadas;
import lapr.project.estados.Demonstracao.EstadoDemonstracaoPendente;
import lapr.project.estados.Exposicao.EstadoExposicaoCandidaturasAbertas;
import lapr.project.estados.Exposicao.EstadoExposicaoCandidaturasAtribuidas;
import lapr.project.estados.Exposicao.EstadoExposicaoCandidaturasAvaliadas;
import lapr.project.estados.Exposicao.EstadoExposicaoCandidaturasDecididas;
import lapr.project.estados.Exposicao.EstadoExposicaoCriada;
import lapr.project.estados.Exposicao.EstadoExposicaoDemosDefinidasSemFAE;
import lapr.project.estados.Exposicao.EstadoExposicaoFAEDefinidosSemDemos;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.model.Expositor;
import lapr.project.model.KeywordRanking;
import lapr.project.model.Local;
import lapr.project.model.Recurso;
import lapr.project.model.Utilizador;
import lapr.project.utils.Data;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ricardo Catalao
 */
public class RegistoExposicoesTest {

    CentroExposicoes ce;
    RegistoExposicoes re;
    Exposicao expo1, expo2, expo3, expo4, expo5, expo6, expo7, expo8, expo9, expo10, expo11;
    KeywordRanking rank = new KeywordRanking();
    CandidaturaAExposicao cand;

    public RegistoExposicoesTest() {
        ce = new CentroExposicoes();
        re = ce.getRegistoExposicoes();

        Utilizador user1 = new Utilizador("Joaquim", "user1", "Secret-1".toCharArray(), "mail@mail.com");
        Utilizador user2 = new Utilizador("Joaquim", "user2", "Secret-1".toCharArray(), "mail@mail.com");
        Utilizador user3 = new Utilizador("Joaquim", "user3", "Secret-1".toCharArray(), "mail@mail.com");
        cand = new CandidaturaAExposicao(expo1, new Expositor(user1));

        Data data1 = new Data(2016, 1, 2);

        expo1 = new Exposicao(ce);

        expo2 = new Exposicao("titulo2", "desc2", data1, data1, data1, data1, data1, data1, new Local("Rua das flores... :P"), ce);
        expo2.setEstado(new EstadoExposicaoCandidaturasAvaliadas(expo2));

        expo3 = new Exposicao("titulo3", "desc2", data1, data1, data1, data1, data1, data1, new Local("Rua das flores... :P"), ce);
        expo3.getRegistoOrganizadores().addOrganizador(user1);
        expo3.getRegistoOrganizadores().addOrganizador(user1);
        expo3.setEstado(new EstadoExposicaoCandidaturasDecididas(expo3));
        expo3.getKeywordRanking().setReady();

        expo4 = new Exposicao("titulo4", "desc2", data1, data1, data1, data1, data1, data1, new Local("Rua das flores... :P"), ce);
        expo4.setEstado(new EstadoExposicaoCandidaturasAbertas(expo4));

        expo5 = new Exposicao("titulo5", "desc2", data1, data1, data1, data1, data1, data1, new Local("Rua das flores... :P"), ce);
        expo5.getRegistoOrganizadores().addOrganizador(user1);
        expo5.setEstado(new EstadoExposicaoCriada(expo5));

        expo6 = new Exposicao("titulo6", "desc2", data1, data1, data1, data1, data1, data1, new Local("Rua das flores... :P"), ce);
        expo6.getRegistoOrganizadores().addOrganizador(user2);
        expo6.setEstado(new EstadoExposicaoCriada(expo6));

        expo7 = new Exposicao("titulo7", "desc2", data1, data1, data1, data1, data1, data1, new Local("Rua das flores... :P"), ce);
        expo7.getRegistoOrganizadores().addOrganizador(user2);
        expo7.setEstado(new EstadoExposicaoDemosDefinidasSemFAE(expo7));

        expo8 = new Exposicao("titulo8", "desc2", data1, data1, data1, data1, data1, data1, new Local("Rua das flores... :P"), ce);
        expo8.getRegistoOrganizadores().addOrganizador(user2);
        expo8.setEstado(new EstadoExposicaoFAEDefinidosSemDemos(expo8));

        expo9 = new Exposicao("titulo9", "desc2", data1, data1, data1, data1, data1, data1, new Local("Rua das flores... :P"), ce);
        expo9.getRegistoOrganizadores().addOrganizador(user3);
        expo9.getRegistoFAE().adicionaFAE(user1);
        CandidaturaAExposicao cand1 = expo9.getRegistoCandidaturasAExposicao().criarCandidatura(user3);
        cand1.setEstado(new EstadoCandidaturaAExposicaoAceite(cand1));
        expo9.getRegistoCandidaturasAExposicao().registaCandidatura(cand1);
        expo9.setEstado(new EstadoExposicaoCandidaturasAtribuidas(expo9));
        Demonstracao demo1 = expo9.getRegistoDemonstracoes().novaDemonstracao("Uma demonstração");
        demo1.setEstado(new EstadoDemonstracaoPendente(demo1));
        demo1.getRegistoRecursosNecessarios().getListaDeRecursos().add(new Recurso("electricidade"));
        expo9.getRegistoDemonstracoes().addDemo(demo1);

        expo10 = new Exposicao("titulo10", "desc2", data1, data1, data1, data1, data1, data1, new Local("Rua das flores... :P"), ce);

        expo11 = new Exposicao("titulo10", "desc2", data1, data1, data1, data1, data1, data1, new Local("Rua das flores... :P"), ce);
        expo11.getRegistoOrganizadores().addOrganizador(user3);
        Demonstracao demo2 = expo11.getRegistoDemonstracoes().novaDemonstracao("Outra demonstração");
        demo2.setEstado(new EstadoDemonstracaoCandidaturasAvaliadas(demo2));
        demo2.getRegistoRecursosNecessarios().getListaDeRecursos().add(new Recurso("electricidade"));
        expo11.getRegistoDemonstracoes().addDemo(demo2);

        re.getListaExposicoes().add(expo1);
        re.getListaExposicoes().add(expo2);
        re.getListaExposicoes().add(expo3);
        re.getListaExposicoes().add(expo4);
        re.getListaExposicoes().add(expo5);
        re.getListaExposicoes().add(expo6);
        re.getListaExposicoes().add(expo7);
        re.getListaExposicoes().add(expo8);
        re.getListaExposicoes().add(expo9);
        re.getListaExposicoes().add(expo10);
        re.getListaExposicoes().add(expo11);
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

    /**
     * Test of getListaExposicoes method, of class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoes() {
        System.out.println("getListaExposicoes");
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(expo1);
        expResult.add(expo2);
        expResult.add(expo3);
        expResult.add(expo4);
        expResult.add(expo5);
        expResult.add(expo6);
        expResult.add(expo7);
        expResult.add(expo8);
        expResult.add(expo9);
        expResult.add(expo10);
        expResult.add(expo11);
        List<Exposicao> result = re.getListaExposicoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of novaExposicao method, of class RegistoExposicoes.
     */
    @Test
    public void testNovaExposicao() {
        System.out.println("novaExposicao");
        boolean expResult = true;
        boolean result = re.novaExposicao().getCentroExposicoes() == ce;
        assertEquals(expResult, result);
    }

    /**
     * Test of registaExposicao method, of class RegistoExposicoes.
     */
    @Test
    public void testRegistaExposicao() {
        System.out.println("registaExposicao");
        Exposicao e = new Exposicao(ce);
        boolean expResult = false;
        boolean result = re.registaExposicao(e);
        assertEquals(expResult, result);

        e = new Exposicao("titulo", "desc", new Data(2016, 1, 2), new Data(2018, 1, 3), new Data(2016, 1, 3), new Data(2016, 1, 4), new Data(2016, 1, 6), new Data(2016, 1, 7), new Local("Rua das flores... :P"), ce
        );
        expResult = true;
        result = re.registaExposicao(e);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaExposicoesValidas method, of class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesValidas() {
        System.out.println("getListaExposicoesValidas");
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(expo3);
        List<Exposicao> result = re.getListaExposicoesValidas();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasAbertas method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAbertas() {
        System.out.println("getListaExposicoesEstadoCandidaturasAbertas");
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(expo4);
        List<Exposicao> result = re.getListaExposicoesEstadoCandidaturasAbertas();
        assertEquals(expResult, result);
    }

    /**
     * Test of getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE
     * method, of class RegistoExposicoes.
     */
    @Test
    public void testGetlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE() {
        System.out.println("getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE");
        String usernameOrganizador = "user2";
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(expo6);
        expResult.add(expo7);
        ArrayList<Exposicao> result = re.getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE(usernameOrganizador);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaExposicoesComCanditaturasAceitesDoRepresentante method,
     * of class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesComCanditaturasAceitesDoRepresentante() {
        System.out.println("getListaExposicoesComCanditaturasAceitesDoRepresentante");
        String email = "mail@mail.com";
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(expo9);
        List<Exposicao> result = re.getListaExposicoesComCanditaturasAceitesDoRepresentante(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of getExposicoesDoRepresentante method, of class RegistoExposicoes.
     */
    @Test
    public void testGetExposicoesDoRepresentante() {
        System.out.println("getExposicoesDoRepresentante");
        String email = "mail@mail.com";
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(expo1);
        List<Exposicao> result = re.getExposicoesDoRepresentanteCandidaturasAbertas(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasAvaliadas method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAvaliadas() {
        System.out.println("getListaExposicoesEstadoCandidaturasAvaliadas");
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(expo2);
        List<Exposicao> result = re.getListaExposicoesEstadoCandidaturasAvaliadas();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasAtribuidasDoFAE method, of
     * class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAtribuidasDoFAE() {
        System.out.println("getListaExposicoesEstadoCandidaturasAtribuidasDoFAE");
        String usernameFAE = "user1";
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(expo9);
        ArrayList<Exposicao> result = re.getListaExposicoesEstadoCandidaturasAtribuidasDoFAE(usernameFAE);
        assertEquals(expResult, result);
    }

    /**
     * Test of getlistaExposicoesDoOrganizadorComDemos method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetlistaExposicoesDoOrganizadorComDemos() {
        System.out.println("getlistaExposicoesDoOrganizadorComDemos");
        String usernameOrganizador = "user3";
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(expo9);
        List<Exposicao> result = re.getlistaExposicoesDoOrganizadorComDemos(usernameOrganizador);
        assertEquals(expResult, result);
    }

    /**
     * Test of getFaeExpos method, of class RegistoExposicoes.
     */
    @Test
    public void testGetFaeExpos() {
        System.out.println("getFaeExpos");
        String usernameFae = "user1";
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(expo9);
        List<Exposicao> result = re.getFaeExpos(usernameFae);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasDecididas method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasDecididas() {
        System.out.println("getListaExposicoesEstadoCandidaturasDecididas");
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(expo3);
        List<Exposicao> result = re.getListaExposicoesEstadoCandidaturasDecididas();
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaExposicoesRankingPronto method, of class
     * RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesRankingPronto() {
        System.out.println("getListaExposicoesRankingPronto");
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(expo3);
        List<Exposicao> result = re.getListaExposicoesRankingPronto();
        assertEquals(expResult, result);
    }

    /**
     * Test of getlistaExposicoesDoOrganizadorEstadoCriadaOuFAEDefinidosSemDemos
     * method, of class RegistoExposicoes.
     */
    @Test
    public void testGetlistaExposicoesDoOrganizadorEstadoCriadaOuFAEDefinidosSemDemos() {
        System.out.println("getlistaExposicoesDoOrganizadorEstadoCriadaOuFAEDefinidosSemDemos");
        String usernameOrg = "user2";
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(expo6);
        expResult.add(expo8);
        List<Exposicao> result = re.getListaExposicoesDoOrganizadorAteEstadoAbertoACandidaturas(usernameOrg);
        assertEquals(expResult, result);
    }

    /**
     * Test of getListaExposicoesEstadoCandidaturasAvaliadasOuAvancado method,
     * of class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesEstadoCandidaturasAvaliadasOuAvancado() {
        System.out.println("getListaExposicoesEstadoCandidaturasAvaliadasOuAvancado");
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(expo2);
        expResult.add(expo3);
        expResult.add(expo10);
        List<Exposicao> result = re.getListaExposicoesEstadoCandidaturasAvaliadasOuAvancado();
        assertEquals(expResult, result);
    }

    /**
     * Test of
     * getListaExposicoesDoOrganizadorEstadoCandidaturasADemonstracoesAvaliadas
     * method, of class RegistoExposicoes.
     */
    @Test
    public void testGetListaExposicoesDoOrganizadorEstadoCandidaturasADemonstracoesAvaliadas() {
        System.out.println("getListaExposicoesDoOrganizadorEstadoCandidaturasADemonstracoesAvaliadas");
        String username = "user3";
        List<Exposicao> expResult = new ArrayList<>();
        expResult.add(expo11);
        List<Exposicao> result = re.getListaExposicoesDoOrganizadorEstadoCandidaturasADemonstracoesAvaliadas(username);
        assertEquals(expResult, result);
    }
}
