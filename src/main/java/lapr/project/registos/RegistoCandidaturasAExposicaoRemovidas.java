package lapr.project.registos;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um RegistoCandidaturasAExposicaoRemovidas
 * 
 * @author G29
 */
public class RegistoCandidaturasAExposicaoRemovidas implements Importable<RegistoCandidaturasAExposicaoRemovidas>,  Exportable {
    
    public static final String ROOT_ELEMENT_NAME = "RegistoCandidaturasAExposicaoRemovidas";

    /**
     * Lista de candidaturas removidas.
     */
    private List<CandidaturaAExposicao> m_listaCandidaturasRemovidas;

   /**
     * Contrutor de objetos do tipo RegistoCandidaturasAExposicaoRemovidas sem parâmetros.
     */
    public RegistoCandidaturasAExposicaoRemovidas() {
        this.m_listaCandidaturasRemovidas = new ArrayList<>();
    }

    /**
     * Adiciona uma candidatura removida do registo de candidaturas
     *
     * @param c - candidatura removida do registo de candidaturas
     */
    public void adicionarCandidatura(CandidaturaAExposicao c) {
        m_listaCandidaturasRemovidas.add(c);
    }

    /**
     * Devolve a lista de candidaturas removidas.
     *
     * @return lista de candidaturas removidas
     */
    public List<CandidaturaAExposicao> getListaCandidaturasAExposicaoRemovidas() {
        return this.m_listaCandidaturasRemovidas;
    }
    
    public RegistoCandidaturasAExposicaoRemovidas importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);
            
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                
                this.m_listaCandidaturasRemovidas.clear();
                
                NodeList nList = elem.getElementsByTagName(CandidaturaAExposicao.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    CandidaturaAExposicao cand = new CandidaturaAExposicao(null);
                    cand.importContentFromXMLNode(n2);
                    this.m_listaCandidaturasRemovidas.add(cand);
                }
            }

        } catch (ParserConfigurationException ex){
           Logger.getLogger(RegistoCandidaturasAExposicaoRemovidas.class.getName()).log(Level.SEVERE, null, ex);
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

            for (CandidaturaAExposicao cand : m_listaCandidaturasRemovidas) {
                Node n = cand.exportContentToXMLNode();
                elementBase.appendChild(document.importNode(n, true));
            }

            document.appendChild(elementBase);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoCandidaturasAExposicaoRemovidas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
