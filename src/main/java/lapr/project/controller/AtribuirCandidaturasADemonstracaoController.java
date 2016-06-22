package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.CandidaturaADemonstracao.EstadoCandidaturaADemonstracao;
import lapr.project.estados.Demonstracao.EstadoDemonstracao;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Representação do Controller do caso de uso - atribuir candidaturas a
 * demonstração
 *
 * @author G29
 */
public class AtribuirCandidaturasADemonstracaoController {

    /**
     * Lista de exposições - a ser preechida pelas exposições do organizador a
     * executar o UC
     */
    private List<Exposicao> m_listaExpo;
    
    /**
     * Centro de Exposições
     */
    private CentroExposicoes m_centroExposicoes;

    /**
     * Registo de Demonstrações
     */
    private RegistoDemonstracoes m_rd;

    /**
     * Registo de Mecanismos
     */
    private RegistoMecanismos m_rm;

    /**
     * Registo Candidaturas a Demonstrações
     */
    private RegistoCandidaturasADemonstracao m_rc;

    /**
     * Registo de atribuições
     */
    private RegistoAtribuicoesCandidaturasDemonstracao m_rad;
    
    /**
     * Registo de exposições
     */
    private RegistoExposicoes m_re;

    /**
     * Lista de demonstrações
     */
    private List<Demonstracao> m_listaDemos;

    /**
     * Exposição
     */
    private Exposicao m_exposicao;

    /**
     * Demonstração escolhida
     */
    private Demonstracao m_demonstracao;

    /**
     * Estado Demonstração
     */
    private EstadoDemonstracao m_estadoDemonstracao;

    /**
     * Estado candidatura a demonstração
     */
    private EstadoCandidaturaADemonstracao m_estadoCandidatura;

    /**
     * Candidatura a demonstração
     */
    private CandidaturaADemonstracao m_cand;

    /**
     * Lista de atribuições geradas
     */
    private List<AtribuicaoCandidaturaDemonstracao> m_listaAtribuicoesGeradas;

    /**
     * Constrói uma instância de AtribuirCandidaturasADemonstracaoController
     * recebendo como parâmetro o centro de exposições
     *
     * @param centroExposicoes centro de exposições
     */
    public AtribuirCandidaturasADemonstracaoController(CentroExposicoes centroExposicoes) {
        this.m_centroExposicoes = centroExposicoes;
        this.m_listaDemos = new ArrayList<>();
    }

    /**
     * Guarda o registo de exposições
     */
    public void getRegistoExposicoes() {
        this.m_re = this.m_centroExposicoes.getRegistoExposicoes();
    }
     
    /**
     * Devolve a lista de Exposições do Organizador
     *
     * @return lista de exposições o organizador
     */
    public List<Exposicao> getListaExposicoesDoOrganizadorEstadoConflitosAlterados(String usernameOrganizador) {
        m_listaExpo = this.m_re.getlistaExposicoesDoOrganizadorEstadoConflitosAlterados(usernameOrganizador);
        return m_listaExpo;
    }
    
    /**
     * Guarda a exposição escolhida pelo utilizador na UI
     *
     * @param exposicao exposição escolhida
     */
    public void setExposicao(Exposicao exposicao) {
        this.m_exposicao = exposicao;
    }
    
    /**
     * Guarda o registo de demonstrações
     */
    public void getRegistoDemonstracoes() {
        this.m_rd = m_exposicao.getRegistoDemonstracoes();
    }

    /**
     * Devolve a lista de demonstrações de um organizador
     *
     * @param usernameOrganizador username do organizador
     * @return lista de demonstrações de um organizador
     */
    public List<Demonstracao> getListaDemonstracoesEstadoCandidaturasFechadas(String usernameOrganizador) {
        for (Organizador o : m_exposicao.getListaOrganizadores()) {
            if (o.getUsernameOrganizador().equalsIgnoreCase(usernameOrganizador)) {
                return m_rd.getListaDemonstracoesEstadoCandidaturasFechadas();
            }
        }
        return new ArrayList<>();
    }

    /**
     * Modifica a demonstração
     *
     * @param demonstracao nova demonstração
     */
    public void setDemonstracao(Demonstracao demonstracao) {
        this.m_demonstracao = demonstracao;
    }

    /**
     * Guarda o registo de mecanismos
     */
    public void getRegistoMecanismos() {
        this.m_rm = m_centroExposicoes.getRegistoMecanismos();
    }

    /**
     * Devolve a lista de mecanismos
     *
     * @return lista de mecanismos
     */
    public List<Mecanismo> getListaMecanismos() {
        return this.m_rm.getListaMecanismos();
    }

    /**
     * Guarda o registo de candidaturas
     */
    public void getRegistoCandidaturas() {
        this.m_rc = this.m_demonstracao.getRegistoCandidaturasADemonstracao();
    }

    /**
     * Guarda o registo de atribuicoes
     */
    public void getRegistoAtribuicoes() {
        this.m_rad = m_exposicao.getRegistoAtribuicoesDemonstracao();
    }

    /**
     * Devolve as atribuições geradas.
     *
     * @param mec mecanismo.
     *
     * @return atribuições geradas.
     */
    public List<AtribuicaoCandidaturaDemonstracao> atribui(Mecanismo mec) {
        MecanismoSimples mecanismo = (MecanismoSimples) mec;
        List<AtribuicaoCandidaturaDemonstracao> listaAtribuicoesGeradas = mecanismo.atribui(this.m_exposicao, this.m_demonstracao);
        this.m_listaAtribuicoesGeradas = listaAtribuicoesGeradas;
        return listaAtribuicoesGeradas;
    }

    /**
     * Devolve as atribuições geradas.
     *
     * @param mec mecanismo.
     * @param numeroFAEOuExperiencia
     *
     * @return atribuições geradas.
     */
    public List<AtribuicaoCandidaturaDemonstracao> atribui(Mecanismo mec, String numeroFAEOuExperiencia) {
        MecanismoIteragivel mecanismo = (MecanismoIteragivel) mec;
        List<AtribuicaoCandidaturaDemonstracao> listaAtribuicoesGeradas = mecanismo.atribui(this.m_exposicao, this.m_demonstracao, numeroFAEOuExperiencia);
        this.m_listaAtribuicoesGeradas = listaAtribuicoesGeradas;
        return listaAtribuicoesGeradas;
    }

    /**
     * Regista a atribuição gerada
     *
     * @param listaAtribuicao lista de atribuicoes
     */
    public void registaAtribuicao(List<AtribuicaoCandidaturaDemonstracao> listaAtribuicao) {
        this.m_rad.setListaAtribuicao(listaAtribuicao);
    }

    /**
     * Atualiza o estado da candidatura e da demonstração atualmente
     * selecionadas pelo organizador na UI para os estados
     * CandidaturasAtribuidas
     */
    public void setEstadoCandidaturaAtribuida() {
        this.m_estadoDemonstracao = this.m_demonstracao.getEstadoDemo();
        m_estadoDemonstracao.setEstadoDemonstracaoCandidaturasAtribuidas();

        for (AtribuicaoCandidaturaDemonstracao atribuicao : this.m_listaAtribuicoesGeradas) {
            this.m_estadoCandidatura = this.m_cand.getEstado();
            m_estadoCandidatura.setEstadoCandidaturaADemonstracaoAtribuida();
        }
    }
}
