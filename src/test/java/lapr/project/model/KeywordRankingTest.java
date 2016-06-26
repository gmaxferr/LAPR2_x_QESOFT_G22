package lapr.project.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class KeywordRankingTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    public KeywordRankingTest() {
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
     * Test of exportCSV method, of class KeywordRanking.
     */
    @Test
    public void testExportCSV() {
        try {
            System.out.println("exportCSV");
            File saveFile = tempFolder.newFile("test_file.txt");
            String[] expResult = {"Ranking,Frequency,Keyword", "1,1,\"Prod1\"", "2,4,\"Prod2\""};
            KeywordRanking instance = new KeywordRanking();
            instance.addKeyword("Prod1", true);
            instance.addKeyword("Prod2", true);
            instance.addKeyword("Prod2", true);
            instance.addKeyword("Prod2", false);
            instance.addKeyword("Prod2", false);
            instance.exportCSV(saveFile);
            Scanner in = new Scanner(saveFile);
            int i = 0;
            while (in.hasNext()) {
                if (i < expResult.length) {
                    assertEquals(expResult[i], in.nextLine());
                } else {
                    fail("Ficheiro tem informação a mais!");
                    break;
                }
                i++;
            }
            if (i < expResult.length) {
                fail("Encontrado o fim do ficheiro inesperadamente.");
            }
        } catch (IOException ex) {
            fail("Nao foi possivel criar um ficheiro temporário.");
            Logger.getLogger(KeywordRankingTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of convertStringToCSVReadable method, of class KeywordRanking.
     */
    @Test
    public void testConvertStringToCSVReadable() {
        System.out.println("convertStringToCSVReadable");
        String str = "to be, or \"not\" to be";
        KeywordRanking instance = new KeywordRanking();
        String expResult = "\"to be, or \"\"not\"\" to be\"";
        String result = instance.convertStringToCSVReadable(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of addKeyword method, of class KeywordRanking.
     */
    @Test
    public void testAddKeyword() {
        System.out.println("addKeyword");
        String keyword = "prod1";
        KeywordRanking instance = new KeywordRanking();
        instance.addKeyword(keyword, true);
        instance.addKeyword(keyword, true);
        instance.addKeyword(keyword, false);
        int expScore = 1;
        int expFrequency = 3;
        assertEquals(expScore, instance.getScoredKeywords().get(0).getScore());
        assertEquals(expFrequency, instance.getScoredKeywords().get(0).getFrequency());
    }

    /**
     * Test of getKeywordIndex method, of class KeywordRanking.
     */
    @Test
    public void testGetKeywordIndex() {
        System.out.println("getKeywordIndex");
        String keyword1 = "cheese";
        String keyword2 = "chocolate";
        KeywordRanking instance = new KeywordRanking();
        instance.addKeyword(keyword2, true);
        instance.addKeyword(keyword1, true);
        int expResult = 0;
        int result = instance.getKeywordIndex("chocolate");
        assertEquals(expResult, result);
        expResult = 1;
        result = instance.getKeywordIndex("cheese");
        assertEquals(expResult, result);
    }

    /**
     * Test of getScoredKeywords method, of class KeywordRanking.
     */
    @Test
    public void testGetScoredKeywords() {
        System.out.println("getScoredKeywords");
        KeywordRanking instance = new KeywordRanking();
        List<ScoredKeyword> expResult = new ArrayList<>();
        ScoredKeyword key = new ScoredKeyword("key1", 10);
        key.setFrequency(10);
        expResult.add(key);
        key = new ScoredKeyword("key2", 30);
        key.setFrequency(30);
        expResult.add(key);
        key = new ScoredKeyword("key3", 20);
        key.setFrequency(20);
        expResult.add(key);
        for (int i = 0; i < 10; i++) {
            instance.addKeyword("key1", true);
        }
        for (int i = 0; i < 30; i++) {
            instance.addKeyword("key2", true);
        }
        for (int i = 0; i < 20; i++) {
            instance.addKeyword("key3", true);
        }
        List<ScoredKeyword> result = instance.getScoredKeywords();
        assertEquals(expResult, result);
    }

    /**
     * Test of setReady method, of class KeywordRanking.
     */
    @Test
    public void testSetReady() {
        System.out.println("setReady");
        KeywordRanking instance = new KeywordRanking();
        instance.setReady();
        boolean expResult = true;
        boolean result = instance.isReady();
        assertEquals(expResult, result); 
   }

    /**
     * Test of isReady method, of class KeywordRanking.
     */
    @Test
    public void testIsReady() {
        System.out.println("isReady");
        KeywordRanking instance = new KeywordRanking();
        boolean expResult = false;
        boolean result = instance.isReady();
        assertEquals(expResult, result);
    }

    /**
     * Test of importContentFromXMLNode method, of class KeywordRanking.
     */
    @Test
    public void testImportContentFromXMLNode() {
        System.out.println("importContentFromXMLNode");
        KeywordRanking instance = new KeywordRanking();
        Node node = instance.exportContentToXMLNode();
        KeywordRanking expResult = new KeywordRanking();
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        KeywordRanking result = instance;
        assertEquals(expResult, result);
    }

    /**
     * Test of exportContentToXMLNode method, of class KeywordRanking.
     */
    @Test
    public void testExportContentToXMLNode() {
        System.out.println("exportContentToXMLNode");
        KeywordRanking instance = new KeywordRanking();
        Node node = instance.exportContentToXMLNode();
        KeywordRanking expResult = new KeywordRanking();
        try {
            expResult.importContentFromXMLNode(node);
        } catch (ParserConfigurationException ex) {
            expResult = null;
        }
        KeywordRanking result = instance;
        assertEquals(expResult, result);
    }
}
