package lapr.project.controller;

import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Representação do Controller do caso de uso - confirmar stands
 *
 * @author G29
 */
public class ConfirmarStandController {

    /**
     * Centro de exposições
     */
    private CentroExposicoes m_centroExpo;

    /**
     * Registo de exposições
     */
    private RegistoExposicoes m_RegistoExposicoes;

    /**
     * Registo candidaturas a exposição
     */
    private RegistoCandidaturasAExposicao m_rce;

    /**
     * Registo de atribuições de stands
     */
    private RegistoAtribuicoesStands m_RegistoAtribuicoesStand;

    /**
     * Decisão tomada pelo representante
     */
    private boolean m_decisao;

    /**
     * Atribuicao Stand
     */
    private AtribuicaoStand m_atribuicaoStand;

    /**
     * Exposicao escolhida
     */
    private Exposicao m_exposicaoEscolhida;

    /**
     * Candidatura escolhida
     */
    private CandidaturaAExposicao m_candEscolhida;

    /**
     * Construtor de objetos do tipo ConfirmarStandsController recendo como
     * parâmentro o centro de exposições
     *
     * @param centro_exposicoes centro de exposições
     */
    public ConfirmarStandController(CentroExposicoes centro_exposicoes) {
        this.m_centroExpo = centro_exposicoes;
    }

    /**
     * Guarda o registo de exposições
     */
    public void getRegistoExposicoes() {
        m_RegistoExposicoes = m_centroExpo.getRegistoExposicoes();
    }

    /**
     * Devolve a lista das exposições de um representante
     *
     * @param email email do representante
     *
     * @return lista das exposições de um representante
     */
    public List<Exposicao> getListaExposicoesDoRepresentante(String email) {
        return m_RegistoExposicoes.getListaExposicoesComCanditaturasAceitesDoRepresentante(email);
    }

    /**
     * Modifica a exposição.
     *
     * @param e nova exposição.
     */
    public void setExposicao(Exposicao e) {
        this.m_exposicaoEscolhida = e;
    }

    /**
     * Guarda o registo de candidatura a exposição
     */
    public void getRegistoCandidaturasAExposicao() {
        this.m_rce = m_exposicaoEscolhida.getRegistoCandidaturasAExposicao();
    }

    /**
     * Devolve a lista de candidaturas de um representante
     *
     * @param email email do representante
     * @return lista de candidaturas de um representante
     */
    public List<CandidaturaAExposicao> getListaCandidaturasDoRepresentante(String email) {
        return m_rce.getCandidaturasRepresentante(email);
    }

    /**
     * Modifica a candidatura
     *
     * @param candidatura nova candidatura
     */
    public void setCandidaturaAExposicao(CandidaturaAExposicao candidatura) {
        this.m_candEscolhida = candidatura;
    }

    /**
     * Guarda o registo de atribuições de stand
     */
    public void getRegistoAtribuicoesStands() {
        m_RegistoAtribuicoesStand = m_exposicaoEscolhida.getRegistoAtribuicoesStands();
    }

    /**
     * Devolve a atribuição do stand de um representante
     *
     * @param email email do representante
     * @param cand candidatura selecionada
     * @return lista de atribuições do stand de um representante
     */
    public AtribuicaoStand getAtribuicao(String email, CandidaturaAExposicao cand) {
        for (AtribuicaoStand as : m_RegistoAtribuicoesStand.getListAtribuicoesStandDoRepresentante(email)) {
            if (as.getCand().equals(cand)) {
                m_atribuicaoStand = as;
                return as;
            }
        }
        this.m_atribuicaoStand = new AtribuicaoStand(null, cand, false);
        m_RegistoAtribuicoesStand.getListaAtribuicoesStand().add(this.m_atribuicaoStand);
        return this.m_atribuicaoStand;

    }

    /**
     * Modifica a decisão do representante
     *
     * @param decisao nova decisão
     */
    public void setDecisao(boolean decisao) {
        this.m_atribuicaoStand.setDecisao(decisao);

    }
}
