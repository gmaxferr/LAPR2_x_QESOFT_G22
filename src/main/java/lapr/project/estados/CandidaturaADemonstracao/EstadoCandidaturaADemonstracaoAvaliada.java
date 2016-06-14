package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author Ana Leite
 */
public class EstadoCandidaturaADemonstracaoAvaliada extends EstadoCandidaturaADemonstracao {

    public EstadoCandidaturaADemonstracaoAvaliada(CandidaturaADemonstracao cand) {
        super(cand);
    }

    @Override
    public boolean setEstadoCandidaturaAvaliada() {
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaAvaliada() {
        return true;
    }

}
