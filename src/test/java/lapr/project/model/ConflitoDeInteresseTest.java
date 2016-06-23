/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.model;

import javax.xml.parsers.ParserConfigurationException;
import lapr.project.registos.RegistoCandidaturasAExposicao;
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
public class ConflitoDeInteresseTest {

    public ConflitoDeInteresseTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private ConflitoDeInteresse instance;
    private FAE fae;
    private CandidaturaAExposicao cand;
    private TipoConflito tipoConflito;
    private Utilizador u;

    @Before
    public void setUp() {
        u = new Utilizador();
        fae = new FAE(u);
        cand = new CandidaturaAExposicao(new Expositor(u));
        tipoConflito = new TipoConflito("id");
        instance = new ConflitoDeInteresse(fae, cand, tipoConflito);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getFae method, of class ConflitoDeInteresse.
     */
    @Test
    public void testGetFae() {
        System.out.println("getFae");
        FAE expResult = fae;
        FAE result = instance.getFae();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCandidatura method, of class ConflitoDeInteresse.
     */
    @Test
    public void testGetCandidatura() {
        System.out.println("getCandidatura");
        CandidaturaAExposicao expResult = cand;
        CandidaturaAExposicao result = instance.getCandidatura();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTipo method, of class ConflitoDeInteresse.
     */
    @Test
    public void testGetTipo() {
        System.out.println("getTipo");
        TipoConflito expResult = tipoConflito;
        TipoConflito result = instance.getTipo();
        assertEquals(expResult, result);
    }

    /**
     * Test of importContentFromXMLNode method, of class ConflitoDeInteresse.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        ConflitoDeInteresse expResult = instance;
        Node node = expResult.exportContentToXMLNode();
        ConflitoDeInteresse result = instance;
        try {
            result.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            result = null;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class ConflitoDeInteresse.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        ConflitoDeInteresse expResult = instance;
        Node node = expResult.exportContentToXMLNode();
        ConflitoDeInteresse result = instance;
        try {
            result.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            result = null;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of fix method, of class ConflitoDeInteresse.
     */
    @Test
    public void testFix() {
        System.out.println("fix");
        RegistoCandidaturasAExposicao rc = null;
        ConflitoDeInteresse instance = null;
        instance.fix(rc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
