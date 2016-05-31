package lapr.project.utils.exemplo;

import org.w3c.dom.Node;

import javax.xml.transform.TransformerException;

/**
 * Interface that allows object's content to be exported.
 * All domains classes should include this interface.
 *
 * @author Nuno Bettencourt [nmb@isep.ipp.pt] on 29/05/16.
 */
@FunctionalInterface
public interface Exportable {

	/**
	 * Exports the object content to a string format.
	 *
	 * @return Structured String containing content.
	 */
	default String exportContentToString() {
		String content = "";

		Node node = exportContentToXMLNode();

		XMLParser xmlParser = new XMLParser();

		try {
			//It exports only the element representation to XML, ommiting the XML header
			content = xmlParser.convertToString(node);
		} catch (TransformerException e) {
			e.printStackTrace();
		}

		return content;
	}

	/**
	 * Exports the object content to a string format.
	 *
	 * @return Structured String containing content.
	 */
	Node exportContentToXMLNode();
}
