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
     * Valor da keyword.
     */
    private String m_value;

    /**
     * Construtor de objetos do tipo Kyword sem parâmetros.
     */
    public Keyword() {
        m_value = "";
    }

    /**
     * Construtor de objetos do tipo keyword com o parâmetro keyword.
     *
     * @param keyword - valor da keyword
     */
    public Keyword(String keyword) {
        this.m_value = keyword;
    }

    /**
     * Devolve o valor desta keyword
     * 
     * @return valor desta keyword
     */
    public String getValue() {
        return m_value;
    }

    /**
     * Modifica o valor desta keyword.
     *
     * @param keyword novo valor da keyword a atribuir
     */
    public void setValue(String keyword) {
        this.m_value = keyword;
    }

    /**
     * Compara a keyword a outro objecto passado por parametro. A comparação
     * entre duas keyword é feita com atenção a alguns todos os atributos
     * desta.
     *
     * @param o objecto a comparar com a keyword
     * @return true se o objeto recebido representar uma keyword equivalente
     * à keyword. Caso contrário, retorna false.
     */

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
    public Keyword importContentFromXMLNode(Node node) throws ParserConfigurationException {
        this.m_value = node.getTextContent();

        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node result = null;
        try {
            Document document = XMLParser.createDocument();

            Element elementKeyword = document.createElement(ROOT_ELEMENT_NAME);
            elementKeyword.setTextContent(m_value);
            document.appendChild(elementKeyword);

            result = elementKeyword;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Keyword.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
