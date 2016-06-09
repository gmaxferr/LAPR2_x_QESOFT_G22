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
    public static final String USER_ELEMENT_NAME = "Utilizador";

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
     * Devolve o username do expositor
     *
     * @return username do expositor
     */
    public String getM_strEmail() {
        return this.m_utilizador.getEmail();
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
                this.m_utilizador = new Utilizador();
                this.m_utilizador.importContentFromXMLNode((Node) elem.getElementsByTagName(Utilizador.ROOT_ELEMENT_NAME));
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

            Element elementKeyword = document.createElement(ROOT_ELEMENT_NAME);

            Node n = this.m_utilizador.exportContentToXMLNode();
            elementKeyword.appendChild(document.importNode(n, true));

            document.appendChild(elementKeyword);

            node = elementKeyword;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Expositor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
