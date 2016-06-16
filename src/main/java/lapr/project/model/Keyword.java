package lapr.project.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

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
    public static final String ROOT_ELEMENT_NAME = "keyword";

    /**
     * Nome do campo value.
     */
    public static final String VALUE_ELEMENT_NAME = "value";

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
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.m_value);
        return hash;
    }

    @Override
    public Keyword importContentFromXMLNode(Node node) {
        try {
            Document document = XMLParser.createDocument(node, true);

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
            Document document = XMLParser.createDocument();

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
