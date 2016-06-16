package lapr.project.model;

import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 *
 * @author Ricardo Catalão
 */
public class TipoConflito implements Importable<TipoConflito>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "TipoConflito";
    public static final String ID_ATTR_NAME = "ID";

    private String ID;

    /**
     * Mecanismo de deteção de conflitos.
     */
    private MecanismoDetecaoConflito m_mec;

    /**
     * Contrutor por definição.
     */
    public TipoConflito(String ID) {
        m_mec = new MecanismoDetecaoConflito(this);
        this.ID = ID;
    }

    /**
     * Define os dados para este tipo de conflitos.
     */
    public void setDadosTipoConflito(String tipoConflito) {
        this.ID = tipoConflito;
    }

    /**
     * @return Retorna o mecanismo de detação deste tipos de conflito
     */
    public MecanismoDetecaoConflito getMecanismoDetecaoConflito() {
        return m_mec;
    }

    @Override
    public TipoConflito importContentFromXMLNode(Node node) {
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
                this.ID = elem.getAttribute(ID_ATTR_NAME);
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

            Element elementBase = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elementBase);

            elementBase.setAttribute(ID_ATTR_NAME, this.ID);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Keyword.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
