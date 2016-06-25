package lapr.project.timerTasks.demonstracao;

import java.util.TimerTask;
import javax.swing.JOptionPane;
import lapr.project.model.Demonstracao;

/**
 * Representação de um timer AlterarParaCandidaturasAbertas
 * 
 * @author G29
 */
public class AlterarParaCandidaturasAbertas extends TimerTask{

    /**
     * Demonstração
     */
    private final Demonstracao m_demo;

    /**
     * Construtor de objetos do tipo ALterarParaCandidaturasAbertas com o 
     * parametro demonstração
     * 
     * @param d - demonstração
     */
    public AlterarParaCandidaturasAbertas(Demonstracao d) {
        m_demo = d;
    }

    @Override
    public void run() {
        m_demo.getEstadoDemo().setEstadoDemonstracaoCandidaturasAbertas();
        JOptionPane.showMessageDialog(null, "Iniciou o período de submissão de candidaturas à demonstração com o código: "+m_demo.getCodigoIdentificacao());
    }
    
}
