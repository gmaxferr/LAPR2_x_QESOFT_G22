package lapr.project.model;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Testes unitários da classe Local
 *
 * @author G29
 */
public class LocalTest {

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
        Local instance = new Local("morada");
        assertEquals("morada", instance.getMorada());
    }
}
