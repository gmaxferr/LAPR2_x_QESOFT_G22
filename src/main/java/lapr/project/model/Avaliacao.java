package lapr.project.model;

import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

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

    /**
     * Verifica se a avalição já foi tomada
     *
     * @return true se a avaliação foi tomada. Caso contrário retorna false.
     */
    public boolean verificaAvaliacaoJaTomada() {
        if (!this.m_justificacao.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * Devolve a avaliação
     *
     * @return avaliação
     */
    public boolean getAvaliacao() {
        return this.m_avaliacao;
    }

    /**
     * Devolve a justificação
     *
     * @return justificação
     */
    public String getJustificacao() {
        return this.m_justificacao;
    }

    /**
     * Devolve o rating Conhecimento sobre o tema
     *
     * @return rating Conhecimento sobre o tema
     */
    public int getRatingConhecimentoSobreOTema() {
        return m_ratingConhecimentoSobreOTema;
    }

    /**
     * Devolve o rating Adequacao à exposição
     *
     * @return rating Adequacao à exposição
     */
    public int getRatingAdequacaoAExposicao() {
        return m_ratingAdequacaoAExposicao;
    }

    /**
     * Devolve o rating Adequação as demos
     *
     * @return rating Adequação as demos
     */
    public int getRatingAdequacaoAsDemos() {
        return m_ratingAdequacaoAsDemos;
    }

    /**
     * Devolve o rating Adequação ao número de convites
     *
     * @return rating Adequação ao número de convites
     */
    public int getRatingAdequacaoNumConvites() {
        return m_ratingAdequacaoNumConvites;
    }

    /**
     * Devolve o rating Recomendação global
     *
     * @return rating Recomendação global
     */
    public int getRatingRecomendacaoGlobal() {
        return m_ratingRecomendacaoGlobal;
    }

    /**
     * Calcula e devolve a média dos ratings associados a esta avaliação
     *
     * @return média dos ratings da avaliação
     */
    public float getMediaRatings() {
        float soma = this.m_ratingAdequacaoAExposicao
                + this.m_ratingAdequacaoAsDemos
                + this.m_ratingAdequacaoNumConvites
                + this.m_ratingConhecimentoSobreOTema
                + this.m_ratingRecomendacaoGlobal;
        return soma / 5;
    }

    /**
     * Define os parametros da avaliação. Usado no momento de tomada da
     * avaliação
     *
     * @param avaliacao true para validar positivamente ou false para o
     * contrário
     * @param justificacao justificação da avaliação dada e/ou ratings
     * @param ratingConhecimentoSobreTema de 0 a 5 sendo 0 o número que
     * representa menor conhecimento sobre o tema
     * @param ratingAdequacaoAExposicao de 0 a 5 sendo 0 o número que representa
     * menor adequação da candidatura à exposição
     * @param ratingAdequacaoAsDemos de 0 a 5 sendo 0 o número que representa
     * menor adequação da candidatura às demonstrações
     * @param ratingAdequacaoNumConvites de 0 a 5 sendo 0 o número que
     * representa menor adequação do número de convites
     * @param ratingRecomendacaoGlobal de 0 a 5 sendo 0 o número que representa
     * menor recomendação global
     */
    public void setAvalicao(boolean avaliacao, String justificacao, int ratingConhecimentoSobreTema, int ratingAdequacaoAExposicao, int ratingAdequacaoAsDemos, int ratingAdequacaoNumConvites, int ratingRecomendacaoGlobal) {
        this.m_avaliacao = avaliacao;
        this.m_justificacao = justificacao;
        this.m_ratingConhecimentoSobreOTema = ratingConhecimentoSobreTema;
        this.m_ratingAdequacaoAExposicao = ratingAdequacaoAExposicao;
        this.m_ratingAdequacaoAsDemos = ratingAdequacaoAsDemos;
        this.m_ratingAdequacaoNumConvites = ratingAdequacaoNumConvites;
        this.m_ratingRecomendacaoGlobal = ratingRecomendacaoGlobal;
    }

    /**
     * Modifica a avaliação e a justificação
     *
     * @param avaliacao nova avaliação
     * @param justificacao nova justificação
     */
    public void setAvalicaoParaDemonstracao(boolean avaliacao, String justificacao) {
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
}
