package lapr.project.estados;

import classesREMOVIDAS.Candidatura;

/**
 *
 * @author Ana Leite
 */
public class EstadoCandidaturaAExposicaoCriada implements EstadoCandidaturaAExposicao {

    private Candidatura cand;

    public EstadoCandidaturaAExposicaoCriada(Candidatura cand) {
        this.cand = cand;
    }

    @Override
    public boolean setEstadoCandidaturaCriada() {
        return true;
    }

    @Override
    public boolean setEstadoConflitosDetetados() {
        if (valida()) {
            this.cand.setEstado(new EstadoCandidaturaAExposicaoConflitosDetetados(this.cand));
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
