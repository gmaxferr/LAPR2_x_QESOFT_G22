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
public class EstadoDemonstracaoConflitosAlterados extends EstadoDemonstracao{
    
    public EstadoDemonstracaoConflitosAlterados(Demonstracao demo) {
        super(demo);
    }
    
    @Override
     public boolean setEstadoDemonstracaoConflitosAlterados(){
        return true;
    }
    
    @Override
     public boolean isEstadoDemonstracaoConflitosAlterados(){
        return true;
    }
    
}