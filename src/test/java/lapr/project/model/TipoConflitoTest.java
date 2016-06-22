package lapr.project.model;

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
    
    private TipoConflito tc;
    private String ID;
    
    @Before
    public void setUp() {
        ID = "id";
        tc = new TipoConflito(ID);
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

        tc.setDadosTipoConflito(tipoConflito);
        
    }

    /**
     * Test of getMecanismoDetecaoConflito method, of class TipoConflito.
     */
    @Test
    public void testGetMecanismoDetecaoConflito() {
        System.out.println("getMecanismoDetecaoConflito");

        MecanismoDetecaoConflito expResult = new MecanismoDetecaoConflito(tc);
        tc.setMecanismo(expResult);
        MecanismoDetecaoConflito result = tc.getMecanismoDetecaoConflito();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of importContentFromXMLNode method, of class TipoConflito.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;

        TipoConflito expResult = null;
        TipoConflito result = tc.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of exportContentToXMLNode method, of class TipoConflito.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");

        Node expResult = null;
        Node result = tc.exportContentToXMLNode();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setMecanismo method, of class TipoConflito.
     */
    @Test
    public void testSetMecanismo() {
        System.out.println("setMecanismo");
        MecanismoDetecaoConflito m_mec = new MecanismoDetecaoConflito(tc);
        tc.setMecanismo(m_mec);

    }
    
}
