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
 * @author G29
 */
public class FAETest {

    public FAETest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private final String email = "a@b.c";
    private final String nome = "nome";
    private final String username = "username";
    private Utilizador u;
    private FAE instance;

    @Before
    public void setUp() {
        u = new Utilizador(nome, username, "Aa.1".toCharArray(), email);
        instance = new FAE(u);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getUtilizador method, of class FAE.
     */
    @Test
    public void testGetUtilizador() {
        System.out.println("getUtilizador");
        Utilizador expResult = u;
        Utilizador result = instance.getUtilizador();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsernameFae method, of class FAE.
     */
    @Test
    public void testGetUsernameFae() {
        System.out.println("getUsernameFae");
        String expResult = username;
        String result = instance.getUsernameFae();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUtilizador method, of class FAE.
     */
    @Test
    public void testSetUtilizador() {
        System.out.println("setUtilizador");
        Utilizador u = new Utilizador();
        instance.setUtilizador(u);
    }

    /**
     * Test of toString method, of class FAE.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "FAE:%n" + "\tUser: " + nome + "%n";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of importContentFromXMLNode method, of class FAE.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = instance.exportContentToXMLNode();
        FAE expResult = new FAE(u);
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        FAE result = instance;
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Node node = instance.exportContentToXMLNode();
        FAE expResult = new FAE(u);
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        FAE result = instance;
        assertEquals(expResult, result);
    }

}
