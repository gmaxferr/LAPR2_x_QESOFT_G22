package lapr.project.model;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

/**
 *
 * @author Ricardo Catalao
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
            String[] expResult = {"Ranking,Keyword", "1,\"Prod4\"", "2,\"Prod1\"", "3,\"Prod2\"", "4,\"Prod5\"", "5,\"Prod3\""};
            KeywordRanking instance = new KeywordRanking();
            instance.addKeyword("Prod1", 30);
            instance.addKeyword("Prod2", 50);
            instance.addKeyword("Prod3", 70);
            instance.addKeyword("Prod4", 20);
            instance.addKeyword("Prod5", 60);
            instance.exportCSV(saveFile);
            Scanner in = new Scanner(saveFile);
            int i = 0;
            while (in.hasNext()) {
                if (i < expResult.length) {
                    assertTrue(expResult[i].equals(in.nextLine()));
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
        String str = "\"to be, or \"not\" to be\"";
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
        int score = 30;
        KeywordRanking instance = new KeywordRanking();
        instance.addKeyword(keyword, score);
        instance.addKeyword(keyword, score);
        assertEquals(60, instance.getScoredKeywords().get(0).getScore());
    }
}
