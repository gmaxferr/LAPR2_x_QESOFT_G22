package lapr.project.utils;

import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Node;

/**
 * All domains classes should include this interface. Created by Nuno
 * Bettencourt [NMB] on 29/05/16.
 */
@FunctionalInterface
public interface Importable<T extends Exportable> {

    /**
     * Imports the object content from an XML format.
     *
     * @param node Node de onde importar data
     * @return Structured String containing content.
     * @throws javax.xml.parsers.ParserConfigurationException
     */
    T importContentFromXMLNode(Node node) throws ParserConfigurationException;
}
