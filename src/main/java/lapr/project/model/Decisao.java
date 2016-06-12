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

    public static final String ROOT_ELEMENT_NAME = "Decisao";
    public static final String DECISAO_ATTR_NAME = "decisao";

    private boolean m_decisao;

    /**
     * Construtor
     *
     */
    public Decisao() {
        this.m_decisao = false;
    }

    /**
     * Construtor
     *
     * @param decisao
     */
    public Decisao(boolean decisao) {
        this.m_decisao = decisao;
    }

    public void setM_bDecisao(boolean decisao) {
        this.m_decisao = decisao;
    }

    public boolean getM_bDecisao() {
        return this.m_decisao;
    }

    @Override
    public Decisao importContentFromXMLNode(Node node) {
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
                this.m_decisao = Boolean.valueOf(elem.getAttribute(DECISAO_ATTR_NAME));
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
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element elementKeyword = document.createElement(ROOT_ELEMENT_NAME);
            
            elementKeyword.setAttribute(DECISAO_ATTR_NAME, String.valueOf(m_decisao));

            document.appendChild(elementKeyword);

            node = elementKeyword;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Decisao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
