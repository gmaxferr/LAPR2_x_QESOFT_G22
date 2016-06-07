package lapr.project.controller;

import java.util.List;
import lapr.project.estados.*;
import lapr.project.model.*;
import lapr.project.registos.RegistoTipoConflitos;

/**
 * Representação do Controller do caso de uso - artibuir conflitos de interesse
 * @author Ana Leite
 */
public class AtribuirConflitoInteresseController {

    private Exposicao exposicao;
    private EstadoExposicao estadoExpo;
    private EstadoCandidaturaAExposicao estadoCand;
    private RegistoTipoConflitos m_rtc;
    private CentroExposicoes m_centro_exposicoes;
    private FAE fae;
    private boolean valida;
    private EstadoExposicao estado;
    private CandidaturaAExposicao cand;
    
    public AtribuirConflitoInteresseController(CentroExposicoes centroExposicoes, RegistoTipoConflitos registoTipoConflitos){
        m_centro_exposicoes = centroExposicoes;
        m_rtc = registoTipoConflitos;
    }
    
     public boolean getEstadoExposicao() {
        estadoExpo = exposicao.getEstado();
        return verificaEstadoExposicao(estadoExpo);
    }

    public boolean verificaEstadoExposicao(EstadoExposicao estado) {
        //Verifica se o estado permite executar este UC
        return true;
    }
    
     public void getM_RegistoTipoConflitos() {
        this.m_rtc = m_centro_exposicoes.getRegistoTiposConflitos();
    }
     
     public List<TipoConflito> getListaTipoConflito() {
        return m_rtc.getListaTipoConflitos();
    }
     
     public void setTipoConflitoFAE(TipoConflito tipoConflito){
         this.valida = fae.validaTipoConflito(tipoConflito);
         if (valida){
             fae.setTipoConflitoFAE(tipoConflito);
         }
         else{
             //mensagem adequada
         }
     }
     
     public void setEstadoConflitosAtribuidos(){
         this.estadoCand = cand.getEstado();
         estadoCand.setEstadoConflitosAtribuidos();
         }
     }

