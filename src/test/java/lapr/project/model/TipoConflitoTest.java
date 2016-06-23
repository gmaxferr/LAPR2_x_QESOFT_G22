package lapr.project.model;

import javax.xml.parsers.ParserConfigurationException;
import org.junit.*;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class TipoConflitoTest {
    
    public TipoConflitoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private TipoConflito instance;
    private String ID;
    
    @Before
    public void setUp() {
        ID = "id";
        instance = new TipoConflito(ID);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setDadosTipoConflito method, of class TipoConflito.
     */
    @Test
    public void testSetDadosTipoConflito() {
        System.out.println("setDadosTipoConflito");
        String tipoConflito = "dados";

        instance.setDadosTipoConflito(tipoConflito);
        
    }

    /**
     * Test of getMecanismoDetecaoConflito method, of class TipoConflito.
     */
    @Test
    public void testGetMecanismoDetecaoConflito() {
        System.out.println("getMecanismoDetecaoConflito");

        MecanismoDetecaoConflito expResult = new MecanismoDetecaoConflito(instance);
        instance.setMecanismo(expResult);
        MecanismoDetecaoConflito result = instance.getMecanismoDetecaoConflito();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of importContentFromXMLNode method, of class TipoConflito.
     */
    @Test
    public void testImportContentFromXMLNode() throws ParserConfigurationException {
        System.out.println("importContentFromXMLNode");
        Node node = instance.exportContentToXMLNode();
        TipoConflito expResult = new TipoConflito(ID);
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        TipoConflito result = instance;
        assertEquals(expResult, result);
        
    }

    /**
     * Test of exportContentToXMLNode method, of class TipoConflito.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Node node = instance.exportContentToXMLNode();
        TipoConflito expResult = new TipoConflito(ID);
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        TipoConflito result = instance;
        assertEquals(expResult, result);
    }

    /**
     * Test of setMecanismo method, of class TipoConflito.
     */
    @Test
    public void testSetMecanismo() {
        System.out.println("setMecanismo");
        MecanismoDetecaoConflito m_mec = new MecanismoDetecaoConflito(instance);
        instance.setMecanismo(m_mec);

    }

    /**
     * Test of equals method, of class TipoConflito.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new TipoConflito(ID);
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
    
}
