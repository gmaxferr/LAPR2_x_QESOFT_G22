package lapr.project.registos;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.Organizador;
import lapr.project.model.Utilizador;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class RegistoOrganizadores implements Importable<RegistoOrganizadores>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "RegistoOrganizadores";
    
    private ArrayList<Organizador> m_listaOrganizadores;
    
    /**
     * Método que valida a exposição
     * @param o organozador de exposição
     * @return 
     */
    private boolean validaOrganizador(Organizador o) {
        System.out.println("Exposição: validaOrganizador: " + o.toString());
        return true;
    }

    /**
     * Método que adiciona o organizador à exposição
     * 
     * @param ut utilizador/organizador da exposição 
     */
    public void addOrganizador(Utilizador ut) {
        Organizador o = new Organizador();
        o.setUtilizador(ut);
        if (validaOrganizador(o)) {
            addOrganizador(o);
        }
    }
    
    /**
     * Método que adiciona um organizador à exposição
     * 
     * @param o organizador a ser adicionado
     */
    private void addOrganizador(Organizador o) {
        m_listaOrganizadores.add(o);
    }

    public ArrayList<Organizador> getListaOrganizadores() {
        return this.m_listaOrganizadores;
    }

    @Override
    public RegistoOrganizadores importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);
            
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                
                this.m_listaOrganizadores.clear();
                
                NodeList nList = elem.getElementsByTagName(Organizador.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    Organizador org = new Organizador();
                    org.importContentFromXMLNode(n2);
                    m_listaOrganizadores.add(org);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoOrganizadores.class.getName()).log(Level.SEVERE, null, ex);
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

            for (Organizador org : m_listaOrganizadores) {
                Node n = org.exportContentToXMLNode();
                elementBase.appendChild(document.importNode(n, true));
            }

            document.appendChild(elementBase);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoOrganizadores.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
