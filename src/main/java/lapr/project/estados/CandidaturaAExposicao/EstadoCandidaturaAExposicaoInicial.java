package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;

/**
 * Representação do EstadoCandidaturaAExposicaoInicial
 * 
 * @author G29
 */
public class EstadoCandidaturaAExposicaoInicial extends EstadoCandidaturaAExposicao {

    public EstadoCandidaturaAExposicaoInicial(CandidaturaAExposicao cand) {
        super(cand);
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
