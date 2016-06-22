package lapr.project.model;

import org.junit.*;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class ScoredKeywordTest {
    
    public ScoredKeywordTest() {
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
     * Test of getScore method, of class ScoredKeyword.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        ScoredKeyword instance = null;
        int expResult = 0;
        int result = instance.getScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setScore method, of class ScoredKeyword.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        int score = 0;
        ScoredKeyword instance = null;
        instance.setScore(score);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFrequency method, of class ScoredKeyword.
     */
    @Test
    public void testGetFrequency() {
        System.out.println("getFrequency");
        ScoredKeyword instance = null;
        int expResult = 0;
        int result = instance.getFrequency();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFrequency method, of class ScoredKeyword.
     */
    @Test
    public void testSetFrequency() {
        System.out.println("setFrequency");
        int frequency = 0;
        ScoredKeyword instance = null;
        instance.setFrequency(frequency);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class ScoredKeyword.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        ScoredKeyword instance = null;
        String expResult = "";
        String result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class ScoredKeyword.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        String value = "";
        ScoredKeyword instance = null;
        instance.setValue(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class ScoredKeyword.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        ScoredKeyword instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class ScoredKeyword.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ScoredKeyword instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class ScoredKeyword.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        ScoredKeyword o = null;
        ScoredKeyword instance = null;
        int expResult = 0;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of importContentFromXMLNode method, of class ScoredKeyword.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        Node node = null;
        ScoredKeyword instance = null;
        ScoredKeyword expResult = null;
        ScoredKeyword result = instance.importContentFromXMLNode(node);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exportContentToXMLNode method, of class ScoredKeyword.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        ScoredKeyword instance = null;
        Node expResult = null;
        Node result = instance.exportContentToXMLNode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
