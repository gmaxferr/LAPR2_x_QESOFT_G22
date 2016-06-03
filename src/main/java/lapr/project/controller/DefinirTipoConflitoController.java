package lapr.project.controller;

import classesREMOVIDAS.CentroExposicoes;

/**
 * Representação do Controller do caso de uso - definir tipo de conflito
 * 
 * @author Ana Leite
 */
public class DefinirTipoConflitoController {

    private RegistoTipoConflitos m_rtc;
    private CentroExposicoes m_centro_exposicoes;
    private TipoConflito tConflito;
    
    public DefinirTipoConflitoController(CentroExposicoes centro_exposicoes, RegistoTipoConflitos registoTipoConflitos){
        m_centro_exposicoes = centro_exposicoes;
        m_rtc = registoTipoConflitos;
    }
    
    public void getRegistoTipoConflito(){
        m_centro_exposicoes.getRegistoTiposConflitos();
    }
    
    public void setTipoConflito(TipoConflito tipoConflito){
        m_rtc.validaTipoDeConflito(tipoConflito);
        m_rtc.criarTipoConflito();
        tConflito.setTipoConflito(tipoConflito);
    }
}
