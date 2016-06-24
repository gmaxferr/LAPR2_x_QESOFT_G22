package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;

/**
 * Representação do EstadoCandidaturaAExposicaoAbertaAtualizacaoConflitos
 *
 * @author G29
 */
public class EstadoCandidaturaAExposicaoAbertaAtualizacaoConflitos extends EstadoCandidaturaAExposicao {

    public EstadoCandidaturaAExposicaoAbertaAtualizacaoConflitos(CandidaturaAExposicao cand) {
        super(cand);
    }

    @Override
    public boolean setEstadoCandidaturaProntaAtribuicoes() {
        if (valida()) {
            this.m_cand.setEstado(new EstadoCandidaturaAExposicaoProntaAtribuicoes(m_cand));
            return true;
        }
        return false;
    }

    private boolean valida() {
        //TODO
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaAbertaAtualizacaoConflitos() {
        return true;
    }
}
