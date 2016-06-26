package lapr.project.registos;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracao;
import lapr.project.model.CandidaturaADemonstracao;
import lapr.project.model.Demonstracao;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de um RegistoCandidaturasADemonstracao
 *
 * @author G29
 */
public class RegistoCandidaturasADemonstracao implements Importable<RegistoCandidaturasADemonstracao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "registoCandidaturaADemonstracoes";

    /**
     * Lista de candidaturas a demonstração
     */
    List<CandidaturaADemonstracao> m_listaCandidaturasADemonstracao;

    /**
     * Construtor de objetos do tipo RegistoCandidaturasADemonstracoes sem
     * parâmetros
     */
    public RegistoCandidaturasADemonstracao() {
        m_listaCandidaturasADemonstracao = new ArrayList<>();
    }

    /**
     * Devolve a lista de candidaturas a demonstração
     *
     * @return lista de candidaturas a demonstração
     */
    public List<CandidaturaADemonstracao> getListaCandidaturasADemonstracao() {
        return m_listaCandidaturasADemonstracao;
    }

    /**
     * Devolve a lista de candidaturas a demonstração de um representante
     *
     * @param email - email do representante
     * @return lista de candidaturas a demonstracao do representante
     */
    public List<CandidaturaADemonstracao> getListaCandidaturasADemonstracaoRep(Demonstracao d, String email) {
        List<CandidaturaADemonstracao> lstCandidaturasRep = new ArrayList<>();
        for (CandidaturaADemonstracao cd : m_listaCandidaturasADemonstracao) {
            if (cd.getEmailExpositor().equals(email)) {
                cd.setDemonstracao(d);
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

    public List<CandidaturaADemonstracao> getListaCandidaturasEstadoCriada() {
        List<CandidaturaADemonstracao> listCand = new ArrayList<>();
        for (CandidaturaADemonstracao cand : m_listaCandidaturasADemonstracao) {
            EstadoCandidaturaADemonstracao state = cand.getEstado();
            if (state.isEstadoCandidaturaADemonstracaoCriada()) {
                listCand.add(cand);
            }
        }
        return listCand;
    }

    /**
     * Devolve a lista de candidaturaas em estado avaliada
     *
     * @return lista de candidaturas em estado Avaliada
     */
    public List<CandidaturaADemonstracao> getListaCandidaturasEstadoAvaliada() {
        List<CandidaturaADemonstracao> listCand = new ArrayList<>();
        for (CandidaturaADemonstracao cand : m_listaCandidaturasADemonstracao) {
            EstadoCandidaturaADemonstracao estado = cand.getEstado();
            if (estado.isEstadoCandidaturaADemonstracaoAvaliada()) {
                listCand.add(cand);
            }
        }
        return listCand;
    }

    public List<CandidaturaADemonstracao> getListaCandidaturasEstadoProntaAAtribuicao() {
        List<CandidaturaADemonstracao> listCand = new ArrayList<>();
        for (CandidaturaADemonstracao cand : m_listaCandidaturasADemonstracao) {
            EstadoCandidaturaADemonstracao estado = cand.getEstado();
            if (estado.isEstadoCandidaturaADemonstracaoProntaAAtribuicao()) {
                listCand.add(cand);
            }
        }
        return listCand;
    }

    @Override
    public RegistoCandidaturasADemonstracao importContentFromXMLNode(Node node) throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        doc.appendChild(doc.importNode(node, true));

        Node n = doc.getChildNodes().item(0);

        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

            this.m_listaCandidaturasADemonstracao.clear();

            NodeList nList = elem.getElementsByTagName(CandidaturaADemonstracao.ROOT_ELEMENT_NAME);
            for (int i = 0; i < nList.getLength(); i++) {
                Node n2 = nList.item(i);
                CandidaturaADemonstracao cand = new CandidaturaADemonstracao("", "");
                cand.importContentFromXMLNode(n2);
                m_listaCandidaturasADemonstracao.add(cand);
            }
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
            Logger.getLogger(RegistoCandidaturasADemonstracao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return node;
    }
}
