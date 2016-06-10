package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.TipoConflito;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Ana Leite
 */
public class RegistoTipoConflitos implements Importable<RegistoTipoConflitos>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "RegistoTipoConflitos";
    public static final String NUM_CONFLITOS_ATTR_NAME = "numConflitos";
    
    private int numConflitos = 0;
    private static final String m_prefix = "TC-";
    private List<TipoConflito> m_listaTipoConflitos;

    public RegistoTipoConflitos() {
        numConflitos = 0;
        this.m_listaTipoConflitos = new ArrayList<>();
    }

    public List<TipoConflito> getListaTipoConflitos() {
        return this.m_listaTipoConflitos;
    }

    public TipoConflito novoTipoConflito() {
        return new TipoConflito(m_prefix + numConflitos++);
    }

    public boolean validaTipoDeConflito(TipoConflito tipoConflito) {
        return !m_listaTipoConflitos.contains(tipoConflito);
    }

    public boolean add(TipoConflito tipoConflito) {
        boolean b = validaTipoDeConflito(tipoConflito);
        if (b) {
            m_listaTipoConflitos.add(tipoConflito);
        }
        return b;
    }

    @Override
    public RegistoTipoConflitos importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);
            
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                
                this.m_listaTipoConflitos.clear();
                
                NodeList nList = elem.getElementsByTagName(TipoConflito.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    TipoConflito tc = new TipoConflito("");
                    tc.importContentFromXMLNode(n2);
                    this.m_listaTipoConflitos.add(tc);
                }
                
                this.numConflitos = Integer.parseInt(elem.getAttribute(NUM_CONFLITOS_ATTR_NAME));
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoTipoConflitos.class.getName()).log(Level.SEVERE, null, ex);
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

            for (TipoConflito tc : this.m_listaTipoConflitos) {
                Node n = tc.exportContentToXMLNode();
                elementBase.appendChild(document.importNode(n, true));
            }
            
            elementBase.setAttribute(NUM_CONFLITOS_ATTR_NAME, String.valueOf(numConflitos));

            document.appendChild(elementBase);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoTipoConflitos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
