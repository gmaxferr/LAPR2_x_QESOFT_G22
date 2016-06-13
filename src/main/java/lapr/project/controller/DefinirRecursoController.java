package lapr.project.controller;

import java.util.List;
import lapr.project.model.CentroExposicoes;
import lapr.project.model.Recurso;
import lapr.project.registos.RegistoRecursos;

/**
 * Representação do Controller do caso de uso - definir recurso
 *
 * @author guilherme
 */
public class DefinirRecursoController {

    private CentroExposicoes m_ce;
    private RegistoRecursos m_rr;

    public DefinirRecursoController(CentroExposicoes ce) {
        m_ce = ce;
    }

    /**
     * Inicializa o registo de recursos e busca a lista de recursos do mesmo.
     * @return lista de recursos;
     */
    public List<Recurso> getListaRecursos() {
        m_rr = m_ce.getRegistoRecursos();
        return m_rr.getListaDeRecursos();
    }

    /**
     * Cria um recurso a partir do seu nome
     *
     * @param nome - nome do recurso a adicionar
     * @return true se for adicionado com sucesso; false caso contrário.
     */
    public boolean criarRecurso(String nome) {
        return m_rr.criarRecurso(nome);
    }
}
