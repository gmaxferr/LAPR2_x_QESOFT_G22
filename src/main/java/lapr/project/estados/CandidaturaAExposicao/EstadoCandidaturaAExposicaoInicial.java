package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;

/**
 *
 * @author Ricardo Osorio
 */
public class EstadoCandidaturaAExposicaoInicial extends EstadoCandidaturaAExposicao {

    private CandidaturaAExposicao m_cand;

    public EstadoCandidaturaAExposicaoInicial(CandidaturaAExposicao cand) {
        this.m_cand = cand;
    }

    @Override
    public boolean setEstadoCandidaturaInicial() {
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaCriada() {
        if (valida()) {
            this.m_cand.setEstado(new EstadoCandidaturaAExposicaoCriada(m_cand));
            return true;
        }
        return false;
    }

    private boolean valida() {
        //TODO
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaIncial() {
        return true;
    }

}
