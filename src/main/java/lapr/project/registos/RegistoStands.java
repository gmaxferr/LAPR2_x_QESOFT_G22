package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.Stand;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Ricardo Catalao
 */
public class RegistoStands implements Importable<RegistoStands>, Exportable {
    
    public static final String ROOT_ELEMENT_NAME = "RegistoStands";

    private final List<Stand> m_listaStands;

    public RegistoStands() {
        this.m_listaStands = new ArrayList<>();
    }

    /**
     * @return lista de stands
     */
    public List<Stand> getListaStands() {
        return m_listaStands;
    }

    /**
     * @param stand O Stand a adicionar à lista
     */
    public void addStand(Stand stand) {
        this.m_listaStands.add(stand);
    }

    public boolean criarStand(String ID, int area) {
        Stand novoStand = new Stand(ID, area);
        if (validarStand(novoStand)) {
            this.m_listaStands.add(novoStand);
            return true;
        }
        return false;
    }

    private boolean validarStand(Stand novoStand) {
        for (Stand stand : m_listaStands) {
            if (novoStand.equals(stand)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public RegistoStands importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);

            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;

                this.m_listaStands.clear();

                NodeList nList = elem.getElementsByTagName(Stand.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    Stand stand = new Stand("", 0);
                    stand.importContentFromXMLNode(n2);
                    this.m_listaStands.add(stand);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoStands.class.getName()).log(Level.SEVERE, null, ex);
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

            for (Stand stand : this.m_listaStands) {
                Node n = stand.exportContentToXMLNode();
                elementBase.appendChild(document.importNode(n, true));
            }

            document.appendChild(elementBase);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoStands.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
