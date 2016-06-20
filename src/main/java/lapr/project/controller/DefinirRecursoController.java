package lapr.project.controller;

import java.util.List;
import lapr.project.model.*;
import lapr.project.registos.RegistoRecursos;

/**
 * Representação do Controller do caso de uso - definir recurso
 *
 * @author G29
 */
public class DefinirRecursoController {

    /**
     * Centro de exposições sobre o qual se estáa trabalhar
     */
    private CentroExposicoes m_ce;

    /**
     * Registo de recursos do centro de exposições atual
     */
    private RegistoRecursos m_rr;

    public DefinirRecursoController(CentroExposicoes ce) {
        m_ce = ce;
    }

    /**
     * Inicializa o registo de recursos e busca a lista de recursos do mesmo.
     *
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
