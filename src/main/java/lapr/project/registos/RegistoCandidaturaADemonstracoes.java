/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CandidaturaADemonstracao;

/**
 *
 * @author guima
 */
public class RegistoCandidaturaADemonstracoes {

    List<CandidaturaADemonstracao> listaCandidaturasADemonstracao;

    public RegistoCandidaturaADemonstracoes() {
        listaCandidaturasADemonstracao = new ArrayList<>();
    }

    /**
     * Adiciona uma candidatura à lista de candidaturas à demonstração que
     * possui este registo.
     *
     * @param cand - candidatura a adicionar
     * @return true se a adição for bem sucedida; false caso contrário.
     */
    public boolean adiciona(CandidaturaADemonstracao cand) {
        boolean valido = false;
        if (isValid(cand)) {
            listaCandidaturasADemonstracao.add(cand);
            valido = true;
        }
        return valido;
    }

    /**
     * Valida globalmente a candidatura à demonstração, vendo se já existe na
     * lista deste registo ou não.
     *
     * @param cand - Candidatura a sofrer validação
     * @return true se for válida; false caso contrário
     */
    public boolean isValid(CandidaturaADemonstracao cand) {
        return !listaCandidaturasADemonstracao.contains(cand);
    }
}
