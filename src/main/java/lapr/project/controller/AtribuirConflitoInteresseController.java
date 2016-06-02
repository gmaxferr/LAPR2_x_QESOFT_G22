package lapr.project.controller;

import java.util.List;

/**
 * Representação do Controller do caso de uso - artibuir conflitos de interesse
 * @author Ana Leite
 */
public class AtribuirConflitoInteresseController {

    private Exposicao exposicao;
    private EstadoExposicao estadoExpo;
    private EstadoCandidatura estadoCand;
    private EstadoCandidaturaConflitosDetetados estadoConflitosdetetados;
    private RegistoTipoConflitos m_rtc;
    private CentroExposicoes m_centro_exposicoes;
    FAE fae;
    private boolean valida;
    EstadoExposicao estado;
    Candidatura cand;
    
    public AtribuirConflitoInteresseController(CentroExposicoes centroExposicoes, RegistoTipoConflitos registoTipoConflitos){
        m_centro_exposicoes = centroExposicoes;
        m_rtc = registoTipoConflitos;
    }
    
     public boolean getEstadoExposicao() {
        estadoExpo = exposicao.getEstadoExposicao();
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
         this.estadoCand = cand.getEstadoCandidatura();
         estadoConflitosdetetados.setEstadoConflitosAtribuidos();
         }
     }

