/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados.Demonstracao;

import lapr.project.model.Demonstracao;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public class EstadoDemonstracaoPendente implements EstadoDemonstracao {

    private Demonstracao m_demo;
    
    public EstadoDemonstracaoPendente(Demonstracao demo){
        this.m_demo = demo;
    }
    
    @Override
    public boolean setEstadoDemonstracaoPendente() {
        return true;
    }

    @Override
    public boolean setEstadoDemonstracaoConfirmada() {
        
        return false;
    }

    @Override
    public boolean setEstadoDemonstracaoCancelada() {
        return false;
    }

    @Override
    public boolean isEstadoDemonstracaoPendente() {
        return true;
    }

    @Override
    public boolean isEstadoDemonstracaoConfirmada() {
        return false;
    }

    @Override
    public boolean isEstadoDemonstracaoCancelada() {
        return false;
    }

}