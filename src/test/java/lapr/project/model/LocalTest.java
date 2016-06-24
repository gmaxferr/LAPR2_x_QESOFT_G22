package lapr.project.model;

import javax.xml.parsers.ParserConfigurationException;
import org.junit.*;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 * Testes unitários da classe Local
 *
 * @author G29
 */
public class LocalTest {

    private Local instance;
    
    public LocalTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new Local("morada");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getMorada method, of class Local.
     */
    @Test
    public void testGetMorada() {
        System.out.println("getMorada");
        Local instance = new Local("morada");
        assertEquals("morada", instance.getMorada());
    }

    /**
     * Test of setMorada method, of class Local.
     */
    @Test
    public void testSetMorada() {
        System.out.println("setMorada");
        Local instance = new Local("morada");
        instance.setMorada("novaMorada");
        assertEquals("novaMorada", instance.getMorada());
    }

    /**
     * Test of importContentFromXMLNode method, of class Local.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = instance.exportContentToXMLNode();
        Local expResult = new Local("morada");
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        Local result = instance;
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class CandidaturaADemonstracao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Node node = instance.exportContentToXMLNode();
        Local expResult = new Local("morada");
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        Local result = instance;
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Local.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Local("morada");
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
}
