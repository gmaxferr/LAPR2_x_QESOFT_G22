package lapr.project.model;

import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um FAE
 *
 * @author Ricardo Osório Ana Leite
 */
public class FAE implements ApresentavelNaJTable, Importable<FAE>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "FAE";
    public static final String USERNAME_ELEMENT_NAME = "Username";
    public static final String EMAIL_ELEMENT_NAME = "Email";

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
        //copiar todos os dados das variaveis de instância
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
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            doc.appendChild(doc.importNode(node, true));

            NodeList nList = doc.getChildNodes();
            
            Node n = nList.item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                
                this.m_Utilizador = new Utilizador();
                this.m_Utilizador.setUsername(elem.getElementsByTagName(USERNAME_ELEMENT_NAME).item(0).getTextContent());
                this.m_Utilizador.setEmail(elem.getElementsByTagName(EMAIL_ELEMENT_NAME).item(0).getTextContent());
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FAE.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            Element elementBase = doc.createElement(ROOT_ELEMENT_NAME);
            doc.appendChild(elementBase);

            Element elemChild = doc.createElement(USERNAME_ELEMENT_NAME);
            elemChild.setTextContent(this.m_Utilizador.getUsername());
            elementBase.appendChild(elemChild);

            elemChild = doc.createElement(EMAIL_ELEMENT_NAME);
            elemChild.setTextContent(this.m_Utilizador.getEmail());
            elementBase.appendChild(elemChild);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(FAE.class.getName()).log(Level.SEVERE, null, ex);
        }

        return node;
    }
}
