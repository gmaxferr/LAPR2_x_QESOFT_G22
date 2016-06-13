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
public class EstadoDemonstracaoCandidaturasAtribuidas implements EstadoDemonstracao{

    private final Demonstracao m_demo;

    public EstadoDemonstracaoCandidaturasAtribuidas(Demonstracao m_demo) {
        this.m_demo = m_demo;
    }
    
    @Override
    public boolean setEstadoDemonstracaoPendente() {
        return false;
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
        return false;
    }

    @Override
    public boolean isEstadoDemonstracaoConfirmada() {
        return false;
    }

    @Override
    public boolean isEstadoDemonstracaoCancelada() {
        return false;
    }

    @Override
    public boolean setEstadoDemonstracaoCandidaturasAtribuidas() {
        return false;
    }

    @Override
    public boolean setEstadoDemonstracaoCandidaturasAvaliadas() {
        if(valida()){
        m_demo.setEstado(new EstadoDemonstracaoCandidaturasAvaliadas(m_demo));
        return true;
        } else return false;
    }

    @Override
    public boolean setEstadoDemonstracaoCandidaturasDecididas() {
        return false;
    }

    @Override
    public boolean setEstadoDemonstracaoCandidaturasAbertas() {
        return false;
    }

    @Override
    public boolean setEstadoDemonstracaoCandidaturasFechadas() {
        return false;
    }

    @Override
    public boolean isEstadoDemonstracaoCandidaturasAtribuidas() {
        return false;
    }

    @Override
    public boolean isEstadoDemonstracaoCandidaturasAvaliadas() {
        return true;
    }

    @Override
    public boolean isEstadoDemonstracaoCandidaturasDecididas() {
        return false;
    }

    @Override
    public boolean isEstadoDemonstracaoCandidaturasAbertas() {
        return false;
    }

    @Override
    public boolean isEstadoDemonstracaoCandidaturasFechadas() {
        return false;
    }
 
    private boolean valida() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado (verificação de atributos)
        return true;
    }
}
