package lapr.project.controller;

import lapr.project.estados.Exposicao.EstadoExposicao;
import lapr.project.estados.CandidaturaAExposicao.EstadoCandidaturaAExposicao;
import java.util.ArrayList;
import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Controller do caso de uso 3 - atribuir candidaturas
 *
 * @author G29
 */
public class AtribuirCandidaturasAExposicaoController {

    /**
     * Lista de exposições - a ser preechida pelas exposições do organizador a
     * executar o UC
     */
    private List<Exposicao> m_listaExpo;

    /**
     *
     */
    private RegistoExposicoes m_re;

    /**
     * Candidatura escolhida pelo organizador na UI
     */
    private CandidaturaAExposicao m_cand;

    /**
     * Exposição escolhida pelo organizador na UI
     */
    private Exposicao m_exposicaoEscolhida;

    /**
     * Centro de exposições atual
     */
    private CentroExposicoes m_centroExposicoes;

    /**
     * Registo de mecanismos associados ao centro de exposições atual
     */
    private RegistoMecanismos m_rm;

    /**
     * Registo das candidaturas à exposição escolhida pelo organizador na UI
     */
    private RegistoCandidaturasAExposicao m_rc;

    /**
     * Estado da exposição escolhida pelo organizador na UI
     */
    private EstadoExposicao m_estadoExposicao;

    /**
     * Estado da candidatura escolhida pelo organizador na UI
     */
    private EstadoCandidaturaAExposicao m_estadoCandidatura;

    /**
     * Username do organizador a executar este UC
     */
    private final String m_usernameOrganizador;
    private List<AtribuicaoCandidatura> m_listaAtribuicoesGeradas;

    /**
     * Construtor do controller do UC - atribuir candidaturas
     *
     * @param centroExposicoes centro de exposições atual
     * @param usernameOrganizador username do organizador a executar este UC
     */
    public AtribuirCandidaturasAExposicaoController(CentroExposicoes centroExposicoes, String usernameOrganizador) {
        this.m_listaExpo = new ArrayList<>();
        this.m_centroExposicoes = centroExposicoes;
        this.m_usernameOrganizador = usernameOrganizador;
    }

    /**
     * Busca e guarda o registo de exposições associado ao centro de exposições
     * atual
     */
    public void getRegistoExposicoes() {
        this.m_re = m_centroExposicoes.getRegistoExposicoes();
    }

    /**
     * Devolve a lista de Exposições do Organizador
     *
     * @return lista de exposições o organizador
     */
    public List<Exposicao> getListaExposicoesDoOrganizadorEstadoConflitosAlterados() {
        m_listaExpo = m_centroExposicoes.getRegistoExposicoes().getlistaExposicoesDoOrganizadorEstadoConflitosAlterados(this.m_usernameOrganizador);
        return m_listaExpo;
    }

    /**
     * Guarda a exposição escolhida pelo utilizador na UI
     *
     * @param exposicao exposição escolhida
     */
    public void setExposicao(Exposicao exposicao) {
        this.m_exposicaoEscolhida = exposicao;
    }

    /**
     * Busca e guarda o registo de mecanismo associado ao centro de exposições
     * atuak
     */
    public void getRegistoMecanismos() {
        this.m_rm = m_centroExposicoes.getRegistoMecanismos();
    }

    /**
     * Devole uma lista com todos os mecanimos existentes no centro de
     * exposições atual
     *
     * @return lista de todos os mecanismos existentes
     */
    public List<Mecanismo> getListaMecanismos() {
        return this.m_rm.getListaMecanismos();
    }

    /**
     * Busca e guarda o registo de candidaturas à exposição escolhida
     */
    public void getRegistoCandidaturas() {
        this.m_rc = this.m_exposicaoEscolhida.getRegistoCandidaturasAExposicao();
    }

    /**
     * Busca e guarda o registo de atribuições associado à exposição escolhida
     */
    public void getRegistoAtribuicoes() {
        this.m_exposicaoEscolhida.getRegistoAtribuicoes();
    }

    /**
     * Devolve as atribuições geradas pelo mecanismo escolhido na UI
     *
     * @param mec mecanismo escolhido na UI
     *
     * @return atribuições geradas
     */
    public List<AtribuicaoCandidatura> atribui(Mecanismo mec) {
        MecanismoSimples mecanismo = (MecanismoSimples) mec;
        List<AtribuicaoCandidatura> listaAtribuicoesGeradas = mecanismo.atribui(this.m_exposicaoEscolhida);
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
    public List<AtribuicaoCandidatura> atribui(Mecanismo mec, String numeroFAEOuExperiencia) {
        MecanismoIteragivel mecanismo = (MecanismoIteragivel) mec;
        List<AtribuicaoCandidatura> listaAtribuicoesGeradas = mecanismo.atribui(this.m_exposicaoEscolhida, numeroFAEOuExperiencia);
        this.m_listaAtribuicoesGeradas = listaAtribuicoesGeradas;
        return listaAtribuicoesGeradas;
    }

    /**
     * Define uma nova lista de atribuições substituindo a já existente no
     * registo de atribuições pela recebida como parametro neste método
     *
     * @param listaAtribuicao nova lista de atribuições
     */
    public void registaAtribuicao(List<AtribuicaoCandidatura> listaAtribuicao) {
        this.m_exposicaoEscolhida.getRegistoAtribuicoes().setListaAtribuicao(listaAtribuicao);
    }

    /**
     * Atualiza o estado das candidaturas sobre as quais foram geradas atribuições e da exposição atualmente selecionada
     * pelo organizador na UI para os estados CandidaturasAtribuidas
     */
    public void setEstadoCandidaturaAtribuida() {
        this.m_estadoExposicao = this.m_exposicaoEscolhida.getEstado();
        m_estadoExposicao.setEstadoCandidaturasAtribuidas();

        for (AtribuicaoCandidatura atribuicao : this.m_listaAtribuicoesGeradas) {
            this.m_estadoCandidatura = atribuicao.getCandidaturaAssociada().getEstado();
            m_estadoCandidatura.setEstadoCandidaturaAtribuida();
        }

    }
}
