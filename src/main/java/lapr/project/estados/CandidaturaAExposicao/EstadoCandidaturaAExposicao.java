package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.estados.Estado;
import lapr.project.model.CandidaturaAExposicao;

/**
 * Representação do EstadoCandidaturaAExposicao
 * 
 * @author G29
 */
public abstract class EstadoCandidaturaAExposicao implements Estado {

    final CandidaturaAExposicao m_cand;

    public EstadoCandidaturaAExposicao(CandidaturaAExposicao cand) {
        this.m_cand = cand;
    }

    public boolean setEstadoCandidaturaInicial() {
        return false;
    }

    public boolean setEstadoCandidaturaCriada() {
        return false;
    }
    
    public boolean setEstadoCandidaturaRemovida() {
        return false;
    }

    public boolean setEstadoCandidaturaAbertaAtualizacaoConflitos() {
        return false;
    }

    public boolean setEstadoCandidaturaAtribuida() {
        return false;
    }

    public boolean setEstadoCandidaturaAvaliada() {
        return false;
    }

    public boolean setEstadoCandidaturaAceite() {
        return false;
    }

    public boolean setEstadoCandidaturaRejeitada() {
        return false;
    }

    public boolean setEstadoCandidaturaProntaAtribuicoes() {
        return false;
    }

    public boolean setEstadoCandidaturaNaoAvaliada() {
        return false;
    }

    public boolean setEstadoCandidaturaStandAceite() {
        return false;
    }

    public boolean setEstadoCandidaturaStandRecusado() {
        return false;
    }

    public boolean setEstadoCandidaturaStandsAtribuidos() {
        return false;
    }

    public boolean isEstadoCandidaturaIncial() {
        return false;
    }

    public boolean isEstadoCandidaturaCriada() {
        return false;
    }

    public boolean isEstadoCandidaturaRemovida() {
        return false;
    }
    
    public boolean isEstadoCandidaturaAbertaAtualizacaoConflitos() {
        return false;
    }

    public boolean isEstadoCandidaturaAtribuida() {
        return false;
    }

    public boolean isEstadoCandidaturaAvaliada() {
        return false;
    }

    public boolean isEstadoCandidaturaAceite() {
        return false;
    }

    public boolean isEstadoCandidaturaRejeitada() {
        return false;
    }

    public boolean isEstadoCandidaturaProntaAtribuicoes() {
        return false;
    }

    public boolean isEstadoCandidaturaNaoAvaliada() {
        return false;
    }

    public boolean isEstadoCandidaturaStandAceite() {
        return false;
    }

    public boolean isEstadoCandidaturaStandRecusado() {
        return false;
    }

    public boolean isEstadoCandidaturaStandsAtribuidos() {
        return false;
    }
}
