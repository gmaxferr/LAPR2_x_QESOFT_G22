/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.controller;

import java.util.List;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicao;
import lapr.project.model.CandidaturaADemonstracao;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Demonstracao;
import lapr.project.model.Exposicao;
import lapr.project.registos.RegistoCandidaturaADemonstracoes;
import lapr.project.registos.RegistoDemonstracoes;
import lapr.project.registos.RegistoExposicoes;

/**
 *
 * @author guima
 */
public class DecidirCandidaturaADemonstracaoController {

    private Exposicao m_e;
    private RegistoDemonstracoes m_rd;
    private CandidaturaAExposicao m_candidaturaSelecionada;
    private RegistoCandidaturaADemonstracoes m_rc;
    private RegistoExposicoes m_re;
    private CentroExposicoes m_ce;
    private String username;
    private String[] keywords;

    public DecidirCandidaturaADemonstracaoController(CentroExposicoes ce, String username) {
        this.m_ce = ce;
        this.username = username;
    }

    public void getRegistoExposicoes() {
        this.m_re = m_ce.getRegistoExposicoes();
    }

    /**
     *
     * @return Lista de Exposicoes Do Organizador que se encontram em
     * EstadoCandidaturasADemonstracoesAvaliadas.
     */
    public List<Exposicao> getListaExposicoes() {
        return this.m_re.getListaExposicoesDoOrganizadorEstadoCandidaturasADemonstracoesAvaliadas(username);
    }

    /**
     * Guarda a seleção do utilizador (exposição selecionada)
     *
     * @param e - Exposição selecionada
     */
    public void setExposicao(Exposicao e) {
        this.m_e = e;
    }

    /**
     *
     * @return lista de demosntrações da exposição selecionada, que já têm as
     * candidaturas avaliadas.
     */
    public List<Demonstracao> getListaDemonstracoes() {
        this.m_rd = this.m_e.getRegistoDemonstracoes();
        return m_rd.getListaDemonstracoesEmEstadoCandidaturasAvaliadas();
    }

    /**
     * 
     * @return lista de candidaturas a demonstração do Registo das mesmas 
     */
    public List<CandidaturaADemonstracao> getListaCandidaturas() {
        return this.m_rc.getListaCandidaturasADemonstracao();
    }

    public void getDadosEstatisticosGerais() {
        throw new UnsupportedOperationException();
    }

    /**
     * Guarda a candidatura selecionada pelo utilizador
     * @param cand 
     */
    public void setCandidatura(CandidaturaAExposicao cand) {
        this.m_candidaturaSelecionada = cand;
    }

    
    public void getKeywords() {
        this.keywords = this.m_candidaturaSelecionada.getKeywords();
    }

    public void setDecisao(boolean decisao) {
        this.m_candidaturaSelecionada.setDecisao(decisao);
        if (decisao) {
            setEstadoCandidaturaAceite();
            for (String keyword : keywords) {
                this.m_e.getKeywordRanking().addKeyword(keyword, true);
            }

        } else {
            setEstadoCandidaturaRejeitada();
            for (String keyword : keywords) {
                this.m_e.getKeywordRanking().addKeyword(keyword, false);
            }
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
