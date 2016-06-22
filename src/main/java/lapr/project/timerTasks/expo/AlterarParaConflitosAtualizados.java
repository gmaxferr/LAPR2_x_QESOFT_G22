package lapr.project.timerTasks.expo;

import java.util.TimerTask;
import javax.swing.JOptionPane;
import lapr.project.model.CandidaturaAExposicao;
import lapr.project.model.Exposicao;

/**
 *
 * @author G29
 */
public class AlterarParaConflitosAtualizados extends TimerTask {

    private final Exposicao m_exposicao;

    /**
     *
     * @param e - exposição
     */
    public AlterarParaConflitosAtualizados(Exposicao e) {
        m_exposicao = e;
    }

    @Override
    public void run() {
        m_exposicao.getEstado().setEstadoConflitosDetetados();
        boolean change = false;
        for (CandidaturaAExposicao c : m_exposicao.getRegistoCandidaturasAExposicao().getListaCandidaturas()) {
            if (c.getEstado().setEstadoCandidaturaProntaAtribuicoes()) {
                change = true;
            }
        }
        if (change) {
            JOptionPane.showMessageDialog(null, "Terminou o período de atualização de conflitos de interesse!");
        }
    }
}
