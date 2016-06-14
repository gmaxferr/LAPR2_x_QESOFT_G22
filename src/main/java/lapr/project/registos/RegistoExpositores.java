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
 * Representação de um RegistoExpositores
 * 
 * @author Ricardo Osorio
 */
public class RegistoExpositores implements Importable<RegistoExpositores>, Exportable {
    
    public static final String ROOT_ELEMENT_NAME = "RegistoExpositores";

    /**
     * Lista de expositores
     */
    private List<Expositor> m_listaExpositores;

    /**
     * Construtor de objetos do tipo RegistoExpositores sem parâmetros
     */
    public RegistoExpositores() {
        this.m_listaExpositores = new ArrayList<>();
    }

    /**
     * Adiciona um utilizador/expositor à lista de expositores
     * 
     * @param utilizador utilizador/expositor a ser adicionado
     * @return true se for adicionado. Caso contrário retorna false.
     */
    public boolean addExpositor(Utilizador utilizador) {
        if (validaExpositor(utilizador)) {
            this.m_listaExpositores.add(new Expositor(utilizador));
            return true;
        }
        return false;
    }

    /**
     * Valida o expositor, verificando se já existe na lista de expositores
     * 
     * @param utilizador expositor a ser validado
     * @return true se o expositor não existir na lista de expositores. Caso
     * contrário retorna false
     */
    private boolean validaExpositor(Utilizador utilizador) {
        for (Expositor expositor : m_listaExpositores) {
            if (expositor.getEmail().equalsIgnoreCase(utilizador.getEmail())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Devolve a lista de expositores
     * 
     * @return lista de expositores
     */
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
                
                this.m_listaExpositores.clear();
                
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

    public void fix(RegistoUtilizadores m_registoUtilizadores) {
        for(Expositor repr : m_listaExpositores){
            for(Utilizador u : m_registoUtilizadores.getListaUtilizadores()){
                if(repr.getUsername().equals(u.getUsername())){
                    repr.setUtilizador(u);
                    break;
                }
            }
        }
    }
}
