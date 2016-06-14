/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import java.util.ArrayList;
import java.util.List;
import lapr.project.dados.DadosInstanciados;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicao;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicaoCriada;
import lapr.project.registos.RegistoDemonstracoes;
import lapr.project.registos.RegistoProdutos;
import lapr.project.registos.RegistoUtilizadores;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class CandidaturaAExposicaoTest {

    private CandidaturaAExposicao ce;
    private Expositor expositor;
    private Utilizador user;
    private DadosInstanciados dadosInst;
    private RegistoProdutos rp;
    private RegistoDemonstracoes rd;
    private List<Produto>listaProdutos;

    public CandidaturaAExposicaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dadosInst = new DadosInstanciados();
        user = dadosInst.inicializarUtilizador("utilizador1", "username1", dadosInst.getPass(), "email1");
        expositor = new Expositor(user);
        ce = new CandidaturaAExposicao(expositor);
        Produto p1 = new Produto("produto1");
        ce.addProduto(p1);
        Produto p2 = new Produto("produto2");
        ce.addProduto(p2);
        Produto p3 = new Produto("produto3");
        ce.addProduto(p3);
        Produto p4 = new Produto("produto4");
        ce.addProduto(p4);
        listaProdutos=new ArrayList<>();
        listaProdutos.add(p1);
        listaProdutos.add(p2);
        listaProdutos.add(p3);
        listaProdutos.add(p4);
        ce.setArea("123");
        ce.setDecisao(true);
        ce.setEstado(new EstadoCandidaturaAExposicaoCriada(ce));
        ce.setKeywords("test1,uno,dos,cinco");
        ce.setMorada("rua");
        ce.setNomeEmpresa("empresa");
        ce.setNumConvites("23");
        ce.setTelemovel("191548767");
        rp = ce.getRegistoProdutos();
        rd = ce.getRegistoDemonstracoes();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getTelemovel method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetTelemovel() {
        System.out.println("getTelemovel");
        CandidaturaAExposicao instance = ce;
        int expResult = 191548767;
        int result = instance.getTelemovel();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumConvites method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetNumConvites() {
        System.out.println("getNumConvites");
        CandidaturaAExposicao instance = ce;
        int expResult = 23;
        int result = instance.getNumConvites();
        assertEquals(expResult, result);
    }

    /**
     * Test of getArea method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetArea() {
        System.out.println("getArea");
        CandidaturaAExposicao instance = ce;
        int expResult = 123;
        int result = instance.getArea();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNomeEmpresa method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetNomeEmpresa() {
        System.out.println("getNomeEmpresa");
        CandidaturaAExposicao instance = ce;
        String expResult = "empresa";
        String result = instance.getNomeEmpresa();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMoradaEmpresa method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetMoradaEmpresa() {
        System.out.println("getMoradaEmpresa");
        CandidaturaAExposicao instance = ce;
        String expResult = "rua";
        String result = instance.getMoradaEmpresa();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsernameExpositor method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetUsernameExpositor() {
        System.out.println("getUsernameExpositor");
        CandidaturaAExposicao instance = ce;
        String expResult = "username1";
        String result = instance.getUsernameExpositor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRegistoProdutos method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetRegistoProdutos() {
        System.out.println("getRegistoProdutos");
        CandidaturaAExposicao instance = ce;
        RegistoProdutos expResult = rp;
        RegistoProdutos result = instance.getRegistoProdutos();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRegistoDemonstracoes method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetRegistoDemonstracoes() {
        System.out.println("getRegistoDemonstracoes");
        CandidaturaAExposicao instance = ce;
        RegistoDemonstracoes expResult = rd;
        RegistoDemonstracoes result = instance.getRegistoDemonstracoes();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTelemovel method, of class CandidaturaAExposicao.
     */
    @Test
    public void testSetTelemovel() {
        System.out.println("setTelemovel");
        String m_intTelemovel = "123456789";
        CandidaturaAExposicao instance = ce;
        instance.setTelemovel(m_intTelemovel);
        int result = instance.getTelemovel();
        int expResult = 123456789;
        assertEquals(result, expResult);
    }

    /**
     * Test of setNumConvites method, of class CandidaturaAExposicao.
     */
    @Test
    public void testSetNumConvites() {
        System.out.println("setNumConvites");
        String m_StrNumConvites = "12";
        CandidaturaAExposicao instance = ce;
        instance.setNumConvites(m_StrNumConvites);
        int result = instance.getNumConvites();
        int expResult = 12;
        assertEquals(result, expResult);
    }

    /**
     * Test of setArea method, of class CandidaturaAExposicao.
     */
    @Test
    public void testSetArea() {
        System.out.println("setArea");
        String m_StrArea = "200";
        CandidaturaAExposicao instance = ce;
        instance.setArea(m_StrArea);
        int result = instance.getArea();
        int expResult = 200;
        assertEquals(result, expResult);
    }

    /**
     * Test of setNomeEmpresa method, of class CandidaturaAExposicao.
     */
    @Test
    public void testSetNomeEmpresa() {
        System.out.println("setNomeEmpresa");
        String nomeEmpresa = "novaEmpresa";
        CandidaturaAExposicao instance = ce;
        instance.setNomeEmpresa(nomeEmpresa);
        String result = instance.getNomeEmpresa();
        String expResult = "novaEmpresa";
        assertEquals(result, expResult);
    }

    /**
     * Test of setMorada method, of class CandidaturaAExposicao.
     */
    @Test
    public void testSetMorada() {
        System.out.println("setMorada");
        String morada = "novaRua";
        CandidaturaAExposicao instance = ce;
        instance.setMorada(morada);
        String result = instance.getMoradaEmpresa();
    }

    /**
     * Test of criarProduto method, of class CandidaturaAExposicao.
     */
    @Test
    public void testCriarProduto() {
        System.out.println("criarProduto");
        String nome = "produto";
        CandidaturaAExposicao instance = ce;
        List<Produto> produtos = instance.getRegistoProdutos().getListaProdutosAExpor();
        Produto expResult = produtos.get(produtos.size());
        Produto result = instance.criarProduto(nome);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeProduto method, of class CandidaturaAExposicao.
     */
    @Test
    public void testRemoveProduto() {
        System.out.println("removeProduto");
        int index = 0;
        CandidaturaAExposicao instance = ce;
        int expResult = instance.getRegistoProdutos().getListaProdutosAExpor().size() - 1;
        instance.removeProduto(index);
        int result = instance.getRegistoProdutos().getListaProdutosAExpor().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of editProduto method, of class CandidaturaAExposicao.
     */
    @Test
    public void testEditProduto() {
        System.out.println("editProduto");
        int index = 0;
        String novoProduto = "produtoEditado";
        CandidaturaAExposicao instance = ce;
        instance.editProduto(index, novoProduto);
        String result = instance.getRegistoProdutos().getListaProdutosAExpor().get(0).getNome();
        assertEquals(novoProduto, result);
    }

    /**
     * Test of addProduto method, of class CandidaturaAExposicao.
     */
    @Test
    public void testAddProduto() {
        System.out.println("addProduto");
        Produto p = new Produto("produtoAdicionado");
        CandidaturaAExposicao instance = ce;
        int expResult = instance.getRegistoProdutos().getListaProdutosAExpor().size() + 1;
        instance.addProduto(p);
        int result = instance.getRegistoProdutos().getListaProdutosAExpor().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProdutosExpor method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetProdutosExpor() {
        System.out.println("getProdutosExpor");
        CandidaturaAExposicao instance = ce;
        List<Produto> expResult = listaProdutos;
        List<Produto> result = instance.getProdutosExpor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDadosCandidatura method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetDadosCandidatura() {
        System.out.println("getDadosCandidatura");
        CandidaturaAExposicao instance = ce;
        ArrayList expResult = instance.getDadosCandidatura();
        ArrayList result = instance.getDadosCandidatura();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDecisao method, of class CandidaturaAExposicao.
     */
    @Test
    public void testSetDecisao() {
        System.out.println("setDecisao");
        boolean decisao = false;
        CandidaturaAExposicao instance = ce;
        instance.setDecisao(decisao);
        boolean result = instance.getDecisao();
        assertEquals(false, result);
    }

    /**
     * Test of getExpositor method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetExpositor() {
        System.out.println("getExpositor");
        CandidaturaAExposicao instance = ce;
        Expositor expResult = expositor;
        Expositor result = instance.getExpositor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEstado method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        CandidaturaAExposicao instance = ce;
        EstadoCandidaturaAExposicao expResult = instance.getEstado();
        EstadoCandidaturaAExposicao result = instance.getEstado();
        assertEquals(expResult, result);
    }

//    /**
//     * Test of setEstado method, of class CandidaturaAExposicao.
//     */
//    @Test
//    public void testSetEstado() {
//        System.out.println("setEstado");
//        EstadoCandidaturaAExposicao ne = ce.getEstado();
//        CandidaturaAExposicao instance = ce;
//        instance.setEstado(ne);
//    }

    /**
     * Test of equals method, of class CandidaturaAExposicao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new CandidaturaAExposicao(expositor);
        CandidaturaAExposicao ce2 = (CandidaturaAExposicao) obj;
        Produto p1 = new Produto("produto1");
        ce2.addProduto(p1);
        Produto p2 = new Produto("produto2");
        ce2.addProduto(p2);
        Produto p3 = new Produto("produto3");
        ce2.addProduto(p3);
        Produto p4 = new Produto("produto4");
        ce2.addProduto(p4);
        ce2.setArea("123");
        ce2.setDecisao(true);
        ce2.setEstado(new EstadoCandidaturaAExposicaoCriada(ce2));
        ce2.setKeywords("teste");
        ce2.setMorada("rua");
        ce2.setNomeEmpresa("empresa");
        ce2.setNumConvites("23");
        ce2.setTelemovel("191548767");
        CandidaturaAExposicao instance = ce;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

//    /**
//     * Test of hashCode method, of class CandidaturaAExposicao.
//     */
//    @Test
//    public void testHashCode() {
//        System.out.println("hashCode");
//        CandidaturaAExposicao instance = null;
//        int expResult = 0;
//        int result = instance.hashCode();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of setKeywords method, of class CandidaturaAExposicao.
     */
    @Test
    public void testSetKeywords() {
        System.out.println("setKeywords");
        String keywords = "teste2,uno,dos,tres";
        CandidaturaAExposicao instance = ce;
        instance.setKeywords(keywords);
        String [] result = instance.getKeywords();
        String[]expResult = {"teste2","uno","dos","tres"};
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getKeywords method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetKeywords() {
        System.out.println("getKeywords");
        CandidaturaAExposicao instance = ce;
        String[] expResult = {"test1","uno","dos","cinco"};
        String[] result = instance.getKeywords();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getListKeyword method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetListKeyword() {
        System.out.println("getListKeyword");
        CandidaturaAExposicao instance = ce;
        List<Keyword> expResult = new ArrayList();
        expResult.add(new Keyword("test1"));
        expResult.add(new Keyword("uno"));
        expResult.add(new Keyword("dos"));
        expResult.add(new Keyword("tres"));
        List<Keyword> result = instance.getListKeyword();
        assertEquals(expResult, result);
    }

    /**
     * Test of validaCandidatura method, of class CandidaturaAExposicao.
     */
    @Test
    public void testValidaCandidatura() {
        System.out.println("validaCandidatura");
        CandidaturaAExposicao instance = null;
        boolean expResult = false;
        boolean result = instance.validaCandidatura();
        assertEquals(expResult, result);
    }

    /**
     * Test of fix method, of class CandidaturaAExposicao.
     */
    @Test
    public void testFix() {
        System.out.println("fix");
        RegistoUtilizadores m_registoUtilizadores = null;
        RegistoDemonstracoes m_rd = null;
        CandidaturaAExposicao instance = null;
        instance.fix(m_registoUtilizadores, m_rd);
    }

    /**
     * Test of importContentFromXMLNode method, of class CandidaturaAExposicao.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        CandidaturaAExposicao instance = null;
        CandidaturaAExposicao expResult = null;
        CandidaturaAExposicao result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class CandidaturaAExposicao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        CandidaturaAExposicao instance = null;
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
