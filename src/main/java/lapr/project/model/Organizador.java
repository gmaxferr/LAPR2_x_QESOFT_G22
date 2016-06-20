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

    public static final String ROOT_ELEMENT_NAME = "organizador";

    /**
     * Atributo utilizador de organizador
     */
    private Utilizador m_Utilizador;

    /**
     * Construtor com parametros
     *
     * @param u - utilizador que vai assumir o cargo de organizador
     */
    public Organizador(Utilizador u) {
        m_Utilizador = u;
    }

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
            Document document = XMLParser.createDocument(node, true);

            Node n = document.getChildNodes().item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                this.m_Utilizador = new Utilizador();
                this.m_Utilizador.importContentFromXMLNode(elem.getElementsByTagName(Utilizador.ROOT_ELEMENT_NAME).item(0));
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
            Document document = XMLParser.createDocument();

            Element elementBase = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elementBase);
            
            Utilizador savedUser = new Utilizador("", m_Utilizador.getUsername(), "".toCharArray(), m_Utilizador.getEmail(), "");
            savedUser.setShifts(0);

            elementBase.appendChild(savedUser.exportContentToXMLNode());

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Organizador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
