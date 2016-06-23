package lapr.project.model;

import java.util.Objects;
import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 *
 * @author G29
 */
public class Recurso implements Importable<Recurso>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "Recurso";

    private String m_nomeRecurso;

    public Recurso(String nomeRecurso) {
        this.m_nomeRecurso = nomeRecurso;
    }

    /**
     * Devolve o nome do recurso
     *
     * @return nome do recurso
     */
    public String getNomeRecurso() {
        return m_nomeRecurso;
    }

    /**
     * Modifica o nome do recurso
     *
     * @param nomeRecurso novo nome do recurso
     */
    public void setNomeRecurso(String nomeRecurso) {
        this.m_nomeRecurso = nomeRecurso;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof Recurso) {
                Recurso o = (Recurso) obj;
                return this.m_nomeRecurso.equals(o.m_nomeRecurso);
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.m_nomeRecurso);
        return hash;
    }

    @Override
    public Recurso importContentFromXMLNode(Node node) throws ParserConfigurationException {
        this.m_nomeRecurso = node.getTextContent();
        
        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            Document document = XMLParser.createDocument();

            Element elementRecurso = document.createElement(ROOT_ELEMENT_NAME);
            elementRecurso.setTextContent(this.m_nomeRecurso);
            document.appendChild(elementRecurso);

            node = elementRecurso;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Recurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
