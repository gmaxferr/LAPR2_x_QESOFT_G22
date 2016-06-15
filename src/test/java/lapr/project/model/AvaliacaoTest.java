/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

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
public class AvaliacaoTest {
    
    public AvaliacaoTest() {
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
     * Test of verificaAvaliacaoJaTomada method, of class Avaliacao.
     */
    @Test
    public void testVerificaAvaliacaoJaTomada() {
        System.out.println("verificaAvaliacaoJaTomada");
        Avaliacao instance = new Avaliacao();
        boolean expResult = false;
        boolean result = instance.verificaAvaliacaoJaTomada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvaliacao method, of class Avaliacao.
     */
    @Test
    public void testGetAvaliacao() {
        System.out.println("getAvaliacao");
        Avaliacao instance = new Avaliacao();
        boolean expResult = false;
        boolean result = instance.getAvaliacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJustificacao method, of class Avaliacao.
     */
    @Test
    public void testGetJustificacao() {
        System.out.println("getJustificacao");
        Avaliacao instance = new Avaliacao();
        String expResult = "";
        String result = instance.getJustificacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRatingConhecimentoSobreOTema method, of class Avaliacao.
     */
    @Test
    public void testGetRatingConhecimentoSobreOTema() {
        System.out.println("getRatingConhecimentoSobreOTema");
        Avaliacao instance = new Avaliacao();
        int expResult = 0;
        int result = instance.getRatingConhecimentoSobreOTema();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRatingAdequacaoAExposicao method, of class Avaliacao.
     */
    @Test
    public void testGetRatingAdequacaoAExposicao() {
        System.out.println("getRatingAdequacaoAExposicao");
        Avaliacao instance = new Avaliacao();
        int expResult = 0;
        int result = instance.getRatingAdequacaoAExposicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRatingAdequacaoAsDemos method, of class Avaliacao.
     */
    @Test
    public void testGetRatingAdequacaoAsDemos() {
        System.out.println("getRatingAdequacaoAsDemos");
        Avaliacao instance = new Avaliacao();
        int expResult = 0;
        int result = instance.getRatingAdequacaoAsDemos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRatingAdequacaoNumConvites method, of class Avaliacao.
     */
    @Test
    public void testGetRatingAdequacaoNumConvites() {
        System.out.println("getRatingAdequacaoNumConvites");
        Avaliacao instance = new Avaliacao();
        int expResult = 0;
        int result = instance.getRatingAdequacaoNumConvites();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRatingRecomendacaoGlobal method, of class Avaliacao.
     */
    @Test
    public void testGetRatingRecomendacaoGlobal() {
        System.out.println("getRatingRecomendacaoGlobal");
        Avaliacao instance = new Avaliacao();
        int expResult = 0;
        int result = instance.getRatingRecomendacaoGlobal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvalicao method, of class Avaliacao.
     */
    @Test
    public void testSetAvalicao() {
        System.out.println("setAvalicao");
        boolean avaliacao = false;
        String justificacao = "";
        int ratingConhecimentoSobreTema = 0;
        int ratingAdequacaoAExposicao = 0;
        int ratingAdequacaoAsDemos = 0;
        int ratingAdequacaoNumConvites = 0;
        int ratingRecomendacaoGlobal = 0;
        Avaliacao instance = new Avaliacao();
        instance.setAvalicao(avaliacao, justificacao, ratingConhecimentoSobreTema, ratingAdequacaoAExposicao, ratingAdequacaoAsDemos, ratingAdequacaoNumConvites, ratingRecomendacaoGlobal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvalicaoParaDemonstracao method, of class Avaliacao.
     */
    @Test
    public void testSetAvalicaoParaDemonstracao() {
        System.out.println("setAvalicaoParaDemonstracao");
        boolean avaliacao = false;
        String justificacao = "";
        Avaliacao instance = new Avaliacao();
        instance.setAvalicaoParaDemonstracao(avaliacao, justificacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importContentFromXMLNode method, of class Avaliacao.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        Avaliacao instance = new Avaliacao();
        Avaliacao expResult = null;
        Avaliacao result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class Avaliacao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Avaliacao instance = new Avaliacao();
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMediaRatings method, of class Avaliacao.
     */
    @Test
    public void testGetMediaRatings() {
        System.out.println("getMediaRatings");
        Avaliacao instance = new Avaliacao();
        float expResult = 0.0F;
        float result = instance.getMediaRatings();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
