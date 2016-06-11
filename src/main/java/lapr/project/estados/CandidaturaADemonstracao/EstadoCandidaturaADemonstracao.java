package lapr.project.estados.CandidaturaADemonstracao;

import lapr.project.estados.Estado;

/**
 *
 * @author guima
 */
public interface EstadoCandidaturaADemonstracao extends Estado{

    boolean setEstadoCandidaturaInstanciada();

    boolean setEstadoCandidaturaCriada();
    
    boolean setEstadoCandidaturaAtribuida();
    
    boolean setEstadoCandidaturaAvaliada();

    boolean isEstadoCandidaturaInstanciada();
    
    boolean isEstadoCandidaturaCriada();
    
    boolean isEstadoCandidaturaAtribuida();
    
    boolean isEstadoCandidaturaAvaliada();

}
