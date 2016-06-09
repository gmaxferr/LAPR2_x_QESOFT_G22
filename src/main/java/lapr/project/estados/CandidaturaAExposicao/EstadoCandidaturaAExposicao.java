package lapr.project.estados.CandidaturaAExposicao;

import lapr.project.estados.Estado;

/**
 *
 * @author Ana Leite e Ricardo Osório
 */
public interface EstadoCandidaturaAExposicao extends Estado{
    
    boolean setEstadoCandidaturaInicial();
    
    boolean setEstadoCandidaturaCriada();
    
    boolean setEstadoCandidaturaAbertaAtualizacaoConflitos();
   
    boolean setEstadoCandidaturaAtribuida();
    
    boolean setEstadoCandidaturaAvaliada();
    
    boolean setEstadoCandidaturaAceite();
    
    boolean setEstadoCandidaturaRejeitada();
    
    boolean setEstadoCandidaturaProntaAtribuicoes();
    
    boolean isEstadoCandidaturaIncial();
    
    boolean isEstadoCandidaturaCriada();
    
    boolean isEstadoCandidaturaAbertaAtualizacaoConflitos();
    
    boolean isEstadoCandidaturaAtribuida();
    
    boolean isEstadoCandidaturaAvaliada();
    
    boolean isEstadoCandidaturaAceite();
    
    boolean isEstadoCandidaturaRejeitada();
    
    boolean isEstadoCandidaturaProntaAtribuicoes();
}
