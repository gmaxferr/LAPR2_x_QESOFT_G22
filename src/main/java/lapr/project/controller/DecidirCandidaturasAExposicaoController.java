package lapr.project.controller;

import java.util.ArrayList;
import lapr.project.estados.EstadoCandidaturaAExposicao;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.registos.RegistoCandidaturas;
import lapr.project.registos.RegistoExposicoes;

/**
 *
 * @author osori
 */
public class DecidirCandidaturasAExposicaoController {

    //a espera de implementarem os vossos models para fazer imports certos
    private Exposicao exposicaoSelecionada;
    private CandidaturaAExposicao candidaturaSelecionada;
    private RegistoCandidaturas rc;
    private RegistoExposicoes re;
    private CentroExposicoes ce;

    //a espera de implementarem os vossos models
    public DecidirCandidaturasAExposicaoController(CentroExposicoes ce) {
        this.ce = ce;
    }

    public void getRegistoExposicoes() {
        this.re = ce.getRegistoExposicoes();
    }

    //a espera de implementarem os vossos models
    public ArrayList<Exposicao> getListaExposicoesEstadoCandidaturasAvaliadas() {
        return this.re.getListaExposicoesEstadoCandidaturasAvaliadas();
    }

    //a espera de implementarem os vossos models
    public void setExposicao(Exposicao exposicao) {
        this.exposicaoSelecionada = exposicao;
    }

    //a espera de implementarem os vossos models
    public ArrayList<CandidaturaAExposicao> getListaCandidaturasEstadoAvaliadas() {
        this.rc = this.exposicaoSelecionada.getRegistoCandidaturas();
        return this.rc.getListaCandidaturasEstadoAvaliadas();
    }

    public naosei getDadosEstatisticosGerais() {
        return naosei;
    }

    //a espera de implementarem os vossos models
    public void setCandidatura(CandidaturaAExposicao cand) {
        this.candidaturaSelecionada = cand;
    }

    public String getNomeEmpresa() {
        return this.candidaturaSelecionada.getNomeEmpresa();
    }

    public String getMoradaEmpresa() {
        return this.candidaturaSelecionada.getMoradaEmpresa();
    }

    public int getTelemovel() {
        return this.candidaturaSelecionada.getTelemovel();
    }

    public int getArea() {
        return this.candidaturaSelecionada.getArea();
    }

    public int getNumeroConvites() {
        return this.candidaturaSelecionada.getNumeroConvites();
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
