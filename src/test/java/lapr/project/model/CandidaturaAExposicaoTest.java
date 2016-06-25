package lapr.project.model;

import java.util.*;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.estados.CandidaturaAExposicao.*;
import lapr.project.registos.*;
import lapr.project.utils.Data;
import org.junit.*;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class CandidaturaAExposicaoTest {

    public CandidaturaAExposicaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private CandidaturaAExposicao instance;
    private Expositor expositor;
    private Utilizador u;
    private CentroExposicoes ce;
    private Exposicao e;
    private Demonstracao d;
    private RegistoDemonstracoes rd;
    private RegistoUtilizadores ru;

    private final String nome = "nome";
    private final String email = "112sss@aaa444.ccc888";
    private final String username = "username";
    private final char[] password = {'A', '.', 'c', '1', 'e'};
    private final String telemovel = "915417433";
    private final String area = "100";
    private final String numConvites = "10";
    private final String empresa = "empresa1";
    private final String morada = "rua1";
    private final String keyword = "key1;key2;key3;key4;key5";
    private final boolean decisao = true;
    private final String nomeProd1 = "prod1";
    private final String nomeProd2 = "prod2";
    private final String nomeProd3 = "prod3";

    @Before
    public void setUp() {
        ce = new CentroExposicoes();
        ru = new RegistoUtilizadores("");
        e = new Exposicao(ce);
        u = new Utilizador(nome, username, password, email);
        ru.getListaUtilizadores().add(u);
        expositor = new Expositor(u);
        instance = new CandidaturaAExposicao(e, expositor);
        instance.criarProduto(nomeProd1);
        instance.criarProduto(nomeProd2);
        instance.criarProduto(nomeProd3);
        instance.setArea(area);
        instance.setKeywords(keyword);
        instance.setNomeEmpresa(empresa);
        instance.setTelemovel(telemovel);
        instance.setNumConvites(numConvites);
        instance.setMorada(morada);
        instance.setDecisao(decisao);
        rd = instance.getRegistoDemonstracoes();

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
        int expResult = Integer.parseInt(telemovel);
        int result = instance.getTelemovel();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumConvites method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetNumConvites() {
        System.out.println("getNumConvites");
        int expResult = Integer.parseInt(numConvites);
        int result = instance.getNumConvites();
        assertEquals(expResult, result);
    }

    /**
     * Test of getArea method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetArea() {
        System.out.println("getArea");
        int expResult = Integer.parseInt(area);
        int result = instance.getArea();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNomeEmpresa method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetNomeEmpresa() {
        System.out.println("getNomeEmpresa");
        String expResult = empresa;
        String result = instance.getNomeEmpresa();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMoradaEmpresa method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetMoradaEmpresa() {
        System.out.println("getMoradaEmpresa");
        String expResult = morada;
        String result = instance.getMoradaEmpresa();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsernameExpositor method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetUsernameExpositor() {
        System.out.println("getUsernameExpositor");
        String expResult = username;
        String result = instance.getUsernameExpositor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRegistoProdutos method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetRegistoProdutos() {
        System.out.println("getRegistoProdutos");
        RegistoProdutos expResult = new RegistoProdutos();
        expResult.getListaProdutosAExpor().add(new Produto(nomeProd1));
        expResult.getListaProdutosAExpor().add(new Produto(nomeProd2));
        expResult.getListaProdutosAExpor().add(new Produto(nomeProd3));
        RegistoProdutos result = instance.getRegistoProdutos();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRegistoDemonstracoes method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetRegistoDemonstracoes() {
        System.out.println("getRegistoDemonstracoes");
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
        String srt_telemovel = "935055577";
        instance.setTelemovel(telemovel);
    }

    /**
     * Test of setNumConvites method, of class CandidaturaAExposicao.
     */
    @Test
    public void testSetNumConvites() {
        System.out.println("setNumConvites");
        String m_StrNumConvites = "10";
        instance.setNumConvites(m_StrNumConvites);
    }

    /**
     * Test of setArea method, of class CandidaturaAExposicao.
     */
    @Test
    public void testSetArea() {
        System.out.println("setArea");
        String m_StrArea = "10";
        instance.setArea(m_StrArea);
    }

    /**
     * Test of setNomeEmpresa method, of class CandidaturaAExposicao.
     */
    @Test
    public void testSetNomeEmpresa() {
        System.out.println("setNomeEmpresa");
        String nomeEmpresa = "";
        instance.setNomeEmpresa(nomeEmpresa);
    }

    /**
     * Test of setMorada method, of class CandidaturaAExposicao.
     */
    @Test
    public void testSetMorada() {
        System.out.println("setMorada");
        String morada = "";
        instance.setMorada(morada);
    }

    /**
     * Test of criarProduto method, of class CandidaturaAExposicao.
     */
    @Test
    public void testCriarProduto() {
        System.out.println("criarProduto");
        String nome = nomeProd1;
        Produto expResult = new Produto(nomeProd1);
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
        instance.removeProduto(index);
    }

    /**
     * Test of editProduto method, of class CandidaturaAExposicao.
     */
    @Test
    public void testEditProduto() {
        System.out.println("editProduto");
        int index = 0;
        String novoProduto = "";
        instance.editProduto(index, novoProduto);
    }

    /**
     * Test of addProduto method, of class CandidaturaAExposicao.
     */
    @Test
    public void testAddProduto() {
        System.out.println("addProduto");
        Produto p = null;
        instance.addProduto(p);
    }

    /**
     * Test of getProdutosExpor method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetProdutosExpor() {
        System.out.println("getProdutosExpor");
        List<Produto> expResult = new ArrayList<>();
        expResult.add(new Produto(nomeProd1));
        expResult.add(new Produto(nomeProd2));
        expResult.add(new Produto(nomeProd3));
        List<Produto> result = instance.getProdutosExpor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDecisao method, of class CandidaturaAExposicao.
     */
    @Test
    public void testSetDecisao() {
        System.out.println("setDecisao");
        boolean decisao = false;
        instance.setDecisao(decisao);
    }

    /**
     * Test of getExpositor method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetExpositor() {
        System.out.println("getExpositor");
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
        EstadoCandidaturaAExposicao estado = new EstadoCandidaturaAExposicaoAceite(instance);
        instance.setEstado(estado);
        EstadoCandidaturaAExposicao expResult = estado;
        EstadoCandidaturaAExposicao result = instance.getEstado();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstado method, of class CandidaturaAExposicao.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        EstadoCandidaturaAExposicao ne = null;
        instance.setEstado(ne);
    }

    /**
     * Test of equals method, of class CandidaturaAExposicao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class CandidaturaAExposicao.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        int h = instance.hashCode();
        int expResult = h;
        int result = h;
        assertEquals(expResult, result);
    }

    /**
     * Test of setKeywords method, of class CandidaturaAExposicao.
     */
    @Test
    public void testSetKeywords() {
        System.out.println("setKeywords");
        String keywords = keyword;
        instance.setKeywords(keywords);
    }

    /**
     * Test of getKeywords method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetKeywords() {
        System.out.println("getKeywords");
        String[] expResult = keyword.split(";");
        String[] result = instance.getKeywords();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getListKeyword method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetListKeyword() {
        System.out.println("getListKeyword");
        CandidaturaAExposicao cand2 = new CandidaturaAExposicao(e, expositor);
        cand2.setKeywords(keyword);
        List<Keyword> expResult = cand2.getListKeyword();
        List<Keyword> result = instance.getListKeyword();
        assertEquals(expResult, result);
    }

    /**
     * Test of validaCandidatura method, of class CandidaturaAExposicao.
     */
    @Test
    public void testValidaCandidatura() {
        System.out.println("validaCandidatura");
        boolean expResult = true;
        boolean result = instance.validaCandidatura();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDecisao method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetDecisao() {
        System.out.println("getDecisao");
        boolean expResult = decisao;
        boolean result = instance.getDecisao();
        assertEquals(expResult, result);
    }

    /**
     * Test of fix method, of class CandidaturaAExposicao.
     */
    @Test
    public void testFix() {
        System.out.println("fix");

        instance = new CandidaturaAExposicao(e, expositor);
        Node node = instance.exportContentToXMLNode();

        CandidaturaAExposicao expResult = new CandidaturaAExposicao(e, null);
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }

        boolean result = instance.equals(expResult);
        assertEquals(false, result);

        expResult.fix(ru, rd);

        result = instance.equals(expResult);
        assertEquals(true, result);
    }

    /**
     * Test of importContentFromXMLNode method, of class CandidaturaAExposicao.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        instance = new CandidaturaAExposicao(e, expositor);
        Node node = instance.exportContentToXMLNode();
        CandidaturaAExposicao expResult = new CandidaturaAExposicao(e, expositor);
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        expResult.fix(ru, rd);
        CandidaturaAExposicao result = instance;
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class CandidaturaAExposicao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        instance = new CandidaturaAExposicao(e, expositor);
        Node node = instance.exportContentToXMLNode();
        CandidaturaAExposicao expResult = new CandidaturaAExposicao(e, expositor);
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        expResult.fix(ru, rd);
        CandidaturaAExposicao result = instance;
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmailExpositor method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetEmailExpositor() {
        System.out.println("getEmailExpositor");
        Expositor expositor = new Expositor(new Utilizador("nome", "username", "password".toCharArray(), "email2"));
        Produto p = instance.criarProduto("produto1");
        instance.addProduto(p);
        instance.setExpositor(expositor);
        assertEquals("email2", instance.getExpositor().getEmail());
    }

    /**
     * Test of setExpositor method, of class CandidaturaAExposicao.
     */
    @Test
    public void testSetExpositor() {
        System.out.println("setExpositor");
        Expositor expositor = new Expositor(new Utilizador("nome", "username", "password".toCharArray(), "email"));
        Produto p = instance.criarProduto("produto1");
        instance.addProduto(p);
        instance.setExpositor(expositor);
        assertEquals("username", instance.getExpositor().getUsername());
    }

    /**
     * Test of toString method, of class CandidaturaAExposicao.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        instance.setNomeEmpresa("nomeEmpresa");
        assertEquals("nomeEmpresa", instance.toString());
    }

    /**
     * Test of getExposicao method, of class CandidaturaAExposicao.
     */
    @Test
    public void testGetExposicao() {
        System.out.println("getExposicao");
        assertEquals(e, instance.getExposicao());
    }

    /**
     * Test of setExposicao method, of class CandidaturaAExposicao.
     */
    @Test
    public void testSetExposicao() {
        System.out.println("setExposicao");
        Exposicao expo = new Exposicao("titulo", "descricao", new Data(), new Data(), new Data(), new Data(), new Data(), new Data(), new Data(), new Local("local"), ce);
        instance.setExposicao(expo);
        assertEquals(expo, instance.getExposicao());
    }

}
