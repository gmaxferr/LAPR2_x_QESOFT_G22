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
    public boolean setEstadoCandidaturaInicial() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaCriada() {
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
        cand.setEstado(new EstadoCandidaturaAExposicaoAceite(cand));
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaRejeitada() {
        cand.setEstado(new EstadoCandidaturaAExposicaoRejeitada(cand));
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaIncial() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaCriada() {
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
    public boolean setEstadoCandidaturaAbertaAtualizacaoConflitos() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaProntaAtribuicoes() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaAbertaAtualizacaoConflitos() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaProntaAtribuicoes() {
        return false;
    }


}
