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
public class EstadoDemonstracaoCancelada implements EstadoDemonstracao{

    private Demonstracao m_demo;
    
    public EstadoDemonstracaoCancelada(Demonstracao demo){
        this.m_demo = demo;
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
        return true;
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
        return true;
    }

    @Override
    public boolean setEstadoDemonstracaoCandidaturasAtribuidas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setEstadoDemonstracaoCandidaturasAvaliadas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setEstadoDemonstracaoCandidaturasDecididas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setEstadoDemonstracaoCandidaturasAbertas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean setEstadoDemonstracaoCandidaturasFechadas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEstadoDemonstracaoCandidaturasAtribuidas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEstadoDemonstracaoCandidaturasAvaliadas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEstadoDemonstracaoCandidaturasDecididas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEstadoDemonstracaoCandidaturasAbertas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEstadoDemonstracaoCandidaturasFechadas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
