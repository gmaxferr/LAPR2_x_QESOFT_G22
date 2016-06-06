package lapr.project.estados;

/**
 *
 * @author Ana Leite e Ricardo Osório
 */
public interface EstadoCandidaturaAExposicao extends Estado{
    
    boolean setEstadoCandidaturaInicial();
    
    boolean setEstadoCandidaturaCriada();
    
    boolean setEstadoConflitosDetetados();
    
    boolean setEstadoConflitosAtribuidos();
    
    boolean setEstadoCandidaturaAtribuida();
    
    boolean setEstadoCandidaturaAvaliada();
    
    boolean setEstadoCandidaturaAceite();
    
    boolean setEstadoCandidaturaRejeitada();
    
    boolean setEstadoCandidaturaRemovida();
    
    boolean isEstadoCandidaturaIncial();
    
    boolean isEstadoCandidaturaCriada();
    
    boolean isEstadoConflitosDetetados();
    
    boolean isEstadoConflitosAtribuidos();
    
    boolean isEstadoCandidaturaAtribuida();
    
    boolean isEstadoCandidaturaAvaliada();
    
    boolean isEstadoCandidaturaAceite();
    
    boolean isEstadoCandidaturaRejeitada();
    
    boolean isEstadoCandidaturaRemovida();
}
