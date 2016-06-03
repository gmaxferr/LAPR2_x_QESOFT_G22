package lapr.project.estados;

import classesREMOVIDAS.Candidatura;

/**
 *
 * @author Ana Leite
 */
public class EstadoCandidaturaAExposicaoConflitosAtribuidos implements EstadoCandidaturaAExposicao {

    private Candidatura cand;

    public EstadoCandidaturaAExposicaoConflitosAtribuidos(Candidatura cand) {
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
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaAtribuida() {
        if (valida()) {
            this.cand.setEstado(new EstadoCandidaturaAExposicaoAvaliada(this.cand));
            return true;
        } else {
            return false;
        }
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
        return false;
    }

    @Override
    public boolean isEstadoConflitosDetetados() {
        return false;
    }

    @Override
    public boolean isEstadoConflitosAtribuidos() {
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaAtribuida() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaAvaliada() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaAceite() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setEstadoCandidaturaRejeitada() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
