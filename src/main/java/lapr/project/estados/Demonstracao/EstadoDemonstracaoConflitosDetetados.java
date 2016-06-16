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
public class EstadoDemonstracaoConflitosDetetados extends EstadoDemonstracao {
    
    private Demonstracao m_demo;
    
    public EstadoDemonstracaoConflitosDetetados(Demonstracao demo) {
        super(demo);
        m_demo = demo;
    }
    
    @Override
    public boolean setEstadoDemonstracaoConflitosDetetados() {
        return true;
    }
    
    @Override
    public boolean setEstadoDemonstracaoConflitosAlterados() {
        EstadoDemonstracao e = m_demo.getEstadoDemo();
        e = new EstadoDemonstracaoConflitosAlterados(m_demo);
        return true;
    }
    
    @Override
    public boolean isEstadoDemonstracaoConflitosDetetados(){
        return true;
    }
    
}
