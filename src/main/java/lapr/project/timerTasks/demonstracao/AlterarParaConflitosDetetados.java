package lapr.project.timerTasks.demonstracao;

import java.util.TimerTask;
import javax.swing.JOptionPane;
import lapr.project.estados.Demonstracao.EstadoDemonstracao;
import lapr.project.estados.Demonstracao.EstadoDemonstracaoConflitosDetetados;
import lapr.project.model.Demonstracao;

/**
 * Representação de um timer AlterarParaConflitosDetetados
 * 
 * @author G29
 */
public class AlterarParaConflitosDetetados extends TimerTask{

    /**
     * Demonstração
     */
    private Demonstracao m_demo;
    
    /**
     * Construtor de objetos do tipo AlterarParaConflitosDetetados com o 
     * parametro demostração
     * 
     * @param d demonstração
     */
    public AlterarParaConflitosDetetados(Demonstracao d){
        m_demo = d;
    }
    
    @Override
    public void run() {
        EstadoDemonstracao e = m_demo.getEstadoDemo();
        e = new EstadoDemonstracaoConflitosDetetados(m_demo);
        JOptionPane.showMessageDialog(null, "Ocorreu a deteção de conflitos de interesse da demonstração");
    }
    
    
}
