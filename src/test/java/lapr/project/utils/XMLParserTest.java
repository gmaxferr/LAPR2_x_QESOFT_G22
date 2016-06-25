package lapr.project.utils;

import java.io.File;
import lapr.project.model.Keyword;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 *
 * @author G29
 */
public class XMLParserTest {
    
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();
    
    public XMLParserTest() {
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
     * Test of convertToString method, of class XMLParser.
     */
    @Test
    public void testConvertToString_Document() throws Exception {
        System.out.println("convertToString");
        Document document = XMLParser.createDocument(new Keyword("keyWordValue").exportContentToXMLNode(), true);
        XMLParser instance = new XMLParser();
        String expResult = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><keyword>\r\n<value>keyWordValue</value>\r\n</keyword>\r\n";
        String result = instance.convertToString(document);
        assertEquals(expResult, result);
    }

    /**
     * Test of convertToString method, of class XMLParser.
     */
    @Test
    public void testConvertToString_Node() throws Exception {
        System.out.println("convertToString");
        Node node = new Keyword("keyWordValue").exportContentToXMLNode();
        XMLParser instance = new XMLParser();
        String expResult = "<keyword>\r\n<value>keyWordValue</value>\r\n</keyword>\r\n";
        String result = instance.convertToString(node);
        assertEquals(expResult, result);
    }

    /**
     * Test of readXMLElementFromFile method, of class XMLParser.
     */
    @Test
    public void testReadXMLElementFromFile() throws Exception {
        System.out.println("readXMLElementFromFile");
        
        File testFile = testFolder.newFile("testFile");
        String filename = testFile.getAbsolutePath();
        
        XMLParser instance = new XMLParser();
        
        Node expResult = new Keyword("keyWordValue").exportContentToXMLNode();
        instance.writeXMLElementToFile(expResult, filename);
        
        Node resultNode = instance.readXMLElementFromFile(filename);
        
        Keyword key = new Keyword();
        key.importContentFromXMLNode(resultNode);
        
        boolean result = key.getValue().equals("keyWordValue");
        assertEquals(true, result);

        testFile = testFolder.newFile("testFile2");
        filename = testFile.getAbsolutePath();

        resultNode = instance.readXMLElementFromFile(filename);

        assertEquals(null, resultNode);
    }

    /**
     * Test of writeXMLElementToFile method, of class XMLParser.
     */
    @Test
    public void testWriteXMLElementToFile() throws Exception {
        System.out.println("writeXMLElementToFile");
        File testFile = testFolder.newFile("testFile");
        String filename = testFile.getAbsolutePath();
        XMLParser instance = new XMLParser();
        Node expResult = new Keyword("keyWordValue").exportContentToXMLNode();
        instance.writeXMLElementToFile(expResult, filename);
        Node resultNode = instance.readXMLElementFromFile(filename);
        Keyword key = new Keyword();
        key.importContentFromXMLNode(resultNode);
        boolean result = key.getValue().equals("keyWordValue");
        assertEquals(true, result);
    }
}
