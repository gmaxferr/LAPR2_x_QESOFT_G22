package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import static lapr.project.model.AtribuicaoCandidatura.ROOT_ELEMENT_NAME;
import lapr.project.registos.RegistoCandidaturasADemonstracoes;
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
 * @author Ana Leite
 */
public class AtribuicaoCandidaturaDemonstracao implements Importable<AtribuicaoCandidaturaDemonstracao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "AtribuicaoCandidaturaDemosntracao";

    private CandidaturaADemonstracao m_candidatura;

    private RegistoFaeAvaliacao m_rFaeAvaliacao;

    public AtribuicaoCandidaturaDemonstracao(CandidaturaADemonstracao candidaturaADemonstracao) {
        this.m_candidatura = candidaturaADemonstracao;
        this.m_rFaeAvaliacao = new RegistoFaeAvaliacao();
    }

    public CandidaturaADemonstracao getCandidaturaAssociada() {
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

    public void fix(RegistoCandidaturasADemonstracoes m_rce, RegistoUtilizadores m_registoUtilizadores) {
        for (CandidaturaADemonstracao cand : m_rce.getListaCandidaturasADemonstracao()) {
            if (cand.equals(m_candidatura)) {
                m_candidatura = cand;
                break;
            }
        }
        this.m_rFaeAvaliacao.fix(m_registoUtilizadores);
    }

    /**
     * TESTE USE ONLY
     *
     * @param m_rFaeAvaliacao the m_rFaeAvaliacao to set
     */
    public void setRegistoFaeAvaliacao(RegistoFaeAvaliacao m_rFaeAvaliacao) {
        this.m_rFaeAvaliacao = m_rFaeAvaliacao;
    }

    @Override
    public AtribuicaoCandidaturaDemonstracao importContentFromXMLNode(Node node) throws ParserConfigurationException {
        Document document = XMLParser.createDocument(node, true);

        Node n = document.getChildNodes().item(0);
        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

            Expositor expositor = new Expositor(null);
            expositor.importContentFromXMLNode(elem.getElementsByTagName(Expositor.ROOT_ELEMENT_NAME).item(0));

            this.m_candidatura = new CandidaturaADemonstracao(null, null);
            this.m_candidatura.importContentFromXMLNode(elem.getElementsByTagName(CandidaturaADemonstracao.ROOT_ELEMENT_NAME).item(0));
            this.m_rFaeAvaliacao = new RegistoFaeAvaliacao();
            this.m_rFaeAvaliacao.importContentFromXMLNode(elem.getElementsByTagName(RegistoFaeAvaliacao.ROOT_ELEMENT_NAME).item(0));
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

            elemBase.appendChild(document.importNode(this.m_candidatura.exportContentToXMLNode(), true));
            elemBase.appendChild(document.importNode(this.m_rFaeAvaliacao.exportContentToXMLNode(), true));

            node = elemBase;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(AtribuicaoCandidatura.class.getName()).log(Level.SEVERE, null, ex);
        }

        return node;
    }
}
