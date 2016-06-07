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

    private Exposicao m_exposicaoSelecionada;
    private CandidaturaAExposicao m_candidaturaSelecionada;
    private RegistoCandidaturasAExposicao m_rc;
    private RegistoExposicoes m_re;
    private CentroExposicoes m_ce;
    private GestorDeExposicoes m_gestorDeExposicoes;
    private RegistoProdutos m_rp;

    public DecidirCandidaturasAExposicaoController(CentroExposicoes ce, GestorDeExposicoes gestorDeExposicoes) {
        this.m_ce = ce;
        this.m_gestorDeExposicoes = gestorDeExposicoes;
    }

    public void getRegistoExposicoes() {
        this.m_re = m_ce.getRegistoExposicoes();
    }

    public ArrayList<Exposicao> getListaExposicoesEstadoCandidaturasAvaliadas() {
        return this.m_re.getListaExposicoesEstadoCandidaturasAvaliadas();
    }

    public void setExposicao(Exposicao exposicao) {
        this.m_exposicaoSelecionada = exposicao;
    }

    public void getRegistoCandidaturas() {
        this.m_rc = this.m_exposicaoSelecionada.getRegistoCandidaturasAExposicao();
    }

    public void getRegistoProdutos() {
        this.m_rp = this.m_candidaturaSelecionada.getRegistoProdutos();
    }

    /*
        lista de candidaturas de uma das expos no estado EstadoExposicaoCandidaturasAvaliadas 
        logo todas estarão no estado EstadoCandidaturasAExposicaoAvaliada
     */
    public List<CandidaturaAExposicao> getListaCandidaturas() {
        return this.m_rc.getListaCandidaturasAExposicao();
    }

    public void getDadosEstatisticosGerais() {
        throw new UnsupportedOperationException();
    }

    //a espera de implementarem os vossos models
    public void setCandidatura(CandidaturaAExposicao cand) {
        this.m_candidaturaSelecionada = cand;
    }

    public String getNomeEmpresa() {
        return this.m_candidaturaSelecionada.getM_StrNomeEmpresa();
    }

    public String getMoradaEmpresa() {
        return this.m_candidaturaSelecionada.getM_StrMoradaEmpresa();
    }

    public int getTelemovel() {
        return this.m_candidaturaSelecionada.getM_intTelemovel();
    }

    public int getArea() {
        return this.m_candidaturaSelecionada.getM_intArea();
    }

    public int getNumeroConvites() {
        return this.m_candidaturaSelecionada.getM_intNumConvites();
    }

    public void getKeywords() {
        throw new UnsupportedOperationException();
    }

    public void setDecisao(boolean decisao) {
        this.m_candidaturaSelecionada.setDecisao(decisao);
        if (decisao) {
            setEstadoCandidaturaAceite();
        } else {
            setEstadoCandidaturaRejeitada();
        }
    }

    private void setEstadoCandidaturaAceite() {
        EstadoCandidaturaAExposicao estado = this.m_candidaturaSelecionada.getEstado();
        estado.setEstadoCandidaturaAceite();
    }

    private void setEstadoCandidaturaRejeitada() {
        EstadoCandidaturaAExposicao estado = this.m_candidaturaSelecionada.getEstado();
        estado.setEstadoCandidaturaRejeitada();
    }

}
