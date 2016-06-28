package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;

/**
 * Represnetação do EstadoCandidaturaAExposicaoAvaliada
 * 
 * @author G29
 */
public class EstadoCandidaturaAExposicaoAvaliada extends EstadoCandidaturaAExposicao {

    public EstadoCandidaturaAExposicaoAvaliada(CandidaturaAExposicao cand) {
        super(cand);
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
