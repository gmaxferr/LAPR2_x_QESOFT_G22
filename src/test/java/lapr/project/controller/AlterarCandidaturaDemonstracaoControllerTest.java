///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package lapr.project.controller;
//
//import java.util.List;
//import lapr.project.dados.DadosInstanciados;
//import lapr.project.model.CandidaturaADemonstracao;
//import lapr.project.model.CentroExposicoes;
//import lapr.project.model.Exposicao;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author JoãoCardoso aka K4rd050
// */
//public class AlterarCandidaturaDemonstracaoControllerTest {
//
//    private String email;
//    private CentroExposicoes ce;
//    private Exposicao expo;
//    private AlterarCandidaturaDemonstracaoController ctrl;
//    private DadosInstanciados dadosInst;
//
//    public AlterarCandidaturaDemonstracaoControllerTest() {
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//        dadosInst = new DadosInstanciados();
//        email = dadosInst.getEmail1();
//        ce = dadosInst.getCe();
//        expo = dadosInst.getExpo1();
//        CandidaturaADemonstracao cd1Lista = expo.getRegistoDemonstracoes().getListaDemonstracoes().get(0).getRegistoCandidaturasADemonstracao().getListaCandidaturasADemonstracao().get(0);
//        ctrl.selectCand(cd1Lista);
//        ctrl = new AlterarCandidaturaDemonstracaoController(email, expo);
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of selectCand method, of class
//     * AlterarCandidaturaDemonstracaoController.
//     */
//    @Test
//    public void testSelectCand() {
//        System.out.println("selectCand");
//        CandidaturaADemonstracao c = new CandidaturaADemonstracao("teste1", "a@iol.com");
//        AlterarCandidaturaDemonstracaoController instance = ctrl;
//        instance.selectCand(c);
//        CandidaturaADemonstracao result = instance.getCandidaturaDemonstracao();
//        assertEquals(c, result);
//    }
//
//    /**
//     * Test of setDados method, of class
//     * AlterarCandidaturaDemonstracaoController.
//     */
//    @Test
//    public void testSetDados() {
//        System.out.println("setDados");
//        String dados = "novosDados";
//        AlterarCandidaturaDemonstracaoController instance = ctrl;
//        instance.setDados(dados);
//        String result = instance.getNovosDados();
//        assertEquals("novosDados", result);
//    }
//
//    /**
//     * Test of alterarCandidatura method, of class
//     * AlterarCandidaturaDemonstracaoController.
//     */
//    @Test
//    public void testAlterarCandidatura() {
//        System.out.println("alterarCandidatura");
//        AlterarCandidaturaDemonstracaoController instance = ctrl;
//        instance.alterarCandidatura();
//        String result = instance.getCandidaturaDemonstracao().getM_dadosCandidatura();
//        assertEquals("novosDados", result);
//    }
//
//    /**
//     * Test of getCandidaturasRepresentante method, of class
//     * AlterarCandidaturaDemonstracaoController.
//     */
//    @Test
//    public void testGetCandidaturasRepresentante() {
//        System.out.println("getCandidaturasRepresentante");
//        AlterarCandidaturaDemonstracaoController instance = ctrl;
//        List<CandidaturaADemonstracao> expResult = dadosInst.getCandsAbertasRepresentante1();
//        List<CandidaturaADemonstracao> result = instance.getCandidaturasRepresentante();
//        assertEquals(expResult, result);
//    }
//
//}
