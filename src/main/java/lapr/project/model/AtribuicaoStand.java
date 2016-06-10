package lapr.project.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import lapr.project.utils.Exportable;
import lapr.project.utils.Importable;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author Ricardo Catalao
 */
public class AtribuicaoStand implements Importable<AtribuicaoStand>, Exportable {

    public static final String ROOT_ELEMENT_NAME = "AtribuicaoStand";
    public static final String DECISAO_ATTR_NAME = "decisao";

    private Stand m_stand;
    private CandidaturaAExposicao m_cand;
    private boolean m_decisao;

    public AtribuicaoStand(Stand m_stand, CandidaturaAExposicao m_cand, boolean decisao) {
        this.m_stand = m_stand;
        this.m_cand = m_cand;
        this.m_decisao = decisao;
    }

    /**
     * @return the stand
     */
    public Stand getStand() {
        return m_stand;
    }

    /**
     * @param stand the stand to set
     */
    public void setStand(Stand stand) {
        this.m_stand = stand;
    }

    /**
     * @return the cand
     */
    public CandidaturaAExposicao getCand() {
        return m_cand;
    }

    /**
     * @param cand the cand to set
     */
    public void setCand(CandidaturaAExposicao cand) {
        this.m_cand = cand;
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
     * Modifica a decisão
     *
     * @param decisao nova decisão
     */
    public void setDecisao(boolean decisao) {
        this.m_decisao = decisao;
    }

    @Override
    public AtribuicaoStand importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            document.appendChild(document.importNode(node, m_decisao));

            Node n = document.getChildNodes().item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                
                this.m_cand = new CandidaturaAExposicao(null);
                this.m_cand.importContentFromXMLNode(elem.getElementsByTagName(CandidaturaAExposicao.ROOT_ELEMENT_NAME).item(0));
                
                this.m_stand = new Stand("", 0);
                this.m_stand.importContentFromXMLNode(elem.getElementsByTagName(Stand.ROOT_ELEMENT_NAME).item(0));
                
                this.m_decisao = Boolean.valueOf(elem.getAttribute(DECISAO_ATTR_NAME));
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(AtribuicaoStand.class.getName()).log(Level.SEVERE, null, ex);
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
            
            Element elemBase = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elemBase);
            
            elemBase.appendChild(document.importNode(this.m_cand.exportContentToXMLNode(), true));
            elemBase.appendChild(document.importNode(this.m_stand.exportContentToXMLNode(), true));
            elemBase.setAttribute(DECISAO_ATTR_NAME, String.valueOf(m_decisao));
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(AtribuicaoStand.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return node;
    }

}
