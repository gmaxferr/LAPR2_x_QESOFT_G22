package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.Candidatura;

/**
 *
 * @author Ana Leite
 */
public class RegistoCandidaturasRemovidas {

    /**
     * Lista de candidaturas removidas.
     */
    private List<Candidatura> listaCandidaturasRemovidas;
    
    /**
     * Contrutor de objetos do tipo RegistoCandidaturasRemovidas sem parâmetros.
     */
    public RegistoCandidaturasRemovidas(){
        this.listaCandidaturasRemovidas = new ArrayList<>();
    }
    
    /**
     * Devolve a lista de candidaturas removidas.
     * 
     * @return lista de candidaturas removidas
     */
    public List<Candidatura> getListaCandidaturasRemovidas(){
        return this.listaCandidaturasRemovidas;
    }
}
