package lapr.project.model;

import javax.xml.parsers.ParserConfigurationException;
import org.junit.*;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class RecursoTest {

    public RecursoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    private Recurso instance;
    private String titulo;

    @Before
    public void setUp() {
        titulo = "titulo";
        instance = new Recurso(titulo);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getNomeRecurso method, of class Recurso.
     */
    @Test
    public void testGetNomeRecurso() {
        System.out.println("getNomeRecurso");

        String expResult = titulo;
        String result = instance.getNomeRecurso();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNomeRecurso method, of class Recurso.
     */
    @Test
    public void testSetNomeRecurso() {
        System.out.println("setNomeRecurso");
        String nomeRecurso = "titulo2";

        instance.setNomeRecurso(nomeRecurso);
    }

    /**
     * Test of equals method, of class Recurso.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = new Recurso("titulo");

        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Recurso.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Recurso novoRecurso = new Recurso(titulo);
        int expResult = novoRecurso.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of importContentFromXMLNode method, of class Recurso.
     */
    @Test
    public void testImportContentFromXMLNode() throws ParserConfigurationException {
         System.out.println("importContentFromXMLNode");
        Node node = instance.exportContentToXMLNode();
        Recurso expResult = new Recurso(titulo);
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        Recurso result = instance;
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class Recurso.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Node node = instance.exportContentToXMLNode();
        Recurso expResult = new Recurso(titulo);
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        Recurso result = instance;
        assertEquals(expResult, result);
    }

}
