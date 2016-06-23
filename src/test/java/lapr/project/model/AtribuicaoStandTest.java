/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import javax.xml.parsers.ParserConfigurationException;
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
public class AtribuicaoStandTest {

    public AtribuicaoStandTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private AtribuicaoStand instance;
    private Stand stand;
    private boolean decisao;
    private CandidaturaAExposicao cand;

    @Before
    public void setUp() {
        stand = new Stand("id", 10, "descricao");
        cand = new CandidaturaAExposicao(new Expositor(new Utilizador()));
        decisao = true;
        instance = new AtribuicaoStand(stand, cand, decisao);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getStand method, of class AtribuicaoStand.
     */
    @Test
    public void testGetStand() {
        System.out.println("getStand");
        Stand expResult = stand;
        Stand result = instance.getStand();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStand method, of class AtribuicaoStand.
     */
    @Test
    public void testSetStand() {
        System.out.println("setStand");
        Stand stand = this.stand;
        instance.setStand(stand);
    }

    /**
     * Test of getCand method, of class AtribuicaoStand.
     */
    @Test
    public void testGetCand() {
        System.out.println("getCand");
        CandidaturaAExposicao expResult = cand;
        CandidaturaAExposicao result = instance.getCand();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCand method, of class AtribuicaoStand.
     */
    @Test
    public void testSetCand() {
        System.out.println("setCand");
        CandidaturaAExposicao cand = this.cand;
        instance.setCand(cand);
    }

    /**
     * Test of getDecisao method, of class AtribuicaoStand.
     */
    @Test
    public void testGetDecisao() {
        System.out.println("getDecisao");
        boolean expResult = decisao;
        boolean result = instance.getDecisao();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDecisao method, of class AtribuicaoStand.
     */
    @Test
    public void testSetDecisao() {
        System.out.println("setDecisao");
        boolean decisao = false;
        instance.setDecisao(decisao);
    }

    /**
     * Test of importContentFromXMLNode method, of class AtribuicaoStand.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        AtribuicaoStand expResult = instance;
        Node node = expResult.exportContentToXMLNode();
        AtribuicaoStand result = instance;
        try {
            result.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class AtribuicaoStand.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        AtribuicaoStand expResult = instance;
        Node node = expResult.exportContentToXMLNode();
        AtribuicaoStand result = instance;
        try {
            result.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        assertEquals(expResult, result);
    }

}
