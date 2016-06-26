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
        this.m_cand.setEstado(new EstadoCandidaturaAExposicaoProntaAtribuicoes(m_cand));
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaAbertaAtualizacaoConflitos() {
        return true;
    }
}
