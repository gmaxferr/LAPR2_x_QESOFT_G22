package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 * Representação doEstadoCandidaturaADemonstracaoRemovida
 * 
 * @author G29
 */
public class EstadoCandidaturaADemonstracaoRemovida extends EstadoCandidaturaADemonstracao {

    public EstadoCandidaturaADemonstracaoRemovida(CandidaturaADemonstracao cand) {
        super(cand);
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoRemovida() {
        return true;
    }
}
