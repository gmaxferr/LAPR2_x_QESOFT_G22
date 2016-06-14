package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.AtribuicaoStand;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Representação de um RegistoAtribuicoesStands
 * 
 * @author Ricardo Catalao
 */
public class RegistoAtribuicoesStands implements Importable<RegistoAtribuicoesStands>, Exportable {
    
    public static final String ROOT_ELEMENT_NAME = "RegistoAtribuicoesStands";

    /**
     * Lista de atribuições stand
     */
    private List<AtribuicaoStand> m_listaAtribuicoesStand;

    /**
     * Construtor de objetos do tipo RegistoAtribuicoesStands sem parâmetros
     */
    public RegistoAtribuicoesStands() {
        this.m_listaAtribuicoesStand = new ArrayList<>();
    }

    /**
     * Devolve a lista de atribuições stand
     * 
     * @return listaAtribuicoesStand
     */
    public List<AtribuicaoStand> getListaAtribuicoesStand() {
        return m_listaAtribuicoesStand;
    }

    /**
     * Modidica a lista de atribuicoes stand
     * 
     * @param listaAtribuicoesStand  nova listaAtribuicoesStand 
     */
    public void setListaAtribuicoesStand(List<AtribuicaoStand> listaAtribuicoesStand) {
        this.m_listaAtribuicoesStand = listaAtribuicoesStand;
    }

    /**
     * Adiciona todas as atribuições passadas como argumento à lista de 
     * atribuicoes de stands
     * 
     * @param listAtr atribuicoes a ser adicionadas
     */
    public void addAll(List<AtribuicaoStand> listAtr) {
        m_listaAtribuicoesStand.addAll(listAtr);
    }

    /**
     * Devolve a lista de atribuições do stand de um representante
     * 
     * @param email email de um representante
     * @return lista de atribuições do stand de um representante
     */
    public List<AtribuicaoStand> getListAtribuicoesStandDoRepresentante(String email) {
        ArrayList<AtribuicaoStand> listaAtribuicoesStandRepresentante = new ArrayList<>();
        for (AtribuicaoStand as : m_listaAtribuicoesStand) {
            if (as.getCand().getExpositor().getEmail().equalsIgnoreCase(email)) {
                listaAtribuicoesStandRepresentante.add(as);
            }
        }
        return listaAtribuicoesStandRepresentante;
    }

    @Override
    public RegistoAtribuicoesStands importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);

            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;

                this.m_listaAtribuicoesStand.clear();

                NodeList nList = elem.getElementsByTagName(AtribuicaoStand.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    AtribuicaoStand atrStand = new AtribuicaoStand(null, null, false);
                    atrStand.importContentFromXMLNode(n2);
                    this.m_listaAtribuicoesStand.add(atrStand);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoAtribuicoesStands.class.getName()).log(Level.SEVERE, null, ex);
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

            for (AtribuicaoStand atrStand : this.m_listaAtribuicoesStand) {
                Node n = atrStand.exportContentToXMLNode();
                elementBase.appendChild(document.importNode(n, true));
            }

            document.appendChild(elementBase);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoAtribuicoesStands.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
