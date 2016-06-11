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
import org.w3c.dom.NodeList;

/**
 *
 * @author Ricardo Osorio
 */
public class Avaliacao implements Importable<Avaliacao>, Exportable {

    //Elements
    public static final String ROOT_ELEMENT_NAME = "Avaliacao";
    public static final String JUSTIFICACAO_ELEMENT_NAME = "Justificacao";

    //Attributes
    public static final String AVALIACAO_ATTR_NAME = "avaliacao";
    public static final String RATING_CONHECIMENTO_TEMA_ATTR_NAME = "conhecimentoTema";
    public static final String RATING_ADEQ_EXPOSICAO_ATTR_NAME = "adequacaoExpo";
    public static final String RATING_ADEQ_DEMOS_ATTR_NAME = "adequacaoDemos";
    public static final String RATING_ADEQ_NUM_CONVITES_ATTR_NAME = "adequacaoNumConvites";
    public static final String RATING_REC_GLOBAL_ATTR_NAME = "recomendacaoGlobal";

    private int m_ratingConhecimentoSobreOTema;
    private int m_ratingAdequacaoAExposicao;
    private int m_ratingAdequacaoAsDemos;
    private int m_ratingAdequacaoNumConvites;
    private int m_ratingRecomendacaoGlobal;
    private boolean m_avaliacao;
    private String m_justificacao;

    public Avaliacao() {
        this.m_justificacao = null;
    }

    public boolean verificaAvaliacaoJaTomada() {
        if (!this.m_justificacao.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean getAvaliacao() {
        return this.m_avaliacao;
    }

    public String getJustificacao() {
        return this.m_justificacao;
    }

    public int getRatingConhecimentoSobreOTema() {
        return m_ratingConhecimentoSobreOTema;
    }

    public int getRatingAdequacaoAExposicao() {
        return m_ratingAdequacaoAExposicao;
    }

    public int getRatingAdequacaoAsDemos() {
        return m_ratingAdequacaoAsDemos;
    }

    public int getRatingAdequacaoNumConvites() {
        return m_ratingAdequacaoNumConvites;
    }

    public int getRatingRecomendacaoGlobal() {
        return m_ratingRecomendacaoGlobal;
    }

    public void setAvalicao(boolean avaliacao, String justificacao, int ratingConhecimentoSobreTema, int ratingAdequacaoAExposicao, int ratingAdequacaoAsDemos, int ratingAdequacaoNumConvites, int ratingRecomendacaoGlobal) {
        this.m_avaliacao = avaliacao;
        this.m_justificacao = justificacao;
        this.m_ratingConhecimentoSobreOTema = ratingConhecimentoSobreTema;
        this.m_ratingAdequacaoAExposicao = ratingAdequacaoAExposicao;
        this.m_ratingAdequacaoAsDemos = ratingAdequacaoAsDemos;
        this.m_ratingAdequacaoNumConvites = ratingAdequacaoNumConvites;
        this.m_ratingRecomendacaoGlobal = ratingRecomendacaoGlobal;
    }

    public void setAvalicaoParaDemonstracao(boolean avaliacao, String justificacao){
        this.m_avaliacao = avaliacao;
        this.m_justificacao = justificacao;
        
    }
    @Override
    public Avaliacao importContentFromXMLNode(Node node) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            document.appendChild(document.importNode(node, true));

            NodeList nList = document.getChildNodes();

            Node n = nList.item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                
                this.m_avaliacao = Boolean.valueOf(elem.getAttribute(AVALIACAO_ATTR_NAME));
                this.m_ratingAdequacaoAExposicao = Integer.parseInt(elem.getAttribute(RATING_ADEQ_EXPOSICAO_ATTR_NAME));
                this.m_ratingAdequacaoAsDemos = Integer.parseInt(elem.getAttribute(RATING_ADEQ_DEMOS_ATTR_NAME));
                this.m_ratingAdequacaoNumConvites = Integer.parseInt(elem.getAttribute(RATING_ADEQ_NUM_CONVITES_ATTR_NAME));
                this.m_ratingConhecimentoSobreOTema = Integer.parseInt(elem.getAttribute(RATING_CONHECIMENTO_TEMA_ATTR_NAME));
                this.m_ratingRecomendacaoGlobal = Integer.parseInt(elem.getAttribute(RATING_REC_GLOBAL_ATTR_NAME));
                this.m_justificacao = elem.getElementsByTagName(JUSTIFICACAO_ELEMENT_NAME).item(0).getTextContent();
            }

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
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
            document.appendChild(elementBase);
            
            Element elemChild = document.createElement(JUSTIFICACAO_ELEMENT_NAME);
            elemChild.setTextContent(this.m_justificacao);
            elementBase.appendChild(elemChild);
            
            elementBase.setAttribute(AVALIACAO_ATTR_NAME, String.valueOf(this.m_avaliacao));
            elementBase.setAttribute(RATING_ADEQ_DEMOS_ATTR_NAME, String.valueOf(this.m_ratingAdequacaoAsDemos));
            elementBase.setAttribute(RATING_ADEQ_EXPOSICAO_ATTR_NAME, String.valueOf(this.m_ratingAdequacaoAExposicao));
            elementBase.setAttribute(RATING_ADEQ_NUM_CONVITES_ATTR_NAME, String.valueOf(this.m_ratingAdequacaoNumConvites));
            elementBase.setAttribute(RATING_CONHECIMENTO_TEMA_ATTR_NAME, String.valueOf(this.m_ratingConhecimentoSobreOTema));
            elementBase.setAttribute(RATING_REC_GLOBAL_ATTR_NAME, String.valueOf(this.m_ratingRecomendacaoGlobal));
            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return node;
    }
    
    public float getMediaRatings(){
        float soma=this.m_ratingAdequacaoAExposicao
                +this.m_ratingAdequacaoAsDemos
                +this.m_ratingAdequacaoNumConvites
                +this.m_ratingConhecimentoSobreOTema
                +this.m_ratingRecomendacaoGlobal;
        return soma/5;
    }

}
