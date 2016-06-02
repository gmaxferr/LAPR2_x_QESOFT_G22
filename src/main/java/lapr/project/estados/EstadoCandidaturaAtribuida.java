package lapr.project.estados;

import lapr.project.model.Candidatura;

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

        return true;
    }

    @Override
    public boolean setEstadoConflitosDetetados() {
        return true;    
    }

    @Override
    public boolean setEstadoConflitosAtribuidos() {
        return true;
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
}

