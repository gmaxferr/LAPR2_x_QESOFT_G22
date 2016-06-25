package lapr.project.timerTasks.expo;

import java.util.TimerTask;
import javax.swing.JOptionPane;
import lapr.project.model.Exposicao;

/**
 * Represnetação de um timer AlterarParaAbertaCandidaturas
 * 
 * @author G29
 */
public class AlterarParaAbertaCandidaturas extends TimerTask {

    /**
     * Exposição
     */
    private Exposicao m_exposicao;

    /**
     * Construtor de objetos do tipo AlterarParaAbertaCandidaturas com o 
     * parametro exposição
     * 
     * @param e - exposição
     */
    public AlterarParaAbertaCandidaturas(Exposicao e) {
        m_exposicao = e;
    }

    @Override
    public void run() {
        if (m_exposicao.getEstado().setEstadoCandidaturasAbertas()) {
            JOptionPane.showMessageDialog(null, "Iniciou o período de submissão de candidaturas à exposição" + m_exposicao.getTitulo());
        }else{
            JOptionPane.showMessageDialog(null, "O período de submissão de candidaturas à exposição " + m_exposicao.getTitulo() + " já"
                    + "\nera para ter começado mas a exposição não tem informação suficiente para lidar com isto. Este período começará"
                    + "\nquando a informação em falta for preenchida.", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

}
