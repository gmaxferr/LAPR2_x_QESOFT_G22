/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class EstadoCandidaturaAExposicaoProntaAtribuicoes implements EstadoCandidaturaAExposicao{

    private CandidaturaAExposicao m_cand;
    
    public EstadoCandidaturaAExposicaoProntaAtribuicoes (CandidaturaAExposicao cand){
        this.m_cand = cand;
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
    public boolean setEstadoCandidaturaAbertaAtualizacaoConflitos() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaAtribuida() {
        m_cand.setEstado(new EstadoCandidaturaAExposicaoAtribuida(m_cand));
        return true;
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
    public boolean setEstadoCandidaturaProntaAtribuicoes() {
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
    public boolean isEstadoCandidaturaAbertaAtualizacaoConflitos() {
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
    public boolean isEstadoCandidaturaProntaAtribuicoes() {
        return true;
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
