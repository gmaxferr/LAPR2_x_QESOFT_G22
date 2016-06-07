package lapr.project.controller;

import lapr.project.model.CentroExposicoes;
import lapr.project.model.TipoConflito;
import lapr.project.registos.RegistoTipoConflitos;

/**
 * Representação do Controller do caso de uso - definir tipo de conflito
 *
 * @author Ricardo Catalão
 */
public class DefinirTipoConflitoController {

    /**
     * Centro de Exposições onde será definido um novo tipo de conflito.
     */
    private final CentroExposicoes m_CentroExposicoes;

    /**
     * Registo pertencente ao Centro de Exposições onde será guardado o novo
     * tipo de conflito.
     */
    private RegistoTipoConflitos m_RegistoTiposConflito;

    /**
     * Novo tipo de conflito.<!-- -->Este objeto guarda o novo tipo de conflito.
     */
    private TipoConflito m_TipoConflito;

    /**
     * Construtor padrão que recebe como argumentos o Centro de Exposições.
     *
     * @param centroExposicoes Centro de Exposições
     */
    public DefinirTipoConflitoController(CentroExposicoes centroExposicoes) {
        m_CentroExposicoes = centroExposicoes;
    }

    /**
     * Cria um novo tipo de conflito.
     */
    public void novoTipoConflito() {
        m_RegistoTiposConflito = m_CentroExposicoes.getRegistoTiposConflitos();
        m_TipoConflito = m_RegistoTiposConflito.novoTipoConflito();
    }

    /**
     * Define os dados necessários para o novo tipo de conflito.
     */
    public void setDadosTipoConflito() {
        m_TipoConflito.setDadosTipoConflito();
    }

    /**
     * Regista o tipo de conflito criado no registo de tipos de conflito do
     * Centro de Exposições.
     */
    public boolean registaTipoConflito() {
        return m_RegistoTiposConflito.add(m_TipoConflito);
    }
}
