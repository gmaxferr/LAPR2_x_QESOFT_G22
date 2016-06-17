package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.registos.RegistoCandidaturasAExposicao;
import lapr.project.registos.RegistoFaeAvaliacao;
import lapr.project.registos.RegistoUtilizadores;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import lapr.project.utils.XMLParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class AtribuicaoCandidatura implements Importable<AtribuicaoCandidatura>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "AtribuicaoCandidatura";

    public static final String KEYWORDS_ELEMENT_NAME = "Keywords";

    private CandidaturaAExposicao m_candidatura;
    private RegistoFaeAvaliacao m_rFaeDecisao;

    public AtribuicaoCandidatura(CandidaturaAExposicao candidaturaAExposicao) {
        this.m_candidatura = candidaturaAExposicao;
        this.m_rFaeDecisao = new RegistoFaeAvaliacao();
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
        return this.m_rFaeDecisao;
    }

    public void addFaeAvaliacao(FAE fae) {
        this.m_rFaeDecisao.addFaeAvaliacao(fae);
    }

    public void fix(RegistoCandidaturasAExposicao m_rce, RegistoUtilizadores m_registoUtilizadores) {
        for (CandidaturaAExposicao cand : m_rce.getListaCandidaturas()) {
            if (cand.equals(m_candidatura)) {
                m_candidatura = cand;
                break;
            }
        }
        this.m_rFaeDecisao.fix(m_registoUtilizadores);
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

                this.m_rFaeDecisao = new RegistoFaeAvaliacao();
                this.m_rFaeDecisao.importContentFromXMLNode(elem.getElementsByTagName(RegistoFaeAvaliacao.ROOT_ELEMENT_NAME).item(0));
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(AtribuicaoCandidatura.class.getName()).log(Level.SEVERE, null, ex);
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
            elemBase.appendChild(document.importNode(this.m_rFaeDecisao.exportContentToXMLNode(), true));
            
            node = elemBase;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(AtribuicaoCandidatura.class.getName()).log(Level.SEVERE, null, ex);
        }

        return node;
    }
}
