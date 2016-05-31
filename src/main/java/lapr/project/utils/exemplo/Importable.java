package lapr.project.utils.exemplo;

import org.w3c.dom.Node;

/**
 * All domains classes should include this interface.
 * Created by Nuno Bettencourt [NMB] on 29/05/16.
 */
@FunctionalInterface
public interface Importable<T extends Exportable> {
	/**
	 * Imports the object content from an XML format.
	 *
	 * @return Structured String containing content.
	 */
	T importContentFromXMLNode(Node node);
}
