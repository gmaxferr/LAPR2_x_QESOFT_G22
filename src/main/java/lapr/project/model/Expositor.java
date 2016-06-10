package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Representação de um Expositor
 *
 * @author Ricardo Osório Ana Leite
 */
public class Expositor implements Importable<Expositor>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "Expositor";
    public static final String USERNAME_ELEMENT_NAME = "Username";
    public static final String EMAIL_ELEMENT_NAME = "Email";

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
     * @return Devolve o username do expositor
     */
    public String getUsername() {
        return this.getUtilizador().getUsername();
    }

    /**
     * @return the m_utilizador
     */
    public Utilizador getUtilizador() {
        return m_utilizador;
    }

    /**
     * @param m_utilizador the m_utilizador to set
     */
    public void setUtilizador(Utilizador m_utilizador) {
        this.m_utilizador = m_utilizador;
    }
    
    @Override
    public Expositor importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();

            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                this.setUtilizador(new Utilizador());
                this.getUtilizador().setUsername(elem.getElementsByTagName(USERNAME_ELEMENT_NAME).item(0).getTextContent());
                this.getUtilizador().setEmail(elem.getElementsByTagName(EMAIL_ELEMENT_NAME).item(0).getTextContent());
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Expositor.class.getName()).log(Level.SEVERE, null, ex);
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
            elem.setTextContent(this.getUtilizador().getUsername());
            elementBase.appendChild(elem);

            elem = document.createElement(EMAIL_ELEMENT_NAME);
            elem.setTextContent(this.getUtilizador().getEmail());
            elementBase.appendChild(elem);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Expositor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
