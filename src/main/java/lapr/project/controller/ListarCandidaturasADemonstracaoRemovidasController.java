package lapr.project.controller;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Representação do Controller do caso de uso - listar candidaturas a
 * demonstracao removidas
 *
 * @author G29
 */
public class ListarCandidaturasADemonstracaoRemovidasController {

    /**
     * Registo candidaturas a demonstracao removidas
     */
    private RegistoCandidaturasADemonstracaoRemovidas m_rcdr;

    /**
     * Registo demonstrações
     */
    private RegistoDemonstracoes m_rd;

    /**
     * Demonstração escolhida
     */
    private Demonstracao m_demonstracaoEscolhida;

    /**
     * Exposição
     */
    private Exposicao m_Exposicao;

    /**
     * Centro de Exposições
     */
    private CentroExposicoes m_centroExposicoes;

    /**
     * Constrói uma instância de ListarCandidaturasADemonstracacaoController
     * recebendo como parâmetro o centro de exposições
     *
     * @param centroExposicoes centro de exposições
     */
    public ListarCandidaturasADemonstracaoRemovidasController(CentroExposicoes centroExposicoes) {
        this.m_centroExposicoes = centroExposicoes;
    }

    /**
     * Guarda o registo de demonstrações
     */
    public void getRegistoDemonstracoes() {
        this.m_rd = m_Exposicao.getRegistoDemonstracoes();
    }

    /**
     * Devolve a lista das demonstrações de um organizador
     *
     * @param usernameOrganizador username do organizador
     * @return lista das demonstrações de um organizador
     */
    public List<Demonstracao> getListaDemonstracoesDoOrganizadorEstadoConfirmada(String usernameOrganizador) {
        for (Organizador o : m_Exposicao.getListaOrganizadores()) {
            if (o.getUsernameOrganizador().equalsIgnoreCase(usernameOrganizador)) {
                return m_rd.getListaDemonstracoesEstadoConfirmada();
            }
        }
        return new ArrayList<>();
    }

    /**
     * Modifica a demonstração.
     *
     * @param d nova demonstracao.
     */
    public void setDemonstracao(Demonstracao d) {
        this.m_demonstracaoEscolhida = d;
    }

    /**
     * Guarda o registo de candidaturas a demonstração removidas.
     */
    public void getRegistoCandidaturasADemonstracaoRemovidas() {
        this.m_rcdr = m_demonstracaoEscolhida.getRegistoCandidaturasADemonstracaoRemovidas();
    }

    /**
     * Devolve a lista de candidaturas a demonstração removidas
     *
     * @return lista de candidaturas a demonstração removidas
     */
    public List<CandidaturaADemonstracao> getListaCandidaturasADemonstracaoRemovidas() {
        return this.m_rcdr.getListaCandidaturasADemonstracaoRemovidas();
    }

}
