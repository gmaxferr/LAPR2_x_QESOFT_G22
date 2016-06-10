package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.Expositor;
import lapr.project.model.Utilizador;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Ricardo Osorio
 */
public class RegistoExpositores implements Importable<RegistoExpositores>, Exportable {
    
    public static final String ROOT_ELEMENT_NAME = "RegistoExpositores";

    private List<Expositor> m_listaExpositores;

    public RegistoExpositores() {
        this.m_listaExpositores = new ArrayList<>();
    }

    public boolean addExpositor(Utilizador utilizador) {
        if (validaExpositor(utilizador)) {
            this.m_listaExpositores.add(new Expositor(utilizador));
            return true;
        }
        return false;
    }

    private boolean validaExpositor(Utilizador utilizador) {
        for (Expositor expositor : m_listaExpositores) {
            if (expositor.getM_strEmail().equalsIgnoreCase(utilizador.getEmail())) {
                return false;
            }
        }
        return true;
    }

    public List<Expositor> getListaExpositores() {
        return this.m_listaExpositores;
    }

    @Override
    public RegistoExpositores importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);
            
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                
                NodeList nList = elem.getElementsByTagName(Expositor.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    Expositor expositor = new Expositor(null);
                    expositor.importContentFromXMLNode(n2);
                    m_listaExpositores.add(expositor);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoExpositores.class.getName()).log(Level.SEVERE, null, ex);
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

            for (Expositor expositor : m_listaExpositores) {
                Node n = expositor.exportContentToXMLNode();
                elementBase.appendChild(document.importNode(n, true));
            }

            document.appendChild(elementBase);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoExpositores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
