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
public class EstadoCandidaturaAExposicaoProntaAtribuicoes extends EstadoCandidaturaAExposicao {

    public EstadoCandidaturaAExposicaoProntaAtribuicoes(CandidaturaAExposicao cand) {
        super(cand);
    }

    @Override
    public boolean setEstadoCandidaturaAtribuida() {
        m_cand.setEstado(new EstadoCandidaturaAExposicaoAtribuida(m_cand));
        return true;
    }

    @Override
    public boolean setEstadoCandidaturaProntaAtribuicoes() {
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaProntaAtribuicoes() {
        return true;
    }

}
