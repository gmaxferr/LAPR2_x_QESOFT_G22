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
 * Keyword com score.
 *
 * @author Ricardo Catalao
 */
public class ScoredKeyword implements Comparable<ScoredKeyword>, Serializable, Importable<ScoredKeyword>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "ScoredKeyword";
    public static final String VALUE_ELEMENT_NAME = "value";
    public static final String SCORE_ATTR_NAME = "score";
    public static final String FREQ_ATTR_NAME = "frequency";

    /**
     * Score da componente keyword.
     */
    private int m_score;

    /**
     * Frequência desta keyword.
     */
    private int m_frequency;

    /**
     * Valor desta keyword.
     */
    private String m_value;

    /**
     * Construtor da classe ScoredKeyword
     *
     * @param keyword keyword a atribuir
     * @param score score a atribuir
     */
    public ScoredKeyword(String keyword, int score) {
        this.m_value = keyword;
        this.m_score = score;
        this.m_frequency = 1;
    }

    /**
     * @return o score
     */
    public int getScore() {
        return m_score;
    }

    /**
     * @param score o score a atribuir
     */
    public void setScore(int score) {
        this.m_score = score;
    }

    /**
     * @return the frequency
     */
    public int getFrequency() {
        return m_frequency;
    }

    /**
     * @param frequency the frequency to set
     */
    public void setFrequency(int frequency) {
        this.m_frequency = frequency;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return m_value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.m_value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof ScoredKeyword) {
            if (o == this) {
                return true;
            }
            ScoredKeyword obj = (ScoredKeyword) o;
            return obj.m_score == m_score && obj.m_frequency == m_frequency && obj.m_value == m_value;
        }
        return false;
    }

    @Override
    public int compareTo(ScoredKeyword o) {
        if (this.m_score < o.m_score) {
            return -1;
        } else if (this.m_score == o.m_score) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public ScoredKeyword importContentFromXMLNode(Node node) {
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
                this.m_score = Integer.parseInt(elem.getAttribute(SCORE_ATTR_NAME));
                this.m_frequency = Integer.parseInt(elem.getAttribute(FREQ_ATTR_NAME));
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ScoredKeyword.class.getName()).log(Level.SEVERE, null, ex);
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
            elementValue.setTextContent(this.m_value);
            elementKeyword.appendChild(elementValue);

            elementKeyword.setAttribute(SCORE_ATTR_NAME, String.valueOf(this.m_score));
            elementKeyword.setAttribute(FREQ_ATTR_NAME, String.valueOf(this.m_frequency));

            document.appendChild(elementKeyword);

            node = elementKeyword;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ScoredKeyword.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
