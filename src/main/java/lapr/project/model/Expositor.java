package lapr.project.model;

import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um Expositor
 *
 * @author G29
 */
public class Expositor implements Importable<Expositor>, Exportable {

    /**
     *
     */
    public static final String ROOT_ELEMENT_NAME = "Expositor";

    /**
     *
     */
    public static final String USERNAME_ELEMENT_NAME = "Username";

    /**
     *
     */
    public static final String EMAIL_ELEMENT_NAME = "Email";

    /**
     * Utilizador por detrás do papel de expositor
     */
    private Utilizador m_utilizador;

    /**
     * Construtor de objectos do tipo Expositor sem parametros
     *
     * @param utilizador Utilizador que faz este papel
     */
    public Expositor(Utilizador utilizador) {
        this.m_utilizador = utilizador;
    }

    /**
     * Devolve o email do expositor
     *
     * @return email do expositor
     */
    public String getEmail() {
        return this.getUtilizador().getEmail();
    }

    /**
     * Devolve o username do expositor
     *
     * @return username do expositor
     */
    public String getUsername() {
        return this.getUtilizador().getUsername();
    }

    /**
     * Devolve o Utilizador por detrás do papel de expositor
     *
     * @return utilizador por detrás do papel de expositor
     */
    public Utilizador getUtilizador() {
        return m_utilizador;
    }

    /**
     * Define um novo Utilizador para substituir o antigo
     *
     * @param m_utilizador novo utilizador
     */
    public void setUtilizador(Utilizador m_utilizador) {
        this.m_utilizador = m_utilizador;
    }

    @Override
    public Expositor importContentFromXMLNode(Node node) {
        try {
            Document document = XMLParser.createDocument(node, true);

            Node n = document.getChildNodes().item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                this.setUtilizador(new Utilizador());
                this.getUtilizador().setUsername(elem.getElementsByTagName(USERNAME_ELEMENT_NAME).item(0).getTextContent());
                this.getUtilizador().setEmail(elem.getElementsByTagName(EMAIL_ELEMENT_NAME).item(0).getTextContent());
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Expositor.class.getName()).log(Level.SEVERE, null, ex);
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

            Element elem = document.createElement(USERNAME_ELEMENT_NAME);
            elem.setTextContent(this.m_utilizador.getUsername());
            elementBase.appendChild(elem);

            elem = document.createElement(EMAIL_ELEMENT_NAME);
            elem.setTextContent(this.m_utilizador.getEmail());
            elementBase.appendChild(elem);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Expositor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
