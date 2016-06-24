package lapr.project.estados.Demonstracao;

import lapr.project.model.Demonstracao;

/**
 * Representação do EstadoDemonstracaoConflitosDetetados
 * 
 * @author G29
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
