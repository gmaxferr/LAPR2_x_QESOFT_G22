package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 *
 * @author G29
 */
public class TipoConflitoDemonstracao implements Importable<TipoConflitoDemonstracao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "TipoConflitoDemonstracao";
    public static final String ID_ATTR_NAME = "ID";

    private String ID;

    /**
     * Mecanismo de deteção de conflitos.
     */
    private MecanismoDetecaoConflitoDemonstracao m_mec;

    /**
     * Contrutor por definição.
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
     * @param tipoConflito
     */
    public void setDadosTipoConflito(String tipoConflito) {
        this.ID = tipoConflito;
    }

    /**
     * @return Retorna o mecanismo de detação deste tipos de conflito
     */
    public MecanismoDetecaoConflitoDemonstracao getMecanismoDetecaoConflito() {
        return m_mec;
    }

    /**
     * @param m_mec the m_mec to set
     */
    public void setMecanismo(MecanismoDetecaoConflitoDemonstracao m_mec) {
        this.m_mec = m_mec;
    }

    @Override
    public TipoConflitoDemonstracao importContentFromXMLNode(Node node) {
        try {
            Document document = XMLParser.createDocument(node, true);

            NodeList elementsKeyword = document.getChildNodes();

            Node n = elementsKeyword.item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                this.ID = elem.getAttribute(ID_ATTR_NAME);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(TipoConflitoDemonstracao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
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
