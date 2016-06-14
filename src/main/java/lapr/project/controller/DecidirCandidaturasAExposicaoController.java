package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicao;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 *
 * @author G29
 */
public class DecidirCandidaturasAExposicaoController {

    /**
     * Exposição selecionada pelo gestor na UI
     */
    private Exposicao m_exposicaoSelecionada;

    /**
     * Candidatura selecionada pelo gestor na UI
     */
    private CandidaturaAExposicao m_candidaturaSelecionada;

    /**
     * Registo de candidaturas feito à exposição selecionada
     */
    private RegistoCandidaturasAExposicao m_rc;

    /**
     * Registo de exposições onde vão ser guardadas as exposições a serem
     * apresentadas ao gestor
     */
    private RegistoExposicoes m_re;

    /**
     * Centro de exposições atual
     */
    private CentroExposicoes m_ce;

    /**
     * Registo de produtos da candidatura selecionada pelo gestor na UI
     */
    private RegistoProdutos m_rp;

    /**
     * Keywords associadas à candidatura selecionada pelo gestor na UI
     */
    private String[] keywords;

    /**
     * Construtor do controller do UC17 - Decidir candidaturas a exposição
     *
     * @param ce centro de exposições atual
     * @param usernameGestor username do gestor de exposições a executar este UC
     */
    public DecidirCandidaturasAExposicaoController(CentroExposicoes ce) {
        this.m_ce = ce;
    }

    /**
     * Busca e guarda registo de exposições guardado no centro de exposições
     * atual
     */
    public void getRegistoExposicoes() {
        this.m_re = m_ce.getRegistoExposicoes();
    }

    /**
     * Devolve uma lista das exposições do registo de exposições que se
     * encontrem no estado Avaliadas
     *
     * @return lista de exposições no estado Avaliadas
     */
    public ArrayList<Exposicao> getListaExposicoesEstadoCandidaturasAvaliadas() {
        return this.m_re.getListaExposicoesEstadoCandidaturasAvaliadas();
    }

    /**
     * Guarda a escolha da exposição feito pelo gestor na UI
     *
     * @param exposicao exposição selecionada pelo gestor na UI
     */
    public void setExposicao(Exposicao exposicao) {
        this.m_exposicaoSelecionada = exposicao;
    }

    /**
     * Busca e guarda o registo de candidaturas associadas à exposição
     * selecionada
     */
    public void getRegistoCandidaturas() {
        this.m_rc = this.m_exposicaoSelecionada.getRegistoCandidaturasAExposicao();
    }

    /**
     * Busca e guarda o registo de produtos associadao à candidatura selecionada
     * pelo gestor na UI
     */
    public void getRegistoProdutos() {
        this.m_rp = this.m_candidaturaSelecionada.getRegistoProdutos();
    }

    /**
     * Devolve a lista de candidaturas associadas à exposição selecionada
     *
     * @return lista de candidatura à exposição selecionada
     */
    public List<CandidaturaAExposicao> getListaCandidaturas() {
        return this.m_rc.getListaCandidaturas();
    }

    /**
     * Guarda a escolha da candidatura feita pelo gestor na UI
     *
     * @param cand candidatura escolhida pelo gestor na UI
     */
    public void setCandidatura(CandidaturaAExposicao cand) {
        this.m_candidaturaSelecionada = cand;
    }

    /**
     * Devolve o nome da empresa associado à candidatura escolhida
     *
     * @return nome da empresa associado à candidatura escolhida
     */
    public String getNomeEmpresa() {
        return this.m_candidaturaSelecionada.getNomeEmpresa();
    }

    /**
     * Devolve a morada da empresa associada à candidatura escolhida
     *
     * @return morada da empresa associada à candidatura escolhida
     */
    public String getMoradaEmpresa() {
        return this.m_candidaturaSelecionada.getMoradaEmpresa();
    }

    /**
     * Devolve o telemóvel da empresa associado à candidatura escolhida
     *
     * @return telemóvel da empresa associado à candidatura escolhida
     */
    public int getTelemovel() {
        return this.m_candidaturaSelecionada.getTelemovel();
    }

    /**
     * Devolve a área associada à candidatura escolhida
     *
     * @return área associada à candidatura escolhida
     */
    public int getArea() {
        return this.m_candidaturaSelecionada.getArea();
    }

    /**
     * Devolve o número de convites associado à candidatura escolhida
     *
     * @return número de convites associado à candidatura escolhida
     */
    public int getNumeroConvites() {
        return this.m_candidaturaSelecionada.getNumConvites();
    }

    /**
     * Devolve e também guarda no controller as keywords associadas à
     * candidatura escolhida
     *
     * @return Keywords associadas à candidatura escolhida
     */
    public String[] getKeywords() {
        this.keywords = this.m_candidaturaSelecionada.getKeywords();
        return this.keywords;
    }

    /**
     * Guarda a decisão do gestor sobre a candidatura escolhida, chama o
     * respectivo método para atualizar estado da candidatura caso tiver sido
     * aceite ou rejeitada e atualiza o ranking das keywords
     *
     * @param decisao Decisão do gestor sobre a candidatura. True se aceitou ou
     * falso caso contrário
     */
    public void setDecisao(boolean decisao) {
        this.m_candidaturaSelecionada.setDecisao(decisao);
        if (decisao) {
            setEstadoCandidaturaAceite();
            for (String keyword : keywords) {
                this.m_exposicaoSelecionada.getKeywordRanking().addKeyword(keyword, true);
            }

        } else {
            setEstadoCandidaturaRejeitada();
            for (String keyword : keywords) {
                this.m_exposicaoSelecionada.getKeywordRanking().addKeyword(keyword, false);
            }
        }
    }

    /**
     * Atualiza o estado da candidatura escolhida para Aceite
     */
    private void setEstadoCandidaturaAceite() {
        EstadoCandidaturaAExposicao estado = this.m_candidaturaSelecionada.getEstado();
        estado.setEstadoCandidaturaAceite();
    }

    /**
     * Atualiza o estado da candidatura escolhida para Rejeitada
     */
    private void setEstadoCandidaturaRejeitada() {
        EstadoCandidaturaAExposicao estado = this.m_candidaturaSelecionada.getEstado();
        estado.setEstadoCandidaturaRejeitada();
    }

}
