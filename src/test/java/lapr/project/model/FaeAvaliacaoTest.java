package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
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
 * @author G29
 */
public class FaeAvaliacaoTest {

    public FaeAvaliacaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private FaeAvaliacao instance;
    private FAE fae;
    private Utilizador u;

    private Avaliacao a;
    private String justificacao;
    private final int rat1 = 5;
    private final int rat2 = 5;
    private final int rat3 = 4;
    private final int rat4 = 3;
    private final int rat5 = 4;

    @Before
    public void setUp() {
        u = new Utilizador("a", "b", "Aa.1".toCharArray(), "a@a.a");
        fae = new FAE(u);
        instance = new FaeAvaliacao(fae);
        a = new Avaliacao();
        a.setAvaliacaoCandidaturaAExposicao(rat1, rat2, rat3, rat4, rat5);
        instance.setAvaliacao(a);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getFaeAssociado method, of class FaeAvaliacao.
     */
    @Test
    public void testGetFaeAssociado() {
        System.out.println("getFaeAssociado");
        FAE expResult = fae;
        FAE result = instance.getFaeAssociado();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAvaliacao method, of class FaeAvaliacao.
     */
    @Test
    public void testGetAvaliacao() {
        System.out.println("getAvaliacao");
        Avaliacao expResult = a;
        Avaliacao result = instance.getAvaliacao();
        assertEquals(expResult, result);
    }

    /**
     * Test of fix method, of class FaeAvaliacao.
     */
    @Test
    public void testFix() {
        System.out.println("fix");
        RegistoUtilizadores m_registoUtilizadores = new RegistoUtilizadores("tag");
        instance.fix(m_registoUtilizadores);
    }

    /**
     * Test of importContentFromXMLNode method, of class FaeAvaliacao.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        FaeAvaliacao expResult = instance;
        Node node = expResult.exportContentToXMLNode();
        FaeAvaliacao result = instance;
        try {
            result.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            result = null;
        }
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class FaeAvaliacao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        FaeAvaliacao expResult = instance;
        Node node = expResult.exportContentToXMLNode();
        FaeAvaliacao result = instance;
        try {
            result.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            result = null;
        }
        assertEquals(expResult, result);
    }

}
