package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracao;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 *
 * @author G29
 */
public class DecidirCandidaturaADemonstracaoController {

    /**
     * Exposição selecionada pelo gestor na UI
     */
    private Exposicao m_exposicaoSelecionada;

    /**
     * Registo de demonstrações
     */
    private RegistoDemonstracoes rd;

    /**
     * Demonstração selecionada pelo gestor na UI
     */
    private Demonstracao m_demonstracaoSelecionada;

    /**
     * Candidatura selecionada pelo gestor na UI
     */
    private CandidaturaADemonstracao m_candidaturaSelecionada;

    /**
     * Registo de candidaturas feito à demonstração selecionada
     */
    private RegistoCandidaturasADemonstracao m_rc;

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
     * username do organizador que iniciou a UC
     */
    private String username;

    /**
     * Construtor do controller do UC17 - Decidir candidaturas a exposição
     *
     * @param ce centro de exposições atual
     */
    public DecidirCandidaturaADemonstracaoController(CentroExposicoes ce, String username) {
        this.m_ce = ce;
        this.username = username;
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
    public ArrayList<Exposicao> getListaExposicoes() {
        return this.m_re.getListaExposicoesDoOrganizadorComDemonstracoesEmEstadoAvaliadas(username);
    }

    /**
     * Busca e guarda o registo de candidaturas associadas à exposição
     * selecionada
     */
    public void getRegistoCandidaturas() {
        this.m_rc = this.m_demonstracaoSelecionada.getRegistoCandidaturasADemonstracao();
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
        } else {
            setEstadoCandidaturaRecusada();
        }
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
     * Guarda a escolha da candidatura feita pelo gestor na UI
     *
     * @param cand candidatura escolhida pelo gestor na UI
     */
    public void setCandidatura(CandidaturaADemonstracao cand) {
        this.m_candidaturaSelecionada = cand;
    }

    /**
     * Atualiza o estado da candidatura escolhida para Aceite
     */
    private void setEstadoCandidaturaAceite() {
        EstadoCandidaturaADemonstracao estado = this.m_candidaturaSelecionada.getEstado();
        estado.setEstadoCandidaturaADemonstracaoAceite();
    }

    /**
     * Atualiza o estado da candidatura escolhida para Recusada
     */
    private void setEstadoCandidaturaRecusada() {
        EstadoCandidaturaADemonstracao estado = this.m_candidaturaSelecionada.getEstado();
        estado.setEstadoCandidaturaADemonstracaoRecusada();
    }

    /**
     *
     * @return descrição de uma candidatura
     */
    public String getDadosCandidatura() {
        return this.m_candidaturaSelecionada.getDadosCandidatura();
    }

    /**
     *
     * @return descrição de uma candidatura
     */
    public String getEmailRep() {
        return this.m_candidaturaSelecionada.getEmailExpositor();
    }

    /**
     *
     * @return lista de demonstrações em estado avaliadas
     */
    public ArrayList<Demonstracao> getListaDemonstracoes() {
        rd = m_exposicaoSelecionada.getRegistoDemonstracoes();
        return rd.getListaDemonstracoesEmEstadoCandidaturasAvaliadas();
    }

    /**
     * Guarda a demonstração selecionada
     *
     * @param d - demonstração selecionada
     */
    public void setDemonstracao(Demonstracao d) {
        this.m_demonstracaoSelecionada = d;
    }

    /**
     *
     * @return descrição da demonstração selecioada
     */
    public String getDescricaoDemo() {
        return this.m_demonstracaoSelecionada.getDescricao();
    }

    /**
     *
     * @return codigo de identificação da demonstração selecioada
     */
    public String getCodigoIDDemo() {
        return this.m_demonstracaoSelecionada.getCodigoIdentificacao();
    }

    public List<CandidaturaADemonstracao> getCandidaturas() {
        return m_rc.getListaCandidaturasEstadoAvaliada();
    }

}
