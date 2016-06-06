package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.EstadoCandidaturaAExposicao;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 *
 * @author osorio
 */
public class DecidirCandidaturasAExposicaoController {

    private Exposicao exposicaoSelecionada;
    private CandidaturaAExposicao candidaturaSelecionada;
    private RegistoCandidaturasAExposicao rc;
    private RegistoExposicoes re;
    private CentroExposicoes ce;
    private GestorDeExposicoes gestorDeExposicoes;
    private RegistoProdutos rp;

    public DecidirCandidaturasAExposicaoController(CentroExposicoes ce, GestorDeExposicoes gestorDeExposicoes) {
        this.ce = ce;
        this.gestorDeExposicoes = gestorDeExposicoes;
    }

    public void getRegistoExposicoes() {
        this.re = ce.getRegistoExposicoes();
    }

    public ArrayList<Exposicao> getListaExposicoesEstadoCandidaturasAvaliadas() {
        return this.re.getListaExposicoesEstadoCandidaturasAvaliadas();
    }

    public void setExposicao(Exposicao exposicao) {
        this.exposicaoSelecionada = exposicao;
    }

    public void getRegistoCandidaturas() {
        this.rc = this.exposicaoSelecionada.getRegistoCandidaturasAExposicao();
    }

    public void getRegistoProdutos() {
        this.rp = this.candidaturaSelecionada.getRegistoProdutos();
    }

    /*
        lista de candidaturas de uma das expos no estado EstadoExposicaoCandidaturasAvaliadas 
        logo todas estarão no estado EstadoCandidaturasAExposicaoAvaliada
     */
    public List<CandidaturaAExposicao> getListaCandidaturas() {
        return this.rc.getListaCandidaturasAExposicao();
    }

    public naosei getDadosEstatisticosGerais() {
        return naosei;
    }

    //a espera de implementarem os vossos models
    public void setCandidatura(CandidaturaAExposicao cand) {
        this.candidaturaSelecionada = cand;
    }

    public String getNomeEmpresa() {
        return this.candidaturaSelecionada.getM_StrNomeEmpresa();
    }

    public String getMoradaEmpresa() {
        return this.candidaturaSelecionada.getM_StrMoradaEmpresa();
    }

    public int getTelemovel() {
        return this.candidaturaSelecionada.getM_intTelemovel();
    }

    public int getArea() {
        return this.candidaturaSelecionada.getM_intArea();
    }

    public int getNumeroConvites() {
        return this.candidaturaSelecionada.getM_intNumConvites();
    }

    public naoSei getKeywords() {
        return naoSei;
    }

    public void setDecisao(boolean decisao) {
        this.candidaturaSelecionada.setDecisao(decisao);
        if (decisao) {
            setEstadoCandidaturaAceite();
        } else {
            setEstadoCandidaturaRejeitada();
        }
    }

    private void setEstadoCandidaturaAceite() {
        EstadoCandidaturaAExposicao estado = this.candidaturaSelecionada.getEstado();
        estado.setEstadoCandidaturaAceite();
    }

    private void setEstadoCandidaturaRejeitada() {
        EstadoCandidaturaAExposicao estado = this.candidaturaSelecionada.getEstado();
        estado.setEstadoCandidaturaRejeitada();
    }

}
