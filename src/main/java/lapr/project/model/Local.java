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
    public static final String ROOT_ELEMENT_NAME = "local";

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
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Local) {
            Local o = (Local) obj;
            return this.m_StrMorada == null ? o.m_StrMorada == null : this.m_StrMorada.equals(o.m_StrMorada);
        }
        return false;
    }

    @Override
    public Local importContentFromXMLNode(Node node) {
        try {
            Document document = XMLParser.createDocument(node, true);

            Node n = document.getChildNodes().item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;

                this.m_StrMorada = elem.getTextContent();
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
