package lapr.project.model;

import java.util.Objects;
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
    public static final String ROOT_ELEMENT_NAME = "avaliacao";

    public static final String JUSTIFICACAO_ELEMENT_NAME = "texto";
    public static final String RATING_CONHECIMENTO_TEMA_ATTR_NAME = "conhecimentoFAE";
    public static final String RATING_ADEQ_EXPOSICAO_ATTR_NAME = "adequacaoExposicao";
    public static final String RATING_ADEQ_DEMOS_ATTR_NAME = "adequacaoDemonstracoes";
    public static final String RATING_ADEQ_NUM_CONVITES_ATTR_NAME = "adequacaoConvites";
    public static final String RATING_REC_GLOBAL_ATTR_NAME = "recomendacao";

    private int m_ratingConhecimentoSobreOTema;
    private int m_ratingAdequacaoAExposicao;
    private int m_ratingAdequacaoAsDemos;
    private int m_ratingAdequacaoNumConvites;
    private int m_ratingRecomendacaoGlobal;
    private String m_justificacao;

    public Avaliacao() {
        this.m_justificacao = "";
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
        float soma = (float) this.m_ratingAdequacaoAExposicao
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
    public void setAvalicao(String justificacao, int ratingConhecimentoSobreTema, int ratingAdequacaoAExposicao, int ratingAdequacaoAsDemos, int ratingAdequacaoNumConvites, int ratingRecomendacaoGlobal) {
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
    public void setAvalicaoParaDemonstracao(String justificacao) {
        this.m_justificacao = justificacao;

    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null
                && obj instanceof Avaliacao) {
            Avaliacao o = (Avaliacao) obj;
            return this.m_justificacao.equals(o.m_justificacao)
                    && this.m_ratingAdequacaoAExposicao == o.m_ratingAdequacaoAExposicao
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
        hash = 89 * hash + Objects.hashCode(this.m_justificacao);
        return hash;
    }

    @Override
    public Avaliacao importContentFromXMLNode(Node node) {
        try {
            Document document = XMLParser.createDocument(node, true);

            NodeList nList = document.getChildNodes();

            Node n = nList.item(0);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) n;

                this.m_justificacao = elem.getElementsByTagName(JUSTIFICACAO_ELEMENT_NAME).item(0).getTextContent();
                this.m_ratingConhecimentoSobreOTema = Integer.parseInt(elem.getElementsByTagName(RATING_CONHECIMENTO_TEMA_ATTR_NAME).item(0).getTextContent());
                this.m_ratingAdequacaoAExposicao = Integer.parseInt(elem.getElementsByTagName(RATING_ADEQ_EXPOSICAO_ATTR_NAME).item(0).getTextContent());
                this.m_ratingAdequacaoAsDemos = Integer.parseInt(elem.getElementsByTagName(RATING_ADEQ_DEMOS_ATTR_NAME).item(0).getTextContent());
                this.m_ratingAdequacaoNumConvites = Integer.parseInt(elem.getElementsByTagName(RATING_ADEQ_NUM_CONVITES_ATTR_NAME).item(0).getTextContent());
                this.m_ratingRecomendacaoGlobal = Integer.parseInt(elem.getElementsByTagName(RATING_REC_GLOBAL_ATTR_NAME).item(0).getTextContent());
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
            Document document = XMLParser.createDocument();

            Element elementBase = document.createElement(ROOT_ELEMENT_NAME);
            document.appendChild(elementBase);

            Element elemChild = document.createElement(JUSTIFICACAO_ELEMENT_NAME);
            elemChild.setTextContent(this.m_justificacao);
            elementBase.appendChild(elemChild);

            elemChild = document.createElement(RATING_ADEQ_DEMOS_ATTR_NAME);
            elemChild.setTextContent(String.valueOf(this.m_ratingAdequacaoAsDemos));
            elementBase.appendChild(elemChild);

            elemChild = document.createElement(RATING_ADEQ_EXPOSICAO_ATTR_NAME);
            elemChild.setTextContent(String.valueOf(this.m_ratingAdequacaoAExposicao));
            elementBase.appendChild(elemChild);

            elemChild = document.createElement(RATING_ADEQ_NUM_CONVITES_ATTR_NAME);
            elemChild.setTextContent(String.valueOf(this.m_ratingAdequacaoNumConvites));
            elementBase.appendChild(elemChild);

            elemChild = document.createElement(RATING_CONHECIMENTO_TEMA_ATTR_NAME);
            elemChild.setTextContent(String.valueOf(this.m_ratingConhecimentoSobreOTema));
            elementBase.appendChild(elemChild);

            elemChild = document.createElement(RATING_REC_GLOBAL_ATTR_NAME);
            elemChild.setTextContent(String.valueOf(this.m_ratingRecomendacaoGlobal));
            elementBase.appendChild(elemChild);

            node = elementBase;

        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Avaliacao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return node;
    }
}
