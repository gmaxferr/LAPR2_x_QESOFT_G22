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
public class EstadoCandidaturaAExposicaoStandAceite extends EstadoCandidaturaAExposicao {

    private final CandidaturaAExposicao m_cand;

    public EstadoCandidaturaAExposicaoStandAceite(CandidaturaAExposicao m_cand) {
        this.m_cand = m_cand;
    }

    @Override
    public boolean setEstadoCandidaturaStandAceite() {
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaStandAceite() {
        return true;
    }

}
