package lapr.project.controller;

import lapr.project.model.*;
import lapr.project.registos.RegistoTipoConflitos;

/**
 * Representação do Controller do caso de uso - definir tipo de conflito
 *
 * @author G29
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
     * Construtor de objetos do tipo DefinirTipoConflitoController com o parametro
     * centro de exposições
     *
     * @param centroExposicoes Centro de Exposições
     */
    public DefinirTipoConflitoController(CentroExposicoes centroExposicoes) {
        m_CentroExposicoes = centroExposicoes;
    }

    /**
     * Define os dados necessários para o novo tipo de conflito.
     * 
     * @param tipoConflito dados necessários para o novo tipo de conflito.
     */
    public void setDadosTipoConflito(String tipoConflito) {
        m_TipoConflito.setDadosTipoConflito(tipoConflito);
    }

    /**
     * Cria um novo tipo de conflito.
     */
    public void novoTipoConflito() {
        m_RegistoTiposConflito = m_CentroExposicoes.getRegistoTiposConflitos();
        m_TipoConflito = m_RegistoTiposConflito.novoTipoConflito();
    }

    /**
     * Regista o tipo de conflito criado no registo de tipos de conflito do
     * Centro de Exposições.
     * 
     * @return true se o tipo de conflito foi adicionado à lista de tipos de
     * conflito. Caso contrário retorna false.
     */
    public boolean registaTipoConflito() {
        return m_RegistoTiposConflito.add(m_TipoConflito);
    }
}
