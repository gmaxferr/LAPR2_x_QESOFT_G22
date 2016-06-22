package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;

/**
 *
 * @author Ricardo Catalao
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
