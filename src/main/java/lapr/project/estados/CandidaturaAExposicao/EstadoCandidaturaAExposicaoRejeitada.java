package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;

/**
 * Represnetação do EstadoCandidaturaAExposicaoRejeitada
 * 
 * @author G29
 */
public class EstadoCandidaturaAExposicaoRejeitada extends EstadoCandidaturaAExposicao {

    public EstadoCandidaturaAExposicaoRejeitada(CandidaturaAExposicao cand) {
        super(cand);
    }

    @Override
    public boolean isEstadoCandidaturaRejeitada() {
        return true;
    }

}
