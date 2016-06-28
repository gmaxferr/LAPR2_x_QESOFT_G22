package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;

/**
 * Representação do EstadoCandidaturaAExposicaoStandAceite
 * 
 * @author G29
 */
public class EstadoCandidaturaAExposicaoStandAceite extends EstadoCandidaturaAExposicao {

    public EstadoCandidaturaAExposicaoStandAceite(CandidaturaAExposicao cand) {
        super(cand);
    }


    @Override
    public boolean isEstadoCandidaturaStandAceite() {
        return true;
    }

}
