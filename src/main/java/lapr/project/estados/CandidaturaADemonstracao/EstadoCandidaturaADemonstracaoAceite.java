package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 * Representação do EstadoCandidaturaADemonstracaoAceite
 * 
 * @author G29
 */
public class EstadoCandidaturaADemonstracaoAceite extends EstadoCandidaturaADemonstracao {

    public EstadoCandidaturaADemonstracaoAceite(CandidaturaADemonstracao cand) {
        super(cand);
    }

    @Override
    public boolean isEstadoCandidaturaADemonstracaoAceite() {
        return true;
    }
}
