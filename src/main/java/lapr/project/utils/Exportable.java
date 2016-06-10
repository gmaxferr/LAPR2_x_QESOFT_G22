package lapr.project.utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Node;

import javax.xml.transform.TransformerException;

/**
 * Interface that allows object's content to be exported. All domains classes
 * should include this interface.
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
            content = xmlParser.convertToString(node);
        } catch (TransformerException ex) {
            Logger.getLogger(Exportable.class.getName()).log(Level.SEVERE, null, ex);
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
