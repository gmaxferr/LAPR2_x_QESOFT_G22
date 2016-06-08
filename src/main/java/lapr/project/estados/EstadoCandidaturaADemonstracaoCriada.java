package lapr.project.estados;

import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author guima
 */
public class EstadoCandidaturaADemonstracaoCriada implements EstadoCandidaturaADemonstracao{

    CandidaturaADemonstracao cand;
    
    public EstadoCandidaturaADemonstracaoCriada(CandidaturaADemonstracao cand) {
        this.cand = cand;
    }


    @Override
    public boolean setEstadoCandidaturaInstanciada() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaCriada() {
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaInstanciada() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaCriada() {
        return true;
    }
    
}
