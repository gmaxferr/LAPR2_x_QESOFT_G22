package lapr.project.model;

import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um local onde se realizara uma exposição
 *
 * @author G29
 */
public class Local implements Importable<Local>, Exportable {

    /**
     *
     */
    public static final String ROOT_ELEMENT_NAME = "Local";

    /**
     *
     */
    public static final String MORADA_ELEMENT_NAME = "Morada";

    /**
     * Morada do local
     */
    private String m_StrMorada;

    /**
     * Construtor de um local recebendo como parametro a morada deste
     *
     * @param morada morada do local
     */
    public Local(String morada) {
        this.m_StrMorada = morada;
    }

    /**
     * Devolve a morada do local
     *
     * @return morada do local
     */
    public String getMorada() {
        return m_StrMorada;
    }

    /**
     * Define uma nova morada para o loca
     *
     * @param nomeLocal nova morada
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
