package lapr.project.model;

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

        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of importContentFromXMLNode method, of class Recurso.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;

        Recurso expResult = null;
        Recurso result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class Recurso.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");

        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
    }

}
