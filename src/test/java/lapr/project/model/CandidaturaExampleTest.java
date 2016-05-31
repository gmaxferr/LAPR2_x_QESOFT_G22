package lapr.project.model;

import lapr.project.model.exemplo.KeywordExample;
import lapr.project.model.exemplo.CandidaturaExample;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Class to demonstrate a Candidatura simple example.
 * @author Nuno Bettencourt [nmb@isep.ipp.pt] on 29/05/16.
 */
public class CandidaturaExampleTest {
	@Test
	public void ensureAddKeywordIsWorking() throws Exception {
		List<KeywordExample> expectedKeywordExampleList = new ArrayList<>();
		expectedKeywordExampleList.add(new KeywordExample("Doors"));

		CandidaturaExample candidatura = new CandidaturaExample("MyCandidatura", new ArrayList<>());
		candidatura.addKeyword(new KeywordExample("Doors"));

		List<KeywordExample> resultList = candidatura.getKeywordList();

		assertArrayEquals(expectedKeywordExampleList.toArray(), resultList.toArray());

	}

	@Test
	public void ensureXMLElementExportToStringIsValid() throws Exception {
		String expected = "<candidatura>\n" +
				"<description>MyCandidatura</description>\n" +
				"<keywords>\n" +
				"<keyword>\n" +
				"<value>Doors</value>\n" +
				"</keyword>\n" +
				"<keyword>\n" +
				"<value>Windows</value>\n" +
				"</keyword>\n" +
				"</keywords>\n" +
				"</candidatura>\n";

		List<KeywordExample> keywordList = new ArrayList<>();
		keywordList.add(new KeywordExample("Doors"));
		keywordList.add(new KeywordExample("Windows"));
		CandidaturaExample candidaturaExample = new CandidaturaExample("MyCandidatura", keywordList);
		String result = candidaturaExample.exportContentToString();
		assertEquals(expected, result);
	}

	@Test
	public void ensureImportFromXMLElementNodeIsValid() throws Exception {
		List<KeywordExample> keywordExampleList = new ArrayList<>();
		keywordExampleList.add(new KeywordExample("Doors"));
		keywordExampleList.add(new KeywordExample("Windows"));

		CandidaturaExample expected = new CandidaturaExample("MyCandidatura", keywordExampleList);

		DocumentBuilderFactory factory =
				DocumentBuilderFactory.newInstance();

		//Create document builder
		DocumentBuilder builder = factory.newDocumentBuilder();

		//Obtain a new document
		Document document = builder.newDocument();

		//Create root element
		Element elementCandidatura = document.createElement("candidatura");

		//Create a sub-element
		Element elementDescription = document.createElement("description");

		//Set the sub-element value
		elementDescription.setTextContent("MyCandidatura");

		//Add sub-element to root element
		elementCandidatura.appendChild(elementDescription);

		//Create a sub-element
		Element elementKeywords = document.createElement("keywords");

		//iterate over keywords
		for (KeywordExample keyword : keywordExampleList) {
			Node keywordNode = keyword.exportContentToXMLNode();
			elementKeywords.appendChild(document.importNode(keywordNode, true));
		}

		elementCandidatura.appendChild(elementKeywords);

		//Add root element to document
		document.appendChild(elementCandidatura);

		CandidaturaExample result = new CandidaturaExample();
		result = result.importContentFromXMLNode(elementCandidatura);

		assertEquals(expected, result);
	}

	@Test
	public void ensureSameContentObjectsAreEqual() {
		String description = "MyCandidatura";

		List<KeywordExample> keywords = new ArrayList<>();
		keywords.add(new KeywordExample("Doors"));
		keywords.add(new KeywordExample("Windows"));

		CandidaturaExample expected = new CandidaturaExample(description, keywords);
		CandidaturaExample result = new CandidaturaExample(description, keywords);

		assertEquals(expected, result);
	}

	@Test
	public void ensureSameObjectIsEqual() {
		String description = "MyCandidatura";

		List<KeywordExample> keywords = new ArrayList<>();
		keywords.add(new KeywordExample("Doors"));
		keywords.add(new KeywordExample("Windows"));

		CandidaturaExample expected = new CandidaturaExample(description, keywords);

		assertEquals(expected, expected);
	}

	@Test
	public void ensureDifferentObjectsAreNotEqual() {
		String description = "MyCandidatura";

		List<KeywordExample> keywords = new ArrayList<>();
		keywords.add(new KeywordExample("Doors"));
		keywords.add(new KeywordExample("Windows"));

		CandidaturaExample expected = new CandidaturaExample(description, keywords);

		Object result = new Object();
		assertNotEquals(expected, result);
	}

	@Test
	public void ensureDifferentDescriptionMakeObjectsNotEqual() {
		String description1 = "MyCandidatura1";
		String description2 = "MyCandidatura2";

		List<KeywordExample> keywords = new ArrayList<>();
		keywords.add(new KeywordExample("Doors"));
		keywords.add(new KeywordExample("Windows"));

		CandidaturaExample expected = new CandidaturaExample(description1, keywords);
		CandidaturaExample result = new CandidaturaExample(description2, keywords);

		assertNotEquals(expected, result);
	}

	@Test
	public void ensureHashCodeIsCorrect() {
		String description = "MyCandidatura";

		List<KeywordExample> keywords = new ArrayList<>();
		keywords.add(new KeywordExample("Doors"));
		keywords.add(new KeywordExample("Windows"));

		CandidaturaExample candidaturaExample = new CandidaturaExample(description, keywords);

		int expected = 461375881;
		int result = candidaturaExample.hashCode();
		assertEquals(expected, result);

	}


}