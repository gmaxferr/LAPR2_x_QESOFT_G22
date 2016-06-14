package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;

/**
 *
 * @author Ana Leite
 */
public class EstadoCandidaturaAExposicaoAvaliada extends EstadoCandidaturaAExposicao {

    private CandidaturaAExposicao m_cand;

    public EstadoCandidaturaAExposicaoAvaliada(CandidaturaAExposicao cand) {
        this.m_cand = cand;
    }

    @Override
    public boolean setEstadoCandidaturaAceite() {
        m_cand.setEstado(new EstadoCandidaturaAExposicaoAceite(m_cand));
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaRejeitada() {
        m_cand.setEstado(new EstadoCandidaturaAExposicaoRejeitada(m_cand));
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaAvaliada() {
        return true;
    }
}
