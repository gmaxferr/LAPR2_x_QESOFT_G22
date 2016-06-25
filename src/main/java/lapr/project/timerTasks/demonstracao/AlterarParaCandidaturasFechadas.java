package lapr.project.timerTasks.demonstracao;

import java.util.TimerTask;
import javax.swing.JOptionPane;
import lapr.project.model.Demonstracao;

/**
 * Represnetação de um timer AlterarParaCandidaturasFechadas
 * 
 * @author G29
 */
public class AlterarParaCandidaturasFechadas extends TimerTask{
    
    /**
     * Demonstração
     */
    private final Demonstracao m_demo;

    /**
     * Construtor de objetos do tipo AlterarParaCandidaturasFechadas com o 
     * paramentro demonstração
     * 
     * @param d - demonstração
     */
    public AlterarParaCandidaturasFechadas(Demonstracao d) {
        m_demo = d;
    }

    @Override
    public void run() {
        m_demo.getEstadoDemo().setEstadoDemonstracaoCandidaturasFechadas();
        JOptionPane.showMessageDialog(null, "Terminou o período de submissão de candidaturas à demonstração com o código: "+m_demo.getCodigoIdentificacao());
    }
    
}
