package lapr.project.controller;

import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.*;

/**
 *
 * @author Ana Leite
 */
public class ListarCandidaturasRemovidasController {

    /**
     * Registo de candidaturas removidas.
     */
    private RegistoCandidaturasRemovidas rcr;

    private RegistoExposicoes re;
    /**
     * Exposicao escolhida.
     */
    private Exposicao exposicaoEscolhida;

    /**
     * Centro de exposições.
     */
    private CentroExposicoes centroExposicoes;

    /**
     * Constrói uma instância de ListarCandidaturasController recebendo como
     * parâmetro o centro de exposições
     *
     * @param centro_exposicoes centro de exposições
     */
    public ListarCandidaturasRemovidasController(CentroExposicoes centro_exposicoes) {
        this.centroExposicoes = centro_exposicoes;
    }

    /**
     * Guarda o registo de exposicoes.
     */
    public void getRegistoExposicoes() {
        this.re = centroExposicoes.getRegistoExposicoes();
    }

    /**
     * Devolve a lista das exposições de um organizador.
     *
     * @param usernameOrganizador
     * @return lista das exposições de um organizador.
     */
    public List<Exposicao> getListaExposicoesDoOrganizador(String usernameOrganizador) {
        return re.getlistaExposicoesDoOrganizadorEstadoCriadaOuDemosDefinidasSemFAE(usernameOrganizador);
    }

    /**
     * Modifica a exposição.
     *
     * @param e nova exposição.
     */
    public void setExposicao(Exposicao e) {
        this.exposicaoEscolhida = e;
    }

    /**
     * Guarda o registo de candidaturas removidas.
     */
    public void getRegistoCandidaturasRemovidas() {
        this.rcr = exposicaoEscolhida.getRegistoCandidaturasRemovidas();
    }

    /**
     * Devolve a lista de candidaturas removidas
     *
     * @return lista de candidaturas removidas
     */
    public List<CandidaturaAExposicao> getListaCandidaturasRemovidas() {
        return this.rcr.getListaCandidaturasRemovidas();
    }

}
