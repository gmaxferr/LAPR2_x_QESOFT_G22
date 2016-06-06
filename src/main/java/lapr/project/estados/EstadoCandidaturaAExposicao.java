package lapr.project.estados;

/**
 *
 * @author Ana Leite e Ricardo Osório
 */
public interface EstadoCandidaturaAExposicao{
    
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
