/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import javax.xml.parsers.ParserConfigurationException;
import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracao;
import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracaoAceite;
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
public class CandidaturaADemonstracaoTest {

    public CandidaturaADemonstracaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private Demonstracao demo;
    private CandidaturaADemonstracao instance;
    private String dados;
    private String email;

    @Before
    public void setUp() {
        dados = "dados";
        email = "email@b.c";
        demo = new Demonstracao("");
        demo.setCodigoIdentificacao("");
        instance = new CandidaturaADemonstracao(dados, email);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getDadosCandidatura method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testGetDadosCandidatura() {
        System.out.println("getDadosCandidatura");
        String expResult = dados;
        String result = instance.getDadosCandidatura();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmailExpositor method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testGetEmailExpositor() {
        System.out.println("getEmailExpositor");
        String expResult = email;
        String result = instance.getEmailExpositor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEstado method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testGetEstado() {
        System.out.println("getEstado");
        EstadoCandidaturaADemonstracao expResult = new EstadoCandidaturaADemonstracaoAceite(instance);
        instance.setEstado(expResult);
        EstadoCandidaturaADemonstracao result = instance.getEstado();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEstado method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testSetEstado() {
        System.out.println("setEstado");
        EstadoCandidaturaADemonstracao novoEstado = new EstadoCandidaturaADemonstracaoAceite(instance);
        instance.setEstado(novoEstado);
    }

    /**
     * Test of setDados method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testSetDados() {
        System.out.println("setDados");
        String novosDados = "dados2";
        instance.setDados(novosDados);
    }

    /**
     * Test of equals method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new CandidaturaADemonstracao(dados, email);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        CandidaturaADemonstracao cand = new CandidaturaADemonstracao(dados, email);
        int expResult = cand.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of importContentFromXMLNode method, of class
     * CandidaturaADemonstracao.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = instance.exportContentToXMLNode();
        CandidaturaADemonstracao expResult = new CandidaturaADemonstracao(dados, email);
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        CandidaturaADemonstracao result = instance;
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Node node = instance.exportContentToXMLNode();
        CandidaturaADemonstracao expResult = new CandidaturaADemonstracao(dados, email);
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        CandidaturaADemonstracao result = instance;
        assertEquals(expResult, result);
    }

    /**
     * Test of setDemonstracao method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testSetDemonstracao() {
        System.out.println("setDemonstracao");
        Demonstracao d = new Demonstracao();
        instance.setDemonstracao(d);
    }

    /**
     * Test of getCodigoDemo method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testGetCodigoDemo() {
        System.out.println("getCodigoDemo");
        String expResult = "";
        instance.setDemonstracao(demo);
        String result = instance.getCodigoDemo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmailExpositor method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testSetEmailExpositor() {
        System.out.println("setEmailExpositor");
        String email = "";
        instance.setEmailExpositor(email);
    }

    /**
     * Test of getDecisao method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testGetDecisao() {
        System.out.println("getDecisao");
        boolean expResult = false;
        instance.setDecisao(false);
        boolean result = instance.getDecisao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDecisao method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testSetDecisao() {
        System.out.println("setDecisao");
        boolean decisao = false;
        instance.setDecisao(decisao);
    }

}
