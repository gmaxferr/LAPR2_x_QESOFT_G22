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
public class EstadoCandidaturaAExposicaoAbertaAtualizacaoConflitos extends EstadoCandidaturaAExposicao{
    
    private CandidaturaAExposicao m_cand;
    
    public EstadoCandidaturaAExposicaoAbertaAtualizacaoConflitos (CandidaturaAExposicao c){
        this.m_cand = c;
    }
    
    @Override
    public boolean setEstadoCandidaturaAbertaAtualizacaoConflitos() {
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaProntaAtribuicoes() {
        if (valida()) {
            this.m_cand.setEstado(new EstadoCandidaturaAExposicaoProntaAtribuicoes(m_cand));
            return true;
        }
        return false;
    }

    private boolean valida() {
        //TODO
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaAbertaAtualizacaoConflitos() {
        return true;
    }
}
