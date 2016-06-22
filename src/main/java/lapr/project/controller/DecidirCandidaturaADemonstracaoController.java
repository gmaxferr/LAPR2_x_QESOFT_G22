package lapr.project.controller;

import java.util.List;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicao;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 *
 * @author G29
 */
public class DecidirCandidaturaADemonstracaoController {

    /**
     * Exposição selecionada na UI
     */
    private Exposicao m_e;

    /**
     * Registo das demonstrações
     */
    private RegistoDemonstracoes m_rd;

    /**
     * Candidatura selecionada na UI
     */
    private CandidaturaAExposicao m_candidaturaSelecionada;

    /**
     * Registo de candidaturas à demonstração em causa
     */
    private RegistoCandidaturasADemonstracoes m_rc;

    /**
     * Registo de exposições do centro de exposições
     */
    private RegistoExposicoes m_re;

    /**
     * Centro de exposições atual
     */
    private CentroExposicoes m_ce;

    /**
     * Username do Organizador a executar este UC no momento
     */
    private String usernameDoOrganizador;

    /**
     * Keywords associadas à demonstração em causa
     */
    private String[] keywords;

    /**
     * Único construtor. Recebe por parametro o centro de exposições atual e o
     * username do organizador a executar este UC no momento
     *
     * @param ce centro de exposições
     * @param usernameDoOrganizador username do organizador
     */
    public DecidirCandidaturaADemonstracaoController(CentroExposicoes ce, String usernameDoOrganizador) {
        this.m_ce = ce;
        this.usernameDoOrganizador = usernameDoOrganizador;
    }

    /**
     * Guarda o registo de exposições do centro de exposições atual
     */
    public void getRegistoExposicoes() {
        this.m_re = m_ce.getRegistoExposicoes();
    }

    /**
     *
     * @return Lista de Exposicoes Do Organizador que se encontram em
     * EstadoCandidaturasADemonstracoesAvaliadas.
     */
    public List<Exposicao> getListaExposicoes() {
        return this.m_re.getListaExposicoesDoOrganizadorEstadoCandidaturasADemonstracoesAvaliadas(usernameDoOrganizador);
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
     * Guarda a candidatura selecionada pelo utilizador na UI
     *
     * @param cand candidatura selecionada na UI
     */
    public void setCandidatura(CandidaturaAExposicao cand) {
        this.m_candidaturaSelecionada = cand;
    }

    /**
     * Guarda as keywords associadas à demonstração
     */
    public void getKeywords() {
        this.keywords = this.m_candidaturaSelecionada.getKeywords();
    }

    /**
     * Define uma decisão sobre a demonstração em causa no momento
     *
     * @param decisao true se aceite, false caso contrário.
     */
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

    /**
     * Altera o estado da c
     */
    private void setEstadoCandidaturaAceite() {
        EstadoCandidaturaAExposicao estado = this.m_candidaturaSelecionada.getEstado();
        estado.setEstadoCandidaturaAceite();
    }

    private void setEstadoCandidaturaRejeitada() {
        EstadoCandidaturaAExposicao estado = this.m_candidaturaSelecionada.getEstado();
        estado.setEstadoCandidaturaRejeitada();
    }

}
