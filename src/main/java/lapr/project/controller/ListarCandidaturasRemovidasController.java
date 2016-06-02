package lapr.project.controller;

import java.util.List;
import lapr.project.model.Candidatura;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Exposicao;
import lapr.project.registos.RegistoCandidaturasRemovidas;

/**
 *
 * @author Ana Leite
 */
public class ListarCandidaturasRemovidasController {

    /**
     * Registo de candidaturas removidas.
     */
    private RegistoCandidaturasRemovidas rcr;
 
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
    public ListarCandidaturasRemovidasController (CentroExposicoes centro_exposicoes){
        this.centroExposicoes = centro_exposicoes;
    }

    /**
     * Guarda o registo de candidaturas removidas.
     */
    public void getRcr() {
        this.rcr = exposicaoEscolhida.getRegistoCandidaturasRemovidas();
    }
    
    /**
     * Devolve a lista de candidaturas removidas
     * 
     * @return lista de candidaturas removidas
     */
    public List<Candidatura> getListaCandidaturasRemovidas(){
        return this.rcr.getListaCandidaturasRemovidas();
    }
    
}
