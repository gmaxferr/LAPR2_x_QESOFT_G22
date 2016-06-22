package lapr.project.model;

import java.util.logging.*;
import javax.xml.parsers.*;
import lapr.project.utils.*;
import org.w3c.dom.*;

/**
 *
 * @author G29
 */
public class Avaliacao implements Importable<Avaliacao>, Exportable {

    //Elements
    public static final String ROOT_ELEMENT_NAME = "avaliacao";

    public static final String JUSTIFICACAO_ELEMENT_NAME = "texto";
    public static final String RATING_CONHECIMENTO_TEMA_ELEM_NAME = "conhecimentoFAE";
    public static final String RATING_ADEQ_EXPOSICAO_ELEMENT_NAME = "adequacaoExposicao";
    public static final String RATING_ADEQ_DEMOS_ELEMENT_NAME = "adequacaoDemonstracoes";
    public static final String RATING_ADEQ_NUM_CONVITES_ELEM_NAME = "adequacaoConvites";
    public static final String RATING_REC_GLOBAL_ELEMENT_NAME = "recomendacao";
    public static final String RATING_ADEQ_DADOS_CAND_ELEM_NAME = "adequacaoDadosCandidatura";

    private int m_ratingConhecimentoSobreOTema;
    private int m_ratingAdequacaoAExposicao;
    private int m_ratingAdequacaoAsDemos;
    private int m_ratingAdequacaoNumConvites;
    private int m_ratingRecomendacaoGlobal;
    private int m_ratingAdequacaoDadosCandidatura;

    public Avaliacao() {
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
     * Devolve o rating Adequação dos dados da candidatura
     *
     * @return rating Adequação dos dados da candidatura
     */
    public int getRatingAdequacaoDadosCandidatura() {
        return m_ratingAdequacaoDadosCandidatura;
    }

    /**
     * Calcula e devolve a média dos ratings associados a esta avaliação
     *
     * @return média dos ratings da avaliação
     */
    public float getMediaRatings() {
        float soma = (float) this.m_ratingAdequacaoAExposicao
                + this.m_ratingAdequacaoAsDemos
                + this.m_ratingAdequacaoNumConvites
                + this.m_ratingConhecimentoSobreOTema
                + this.m_ratingRecomendacaoGlobal;
        return soma / 5;
    }

    /**
     * Define os parametros da avaliação. Usado no momento de tomada da
     * avaliação (candidaturas a exposição)
     *
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
    public void setAvalicao(int ratingConhecimentoSobreTema, int ratingAdequacaoAExposicao, int ratingAdequacaoAsDemos, int ratingAdequacaoNumConvites, int ratingRecomendacaoGlobal) {
        this.m_ratingConhecimentoSobreOTema = ratingConhecimentoSobreTema;
        this.m_ratingAdequacaoAExposicao = ratingAdequacaoAExposicao;
        this.m_ratingAdequacaoAsDemos = ratingAdequacaoAsDemos;
        this.m_ratingAdequacaoNumConvites = ratingAdequacaoNumConvites;
        this.m_ratingRecomendacaoGlobal = ratingRecomendacaoGlobal;
    }

    /**
     * Define os parametros da avaliação. Usado no momento de tomada da
     * avaliação (candidaturas a demonstracao)
     *
     * @param ratingConhecimentoSobreTema de 0 a 5 sendo 0 o número que
     * representa menor conhecimento sobre o tema
     * @param ratingAdequacaoDadosCandidatura de o a 5 sendo 0 o número que
     * representa menor adequação dos dados da candidatura
     * @param ratingRecomendacaoGlobal de 0 a 5 sendo 0 o número que representa
     * menor recomendação global
     */
    public void setAvaliacaoParaDemonstracao(int ratingConhecimentoSobreTema, int ratingAdequacaoDadosCandidatura, int ratingRecomendacaoGlobal) {
        this.m_ratingConhecimentoSobreOTema = ratingConhecimentoSobreTema;
        this.m_ratingAdequacaoDadosCandidatura = ratingAdequacaoDadosCandidatura;
        this.m_ratingRecomendacaoGlobal = ratingRecomendacaoGlobal;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null
                && obj instanceof Avaliacao) {
            Avaliacao o = (Avaliacao) obj;
            return this.m_ratingAdequacaoAExposicao == o.m_ratingAdequacaoAExposicao
                    && this.m_ratingAdequacaoAsDemos == o.m_ratingAdequacaoAsDemos
                    && this.m_ratingAdequacaoNumConvites == o.m_ratingAdequacaoNumConvites
                    && this.m_ratingConhecimentoSobreOTema == o.m_ratingConhecimentoSobreOTema
                    && this.m_ratingRecomendacaoGlobal == o.m_ratingRecomendacaoGlobal
                    && Float.compare(this.getMediaRatings(), o.getMediaRatings()) == 0;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.m_ratingConhecimentoSobreOTema;
        hash = 89 * hash + this.m_ratingAdequacaoAExposicao;
        hash = 89 * hash + this.m_ratingAdequacaoAsDemos;
        hash = 89 * hash + this.m_ratingAdequacaoNumConvites;
        hash = 89 * hash + this.m_ratingRecomendacaoGlobal;
        return hash;
    }

    @Override
    public Avaliacao importContentFromXMLNode(Node node) throws ParserConfigurationException {
        Document document = XMLParser.createDocument(node, true);

        NodeList nList = document.getChildNodes();

        Node n = nList.item(0);
        if (n.getNodeType() == Node.ELEMENT_NODE) {
            Element elem = (Element) n;

            this.m_ratingConhecimentoSobreOTema = Integer.parseInt(elem.getElementsByTagName(RATING_CONHECIMENTO_TEMA_ELEM_NAME).item(0).getTextContent());
            this.m_ratingAdequacaoAExposicao = Integer.parseInt(elem.getElementsByTagName(RATING_ADEQ_EXPOSICAO_ELEMENT_NAME).item(0).getTextContent());
            this.m_ratingAdequacaoAsDemos = Integer.parseInt(elem.getElementsByTagName(RATING_ADEQ_DEMOS_ELEMENT_NAME).item(0).getTextContent());
            this.m_ratingAdequacaoNumConvites = Integer.parseInt(elem.getElementsByTagName(RATING_ADEQ_NUM_CONVITES_ELEM_NAME).item(0).getTextContent());
            this.m_ratingRecomendacaoGlobal = Integer.parseInt(elem.getElementsByTagName(RATING_REC_GLOBAL_ELEMENT_NAME).item(0).getTextContent());
            this.m_ratingAdequacaoDadosCandidatura = Integer.parseInt(elem.getElementsByTagName(RATING_ADEQ_DADOS_CAND_ELEM_NAME).item(0).getTextContent());
        }

        return this;
    }

    @Override
    public Node exportContentToXMLNode() {
        Node node = null;

        try {
            Document document = XMLParser.createDocument();

            Element elementBase = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elementBase);

            Element elemChild = document.createElement(RATING_ADEQ_DEMOS_ELEMENT_NAME);
            elemChild.setTextContent(String.valueOf(this.m_ratingAdequacaoAsDemos));
            elementBase.appendChild(elemChild);

            elemChild = document.createElement(RATING_ADEQ_EXPOSICAO_ELEMENT_NAME);
            elemChild.setTextContent(String.valueOf(this.m_ratingAdequacaoAExposicao));
            elementBase.appendChild(elemChild);

            elemChild = document.createElement(RATING_ADEQ_NUM_CONVITES_ELEM_NAME);
            elemChild.setTextContent(String.valueOf(this.m_ratingAdequacaoNumConvites));
            elementBase.appendChild(elemChild);

            elemChild = document.createElement(RATING_CONHECIMENTO_TEMA_ELEM_NAME);
            elemChild.setTextContent(String.valueOf(this.m_ratingConhecimentoSobreOTema));
            elementBase.appendChild(elemChild);

            elemChild = document.createElement(RATING_REC_GLOBAL_ELEMENT_NAME);
            elemChild.setTextContent(String.valueOf(this.m_ratingRecomendacaoGlobal));
            elementBase.appendChild(elemChild);

            elemChild = document.createElement(RATING_ADEQ_DADOS_CAND_ELEM_NAME);
            elemChild.setTextContent(String.valueOf(this.m_ratingAdequacaoDadosCandidatura));
            elementBase.appendChild(elemChild);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return node;
    }
}
