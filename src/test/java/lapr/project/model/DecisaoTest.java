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
}
