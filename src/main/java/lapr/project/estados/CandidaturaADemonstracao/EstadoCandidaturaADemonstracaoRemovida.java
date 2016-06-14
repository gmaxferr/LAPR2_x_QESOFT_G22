package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author guilherme
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
