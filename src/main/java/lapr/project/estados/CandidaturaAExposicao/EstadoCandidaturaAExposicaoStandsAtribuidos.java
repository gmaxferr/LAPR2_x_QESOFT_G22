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
public class EstadoCandidaturaAExposicaoStandsAtribuidos extends EstadoCandidaturaAExposicao{

    public EstadoCandidaturaAExposicaoStandsAtribuidos(CandidaturaAExposicao cand) {
        super(cand);
    }

    @Override
    public boolean setEstadoCandidaturaStandAceite() {
        this.m_cand.setEstado(new EstadoCandidaturaAExposicaoStandAceite(m_cand));
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaStandRecusado() {
        this.m_cand.setEstado(new EstadoCandidaturaAExposicaoStandRecusado(m_cand));
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaStandsAtribuidos() {
        return true;
    }
}
