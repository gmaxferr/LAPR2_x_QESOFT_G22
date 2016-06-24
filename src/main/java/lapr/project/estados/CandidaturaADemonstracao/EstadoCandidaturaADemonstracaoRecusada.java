package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 * Representação do EstadoCandidaturaADemonstracaoRecusada
 * 
 * @author G29
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
