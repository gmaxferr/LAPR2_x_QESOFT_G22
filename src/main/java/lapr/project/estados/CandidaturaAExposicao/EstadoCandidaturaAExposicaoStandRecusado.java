package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;

/**
 * Representação do EstadoCandidaturaAExposicaoStandRecusado
 * 
 * @author G29
 */
public class EstadoCandidaturaAExposicaoStandRecusado extends EstadoCandidaturaAExposicao {

    public EstadoCandidaturaAExposicaoStandRecusado(CandidaturaAExposicao cand) {
        super(cand);
    }


    @Override
    public boolean isEstadoCandidaturaStandRecusado() {
        return true;
    }

}
