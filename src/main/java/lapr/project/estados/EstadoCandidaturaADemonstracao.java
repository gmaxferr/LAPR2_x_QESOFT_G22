/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados;

/**
 *
 * @author guima
 */
public interface EstadoCandidaturaADemonstracao extends Estado {

    boolean setEstadoCandidaturaInstanciada();

    boolean setEstadoCandidaturaCriada();

    boolean isEstadoCandidaturaInstanciada();
    
    boolean isEstadoCandidaturaCriada();

}
