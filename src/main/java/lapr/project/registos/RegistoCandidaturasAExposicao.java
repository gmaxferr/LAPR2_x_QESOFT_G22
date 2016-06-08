package lapr.project.registos;

import java.util.ArrayList;
import java.util.List;
import lapr.project.estados.EstadoCandidaturaAExposicao;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.Expositor;

/**
 *
 * @author Ana Leite Ricardo Osório
 */
public class RegistoCandidaturasAExposicao {

    /**
     * Atributo lista de candidaturas
     */
    private List<CandidaturaAExposicao> m_listaCandidaturas;

    public RegistoCandidaturasAExposicao() {
        this.m_listaCandidaturas = new ArrayList<>();
    }

    /**
     * Método que devolve a lista de candidatuas
     *
     * @return lista de candidatuas
     */
    public List<CandidaturaAExposicao> getListaCandidaturas() {
        return this.m_listaCandidaturas;
    }

    /**
     * Método que cria uma nova candidatura
     *
     * @return nova candidatura
     */
    public CandidaturaAExposicao criarCandidatura(Expositor expositor) {
        return new CandidaturaAExposicao(expositor);
    }

    /**
     * Método que valida dados da candidatura
     *
     * @param c candidatura
     *
     * @return boolean que confirma a validação dos dados
     */
    public boolean validarDadosCandidatura(CandidaturaAExposicao c) {
        for (CandidaturaAExposicao candidatura : this.m_listaCandidaturas) {
            if (c.equals(candidatura)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Método que regista candidatura
     *
     * @param candidaturaAExposicao candidatura
     * @return
     */
    public boolean registaCandidatura(CandidaturaAExposicao candidaturaAExposicao) {
        boolean b = validaCandidatua(candidaturaAExposicao);
        if (b) {
            addCandidatura(candidaturaAExposicao);
        }
        return b;
    }

    /**
     * Método que valida candidatura
     *
     * @param c candidatura
     */
    public boolean validaCandidatua(CandidaturaAExposicao c) {
        //validação global - repetida
        return true;
    }

    /**
     * Método que valida a candidatura
     *
     * @param c candidatura
     *
     * @return boolean de confirmação da validação
     */
    private boolean validaCandidatura(CandidaturaAExposicao c) {
        //validaçao global
        return true;

    }

    /**
     * Método que adiciona uma candidatura
     *
     * @param c candidatura a ser adicionada
     */
    void addCandidatura(CandidaturaAExposicao c) {
        if (validaCandidatura(c)) {
            addCandidatura(c);
        }
    }

    /**
     * Remove uma candidatura do registo
     *
     * @param c - candidatura a remover
     */
    public void removeCandidatura(CandidaturaAExposicao c) {
        m_listaCandidaturas.remove(c);
    }

    public List<CandidaturaAExposicao> getCandidaturasRepresentante(String username) {
        List<CandidaturaAExposicao> candidaturasRepLst = new ArrayList<>();
        for (CandidaturaAExposicao c : m_listaCandidaturas) {
            if (c.getUsernameExpositor().equals(username)) {
                candidaturasRepLst.add(c);
            }
        }
        return candidaturasRepLst;
    }

    /**
     * @return Retorna uma lista com todas as Candidaturas aceites a esta
     * Exposição
     */
    public List<CandidaturaAExposicao> getListaCandidaturasAceites() {
        List<CandidaturaAExposicao> listCand = new ArrayList<>();
        for(CandidaturaAExposicao cand : m_listaCandidaturas){
            EstadoCandidaturaAExposicao state = cand.getEstado();
            if(state.isEstadoCandidaturaAceite()){
                listCand.add(cand);
            }
        }
        return listCand;
    }
}
