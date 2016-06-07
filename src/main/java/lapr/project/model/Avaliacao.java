package lapr.project.model;

/**
 *
 * @author Ricardo Osorio
 */
public class Avaliacao {

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

}
