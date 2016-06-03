package lapr.project.estados;

import lapr.project.model.CandidaturaAExposicao;

/**
 *
 * @author Ana Leite
 */
public class EstadoCandidaturaAExposicaoCriada implements EstadoCandidaturaAExposicao {

    private CandidaturaAExposicao cand;

    public EstadoCandidaturaAExposicaoCriada(CandidaturaAExposicao cand) {
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
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaRejeitada() {
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
        this.cand.setEstado(new EstadoCandidaturaAExposicaoRemovida());
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaRemovida() {
        return false;
    }

}
