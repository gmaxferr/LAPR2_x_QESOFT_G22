package lapr.project.model;

import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um Organizador
 *
 * @author G29
 */
public class Organizador implements Importable<Organizador>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "Organizador";
    public static final String USERNAME_ELEMENT_NAME = "Username";
    public static final String EMAIL_ELEMENT_NAME = "Email";
    
    /**
     * Atributo utilizador de organizador
     */
    private Utilizador m_Utilizador;

    /**
     * Construtor de organizador sem parametros
     */
    public Organizador() {
    }

    /**
     * Devolve o utilizador de organizador
     *
     * @return utilizador de organizador
     */
    public Utilizador getUtilizador() {
        return m_Utilizador;
    }

    /**
     * Define novo utilizador de organizador
     *
     * @param u novo utilizador
     */
    public void setUtilizador(Utilizador u) {
        this.m_Utilizador = u;
    }

    public String getUsernameOrganizador() {
        return this.m_Utilizador.getUsername();
    }

    /**
     * Devolve uma descrição textual do objeto Organizador, isto é, com os seus
     * atributos
     *
     * @return descrição textual do objeto Organizador
     */
    @Override
    public String toString() {
        String str = "Organizador:\n";
        str += "\tUser: " + this.m_Utilizador.getNome() + "\n";

        return str;
    }
    
    @Override
    public Organizador importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                this.m_Utilizador = new Utilizador();
                this.m_Utilizador.setUsername(elem.getElementsByTagName(USERNAME_ELEMENT_NAME).item(0).getTextContent());
                this.m_Utilizador.setEmail(elem.getElementsByTagName(EMAIL_ELEMENT_NAME).item(0).getTextContent());
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Organizador.class.getName()).log(Level.SEVERE, null, ex);
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
            
            Element elem = document.createElement(USERNAME_ELEMENT_NAME);
            elem.setTextContent(this.m_Utilizador.getUsername());
            elementBase.appendChild(elem);

            elem = document.createElement(EMAIL_ELEMENT_NAME);
            elem.setTextContent(this.m_Utilizador.getEmail());
            elementBase.appendChild(elem);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Organizador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
