package lapr.project.registos;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import lapr.project.model.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um registo de organizadores
 * 
 * @author G29
 */
public class RegistoOrganizadores implements Importable<RegistoOrganizadores>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "registoOrganizadores";

    /**
     * Lista de organizadores
     */
    private final List<Organizador> m_listaOrganizadores;

    /**
     * Construtor de objetos do tipo RegistoOrganizadores sem parâmetros
     */
    public RegistoOrganizadores() {
        this.m_listaOrganizadores = new ArrayList<>();
    }
    
    /**
     * Valida a exposição
     *
     * @param o organizador de exposição
     * @return true
     */
    private boolean validaOrganizador(Organizador o) {
        System.out.println("Exposição: validaOrganizador: " + o.toString());
        return true;
    }

    /**
     * Adiciona o organizador à exposição
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
     * Adiciona um organizador à exposição
     *
     * @param o organizador a ser adicionado
     */
    public void addOrganizador(Organizador o) {
        m_listaOrganizadores.add(o);
    }

    /**
     * Devolve a lista de organizadores
     * 
     * @return lista de organizadores
     */
    public List<Organizador> getListaOrganizadores() {
        return this.m_listaOrganizadores;
    }

    public void fix(RegistoUtilizadores m_registoUtilizadores) {
        for (Organizador o : m_listaOrganizadores) {
            for (Utilizador u : m_registoUtilizadores.getListaUtilizadores()) {
                if (o.getUtilizador().getUsername().equals(u.getUsername())) {
                    o.setUtilizador(u);
                    break;
                }
            }
        }
    }

    /**
     * Conserta o valor das referências das variáveis guardados pelos objetos
     * que este objeto agrega.
     * 
     * @param m_ro registo organizadores
     */
    public void fix(RegistoOrganizadores m_ro) {
        List<Organizador> toBeAdded = new ArrayList<>();
        for (Organizador o : m_listaOrganizadores) {
            for (Organizador o2 : m_ro.m_listaOrganizadores) {
                if (o.getUtilizador().getUsername().equals(o2.getUtilizador().getUsername())) {
                    toBeAdded.add(o2);
                    break;
                }
            }
        }
        m_listaOrganizadores.clear();
        m_listaOrganizadores.addAll(toBeAdded);
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
