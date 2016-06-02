package lapr.project.estados;

/**
 *
 * @author Ana Leite e Ricardo Osório
 */
public interface EstadoCandidatura extends Estado{
    
    boolean setEstadoCandidaturaCriada();
    
    boolean setEstadoConflitosDetetados();
    
    boolean setEstadoConflitosAtribuidos();
    
    boolean setEstadoCandidaturaAtribuida();
    
    boolean setEstadoCandidaturaAvaliada();
    
    boolean isEstadoCandidaturaCriada();
    
    boolean isEstadoConflitosDetetados();
    
    boolean isEstadoConflitosAtribuidos();
    
    boolean isEstadoCandidaturaAtribuida();
    
    boolean isEstadoCandidaturaAvaliada();
}
