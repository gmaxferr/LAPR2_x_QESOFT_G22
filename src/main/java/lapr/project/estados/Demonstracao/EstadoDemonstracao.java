/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lapr.project.estados.Demonstracao;

import lapr.project.estados.Estado;
import lapr.project.model.Demonstracao;

/**
 *
 * @author JoãoCardoso aka K4rd050
 */
public abstract class EstadoDemonstracao implements Estado {

    final Demonstracao m_demo;

    public EstadoDemonstracao(Demonstracao demo) {
        this.m_demo = demo;
    }

    public boolean setEstadoDemonstracaoPendente() {
        return false;
    }

    public boolean setEstadoDemonstracaoConfirmada() {
        return false;
    }

    public boolean setEstadoDemonstracaoCancelada() {
        return false;
    }

    public boolean setEstadoDemonstracaoDatasDefinidas() {
        return false;
    }

    public boolean setEstadoDemonstracaoCandidaturasAtribuidas() {
        return false;
    }

    public boolean setEstadoDemonstracaoCandidaturasAvaliadas() {
        return false;
    }

    public boolean setEstadoDemonstracaoCandidaturasDecididas() {
        return false;
    }

    public boolean setEstadoDemonstracaoCandidaturasAbertas() {
        return false;
    }

    public boolean setEstadoDemonstracaoCandidaturasFechadas() {
        return false;
    }

    public boolean setEstadoDemonstracaoConflitosDetetados() {
        return false;
    }

    public boolean setEstadoDemonstracaoConflitosAlterados() {
        return false;
    }

    public boolean isEstadoDemonstracaoPendente() {
        return false;
    }

    public boolean isEstadoDemonstracaoConfirmada() {
        return false;
    }

    public boolean isEstadoDemonstracaoCancelada() {
        return false;
    }

    public boolean isEstadoDemonstracaoDatasDefinidas() {
        return false;
    }

    public boolean isEstadoDemonstracaoCandidaturasAtribuidas() {
        return false;
    }

    public boolean isEstadoDemonstracaoCandidaturasAvaliadas() {
        return false;
    }

    public boolean isEstadoDemonstracaoCandidaturasDecididas() {
        return false;
    }

    public boolean isEstadoDemonstracaoCandidaturasAbertas() {
        return false;
    }

    public boolean isEstadoDemonstracaoCandidaturasFechadas() {
        return false;
    }

    public boolean isEstadoDemonstracaoConflitosDetetados() {
        return false;
    }

    public boolean isEstadoDemonstracaoConflitosAlterados() {
        return false;
    }
}
