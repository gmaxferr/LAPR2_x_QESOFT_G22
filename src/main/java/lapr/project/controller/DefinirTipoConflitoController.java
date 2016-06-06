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
    private final CentroExposicoes mCentroExposicoes;

    /**
     * Registo pertencente ao Centro de Exposições onde será guardado o novo
     * tipo de conflito.
     */
    private RegistoTipoConflitos mRegistoTiposConflito;

    /**
     * Novo tipo de conflito.<!-- -->Este objeto guarda o novo tipo de conflito.
     */
    private TipoConflito mTipoConflito;

    /**
     * Construtor padrão que recebe como argumentos o Centro de Exposições.
     *
     * @param centroExposicoes Centro de Exposições
     */
    public DefinirTipoConflitoController(CentroExposicoes centroExposicoes) {
        mCentroExposicoes = centroExposicoes;
    }

    /**
     * Cria um novo tipo de conflito.
     */
    public void novoTipoConflito() {
        mRegistoTiposConflito = mCentroExposicoes.getRegistoTiposConflitos();
        mTipoConflito = mRegistoTiposConflito.novoTipoConflito();
    }

    /**
     * Define os dados necessários para o novo tipo de conflito.
     */
    public void setDadosTipoConflito() {
        mTipoConflito.setDadosTipoConflito();
    }

    /**
     * Regista o tipo de conflito criado no registo de tipos de conflito do
     * Centro de Exposições.
     */
    public boolean registaTipoConflito() {
        return mRegistoTiposConflito.add(mTipoConflito);
    }
}
