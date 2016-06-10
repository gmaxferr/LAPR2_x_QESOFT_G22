package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;

/**
 *
 * @author Ricardo Osorio
 */
public class EstadoCandidaturaAExposicaoInicial implements EstadoCandidaturaAExposicao {

    private CandidaturaAExposicao m_cand;

    public EstadoCandidaturaAExposicaoInicial(CandidaturaAExposicao cand) {
        this.m_cand = cand;
    }

    @Override
    public boolean setEstadoCandidaturaInicial() {
        return true;
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
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaRejeitada() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaIncial() {
        return true;
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

    @Override
    public boolean setEstadoCandidaturaNaoAvaliada() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaStandAceite() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaStandRecusado() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaStandsAtribuidos() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaNaoAvaliada() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaStandAceite() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaStandRecusado() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaStandsAtribuidos() {
        return false;
    }

}
