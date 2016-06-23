package lapr.project.model;

import java.util.Objects;
import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um recurso
 * 
 * @author G29
 */
public class Recurso implements Importable<Recurso>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "Recurso";

    /**
     * Nome do recurso
     */
    private String m_nomeRecurso;

    /**
     * Construtor de objetos do tipo Recurso com o parametro nome do recurso
     * 
     * @param nomeRecurso nome do recurso
     */
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

    /**
     * Compara o recurso a outro objecto passado por parametro. A comparação
     * entre dois recursos é feita com atenção a alguns todos os atributos
     * desta.
     *
     * @param obj objecto a comparar com o produto
     * @return true se o objeto recebido representar um produto equivalente
     * ao produto. Caso contrário, retorna false.
     */

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
