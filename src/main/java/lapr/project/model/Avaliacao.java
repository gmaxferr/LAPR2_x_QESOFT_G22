package lapr.project.model;

/**
 *
 * @author Ricardo Osorio
 */
public class Avaliacao {

    private int ratingConhecimentoSobreOTema;
    private int ratingAdequacaoAExposicao;
    private int ratingAdequacaoAsDemos;
    private int ratingAdequacaoNumConvites;
    private int ratingRecomendacaoGlobal;
    private boolean avaliacao;
    private String justificacao;

    public Avaliacao() {
        this.justificacao = null;
    }

    public boolean verificaAvaliacaoJaTomada() {
        if (!this.justificacao.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean getAvaliacao() {
        return this.avaliacao;
    }

    public String getJustificacao() {
        return this.justificacao;
    }

    public int getRatingConhecimentoSobreOTema() {
        return ratingConhecimentoSobreOTema;
    }

    public int getRatingAdequacaoAExposicao() {
        return ratingAdequacaoAExposicao;
    }

    public int getRatingAdequacaoAsDemos() {
        return ratingAdequacaoAsDemos;
    }

    public int getRatingAdequacaoNumConvites() {
        return ratingAdequacaoNumConvites;
    }

    public int getRatingRecomendacaoGlobal() {
        return ratingRecomendacaoGlobal;
    }

    public void setAvalicao(boolean avaliacao, String justificacao, int ratingConhecimentoSobreTema, int ratingAdequacaoAExposicao, int ratingAdequacaoAsDemos, int ratingAdequacaoNumConvites, int ratingRecomendacaoGlobal) {
        this.avaliacao = avaliacao;
        this.justificacao = justificacao;
        this.ratingConhecimentoSobreOTema = ratingConhecimentoSobreTema;
        this.ratingAdequacaoAExposicao = ratingAdequacaoAExposicao;
        this.ratingAdequacaoAsDemos = ratingAdequacaoAsDemos;
        this.ratingAdequacaoNumConvites = ratingAdequacaoNumConvites;
        this.ratingRecomendacaoGlobal = ratingRecomendacaoGlobal;
    }

}
