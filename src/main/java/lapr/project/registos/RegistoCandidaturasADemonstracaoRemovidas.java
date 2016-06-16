/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.model.CandidaturaADemonstracao;
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
public class RegistoCandidaturasADemonstracaoRemovidas implements Importable<RegistoCandidaturasADemonstracaoRemovidas>,  Exportable{

    public static final String ROOT_ELEMENT_NAME = "RegistoCandidaturasADemonstracaoRemovidas";

    private List<CandidaturaADemonstracao> m_listaCandidaturasRemovidas;
    
    public RegistoCandidaturasADemonstracaoRemovidas(){
        this.m_listaCandidaturasRemovidas = new ArrayList<>();
    }
    
    public void adicionarCandidatura(CandidaturaADemonstracao c){
        m_listaCandidaturasRemovidas.add(c);
    }
    
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