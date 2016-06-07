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
    private List<CandidaturaAExposicao> m_listaCandidaturasRemovidas;

    /**
     * Contrutor de objetos do tipo RegistoCandidaturasRemovidas sem parâmetros.
     */
    public RegistoCandidaturasRemovidas() {
        this.m_listaCandidaturasRemovidas = new ArrayList<>();
    }

    /**
     * Adiciona uma candidatura removida do registo de candidaturas
     *
     * @param c - candidatura removida do registo de candidaturas
     */
    public void adicionarCandidatura(CandidaturaAExposicao c) {
        m_listaCandidaturasRemovidas.add(c);
    }

    /**
     * Devolve a lista de candidaturas removidas.
     *
     * @return lista de candidaturas removidas
     */
    public List<CandidaturaAExposicao> getListaCandidaturasRemovidas() {
        return this.m_listaCandidaturasRemovidas;
    }
}
