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
public class EstadoDemonstracaoDatasDefinidas extends EstadoDemonstracao {

    public EstadoDemonstracaoDatasDefinidas(Demonstracao m_demo) {
        super(m_demo);
    }

    @Override
    public boolean setEstadoDemonstracaoCandidaturasAbertas() {
        this.m_demo.setEstado(new EstadoDemonstracaoCandidaturasAbertas(m_demo));
        return true;
    }

    @Override
    public boolean isEstadoDemonstracaoDatasDefinidas() {
        return true;
    }

}
