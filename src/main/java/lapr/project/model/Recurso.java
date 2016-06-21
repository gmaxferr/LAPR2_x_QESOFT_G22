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
    public static final String NOME_ELEMENT_NAME = "Nome";

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
        Document document = XMLParser.createDocument(node, true);

        NodeList elementsKeyword = document.getChildNodes();

        Node n = elementsKeyword.item(0);
        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;
            this.m_nomeRecurso = elem.getElementsByTagName(NOME_ELEMENT_NAME).item(0).getTextContent();
        }
        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            Document document = XMLParser.createDocument();

            Element elementRecurso = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elementRecurso);

            Element elementNome = document.createElement(NOME_ELEMENT_NAME);
            elementNome.setTextContent(this.m_nomeRecurso);
            elementRecurso.appendChild(elementNome);

            node = elementRecurso;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Recurso.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
