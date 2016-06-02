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
public class EstadoCandidaturaADemonstracaoInstanciada implements EstadoCandidaturaADemonstracao {

    @Override
    public boolean setEstadoCandidaturaInstanciada() {
        return false;
    }

    @Override
    public boolean setEstadoCandidaturaCriada() {
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaInstanciada() {
        return true;
    }

    @Override
    public boolean isEstadoCandidaturaCriada() {
        return false;
    }
}
