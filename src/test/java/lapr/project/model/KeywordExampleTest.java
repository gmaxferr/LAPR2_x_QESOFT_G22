package lapr.project.model;

import lapr.project.model.exemplo.KeywordExample;
import lapr.project.utils.exemplo.XMLParser;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import static org.junit.Assert.*;

/**
 * Example of a domain class that is used in Candidatura.
 * Created by Nuno Bettencourt [NMB] on 29/05/16.
 */
public class KeywordExampleTest {
	@Test
	public void ensureSameContentObjectsAreEqual() {
		KeywordExample expected = new KeywordExample("Doors");
		KeywordExample result = new KeywordExample("Doors");
		assertEquals(expected, result);
	}

	@Test
	public void ensureSameObjectIsEqual() {
		KeywordExample expected = new KeywordExample("Doors");
		assertEquals(expected, expected);
	}

	@Test
	public void ensureDifferentObjectsAreNotEqual() {
		KeywordExample expected = new KeywordExample("Doors");
		Object result = new Object();
		assertNotEquals(expected, result);
	}

	@Test
	public void ensureHashCodeIsCorrect() {
		KeywordExample firstKeywordExample = new KeywordExample("Doors");

		int expected = 66216549;
		int result = firstKeywordExample.hashCode();
		assertEquals(expected, result);
	}

	@Test
	public void ensureXMLElementExportToStringIsValid() throws Exception {
		String expected = "<keyword>\n" +
				"<value>Doors</value>\n" +
				"</keyword>\n";
		KeywordExample keyword = new KeywordExample("Doors");
		String result = keyword.exportContentToString();
		assertEquals(expected, result);
	}

	@Test
	public void ensureXMLElementExportToNodeIsValid() throws Exception {
		DocumentBuilderFactory factory =
				DocumentBuilderFactory.newInstance();
		Node expected = null;

		try {
			//Create document builder
			DocumentBuilder builder = factory.newDocumentBuilder();

			//Obtain a new document
			Document document = builder.newDocument();

			//Create root element
			Element elementKeyword = document.createElement("keyword");

			//Create a sub-element
			Element elementValue = document.createElement("value");

			//Set the sub-element value
			elementValue.setTextContent("Doors");

			//Add sub-element to root element
			elementKeyword.appendChild(elementValue);

			//Add root element to document
			document.appendChild(elementKeyword);

			expected = elementKeyword;

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		KeywordExample keyword = new KeywordExample("Doors");

		Node result = keyword.exportContentToXMLNode();
		assertTrue(expected.isEqualNode(result));
	}

	@Test
	public void ensureImportFromXMLElementNodeIsValid() throws Exception {
		KeywordExample expected = new KeywordExample("Doors");

		DocumentBuilderFactory factory =
				DocumentBuilderFactory.newInstance();

		//Create document builder
		DocumentBuilder builder = factory.newDocumentBuilder();

		//Obtain a new document
		Document document = builder.newDocument();

		//Create root element
		Element elementKeyword = document.createElement("keyword");

		//Create a sub-element
		Element elementValue = document.createElement("value");

		//Set the sub-element value
		elementValue.setTextContent("Doors");

		//Add sub-element to root element
		elementKeyword.appendChild(elementValue);

		//Add root element to document
		document.appendChild(elementKeyword);

		KeywordExample keyword = new KeywordExample("Doors");

		KeywordExample result = keyword.importContentFromXMLNode(elementKeyword);

		assertEquals(expected, result);
	}

	@Test
	public void testCreateExportImport() throws Exception {
		String filename = "target/test-classes/TestKeywordImportExport.xml";
		KeywordExample expected = new KeywordExample("Doors");

		Node memoryNode = expected.exportContentToXMLNode();

		XMLParser xmlParser = new XMLParser();
		xmlParser.writeXMLElementToFile(memoryNode, filename);

		Node fileNode = xmlParser.readXMLElementFromFile(filename);

		KeywordExample result = new KeywordExample();
		result = result.importContentFromXMLNode(fileNode);

		assertEquals(expected, result);
	}
}