package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um TipoConflitoDemonstracao
 * 
 * @author G29
 */
public class TipoConflitoDemonstracao implements Importable<TipoConflitoDemonstracao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "TipoConflitoDemonstracao";
    public static final String ID_ATTR_NAME = "ID";

    /**
     * ID do tipo de conflito da demonstraação
     */
    private String ID;

    /**
     * Mecanismo de deteção de conflitos da demonstração
     */
    private MecanismoDetecaoConflitoDemonstracao m_mec;

    /**
     * Contrutor de objetos do tipo TipoConflitoDemonstracao com o parametro
     * ID
     *
     * @param ID ID deste novo tipo de conflito
     */
    public TipoConflitoDemonstracao(String ID) {
        m_mec = new MecanismoDetecaoConflitoDemonstracao(this);
        this.ID = ID;
    }

    /**
     * Define os dados para este tipo de conflitos.
     *
     * @param tipoConflito ID do tipo de conflito
     */
    public void setDadosTipoConflito(String tipoConflito) {
        this.ID = tipoConflito;
    }

    /**
     * Retorna o mecanismo de detação deste tipos de conflito
     * 
     * @return mecanismo de detação deste tipos de conflito
     */
    public MecanismoDetecaoConflitoDemonstracao getMecanismoDetecaoConflito() {
        return m_mec;
    }

    /**
     * Modifica o mecanismo deteção de conflitos da demonstração
     * 
     * @param m_mec novo mecanismo deteção de conflitos da demonstração
     */
    public void setMecanismo(MecanismoDetecaoConflitoDemonstracao m_mec) {
        this.m_mec = m_mec;
    }

    @Override
    public TipoConflitoDemonstracao importContentFromXMLNode(Node node) throws ParserConfigurationException {
        Document document = XMLParser.createDocument(node, true);

        NodeList elementsKeyword = document.getChildNodes();

        Node n = elementsKeyword.item(0);
        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;
            this.ID = elem.getAttribute(ID_ATTR_NAME);
        }
        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            Document document = XMLParser.createDocument();

            Element elementBase = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elementBase);

            elementBase.setAttribute(ID_ATTR_NAME, this.ID);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TipoConflitoDemonstracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
