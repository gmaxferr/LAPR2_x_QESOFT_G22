package lapr.project.controller;

import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 * Representação do Controller do caso de uso - listar candidaturas removidas
 * 
 * @author Ana Leite
 */
public class ListarCandidaturasAExposicaoRemovidasController {

    /**
     * Registo de candidaturas removidas.
     */
    private RegistoCandidaturasAExposicaoRemovidas m_rcr;

    /**
     * Registo de Exposições
     */
    private RegistoExposicoes m_re;
    
    /**
     * Exposicao escolhida.
     */
    private Exposicao m_exposicaoEscolhida;

    /**
     * Centro de exposições.
     */
    private CentroExposicoes m_centroExposicoes;

    /**
     * Constrói uma instância de ListarCandidaturasController recebendo como
     * parâmetro o centro de exposições
     *
     * @param centro_exposicoes centro de exposições
     */
    public ListarCandidaturasAExposicaoRemovidasController(CentroExposicoes centro_exposicoes) {
        this.m_centroExposicoes = centro_exposicoes;
    }

    /**
     * Guarda o registo de exposicoes.
     */
    public void getRegistoExposicoes() {
        this.m_re = m_centroExposicoes.getRegistoExposicoes();
    }

    /**
     * Devolve a lista das exposições de um organizador.
     *
     * @param usernameOrganizador username do organizador
     * 
     * @return lista das exposições de um organizador.
     */
    public List<Exposicao> getListaExposicoesDoOrganizador(String usernameOrganizador) {
        return m_re.getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE(usernameOrganizador);
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
     * Guarda o registo de candidaturas removidas.
     */
    public void getRegistoCandidaturasRemovidas() {
        this.m_rcr = m_exposicaoEscolhida.getRegistoCandidaturasAExposicaoRemovidas();
    }

    /**
     * Devolve a lista de candidaturas removidas
     *
     * @return lista de candidaturas removidas
     */
    public List<CandidaturaAExposicao> getListaCandidaturasRemovidas() {
        return this.m_rcr.getListaCandidaturasAExposicaoRemovidas();
    }

}
