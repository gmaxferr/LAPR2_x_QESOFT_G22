package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;

/**
 * Representação do EstadoCandidaturaAExposicaoAceite
 * 
 * @author G29
 */
public class EstadoCandidaturaAExposicaoAceite extends EstadoCandidaturaAExposicao {

    public EstadoCandidaturaAExposicaoAceite(CandidaturaAExposicao cand) {
        super(cand);
    }

    @Override
    public boolean setEstadoCandidaturaStandsAtribuidos() {
        if (valida()) {
            this.m_cand.setEstado(new EstadoCandidaturaAExposicaoStandsAtribuidos(m_cand));
            return true;
        }
        return false;
    }

    private boolean valida() {
        //TODO
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaAceite() {
        return true;
    }
}
