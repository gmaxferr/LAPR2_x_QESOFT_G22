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
public class EstadoCandidaturaAExposicaoStandRecusado extends EstadoCandidaturaAExposicao {

    public EstadoCandidaturaAExposicaoStandRecusado(CandidaturaAExposicao cand) {
        super(cand);
    }


    @Override
    public boolean isEstadoCandidaturaStandRecusado() {
        return true;
    }

}
