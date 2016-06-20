package lapr.project.model;

import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de uma Decisão
 *
 * @author Ana Leite Ricardo Osório
 */
public class Decisao implements Importable<Decisao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "aceite";

    private boolean m_decisao;

    /**
     * Construtor
     *
     */
    public Decisao() {
        this.m_decisao = false;
    }

    /**
     * Construtor. Recebe por parametro a decisão tomada pelo Gestor
     *
     * @param decisao decisao tomada pelo gestor
     */
    public Decisao(boolean decisao) {
        this.m_decisao = decisao;
    }

    /**
     * Define uma nova decisão (true ou false) para esta Decisão recebendo-a por
     * parametro
     *
     * @param decisao nova decisão tomada pelo gestor
     */
    public void setDecisao(boolean decisao) {
        this.m_decisao = decisao;
    }

    /**
     * Devolve a decisão tomada pelo Gestor
     *
     * @return decisão tomada pelo gestor
     */
    public boolean getDecisao() {
        return this.m_decisao;
    }

    @Override
    public Decisao importContentFromXMLNode(Node node) {
        try {
            Document document = XMLParser.createDocument(node, true);

            NodeList elementsKeyword = document.getChildNodes();

            Node n = elementsKeyword.item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                this.m_decisao = Boolean.valueOf(elem.getTextContent());
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Decisao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            Document document = XMLParser.createDocument(node, true);

            Element elementKeyword = document.createElement(ROOT_ELEMENT_NAME);

            elementKeyword.setTextContent(String.valueOf(m_decisao));

            node = elementKeyword;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Decisao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
