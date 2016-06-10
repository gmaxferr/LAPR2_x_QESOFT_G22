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
 * @author guima
 */
public class RegistoCandidaturaADemonstracoes implements Importable<RegistoCandidaturaADemonstracoes>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "RegistoCandidaturaADemonstracoes";

    List<CandidaturaADemonstracao> m_listaCandidaturasADemonstracao;

    public RegistoCandidaturaADemonstracoes() {
        m_listaCandidaturasADemonstracao = new ArrayList<>();
    }

    public List<CandidaturaADemonstracao> getListaCandidaturasADemonstracao() {
        return m_listaCandidaturasADemonstracao;
    }

    /**
     *
     * @param username do representante
     * @return lista de candidaturas a demonstracao do representante
     */
    public List<CandidaturaADemonstracao> getListaCandidaturasADemonstracaoRep(String username) {
        List<CandidaturaADemonstracao> lstCandidaturasRep = new ArrayList<>();
        for (CandidaturaADemonstracao cd : m_listaCandidaturasADemonstracao) {
            if (cd.getM_usernameExpositor().equals(username)) {
                lstCandidaturasRep.add(cd);
            }
        }
        return lstCandidaturasRep;
    }

    /**
     * Adiciona uma candidatura à lista de candidaturas à demonstração que
     * possui este registo.
     *
     * @param cand - candidatura a adicionar
     * @return true se a adição for bem sucedida; false caso contrário.
     */
    public boolean adiciona(CandidaturaADemonstracao cand) {
        boolean valido = false;
        if (isValid(cand)) {
            m_listaCandidaturasADemonstracao.add(cand);
            valido = true;
        }
        return valido;
    }

    /**
     * Valida globalmente a candidatura à demonstração, vendo se já existe na
     * lista deste registo ou não.
     *
     * @param cand - Candidatura a sofrer validação
     * @return true se for válida; false caso contrário
     */
    public boolean isValid(CandidaturaADemonstracao cand) {
        return !m_listaCandidaturasADemonstracao.contains(cand);
    }

    @Override
    public RegistoCandidaturaADemonstracoes importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            doc.appendChild(doc.importNode(node, true));

            Node n = doc.getChildNodes().item(0);

            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;

                NodeList nList = elem.getElementsByTagName(CandidaturaADemonstracao.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    CandidaturaADemonstracao cand = new CandidaturaADemonstracao("", "");
                    cand.importContentFromXMLNode(n2);
                    m_listaCandidaturasADemonstracao.add(cand);
                }
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoCandidaturaADemonstracoes.class.getName()).log(Level.SEVERE, null, ex);
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

            Element elementKeyword = document.createElement(ROOT_ELEMENT_NAME);

            for (CandidaturaADemonstracao c : m_listaCandidaturasADemonstracao) {
                Node n = c.exportContentToXMLNode();
                elementKeyword.appendChild(document.importNode(n, true));
            }

            document.appendChild(elementKeyword);

            node = elementKeyword;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(RegistoCandidaturaADemonstracoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
