package lapr.project.estados;

import lapr.project.model.Candidatura;

/**
 *
 * @author Ana Leite
 */
public class EstadoCandidaturaAvaliada implements EstadoCandidatura {

    private Candidatura cand;

    public EstadoCandidaturaAvaliada(Candidatura cand) {
        this.cand = cand;
    }

    @Override
    public boolean setEstadoCandidaturaCriada() {
        return false;
    }

    @Override
    public boolean setEstadoConflitosDetetados() {
        return false;
    }

    @Override
    public boolean setEstadoConflitosAtribuidos() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaAtribuida() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaAvaliada() {
        return false;
    }

}
