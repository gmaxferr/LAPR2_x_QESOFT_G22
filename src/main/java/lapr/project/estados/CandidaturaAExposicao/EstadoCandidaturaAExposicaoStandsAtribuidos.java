package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;

/**
 * Represnetação do EstadoCandidaturaAExposicaoStandsAtribuidos
 * 
 * @author G29
 */
public class EstadoCandidaturaAExposicaoStandsAtribuidos extends EstadoCandidaturaAExposicao{

    public EstadoCandidaturaAExposicaoStandsAtribuidos(CandidaturaAExposicao cand) {
        super(cand);
    }

    @Override
    public boolean setEstadoCandidaturaStandAceite() {
        this.m_cand.setEstado(new EstadoCandidaturaAExposicaoStandAceite(m_cand));
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaStandRecusado() {
        this.m_cand.setEstado(new EstadoCandidaturaAExposicaoStandRecusado(m_cand));
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaStandsAtribuidos() {
        return true;
    }
}
