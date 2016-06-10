package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Representação de objectos do tipo Local
 *
 * @author Ricardo Osório Ana Leite
 */
public class Local implements Importable<Local>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "Local";
    
    public static final String MORADA_ELEMENT_NAME = "Morada";
    
    private String m_StrMorada;

    public Local(String nomeLocal) {
        this.m_StrMorada = nomeLocal;
    }

    /**
     *
     * @return
     */
    public String getMorada() {
        return m_StrMorada;
    }

    /**
     *
     * @param nomeLocal
     */
    public void setMorada(String nomeLocal) {
        this.m_StrMorada = nomeLocal;
    }

    @Override
    public Local importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                
                this.m_StrMorada = elem.getElementsByTagName(MORADA_ELEMENT_NAME).item(0).getTextContent();
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Local.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            
            Element elementBase = doc.createElement(ROOT_ELEMENT_NAME);
            doc.appendChild(elementBase);
            
            Element elemChild = doc.createElement(MORADA_ELEMENT_NAME);
            elemChild.setTextContent(this.m_StrMorada);
            elementBase.appendChild(elemChild);
            
            node = elementBase;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Local.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }

}
