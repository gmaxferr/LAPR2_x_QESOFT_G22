package lapr.project.model;

import javax.xml.parsers.ParserConfigurationException;
import org.junit.*;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class KeywordTest {

    public KeywordTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private Keyword instance;
    private String strKey;

    @Before
    public void setUp() {

        strKey = "key";
        instance = new Keyword(strKey);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getValue method, of class Keyword.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        String expResult = strKey;
        String result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of setValue method, of class Keyword.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        String keyword = "something";
        instance.setValue(keyword);
    }

    /**
     * Test of equals method, of class Keyword.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Keyword instance2 = new Keyword("something");
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        Keyword instance3 = new Keyword(strKey);
        expResult = true;
        result = instance.equals(instance3);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Keyword.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        int expResult = new Keyword(strKey).hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of importContentFromXMLNode method, of class Keyword.
     */
    @Test
    public void testImportContentFromXMLNode() throws ParserConfigurationException {
        System.out.println("importContentFromXMLNode");
        instance = new Keyword("keyword");
        Node node = instance.exportContentToXMLNode();
        Keyword expResult = new Keyword("keyword");
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        Keyword result = instance;
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class Keyword.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        instance = new Keyword("keyword");
        Node node = instance.exportContentToXMLNode();
        Keyword expResult = new Keyword("keyword");
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        Keyword result = instance;
        assertEquals(expResult, result);
    }

}
