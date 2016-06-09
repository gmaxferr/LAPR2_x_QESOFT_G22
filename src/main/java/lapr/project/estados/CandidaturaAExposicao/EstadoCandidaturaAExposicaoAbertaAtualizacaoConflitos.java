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
public class EstadoCandidaturaAExposicaoAbertaAtualizacaoConflitos implements EstadoCandidaturaAExposicao{
    
    private CandidaturaAExposicao m_c;
    
    public EstadoCandidaturaAExposicaoAbertaAtualizacaoConflitos (CandidaturaAExposicao c){
        this.m_c = c;
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
        return true;
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
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaCriada() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaAbertaAtualizacaoConflitos() {
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
    public boolean isEstadoCandidaturaAceite() {
        return false;
    }

    @Override
    public boolean isEstadoCandidaturaRejeitada() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaProntaAtribuicoes() {
        m_c.setEstado(new EstadoCandidaturaAExposicaoProntaAtribuicoes(m_c));
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaProntaAtribuicoes() {
        return false;
    }

    
    
}
