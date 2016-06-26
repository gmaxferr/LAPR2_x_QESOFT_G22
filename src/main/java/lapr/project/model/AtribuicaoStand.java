package lapr.project.model;

import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 * Representação de uma atribuição stand
 * 
 * @author G29
 */
public class AtribuicaoStand implements Importable<AtribuicaoStand>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "AtribuicaoStand";
    public static final String DECISAO_ATTR_NAME = "decisao";

    /**
     * Stand atribuído
     */
    private Stand m_stand;
    
    /**
     * Candidatura a exposição
     */
    private CandidaturaAExposicao m_cand;
    
    /**
     * Decisão sobre o stand
     */
    private boolean m_decisao;

    /**
     * Construtor de objetos do tipo AtribuicaoStand com os parâmentros
     * stand, candidatura a exposição e decisao
     * 
     * @param m_stand stand atribuido
     * @param m_cand candidatura a exposição
     * @param decisao decisão sobre o stand
     */
    public AtribuicaoStand(Stand m_stand, CandidaturaAExposicao m_cand, boolean decisao) {
        this.m_stand = m_stand;
        this.m_cand = m_cand;
        this.m_decisao = decisao;
    }

   /**
    * Devolve o stand atribuido
    * 
    * @return stand atribuido
    */
    public Stand getStand() {
        return m_stand;
    }

    /**
     * Devolve a candidatura a exposição
     * 
     * @return candidatura a exposição
     */
    public CandidaturaAExposicao getCand() {
        return m_cand;
    }
    
    /**
     * Devolve a decisão
     *
     * @return decisão
     */
    public boolean getDecisao() {
        return this.m_decisao;
    }
    
    /**
     * Modifica o stand
     * @param stand novo stand
     */
    public void setStand(Stand stand) {
        this.m_stand = stand;
    }

    /**
     * Modifica a candidatura a exposição
     * 
     * @param cand nova candidatura a exposição
     */
    public void setCand(CandidaturaAExposicao cand) {
        this.m_cand = cand;
    }

    /**
     * Modifica a decisão
     *
     * @param decisao nova decisão
     */
    public void setDecisao(boolean decisao) {
        this.m_decisao = decisao;
    }

    @Override
    public AtribuicaoStand importContentFromXMLNode(Node node) throws ParserConfigurationException {
        Document document = XMLParser.createDocument(node, true);

        Node n = document.getChildNodes().item(0);
        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

            this.m_cand = new CandidaturaAExposicao(null);
            this.m_cand.importContentFromXMLNode(elem.getElementsByTagName(CandidaturaAExposicao.ROOT_ELEMENT_NAME).item(0));

            this.m_stand = new Stand("", 0, "");
            this.m_stand.importContentFromXMLNode(elem.getElementsByTagName(Stand.ROOT_ELEMENT_NAME).item(0));

            this.m_decisao = Boolean.valueOf(elem.getAttribute(DECISAO_ATTR_NAME));
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

            elemBase.appendChild(document.importNode(this.m_cand.exportContentToXMLNode(), true));
            elemBase.appendChild(document.importNode(this.m_stand.exportContentToXMLNode(), true));
            elemBase.setAttribute(DECISAO_ATTR_NAME, String.valueOf(m_decisao));
            
            node = elemBase;
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(AtribuicaoStand.class.getName()).log(Level.SEVERE, null, ex);
        }

        return node;
    }

}
