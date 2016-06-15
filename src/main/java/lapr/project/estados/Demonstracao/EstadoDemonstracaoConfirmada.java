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
public class EstadoDemonstracaoConfirmada extends EstadoDemonstracao {

    public EstadoDemonstracaoConfirmada(Demonstracao demo) {
        super(demo);
    }

    @Override
    public boolean setEstadoDemonstracaoDatasDefinidas() {
        if (valida()) {
            this.m_demo.setEstado(new EstadoDemonstracaoDatasDefinidas(m_demo));
            return true;
        }
        return false;
    }

    private boolean valida() {
        //TODO
        return true;
    }

    @Override
    public boolean isEstadoDemonstracaoConfirmada() {
        return true;
    }

}
