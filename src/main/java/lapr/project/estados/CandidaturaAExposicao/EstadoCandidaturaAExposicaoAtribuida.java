package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;

/**
 * Representação do EstadoCandidaturaAExposicaoAtribuida
 * 
 * @author G29
 */
public class EstadoCandidaturaAExposicaoAtribuida extends EstadoCandidaturaAExposicao {

    public EstadoCandidaturaAExposicaoAtribuida(CandidaturaAExposicao cand) {
        super(cand);
    }


    @Override
    public boolean setEstadoCandidaturaAvaliada() {
        if (valida()) {
            this.m_cand.setEstado(new EstadoCandidaturaAExposicaoAvaliada(m_cand));
            return true;
        }
        return false;
    }

    private boolean valida() {
        //TODO
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaAtribuida() {
        return true;
    }
}
