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
public class EstadoCandidaturaAExposicaoRejeitada extends EstadoCandidaturaAExposicao {

    private CandidaturaAExposicao m_cand;

    public EstadoCandidaturaAExposicaoRejeitada(CandidaturaAExposicao cand) {
        this.m_cand = cand;
    }

    @Override
    public boolean setEstadoCandidaturaRejeitada() {
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaRejeitada() {
        return true;
    }

}
