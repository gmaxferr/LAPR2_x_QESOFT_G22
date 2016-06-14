package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.estados.Estado;
import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author guima
 */
public abstract class EstadoCandidaturaADemonstracao implements Estado {

    final CandidaturaADemonstracao m_cand;

    public EstadoCandidaturaADemonstracao(CandidaturaADemonstracao cand) {
        this.m_cand = cand;
    }

    public boolean setEstadoCandidaturaInstanciada() {
        return false;
    }

    public boolean setEstadoCandidaturaCriada() {
        return false;
    }

    public boolean setEstadoCandidaturaAtribuida() {
        return false;
    }

    public boolean setEstadoCandidaturaAvaliada() {
        return false;
    }

    public boolean isEstadoCandidaturaInstanciada() {
        return false;
    }

    public boolean isEstadoCandidaturaCriada() {
        return false;
    }

    public boolean isEstadoCandidaturaAtribuida() {
        return false;
    }

    public boolean isEstadoCandidaturaAvaliada() {
        return false;
    }

}
