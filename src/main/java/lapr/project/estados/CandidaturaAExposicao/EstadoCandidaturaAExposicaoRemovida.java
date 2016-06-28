package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;

/**
 * Represnetação do EstadoCandidaturaAExposicaoRemovida
 * 
 * @author G29
 */
public class EstadoCandidaturaAExposicaoRemovida extends EstadoCandidaturaAExposicao {

    public EstadoCandidaturaAExposicaoRemovida(CandidaturaAExposicao cand) {
        super(cand);
    }

    @Override
    public boolean isEstadoCandidaturaRemovida() {
        return true;
    }

}
