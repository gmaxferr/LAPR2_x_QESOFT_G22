/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.model.CandidaturaAExposicao;

/**
 *
 * @author osori
 */
public class EstadoCandidaturaAExposicaoAceite extends EstadoCandidaturaAExposicao {

    public EstadoCandidaturaAExposicaoAceite(CandidaturaAExposicao cand) {
        super(cand);
    }

    @Override
    public boolean setEstadoCandidaturaAceite() {
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaStandsAtribuidos() {
        if (valida()) {
            this.m_cand.setEstado(new EstadoCandidaturaAExposicaoStandsAtribuidos(m_cand));
            return true;
        }
        return false;
    }

    private boolean valida() {
        //TODO
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaAceite() {
        return true;
    }
}
