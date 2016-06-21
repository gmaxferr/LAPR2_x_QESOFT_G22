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

    private Decisao instance;
    private boolean decisao;

    @Before
    public void setUp() {
        decisao = true;
        instance = new Decisao(decisao);
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
        instance.setDecisao(false);
    }

    /**
     * Test of getDecisao method, of class Decisao.
     */
    @Test
    public void testGetDecisao() {
        System.out.println("getDecisao");
        assertEquals(decisao, instance.getDecisao());
    }

    /**
     * Test of importContentFromXMLNode method, of class Decisao.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Decisao expResult = instance;
        Node node = expResult.exportContentToXMLNode();
        Decisao result = instance;
        result.importContentFromXMLNode(node);
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class Decisao.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Decisao expResult = instance;
        Node node = expResult.exportContentToXMLNode();
        Decisao result = instance;
        result.importContentFromXMLNode(node);
        assertEquals(expResult, result);
    }
}
