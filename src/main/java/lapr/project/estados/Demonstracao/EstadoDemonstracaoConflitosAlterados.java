package lapr.project.estados.Demonstracao;

import lapr.project.model.Demonstracao;

/**
 * Representação do EstadoDemonstracaoConflitosAlterados
 * 
 * @author G29
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
