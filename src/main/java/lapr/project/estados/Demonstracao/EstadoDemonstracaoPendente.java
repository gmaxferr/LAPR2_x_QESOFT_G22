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
public class EstadoDemonstracaoPendente extends EstadoDemonstracao {

    public EstadoDemonstracaoPendente(Demonstracao demo) {
        super(demo);
    }

    @Override
    public boolean setEstadoDemonstracaoPendente() {
        return true;
    }

    @Override
    public boolean setEstadoDemonstracaoConfirmada() {
        this.m_demo.setEstado(new EstadoDemonstracaoConfirmada(m_demo));
        return true;
    }

    @Override
    public boolean setEstadoDemonstracaoCancelada() {
        this.m_demo.setEstado(new EstadoDemonstracaoCancelada(m_demo));
        return true;
    }

    @Override
    public boolean isEstadoDemonstracaoPendente() {
        return true;
    }

}
