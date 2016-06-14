package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author guilherme
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
