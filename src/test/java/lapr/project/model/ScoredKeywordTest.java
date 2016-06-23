package lapr.project.model;

import javax.xml.parsers.ParserConfigurationException;
import org.junit.*;
import static org.junit.Assert.assertEquals;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class ScoredKeywordTest {

    private ScoredKeyword instance;
    private String keyword;
    private int score;

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
        keyword = "keyword";
        score = 3;
        instance = new ScoredKeyword(keyword, score);

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
        int expResult = 3;
        int result = instance.getScore();
        assertEquals(expResult, result);
    }

    /**
     * Test of setScore method, of class ScoredKeyword.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        int score = 0;
        instance.setScore(score);
    }

    /**
     * Test of getFrequency method, of class ScoredKeyword.
     */
    @Test
    public void testGetFrequency() {
        System.out.println("getFrequency");
        int expResult = 1;
        int result = instance.getFrequency();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFrequency method, of class ScoredKeyword.
     */
    @Test
    public void testSetFrequency() {
        System.out.println("setFrequency");
        int frequency = 0;
        instance.setFrequency(frequency);
    }

    /**
     * Test of getValue method, of class ScoredKeyword.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        String expResult = keyword;
        String result = instance.getValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of setValue method, of class ScoredKeyword.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        String value = "";
        instance.setValue(value);
    }

    /**
     * Test of equals method, of class ScoredKeyword.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = new ScoredKeyword(keyword, score);
        boolean expResult = true;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class ScoredKeyword.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        ScoredKeyword newScore = new ScoredKeyword(keyword, score);
        int expResult = newScore.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of compareTo method, of class ScoredKeyword.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        ScoredKeyword o = new ScoredKeyword(keyword, 5);
        int expResult = -1;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }

    /**
     * Test of importContentFromXMLNode method, of class ScoredKeyword.
     */
    @Test
    public void testImportContentFromXMLNode() {
         System.out.println("importContentFromXMLNode");
        Node node = instance.exportContentToXMLNode();
        ScoredKeyword expResult = new ScoredKeyword(keyword, score);
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        ScoredKeyword result = instance;
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class ScoredKeyword.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        Node node = instance.exportContentToXMLNode();
        ScoredKeyword expResult = instance;
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        ScoredKeyword result = instance;
        assertEquals(expResult, result);
    }

    }
