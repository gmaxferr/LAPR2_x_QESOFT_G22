package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicao;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.Expositor;
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
public class RegistoCandidaturasAExposicao implements Importable<RegistoCandidaturasAExposicao>, Exportable {
    
    public static final String ROOT_ELEMENT_NAME = "RegistoCandidaturasAExposicao";

    /**
     * Atributo lista de candidaturas
     */
    private List<CandidaturaAExposicao> m_listaCandidaturas;

    public RegistoCandidaturasAExposicao() {
        this.m_listaCandidaturas = new ArrayList<>();
    }

    /**
     * Método que devolve a lista de candidatuas
     *
     * @return lista de candidatuas
     */
    public List<CandidaturaAExposicao> getListaCandidaturas() {
        return this.m_listaCandidaturas;
    }

    /**
     * Método que cria uma nova candidatura
     *
     * @return nova candidatura
     */
    public CandidaturaAExposicao criarCandidatura(Expositor expositor) {
        return new CandidaturaAExposicao(expositor);
    }

    /**
     * Método que valida dados da candidatura
     *
     * @param c candidatura
     *
     * @return boolean que confirma a validação dos dados
     */
    public boolean validarDadosCandidatura(CandidaturaAExposicao c) {
        for (CandidaturaAExposicao candidatura : this.m_listaCandidaturas) {
            if (c.equals(candidatura)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Método que regista candidatura
     *
     * @param candidaturaAExposicao candidatura
     * @return
     */
    public boolean registaCandidatura(CandidaturaAExposicao candidaturaAExposicao) {
        boolean b = validaCandidatua(candidaturaAExposicao);
        if (b) {
            addCandidatura(candidaturaAExposicao);
        }
        return b;
    }

    /**
     * Método que valida candidatura
     *
     * @param c candidatura
     */
    public boolean validaCandidatua(CandidaturaAExposicao c) {
        //validação global - repetida
        return true;
    }

    /**
     * Método que valida a candidatura
     *
     * @param c candidatura
     *
     * @return boolean de confirmação da validação
     */
    private boolean validaCandidatura(CandidaturaAExposicao c) {
        //validaçao global
        return true;

    }

    /**
     * Método que adiciona uma candidatura
     *
     * @param c candidatura a ser adicionada
     */
    void addCandidatura(CandidaturaAExposicao c) {
        if (validaCandidatura(c)) {
            addCandidatura(c);
        }
    }

    /**
     * Remove uma candidatura do registo
     *
     * @param c - candidatura a remover
     */
    public void removeCandidatura(CandidaturaAExposicao c) {
        m_listaCandidaturas.remove(c);
    }

    public List<CandidaturaAExposicao> getCandidaturasRepresentante(String username) {
        List<CandidaturaAExposicao> candidaturasRepLst = new ArrayList<>();
        for (CandidaturaAExposicao c : m_listaCandidaturas) {
            if (c.getUsernameExpositor().equals(username)) {
                candidaturasRepLst.add(c);
            }
        }
        return candidaturasRepLst;
    }

    /**
     * @return Retorna uma lista com todas as Candidaturas aceites a esta
     * Exposição
     */
    public List<CandidaturaAExposicao> getListaCandidaturasAceites() {
        List<CandidaturaAExposicao> listCand = new ArrayList<>();
        for(CandidaturaAExposicao cand : m_listaCandidaturas){
            EstadoCandidaturaAExposicao state = cand.getEstado();
            if(state.isEstadoCandidaturaAceite()){
                listCand.add(cand);
            }
        }
        return listCand;
    }

    @Override
    public RegistoCandidaturasAExposicao importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);
            
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                
                this.m_listaCandidaturas.clear();
                
                NodeList nList = elem.getElementsByTagName(CandidaturaAExposicao.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    CandidaturaAExposicao cand = new CandidaturaAExposicao(null);
                    cand.importContentFromXMLNode(n2);
                    m_listaCandidaturas.add(cand);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoCandidaturasAExposicao.class.getName()).log(Level.SEVERE, null, ex);
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

            for (CandidaturaAExposicao cand : m_listaCandidaturas) {
                Node n = cand.exportContentToXMLNode();
                elementBase.appendChild(document.importNode(n, true));
            }

            document.appendChild(elementBase);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoCandidaturasAExposicao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
