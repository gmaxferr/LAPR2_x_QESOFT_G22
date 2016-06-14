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
public class EstadoCandidaturaAExposicaoNaoAvaliada extends EstadoCandidaturaAExposicao {

    public EstadoCandidaturaAExposicaoNaoAvaliada(CandidaturaAExposicao cand) {
        super(cand);
    }

    @Override
    public boolean setEstadoCandidaturaNaoAvaliada() {
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaNaoAvaliada() {
        return true;
    }
}
