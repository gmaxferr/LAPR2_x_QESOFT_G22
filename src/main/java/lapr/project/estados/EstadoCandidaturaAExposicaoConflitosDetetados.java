package lapr.project.estados;

import classesREMOVIDAS.Candidatura;

/**
 *
 * @author Ricardo Osório Ana Leite
 */
public class EstadoCandidaturaAExposicaoConflitosDetetados implements EstadoCandidaturaAExposicao {

    private Candidatura cand;

    public EstadoCandidaturaAExposicaoConflitosDetetados(Candidatura cand) {
        this.cand = cand;
    }

    @Override
    public boolean setEstadoCandidaturaCriada() {
        return false;
    }

    @Override
    public boolean setEstadoConflitosDetetados() {
        return true;

    }

    @Override
    public boolean setEstadoConflitosAtribuidos() {
        if (valida()) {
            this.cand.setEstado(new EstadoCandidaturaAExposicaoConflitosAtribuidos(this.cand));
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean setEstadoCandidaturaAtribuida() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaAvaliada() {
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
        return true;
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
