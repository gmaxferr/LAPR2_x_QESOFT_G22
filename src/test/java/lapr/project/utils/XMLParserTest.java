package lapr.project.utils;

import lapr.project.utils.exemplo.XMLParser;
import lapr.project.model.exemplo.KeywordExample;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXParseException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;
import static org.junit.Assert.assertEquals;

/**
 * @author Nuno Bettencourt [nmb@isep.ipp.pt] on 29/05/16.
 */
public class XMLParserTest {

	@Test
	public void ensureXMLElementExportToStringIsValid() throws Exception {
		String expected = "<keyword>\n"
				+ "<value>Doors</value>\n"
				+ "</keyword>\n";

		KeywordExample keyword = new KeywordExample("Doors");
		Node node = keyword.exportContentToXMLNode();

		XMLParser xmlParser = new XMLParser();
		String result = xmlParser.convertToString(node);
		assertEquals(expected, result);
	}

	@Test
	public void ensureXMLDocumentExportToStringIsValid() throws Exception {
		String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>\n"
				+ "<keyword>\n"
				+ "<value>Doors</value>\n"
				+ "</keyword>\n";



		DocumentBuilderFactory factory
				= DocumentBuilderFactory.newInstance();

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

		XMLParser xmlParser = new XMLParser();
		String result = xmlParser.convertToString(document);

		assertEquals(expected, result);
	}

	@Test
	public void readFromValidFile() throws Exception {
		DocumentBuilderFactory factory
				= DocumentBuilderFactory.newInstance();

		//Create document builder
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

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
		Node expected = document.getDocumentElement();

		String filename = "target/test-classes/KeywordXMLValidExample.xml";
		XMLParser xmlParser = new XMLParser();

		Node result = xmlParser.readXMLElementFromFile(filename);

		XMLUnit.setIgnoreAttributeOrder(true);
		XMLUnit.setIgnoreComments(true);
		XMLUnit.setIgnoreWhitespace(true);
		assertXMLEqual(expected.getOwnerDocument(), result.getOwnerDocument());
	}

	@Test(expected = SAXParseException.class)
	public void readFromInvalidFile() throws Exception {
		String filename = "target/test-classes/KeywordXMLInvalidExample.xml";
		XMLParser xmlParser = new XMLParser();

		xmlParser.readXMLElementFromFile(filename);
	}

	@Test(expected = FileNotFoundException.class)
	public void readFromNonExistingFile() throws Exception {
		String filename = "InvalidFileName";
		XMLParser xmlParser = new XMLParser();

		xmlParser.readXMLElementFromFile(filename);
	}

	@Test
	public void writeXMLElementToFile() throws Exception {
		DocumentBuilderFactory factory
				= DocumentBuilderFactory.newInstance();

		//Create document builder
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

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
		Node expected = document.getDocumentElement();

		String filename = "target/test-classes/ExampleOutput.xml";
		XMLParser xmlParser = new XMLParser();

		xmlParser.writeXMLElementToFile(expected, filename);

		Node result = xmlParser.readXMLElementFromFile(filename);

		XMLUnit.setIgnoreAttributeOrder(true);
		XMLUnit.setIgnoreComments(true);
		XMLUnit.setIgnoreWhitespace(true);
		assertXMLEqual(expected.getOwnerDocument(), result.getOwnerDocument());
	}

}
