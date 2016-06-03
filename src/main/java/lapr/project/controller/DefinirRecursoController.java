package lapr.project.controller;

import classesModelERegistodePPROG.CentroExposicoes;
import classesModelERegistodePPROG.RegistoRecursos;

/**
 * Representação do Controller do caso de uso - definir recurso
 *
 * @author Ana Leite e Ricardo Osório
 */
public class DefinirRecursoController {

    private CentroExposicoes m_centro_exposicoes;
    private RegistoRecursos m_rr;

    public DefinirRecursoController(CentroExposicoes centro_exposicoes, RegistoRecursos registoRecursos) {
        m_centro_exposicoes = centro_exposicoes;
        m_rr = registoRecursos;
    }

    public void getRegistoRecursos() {
        m_centro_exposicoes.getRegistoRecursos();
    }

    public void criarRecurso(String nome) {
        m_rr.criarRecurso(nome);
    }
}
