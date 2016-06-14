package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author guilherme
 */
public class EstadoCandidaturaADemonstracaoRecusada extends EstadoCandidaturaADemonstracao {

    public EstadoCandidaturaADemonstracaoRecusada(CandidaturaADemonstracao cand) {
        super(cand);
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoRecusada() {
        return true;
    }

}