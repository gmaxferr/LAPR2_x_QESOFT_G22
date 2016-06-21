package lapr.project.model;

import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um FAE
 *
 * @author G29
 */
public class FAE implements ApresentavelNaJTable, Importable<FAE>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "fae";

    /**
     * Atributo do FAE que representa o utilizador associado a este
     */
    private Utilizador m_Utilizador;

    /**
     * Construtor de objectos do tipo FAE com parametro Utilizador
     *
     * @param u Utilizador associado ao FAE
     */
    public FAE(Utilizador u) {
        this.m_Utilizador = u;
    }

    /**
     * Construtor de objectos do tipo FAE sem parametros
     */
    public FAE() {

    }

    /**
     * Devolve o Utilizador atualmente associado ao FAE
     *
     * @return Utilizador associado ao FAE
     */
    public Utilizador getUtilizador() {
        return m_Utilizador;
    }

    public String getUsernameFae() {
        return this.m_Utilizador.getUsername();
    }

    /**
     * Define um novo utilizador associado ao FAE
     *
     * @param u novo Utilizador
     */
    public void setUtilizador(Utilizador u) {
        this.m_Utilizador = u;
    }

    /**
     * Devolve uma string com a descrição do objecto FAE, isto é, com os seus
     * atributos
     *
     * @return descrição do FAE
     */
    @Override
    public String toString() {
        String str = "FAE:\n";
        str += "\tUser: " + this.m_Utilizador.getNome() + "\n";

        return str;
    }

    @Override
    public FAE importContentFromXMLNode(Node node) {
        try {
            Document document = XMLParser.createDocument(node, true);

            NodeList nList = document.getChildNodes();

            Node n = nList.item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;

                this.m_Utilizador = new Utilizador();
                this.m_Utilizador.importContentFromXMLNode(elem.getElementsByTagName(Utilizador.ROOT_ELEMENT_NAME).item(0));
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FAE.class.getName()).log(Level.SEVERE, null, ex);
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

            Utilizador savedUser = new Utilizador("", m_Utilizador.getUsername(), "".toCharArray(), m_Utilizador.getEmail(), "");
            savedUser.setShifts(0);
            elementBase.appendChild(document.importNode(savedUser.exportContentToXMLNode(), true));
            
            node = elementBase;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FAE.class.getName()).log(Level.SEVERE, null, ex);
        }

        return node;
    }
}
