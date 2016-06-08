package lapr.project.model;

import java.io.Serializable;
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
import org.w3c.dom.NodeList;

/**
 * Keyword.
 *
 * @author Ricardo Catalao
 */
public class Keyword implements Serializable, Importable<Keyword>, Exportable {

    /**
     * Nome da tag keyword.<!-- -->Serve para identificar quais blocos de dados
     * pertencem a uma keyword e quais não.
     */
    private static final String ROOT_ELEMENT_NAME = "keyword";

    /**
     * Nome do campo value.
     */
    private static final String VALUE_ELEMENT_NAME = "value";

    /**
     * Valor da keyword.
     */
    private String m_value;

    /**
     * Construtor por defeito.
     */
    public Keyword() {
        m_value = "";
    }

    /**
     * Construtor com parâmetros.
     *
     * @param keyword - valor da keyword
     */
    public Keyword(String keyword) {
        this.m_value = keyword;
    }

    /**
     * @return Devolve o valor desta keyword
     */
    public String getValue() {
        return m_value;
    }

    /**
     * Modifica o valor desta keyword.
     *
     * @param keyword keyword a atribuir
     */
    public void setValue(String keyword) {
        this.m_value = keyword;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Keyword) {
            if (o == this) {
                return true;
            } else {
                Keyword obj = (Keyword) o;
                return obj.m_value.equals(this.m_value);
            }
        }
        return false;
    }

    @Override
    public Keyword importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            document.appendChild(document.importNode(node, true));

            NodeList elementsKeyword = document.getChildNodes();

            Node n = elementsKeyword.item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                this.m_value = elem.getElementsByTagName(VALUE_ELEMENT_NAME).item(0).getTextContent();
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Keyword.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element elementKeyword = document.createElement(ROOT_ELEMENT_NAME);
            Element elementValue = document.createElement(VALUE_ELEMENT_NAME);

            elementValue.setTextContent(getValue());
            elementKeyword.appendChild(elementValue);

            document.appendChild(elementKeyword);

            node = elementKeyword;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Keyword.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
