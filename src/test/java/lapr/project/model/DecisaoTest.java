package lapr.project.model;

import org.junit.*;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class DecisaoTest {

    public DecisaoTest() {
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
     * Test of setDecisao method, of class Decisao.
     */
    @Test
    public void testSetDecisao() {
        System.out.println("setDecisao");
        Decisao instance = new Decisao(true);
        instance.setDecisao(false);
        assertEquals(false, instance.getDecisao());
    }

    /**
     * Test of getDecisao method, of class Decisao.
     */
    @Test
    public void testGetDecisao() {
        System.out.println("getDecisao");
        Decisao instance = new Decisao(false);
        assertEquals(false, instance.getDecisao());
    }

    /**
     * Test of importContentFromXMLNode method, of class Decisao.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        Decisao instance = new Decisao();
        Decisao expResult = null;
        Decisao result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class Decisao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Decisao instance = new Decisao();
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
