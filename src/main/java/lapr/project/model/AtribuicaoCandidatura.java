package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.registos.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class AtribuicaoCandidatura implements Importable<AtribuicaoCandidatura>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "AtribuicaoCandidatura";

    public static final String KEYWORDS_ELEMENT_NAME = "Keywords";

    private CandidaturaAExposicao m_candidatura;
    private RegistoFaeAvaliacao m_rFaeAvaliacao;

    public AtribuicaoCandidatura(CandidaturaAExposicao candidaturaAExposicao) {
        this.m_candidatura = candidaturaAExposicao;
        this.m_rFaeAvaliacao = new RegistoFaeAvaliacao();
    }

    public CandidaturaAExposicao getCandidaturaAssociada() {
        return this.m_candidatura;
    }

    /**
     * Devolve o registo de FAEAvaliação
     *
     * @return registo de FAEAvaliação
     */
    public RegistoFaeAvaliacao getRegistoFaeAvaliacao() {
        return this.m_rFaeAvaliacao;
    }

    public void addFaeAvaliacao(FAE fae) {
        this.m_rFaeAvaliacao.addFaeAvaliacao(fae);
    }

    public void fix(RegistoCandidaturasAExposicao m_rce, RegistoUtilizadores m_registoUtilizadores) {
        for (CandidaturaAExposicao cand : m_rce.getListaCandidaturas()) {
            if (cand.equals(m_candidatura)) {
                m_candidatura = cand;
                break;
            }
        }
        this.m_rFaeAvaliacao.fix(m_registoUtilizadores);
    }

    @Override
    public AtribuicaoCandidatura importContentFromXMLNode(Node node) {
        try {
            Document document = XMLParser.createDocument(node, true);

            Node n = document.getChildNodes().item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;

                Expositor expositor = new Expositor(null);
                expositor.importContentFromXMLNode(elem.getElementsByTagName(Expositor.ROOT_ELEMENT_NAME).item(0));

                this.m_candidatura = new CandidaturaAExposicao(expositor);
                NodeList nList = elem.getElementsByTagName(Keyword.ROOT_ELEMENT_NAME);
                for (int i = 0; i < nList.getLength(); i++) {
                    Node n2 = nList.item(i);
                    Keyword key = new Keyword();
                    key.importContentFromXMLNode(n2);
                    this.m_candidatura.getListKeyword().add(key);
                }

                this.m_rFaeAvaliacao = new RegistoFaeAvaliacao();
                this.m_rFaeAvaliacao.importContentFromXMLNode(elem.getElementsByTagName(RegistoFaeAvaliacao.ROOT_ELEMENT_NAME).item(0));
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(AtribuicaoCandidatura.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            Document document = XMLParser.createDocument();

            Element elemBase = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elemBase);

            elemBase.appendChild(document.importNode(this.m_candidatura.getExpositor().exportContentToXMLNode(), true));
            for (Keyword k : this.m_candidatura.getListKeyword()) {
                elemBase.appendChild(document.importNode(k.exportContentToXMLNode(), true));
            }
            elemBase.appendChild(document.importNode(this.m_rFaeAvaliacao.exportContentToXMLNode(), true));

            node = elemBase;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(AtribuicaoCandidatura.class.getName()).log(Level.SEVERE, null, ex);
        }

        return node;
    }

    /**
     * TESTE USE ONLY
     *
     * @param m_rFaeAvaliacao the m_rFaeAvaliacao to set
     */
    public void setRegistoFaeAvaliacao(RegistoFaeAvaliacao m_rFaeAvaliacao) {
        this.m_rFaeAvaliacao = m_rFaeAvaliacao;
    }
}
