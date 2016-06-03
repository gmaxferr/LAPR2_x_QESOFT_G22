package lapr.project.estados;

import lapr.project.model.CandidaturaAExposicao;

/**
 *
 * @author Ana Leite
 */
public class EstadoCandidaturaAExposicaoAvaliada implements EstadoCandidaturaAExposicao {

    private CandidaturaAExposicao cand;

    public EstadoCandidaturaAExposicaoAvaliada(CandidaturaAExposicao cand) {
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
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaAceite() {
        //falta implementar
    }

    @Override
    public boolean setEstadoCandidaturaRejeitada() {
        //falta implementar
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
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaAvaliada() {
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaAceite() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaRejeitada() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaRemovida() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaRemovida() {
        return false;
    }

}
