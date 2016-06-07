package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.registos.RegistoCandidaturasRemovidas;
import lapr.project.model.*;
import lapr.project.registos.RegistoCandidaturasAExposicao;
import lapr.project.registos.RegistoExposicoes;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class RemoverCandidaturaExpoController {

    private Exposicao m_exposicaoSelecionada;
    private String m_username;
    private CentroExposicoes m_ce;
    private RegistoCandidaturasAExposicao m_rc;
    private CandidaturaAExposicao m_candidaturaARemover;

    /**
     * Construtor do controller da UC18 - remover candidatura a uma exposição
     *
     * @param username - username do utilizador logado
     * @param ce - centro de exposições
     */
    public RemoverCandidaturaExpoController(String username, CentroExposicoes ce) {
        this.m_username = username;
        this.m_ce = ce;
    }

    /**
     * Seleciona a exposição a remover
     *
     * @param e - exposição a remover
     */
    public void setExposicao(Exposicao e) {
        m_exposicaoSelecionada = e;
    }

    /**
     * Obtém a lista de exposições em que o representante logado possui
     * candidaturas
     *
     * @param username - username do representante
     * @return - lista de exposições em que o representante logado possui
     * candidaturas
     */
    public List<Exposicao> getExposRepresentante(String username) {
        List<Exposicao> exposicoesLst = new ArrayList();
        RegistoExposicoes re = m_ce.getRegistoExposicoes();
        exposicoesLst = re.getExposicoesDoRepresentante(username);
        return exposicoesLst;
    }

    /**
     * Obtém a lista de candidaturas do representante
     *
     * @param username - username do representante
     * @return - lista de candidaturas do representante
     */
    public List<CandidaturaAExposicao> getListaCandidaturas(String username) {
        List<CandidaturaAExposicao> candidaturasLst = new ArrayList();
        m_rc = m_exposicaoSelecionada.getRegistoCandidaturasAExposicao();
        candidaturasLst = m_rc.getCandidaturasRepresentante(username);
        return candidaturasLst;
    }

    public void setCandidaturaARemover(CandidaturaAExposicao c) {
         m_candidaturaARemover = c;
    }

    public void removerCandidatura() {
        m_rc.removeCandidatura(m_candidaturaARemover);
        RegistoCandidaturasRemovidas rcr = m_exposicaoSelecionada.getRegistoCandidaturasRemovidas();
        rcr.adicionarCandidatura(m_candidaturaARemover);
    }

}
