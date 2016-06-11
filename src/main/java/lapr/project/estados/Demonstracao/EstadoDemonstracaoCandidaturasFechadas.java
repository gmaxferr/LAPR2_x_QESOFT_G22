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
public class EstadoDemonstracaoCandidaturasFechadas implements EstadoDemonstracao{
    
    private final Demonstracao m_demo;

    public EstadoDemonstracaoCandidaturasFechadas(Demonstracao m_demo) {
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
        m_demo.setEstado(new EstadoDemonstracaoCandidaturasAtribuidas(m_demo));
        return true;
    }

    @Override
    public boolean setEstadoDemonstracaoCandidaturasAvaliadas() {
        return false;
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

    private boolean valida() {
        //valida se tem as coisas todas necessárias para passar ao próximo estado (verificação de atributos)
        return true;
    }
    
    @Override
    public boolean isEstadoDemonstracaoCandidaturasAtribuidas() {
        return false;
    }

    @Override
    public boolean isEstadoDemonstracaoCandidaturasAvaliadas() {
        return false;
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
    
}
