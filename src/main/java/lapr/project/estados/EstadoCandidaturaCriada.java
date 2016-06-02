package lapr.project.estados;

import lapr.project.model.Candidatura;

/**
 *
 * @author Ana Leite
 */
public class EstadoCandidaturaCriada implements EstadoCandidatura {

    private Candidatura cand;

    public EstadoCandidaturaCriada(Candidatura cand) {
        this.cand = cand;
    }

    @Override
    public boolean setEstadoCandidaturaCriada() {
        return true;
    }

    @Override
    public boolean setEstadoConflitosDetetados() {
        if (valida()) {
            this.cand.setEstado(new EstadoCandidaturaConflitosDetetados(this.cand));
            return true;
        } else {
            return false;
        }
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

    private boolean valida() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado (verificação de atributos)
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaCriada() {
        return true;
    }

    @Override
    public boolean isEstadoConflitosDetetados() {
        return false;
    }

    @Override
    public boolean isEstadoConflitosAtribuidos() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaAtribuida() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaAvaliada() {
        return false;
    }

}
