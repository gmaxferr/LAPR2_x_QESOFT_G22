package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.registos.RegistoCandidaturasAExposicaoRemovidas;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 *
 * @author G29
 */
public class RemoverCandidaturaExpoController {

    /**
     * Exposição selecionada na UI
     */
    private Exposicao m_exposicaoSelecionada;

    /**
     * Username do FAE a executar este caso de uso
     */
    private String m_emailFAE;

    /**
     * Centro de exposições atual
     */
    private CentroExposicoes m_ce;

    /**
     * Registo de candidaturas à exposição selecionada
     */
    private RegistoCandidaturasAExposicao m_rc;

    /**
     * Candidatura selecionada na UI para ser removidaa
     */
    private CandidaturaAExposicao m_candidaturaARemover;

    /**
     * Registo de atribuições da exposição selecionada
     */
    private RegistoAtribuicoesCandidaturasExposicao m_ra;

    /**
     * Construtor do controller da UC18 - remover candidatura a uma exposição
     *
     * @param username - username do utilizador logado
     * @param ce - centro de exposições
     */
    public RemoverCandidaturaExpoController(String email, CentroExposicoes ce) {
        this.m_emailFAE = email;
        this.m_ce = ce;
    }

    public ArrayList<AtribuicaoCandidatura> getListaAtribuicoesComOFAE() {
        return this.m_ra.getListaAtribuicoesDoFAE(this.m_emailFAE);
    }

    /**
     * Devolve o registo de atribuicoes da exposição selecionada
     *
     * @return registo de atribuicoes da exposição selecionada
     */
    public RegistoAtribuicoesCandidaturasExposicao getRegistoAtribuicoes() {
        m_ra = m_exposicaoSelecionada.getRegistoAtribuicoesExposicao();
        return m_ra;
    }

    /**
     * Obtém a lista de exposições em que o representante logado possui
     * candidaturas
     *
     * @param username - username do representante
     * @return - lista de exposições em que o representante logado possui
     * candidaturas
     */
    public List<Exposicao> getExposRepresentante(String email) {
        List<Exposicao> exposicoesLst = new ArrayList();
        RegistoExposicoes re = m_ce.getRegistoExposicoes();
        exposicoesLst = re.getExposicoesDoRepresentanteCandidaturasAbertas(email);
        return exposicoesLst;
    }

    /**
     * Obtém a lista de candidaturas do representante
     *
     * @param username - username do representante
     * @return - lista de candidaturas do representante
     */
    public List<CandidaturaAExposicao> getListaCandidaturas(String email) {
        List<CandidaturaAExposicao> candidaturasLst = new ArrayList();
        m_rc = m_exposicaoSelecionada.getRegistoCandidaturasAExposicao();
        candidaturasLst = m_rc.getCandidaturasRepresentante(email);
        return candidaturasLst;
    }

    /**
     * Seleciona a exposição a remover
     *
     * @param e - exposição a remover
     */
    public void setExposicao(Exposicao e) {
        m_exposicaoSelecionada = e;
    }

    public void setCandidaturaARemover(CandidaturaAExposicao c) {
        m_candidaturaARemover = c;
    }

    public void removerCandidatura() {
        RegistoCandidaturasAExposicaoRemovidas rcr = m_exposicaoSelecionada.getRegistoCandidaturasAExposicaoRemovidas();
        rcr.adicionarCandidatura(m_candidaturaARemover);
        m_rc.removeCandidatura(m_candidaturaARemover);
    }

}
