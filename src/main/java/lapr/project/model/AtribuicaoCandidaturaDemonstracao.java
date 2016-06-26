package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.registos.RegistoCandidaturasADemonstracao;
import lapr.project.registos.RegistoFaeAvaliacao;
import lapr.project.registos.RegistoUtilizadores;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import lapr.project.utils.XMLParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Representação de uma atribuição candidatura a demonstração
 * 
 * @author G29
 */
public class AtribuicaoCandidaturaDemonstracao implements Importable<AtribuicaoCandidaturaDemonstracao>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "AtribuicaoCandidaturaDemosntracao";

    /**
     * Candidatura a demonstração
     */
    private CandidaturaADemonstracao m_candidatura;

    /**
     * Registo de FaeAvaliacao
     */
    private RegistoFaeAvaliacao m_rFaeAvaliacao;

    
    /**
     * Construtor de objetos do tipo AtribuicaoCandidaturaADemonstracao com o 
     * parâmetro candidatura a demostração
     * 
     * @param candidaturaADemonstracao candidatura a demostração
     */
    public AtribuicaoCandidaturaDemonstracao(CandidaturaADemonstracao candidaturaADemonstracao) {
        this.m_candidatura = candidaturaADemonstracao;
        this.m_rFaeAvaliacao = new RegistoFaeAvaliacao();
    }

    /**
     * Devolve a candidatura a demonstração
     * 
     * @return candidatura a demonstração
     */
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

    /**
     * Adiciona um fae ao registo FaeAvaliação
     * 
     * @param fae fae a ser adicionado ao registo
     */
    public void addFaeAvaliacao(FAE fae) {
        this.m_rFaeAvaliacao.addFaeAvaliacao(fae);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj instanceof AtribuicaoCandidaturaDemonstracao){
            AtribuicaoCandidaturaDemonstracao o = (AtribuicaoCandidaturaDemonstracao) obj;
            return this.m_candidatura.equals(o.m_candidatura)
                    && this.m_rFaeAvaliacao.equals(o.getRegistoFaeAvaliacao());
        }
        return false;
    }

    /**
     * Conserta o valor das referências das variáveis guardados pelos objetos
     * que este objeto agrega.
     * 
     * @param m_rce registo de candidaturas a demonstração
     * @param m_registoUtilizadores registo de utilizadores
     */
    public void fix(RegistoCandidaturasADemonstracao m_rce, RegistoUtilizadores m_registoUtilizadores) {
        for (CandidaturaADemonstracao cand : m_rce.getListaCandidaturasADemonstracao()) {
            if (cand.equals(m_candidatura)) {
                m_candidatura = cand;
                break;
            }
        }
        this.m_rFaeAvaliacao.fix(m_registoUtilizadores);
    }

    @Override
    public AtribuicaoCandidaturaDemonstracao importContentFromXMLNode(Node node) throws ParserConfigurationException {
        Document document = XMLParser.createDocument(node, true);

        Node n = document.getChildNodes().item(0);
        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

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
