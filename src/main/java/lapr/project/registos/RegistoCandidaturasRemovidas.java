package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.model.CandidaturaAExposicao;

/**
 *
 * @author Ana Leite
 */
public class RegistoCandidaturasRemovidas {

    /**
     * Lista de candidaturas removidas.
     */
    private List<CandidaturaAExposicao> listaCandidaturasRemovidas;

    /**
     * Contrutor de objetos do tipo RegistoCandidaturasRemovidas sem parâmetros.
     */
    public RegistoCandidaturasRemovidas() {
        this.listaCandidaturasRemovidas = new ArrayList<>();
    }

    /**
     * Adiciona uma candidatura removida do registo de candidaturas
     *
     * @param c - candidatura removida do registo de candidaturas
     */
    public void adicionarCandidatura(CandidaturaAExposicao c) {
        if (c.getEstadoCandidatura().setEstadoCandidaturaRemovida()) {
            listaCandidaturasRemovidas.add(c);
        }
    }

    /**
     * Devolve a lista de candidaturas removidas.
     *
     * @return lista de candidaturas removidas
     */
    public List<CandidaturaAExposicao> getListaCandidaturasRemovidas() {
        return this.listaCandidaturasRemovidas;
    }
}
