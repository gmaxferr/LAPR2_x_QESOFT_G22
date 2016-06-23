package lapr.project.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Keyword com score.
 *
 * @author G29
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
     * Construtor da objetos do tipo ScoredKeyword com os parametros keyword e
     * score
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
     * Devolve o score
     * 
     * @return score
     */
    public int getScore() {
        return m_score;
    }

    /**
     * Modifica o score
     * 
     * @param score novo score a atribuir
     */
    public void setScore(int score) {
        this.m_score = score;
    }

    /**
     * Devolve a frequencia
     * 
     * @return frequencia
     */
    public int getFrequency() {
        return m_frequency;
    }

    /**
     * Modifica a frequencia
     * 
     * @param frequency nova frequencia
     */
    public void setFrequency(int frequency) {
        this.m_frequency = frequency;
    }

    /**
     * Devolve o valor
     * @return valor
     */
    public String getValue() {
        return m_value;
    }

    /**
     * Modifica o valor
     * 
     * @param value novo valor
     */
    public void setValue(String value) {
        this.m_value = value;
    }

    /**
     * Compara o scoredKeyword a outro objecto passado por parametro. A comparação
     * entre dois scoredKeyword é feita com atenção a alguns todos os atributos
     * desta.
     *
     * @param o objecto a comparar com o scoredKeyword
     * @return true se o objeto recebido representar um scoredKeyword equivalente
     * ao scoredKeyword. Caso contrário, retorna false.
     */

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
            return obj.m_score == m_score && obj.m_frequency == m_frequency && obj.m_value.equals(m_value);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.m_score;
        hash = 97 * hash + this.m_frequency;
        hash = 97 * hash + Objects.hashCode(this.m_value);
        return hash;
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
    public ScoredKeyword importContentFromXMLNode(Node node) throws ParserConfigurationException {
        Document document = XMLParser.createDocument(node, true);

        NodeList elementsKeyword = document.getChildNodes();

        Node n = elementsKeyword.item(0);

        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;
            this.m_value = elem.getElementsByTagName(VALUE_ELEMENT_NAME).item(0).getTextContent();
            this.m_score = Integer.parseInt(elem.getAttribute(SCORE_ATTR_NAME));
            this.m_frequency = Integer.parseInt(elem.getAttribute(FREQ_ATTR_NAME));
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
