package lapr.project.estados;

import classesREMOVIDAS.Candidatura;

/**
 *
 * @author Ana Leite
 */
public class EstadoCandidaturaAtribuida implements EstadoCandidatura {

    private Candidatura cand;

    public EstadoCandidaturaAtribuida(Candidatura cand) {
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
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaAvaliada() {
        if (valida()){
            cand.setEstado(new EstadoCandidaturaAvaliada(cand));
            return true;
        } else return false;
    }
  
    private boolean valida() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado (verificação de atributos)
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaCriada() {
        return false;
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
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaAvaliada() {
        return false;
    }
}

