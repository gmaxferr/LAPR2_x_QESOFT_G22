package lapr.project.registos;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import lapr.project.model.CandidaturaADemonstracao;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 *
 * @author G29
 */
public class RegistoCandidaturasADemonstracaoRemovidas implements Importable<RegistoCandidaturasADemonstracaoRemovidas>,  Exportable{

    public static final String ROOT_ELEMENT_NAME = "RegistoCandidaturasADemonstracaoRemovidas";

    /**
     * Lista de candidaturas a demonstração
     */
    private List<CandidaturaADemonstracao> m_listaCandidaturasRemovidas;
    
    /**
     * Construtor de objetos do tipo RegistoCandidaturasADemonstracao sem 
     * parâmetros
     */
    public RegistoCandidaturasADemonstracaoRemovidas(){
        this.m_listaCandidaturasRemovidas = new ArrayList<>();
    }
    
    /**
     * Adiciona uma candidatura a demonstracao à lista de candidaturas removidas
     * 
     * @param c candidatura a ser adicionada
     */
    public void adicionarCandidatura(CandidaturaADemonstracao c){
        m_listaCandidaturasRemovidas.add(c);
    }
    
    /**
     * Devolve a lista de candidaturas a demonstracao removidas
     * @return 
     */
    public List<CandidaturaADemonstracao> getListaCandidaturasADemonstracaoRemovidas(){
        return this.m_listaCandidaturasRemovidas;
    }

    @Override
    public RegistoCandidaturasADemonstracaoRemovidas importContentFromXMLNode(Node node) {
     try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);
            
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                
                this.m_listaCandidaturasRemovidas.clear();
                
                NodeList nList = elem.getElementsByTagName(CandidaturaADemonstracao.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    CandidaturaADemonstracao cand = new CandidaturaADemonstracao(null, null);
                    cand.importContentFromXMLNode(n2);
                    this.m_listaCandidaturasRemovidas.add(cand);
                }
            }

        } catch (ParserConfigurationException ex){
           Logger.getLogger(RegistoCandidaturasADemonstracaoRemovidas.class.getName()).log(Level.SEVERE, null, ex);
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

            for (CandidaturaADemonstracao cand : m_listaCandidaturasRemovidas) {
                Node n = cand.exportContentToXMLNode();
                elementBase.appendChild(document.importNode(n, true));
            }

            document.appendChild(elementBase);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoCandidaturasADemonstracaoRemovidas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
    
}