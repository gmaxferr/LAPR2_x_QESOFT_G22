package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.estados.Estado;

/**
 *
 * @author guima
 */
public abstract class EstadoCandidaturaADemonstracao implements Estado {

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
