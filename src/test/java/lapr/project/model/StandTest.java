package lapr.project.model;

import javax.xml.parsers.ParserConfigurationException;
import org.junit.*;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class StandTest {

    public StandTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    
    private Stand instance;
    private String ID;
    private int area;
    private String descricao;
    
    @Before
    public void setUp() {
        ID = "id";
        area = 10;
        descricao = "descricao";
        instance = new Stand(ID, area, descricao);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getID method, of class Stand.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");

        String expResult = ID;
        String result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setID method, of class Stand.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        String ID = "novoID";
        instance.setID(ID);
    }

    /**
     * Test of getArea method, of class Stand.
     */
    @Test
    public void testGetArea() {
        System.out.println("getArea");

        int expResult = area;
        int result = instance.getArea();
        assertEquals(expResult, result);
    }

    /**
     * Test of setM_area method, of class Stand.
     */
    @Test
    public void testSetM_area() {
        System.out.println("setM_area");
        int area = 15;

        instance.setArea(area);
    }

    /**
     * Test of equals method, of class Stand.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Stand s = new Stand(ID, area, descricao);
        Object obj = s;

        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
                
        s = new Stand(ID, (area-1), descricao);
        expResult = false;
        obj = s;
        result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Stand.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");

        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of importContentFromXMLNode method, of class Stand.
     */
    @Test
    public void testImportContentFromXMLNode() throws ParserConfigurationException {
        System.out.println("importContentFromXMLNode");
        Node node = null;

        Stand expResult = null;
        Stand result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class Stand.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");

        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
    }

}
