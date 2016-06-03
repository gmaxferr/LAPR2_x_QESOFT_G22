package lapr.project.estados;

/**
 *
 * @author Ana Leite e Ricardo Osório
 */
public interface EstadoCandidaturaAExposicao extends Estado{
    
    boolean setEstadoCandidaturaCriada();
    
    boolean setEstadoConflitosDetetados();
    
    boolean setEstadoConflitosAtribuidos();
    
    boolean setEstadoCandidaturaAtribuida();
    
    boolean setEstadoCandidaturaAvaliada();
    
    boolean setEstadoCandidaturaAceite();
    
    boolean setEstadoCandidaturaRejeitada();
    
    boolean isEstadoCandidaturaCriada();
    
    boolean isEstadoConflitosDetetados();
    
    boolean isEstadoConflitosAtribuidos();
    
    boolean isEstadoCandidaturaAtribuida();
    
    boolean isEstadoCandidaturaAvaliada();
}
