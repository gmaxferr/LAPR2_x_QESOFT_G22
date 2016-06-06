/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.registos.RegistoCandidaturasRemovidas;
import lapr.project.model.*;
import lapr.project.registos.RegistoCandidaturasAExposicao;
import lapr.project.registos.RegistoExposicoes;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class RemoverCandidaturaExpoController {

    private Exposicao exposicaoSelecionada;
    private String username;
    private CentroExposicoes ce;
    private RegistoCandidaturasAExposicao rc;
    private CandidaturaAExposicao candidaturaARemover;

    /**
     * Construtor do controller da UC18 - remover candidatura a uma exposição
     *
     * @param username - username do utilizador logado
     * @param ce - centro de exposições
     */
    public RemoverCandidaturaExpoController(String username, CentroExposicoes ce) {
        this.username = username;
        this.ce = ce;
    }

    /**
     * Seleciona a exposição a remover
     *
     * @param e - exposição a remover
     */
    public void setExposicao(Exposicao e) {
        exposicaoSelecionada = e;
    }

    /**
     * Obtém a lista de exposições em que o representante logado possui
     * candidaturas
     *
     * @param username - username do representante
     * @return - lista de exposições em que o representante logado possui
     * candidaturas
     */
    public List<Exposicao> getExposRepresentante(String username) {
        List<Exposicao> exposicoesLst = new ArrayList();
        RegistoExposicoes re = ce.getRegistoExposicoes();
        exposicoesLst = re.getExposicoesDoRepresentante(username);
        return exposicoesLst;
    }

    /**
     * Obtém a lista de candidaturas do representante
     *
     * @param username - username do representante
     * @return - lista de candidaturas do representante
     */
    public List<CandidaturaAExposicao> getListaCandidaturas(String username) {
        List<CandidaturaAExposicao> candidaturasLst = new ArrayList();
        rc = exposicaoSelecionada.getRegistoCandidaturas();
        candidaturasLst = rc.getCandidaturasRepresentante(username);
        return candidaturasLst;
    }

    public void setCandidaturaARemover(CandidaturaAExposicao c) {
         candidaturaARemover = c;
    }

    public void removerCandidatura() {
        rc.removeCandidatura(candidaturaARemover);
        RegistoCandidaturasRemovidas rcr = exposicaoSelecionada.getRegistoCandidaturasRemovidas();
        rcr.adicionarCandidatura(candidaturaARemover);
    }

}
