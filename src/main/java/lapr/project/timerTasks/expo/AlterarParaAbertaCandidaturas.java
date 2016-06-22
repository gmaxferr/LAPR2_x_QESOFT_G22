package lapr.project.timerTasks.expo;

import java.util.TimerTask;
import javax.swing.JOptionPane;
import lapr.project.model.Exposicao;

/**
 *
 * @author G29
 */
public class AlterarParaAbertaCandidaturas extends TimerTask {

    private Exposicao m_exposicao;

    /**
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
        }
    }

}
