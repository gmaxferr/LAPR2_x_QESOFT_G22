package lapr.project.model;

import java.util.Objects;
import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um tipo de conflito
 * 
 * @author G29
 */
public class TipoConflito implements Importable<TipoConflito>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "TipoConflito";
    public static final String ID_ATTR_NAME = "ID";

    /**
     * ID do tipo de conflito
     */
    private String ID;

    /**
     * Mecanismo de deteção de conflitos.
     */
    private MecanismoDetecaoConflito m_mec;

    /**
     * Contrutor de objetos do tipo TipoConflito com o parametro ID
     * 
     * @param ID ID do tipo de conflito
     */
    public TipoConflito(String ID) {
        m_mec = new MecanismoDetecaoConflito(this);
        this.ID = ID;
    }

    /**
     * Define os dados para este tipo de conflito
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
    public MecanismoDetecaoConflito getMecanismoDetecaoConflito() {
        return m_mec;
    }

    /**
     * Compara o tipoConflito a outro objecto passado por parametro. A comparação
     * entre dois tipoConflito é feita com atenção a alguns todos os atributos
     * desta.
     *
     * @param obj objecto a comparar com o tipoConflito
     * @return true se o objeto recebido representar um tipoConflito equivalente
     * ao tipoConflito. Caso contrário, retorna false.
     */

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof TipoConflito){
            TipoConflito o = (TipoConflito) obj;
            return this.ID.equals(o.ID);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.ID);
        return hash;
    }

    @Override
    public TipoConflito importContentFromXMLNode(Node node) throws ParserConfigurationException {
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
            Logger.getLogger(TipoConflito.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }

    /**
     * Modifica o mecanismo de deteção de conflitos
     * 
     * @param m_mec novo mecanismo de deteção de conflitos
     */
    public void setMecanismo(MecanismoDetecaoConflito m_mec) {
        this.m_mec = m_mec;
    }
}
