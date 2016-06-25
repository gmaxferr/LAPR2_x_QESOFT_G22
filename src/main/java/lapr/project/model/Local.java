package lapr.project.model;

import java.util.Objects;
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

    public static final String ROOT_ELEMENT_NAME = "local";

    /**
     * Morada do local
     */
    private String m_StrMorada;

    /**
     * Construtor de objetos do tipo local recebendo como parametro a morada deste
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
     * Define uma nova morada para o local
     *
     * @param nomeLocal nova morada
     */
    public void setMorada(String nomeLocal) {
        this.m_StrMorada = nomeLocal;
    }

    /**
     * Compara o local a outro objecto passado por parametro. A comparação
     * entre dois locais é feita com atenção a alguns todos os atributos
     * desta.
     *
     * @param obj objecto a comparar com o local
     * @return true se o objeto recebido representar um local equivalente
     * ao local. Caso contrário, retorna false.
     */

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Local) {
            Local o = (Local) obj;
            return this.m_StrMorada == null ? o.m_StrMorada == null : this.m_StrMorada.equals(o.m_StrMorada);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.m_StrMorada);
        return hash;
    }

    @Override
    public Local importContentFromXMLNode(Node node) throws ParserConfigurationException {
        Document document = XMLParser.createDocument(node, true);

        Node n = document.getChildNodes().item(0);
        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

            this.m_StrMorada = elem.getTextContent();
        }
        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;
        try {
            Document document = XMLParser.createDocument();

            Element elementBase = document.createElement(ROOT_ELEMENT_NAME);
            elementBase.setTextContent(m_StrMorada);
            document.appendChild(elementBase);

            node = elementBase;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Local.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }

}
